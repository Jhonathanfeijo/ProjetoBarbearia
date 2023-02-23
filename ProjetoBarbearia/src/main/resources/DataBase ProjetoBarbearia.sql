CREATE DATABASE ProjetoBarbeariaDB;

USE ProjetoBarbeariaDB;

CREATE TABLE cliente(
id integer NOT NULL auto_increment,
dados_pessoais_id integer,
usuario_id integer,
primary key(id)
);

CREATE TABLE funcionario(
id integer NOT NULL auto_increment,
dados_pessoais_id integer,
usuario_id integer,
primary key(id)
);

CREATE TABLE usuario(
id integer NOT NULL auto_increment,
login varchar(30),
senha varchar(50),
primary key (id)
);

CREATE TABLE dados_pessoais(
id integer NOT NULL auto_increment,
nome varchar(50),
cpf varchar(11),
rg varchar(15),
data_nascimento DATE,
primary key(id)
);

CREATE TABLE item_servico_realizado(
id integer NOT NULL auto_increment,
servico_realizado_id integer,
servico_id integer,
quantidade integer,
primary key(id)
);

CREATE TABLE servico(
id integer NOT NULL auto_increment,
nome_servico varchar(50),
valor_servico numeric,
duracao_minutos integer,
primary key(id)
);

CREATE TABLE servico_realizado(
id integer NOT NULL auto_increment,
valor_total numeric,
cliente_id integer,
funcionario_id integer,
hora_conclusao datetime,
primary key(id)
);

ALTER TABLE cliente ADD CONSTRAINT fk_cliente_usuario foreign key (usuario_id) REFERENCES usuario (id);
ALTER TABLE cliente ADD CONSTRAINT fk_cliente_dados_pessoais foreign key (dados_pessoais_id) REFERENCES dados_pessoais (id);
ALTER TABLE funcionario ADD CONSTRAINT fk_funcionario_usuario foreign key (usuario_id) REFERENCES usuario (id);
ALTER TABLE funcionario ADD CONSTRAINT fk_funcionario_dados_pessoais foreign key (dados_pessoais_id) references dados_pessoais(id);
ALTER TABLE servico_realizado ADD CONSTRAINT fk_servico_realizado_cliente foreign key (cliente_id) references cliente(id);
ALTER TABLE servico_realizado ADD CONSTRAINT fk_servico_realizado_funcionario foreign key (funcionario_id) references funcionario (id);
ALTER TABLE item_servico_realizado ADD CONSTRAINT fk_item_servico_realizado_servico_realizado foreign key (servico_realizado_id) references servico_realizado(id);
ALTER TABLE item_servico_realizado ADD CONSTRAINT fk_item_servico_realizado_servico foreign key (servico_id) references servico(id);
