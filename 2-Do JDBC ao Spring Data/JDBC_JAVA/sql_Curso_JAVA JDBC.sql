create table produto (id INT AUTO_INCREMENT,  nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), 
PRIMARY KEY(id)) Engine = innoDB;

INSERT INTO produto (nome, descricao) VALUES ('NOTEBOOK', 'NOTEBOOK SAMSUNG');

INSERT INTO produto (nome, descricao) VALUES ('GELADEIRA', 'GELADEIRA AZUL');

select * from produto;