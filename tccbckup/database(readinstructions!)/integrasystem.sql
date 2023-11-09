create database if not exists integrasystem;
use integrasystem;

create table if not exists aluno(
	nome varchar(50) not null,
    alunoid int primary key not null auto_increment,
    necessidade varchar(30) not null,
    codigoTurma int not null,
    curso varchar(50) not null
);

create table if not exists coordenacao(
	coordenacaoid int primary key not null auto_increment,
    nomecoordenador varchar(50) not null,
    senha varchar(100) not null
);

create table if not exists professor(
	professorid int primary key not null auto_increment,
    nome varchar(50) not null,
    senha varchar(100) not null
);

create table if not exists observacoes(
	id int not null auto_increment primary key,
    titulo varchar(100) not null,
    conteudo varchar(255) not null,
    publidata varchar(25) not null
);

insert into coordenacao(nomecoordenador, senha) values("Iran","123");