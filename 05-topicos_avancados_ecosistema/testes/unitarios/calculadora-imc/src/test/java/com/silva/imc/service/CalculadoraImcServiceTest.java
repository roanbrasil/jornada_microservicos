package com.silva.imc.service;

import com.silva.imc.repository.CalculadoraImcRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculadoraImcServiceTest {
    static Logger log = LoggerFactory.getLogger(CalculadoraImcServiceTest.class);

    //    @Autowired
    @Mock
    private CalculadoraImcRepository repository;

//    @InjectMocks
    @Mock
    private CalculadoraImcService service;

    @BeforeAll
    static void setup() {
        //@BeforeAll - é o método executado antes de todos os outros da classe
    }

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        //@BeforeEach - é executado antes de cada método da classe
    }

    @DisplayName("Irá Mostrar Este Nome Amigável")
    @Test
    void milNovecentoOitentaEOitoFoiVotadaAConstituicao() {
        //@DisplayName - Permite definir um nome para ser mostrada nos relatórios e em outras ferramentas
    }

    @Test
    @Disabled("Not implemented yet")
    void deveIgnoraTesteComDesabilitadoMesmoComFalha() {
        //@Disabled - Indica que o teste não será executado, se estiver com erro, nao falhará
        Assertions.assertEquals(1, 2);
    }

    @AfterEach
    void tearDown() {
        //@AfterEach - Método que será executado depois de cada método de teste
    }

    @AfterAll
    static void done() {
        //@AfterAll - Método que será executado depois que todos os testes terminarem
    }

    @Test
    public void deveExecutarAssertAllComLambdas() {
        int[] numbers = {1, 2, 3, 4, 5};
        Assertions.assertAll("number",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 4),
                () -> assertEquals(numbers[4], 5)
        );
    }

    @Test
    void deveRetornarPesoIdeal() {
        // Arranjo
        double peso = 70.0;
        double altura = 1.68;
        //  Ação
        SituacaoPeso situacaoPeso = service.avaliarPeso(peso, altura);

        // Asserção
        assertEquals(SituacaoPeso.IDEAL, situacaoPeso);
    }

    @Test
    void deveRetornarPesoAbaixo() {
        // Arranjo
        double peso = 50.0;
        double altura = 1.68;

        //  Ação
        SituacaoPeso situacaoPeso = service.avaliarPeso(peso, altura);

        // Asserção
        assertEquals(situacaoPeso, SituacaoPeso.ABAIXO);
    }

    @Test
    void deveRetornarSituacaoInformadaNoMock() {
        // Arranjo
        Mockito.when(service.avaliarPeso(0.0, 0.0)).thenReturn(SituacaoPeso.OBESO_MORBIDO);

        //  Ação
        //o método real não será executado, será retornado o valor arbitrado no mock acima
        SituacaoPeso situacao = service.avaliarPeso(0.0, 0.0);

        // Asserção
        assertEquals(situacao, SituacaoPeso.OBESO_MORBIDO);
    }

    @InjectMocks
    private CalculadoraImcService serviceSpy;
    @Test
    void deveMockarRetornoDoMetodoInterno() {
        // Arranjo
        //queremos que o metodo interno "calcularImc()" retorne imc=19.0, que produz a SituacaoPeso.ABAIXO
        Mockito.when(service.calcularImc(120.0, 1.50)).thenReturn(19.0);

        //  Ação
        //o método real será executado, será retornado o valor arbitrado no mock acima
        SituacaoPeso situacao = serviceSpy.avaliarPeso(0.1, 0.1);

        // Asserção
        //mesmo que colocamos pesso 100 Kg, retornou situação abaixo, pois mockamos o método "calcularImc()", chamado dentro do método principal
        assertEquals(SituacaoPeso.ABAIXO, situacao);
    }

    @Test
    void deveRetornarSobrepeso() {
        assertEquals(SituacaoPeso.SOBREPESO, service.avaliarPeso(72.0, 1.68));
    }


    @Test
    void deveRetornar25ponto9() {
        double value = service.calcularImc(73.0, 1.68);
        assertEquals(25.9, value);
    }

}