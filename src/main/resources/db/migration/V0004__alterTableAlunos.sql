ALTER TABLE alunos ADD CONSTRAINT fk_id_turma
FOREIGN KEY (turma) REFERENCES turmas (id_Turma);