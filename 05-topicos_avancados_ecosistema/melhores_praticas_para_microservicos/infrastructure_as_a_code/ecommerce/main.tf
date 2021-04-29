# https://www.terraform.io/downloads.html

provider "aws" {
	#variável lida do arquivo variable.tf
    region = var.aws_region
}

resource "aws_vpc" "e-commerce" {
  cidr_block = "10.0.0.0/16"
}

resource "aws_subnet" "main" {
  vpc_id     = "${aws_vpc.e-commerce.id}"
  cidr_block = "10.0.1.0/24"
}

resource "aws_security_group" "sg-0ef3f5e1324d6769e" {
    description = "SG do e-commerce de exemplo do livro "
    name = "sg_ecommerce-2"
    vpc_id     = "${aws_vpc.e-commerce.id}"
}

resource "aws_instance" "ec224da8f4" {
    #ami = "ami-09d95fab7fff3776c"
    ami = "ami-0947d2ba12ee1ff75"
    key_name = "maq-win-key"
    vpc_security_group_ids = [
        "sg-0ef3f5e1324d6769e"
    ]
    instance_type = "t2.micro"
    tenancy = "default"
    monitoring = false
    disable_api_termination = false
    instance_initiated_shutdown_behavior = "stop"
    credit_specification {
        cpu_credits = "standard"
    }

    tags = {
        projeto = "livro-microsservicos"
    }

    ebs_optimized = false
    root_block_device {
        volume_type = "gp2"
        volume_size = 8
    }
#user data, onde se pode adicionar comandos a serem executados apos a criação das instâncias
    user_data = <<EOF
		#! /bin/bash	
		sudo yum update -y
		sudo yum install java  -y
		sudo yum install git  -y
		sudo yum install maven  -y
		EOF
}