CREATE TABLE chamada (
    id_frequencia bigint not null auto_increment,
    data_Chamada DATE not null,
    id_Aluno bigint not null ,
    presenca boolean not null,
    primary key(id_frequencia)
);

ALTER TABLE chamada ADD CONSTRAINT fk_alunos_chamada
FOREIGN KEY (id_Aluno) REFERENCES alunos (n_Cadastro);