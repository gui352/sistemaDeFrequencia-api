CREATE TABLE chamada (
    id_frequencia bigint not null auto_increment,
    data_Chamada DATE not null,
    id_Aluno bigint not null ,
    presenca boolean not null,
    primary key(id_frequencia)
);