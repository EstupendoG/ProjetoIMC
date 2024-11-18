CREATE DATABASE db_projImc;

USE db_projImc;

CREATE TABLE tb_aluno(
	al_cpf VARCHAR(15) PRIMARY KEY,
    al_nome VARCHAR(30),
    al_nascimento DATE,
    al_peso DOUBLE NOT NULL,
    al_altura DOUBLE NOT NULL
);
