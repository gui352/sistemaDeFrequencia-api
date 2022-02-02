CREATE TABLE alunos (
    cadastro bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone bigint not null,
    data_Nascimento date not null,
    email varchar(60) not null,
    turma bigint not null,
    primary key(cadastro)
);