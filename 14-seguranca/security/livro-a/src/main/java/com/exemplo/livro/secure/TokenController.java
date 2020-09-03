package com.exemplo.livro.secure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.users.MemoryUser;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.jwt.JWTOptions;

@Path("/secured")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TokenController {

	private String key;

	@PostConstruct
	public void init() {
		key = obterPemFile();
	}

	@GET
	@Path("/token")
	@RolesAllowed({ "gerente", "cliente" })
	public String getToken(@Context SecurityContext securityContext) {

		if (key == null) {
			throw new WebApplicationException("Nao foi possivel ler privateKey.pem", 500);
		}

		String jwt = gerarJWT(key, securityContext);

		return jwt;
	}

	/*
	 * Gera o token do cliente autenticado.
	 */
	private static String gerarJWT(String key, SecurityContext securityContext) {
		JWTAuth provider = JWTAuth.create(null,
				new JWTAuthOptions().addPubSecKey(new PubSecKeyOptions().setAlgorithm("RS256").setSecretKey(key)));

		MPJWTToken token = new MPJWTToken();

		token.setAud("targetService"); // O 'Audience' corresponde ao domínio ou para o qual o token é válido.
		token.setIss("https://server.example.com"); // O 'Issuer' é a entidade que emitiu o token.
		token.setJti(UUID.randomUUID().toString()); // JTW id

		token.setSub(securityContext.getUserPrincipal().getName()); // Subject ou User principal
		token.setUpn(securityContext.getUserPrincipal().getName()); // User Principal

		token.setIat(System.currentTimeMillis()); // Data e hora que o token foi expedido.
		token.setExp(System.currentTimeMillis() + 30000); // Tempo de validade do token em segundos. Nesse caso 30 segundos

		// Um exemplo de custom claim
		token.addAdditionalClaims("custom-value", securityContext.getUserPrincipal().getName() + " specific value");

		token.setGroups(getGroups(securityContext));
		token.setRoles(getGroups(securityContext));

		return provider.generateToken(new JsonObject().mergeIn(token.toJSONString()),
				new JWTOptions().setAlgorithm("RS256"));
	}

	/**
	 * Obtem a chave privada
	 * 
	 * @return chave privada
	 */
	private static String obterPemFile() {
		StringBuilder sb = new StringBuilder(8192);
		try (BufferedReader is = new BufferedReader(new InputStreamReader(
				TokenController.class.getResourceAsStream("/privateKey.pem"), StandardCharsets.US_ASCII))) {
			String line;
			while ((line = is.readLine()) != null) {
				if (!line.startsWith("-")) {
					sb.append(line);
					sb.append('\n');
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Retorna os grupos do contexto do usuário.
	 * 
	 * @param securityContext
	 * @return a List de grupos
	 */
	private static List<String> getGroups(@Context SecurityContext securityContext) {
		List<String> groups = new ArrayList<String>();
		Principal user = securityContext.getUserPrincipal();

		// Se já existe um token, devove os grupos do mesmo
		if (user instanceof JsonWebToken) {
			JsonWebToken jwt = (JsonWebToken) user;

			for (String group : jwt.getGroups()) {
				groups.add(group);
			}

			// Se o JWTToken não existe, obtem as roles do MemoryUser, pois o usuário existe
			// na própria configuração do tomee.
		} else if (user instanceof MemoryUser) {
			Iterator<Role> it = ((MemoryUser) user).getRoles();

			while (it.hasNext()) {
				groups.add(it.next().getRolename());
			}
		}

		return groups;
	}

}
