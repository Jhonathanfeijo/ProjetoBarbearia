
create database barbearia;

USE barbearia;

create table usuario(
id bigint not null auto_increment,
login varchar(200) not null unique,
senha varchar(200) not null,
primary key(id)
);
CREATE TABLE FUNCIONARIO(
id bigint not null auto_increment,
nome varchar(200) not null,
cpf varchar(11) not null unique,
rg varchar(25) not null,
data_nascimento datetime not null,
id_usuario bigint not null,
ativo tinyint not null,
primary key(id),
constraint fk_funcionario_id_usuario foreign key (id_usuario) references usuario (id)
);
CREATE TABLE cliente(
id bigint not null auto_increment,
nome varchar(200) not null,
cpf varchar(11) not null unique,
rg varchar(25) not null,
data_nascimento datetime not null,
id_usuario bigint not null,
ativo tinyint not null,
primary key(id),
constraint fk_cliente_id_usuario foreign key (id_usuario) references usuario (id)
);
create table servico(
id bigint not null auto_increment,
nome_servico varchar(100) not null,
valor_servico decimal not null,
duracao_minutos integer not null,
ativo tinyint not null,
primary key(id)
);
create table atendimento(

id bigint not null auto_increment,
id_funcionario bigint not null,
id_cliente bigint not null,
horario_marcado datetime not null,
horario_final datetime not null,
valor_atendimento decimal not null,
status varchar(50) not null,
primary key(id),
constraint fk_atendimento_id_cliente foreign key (id_cliente) references cliente (id),
constraint fk_atendimento_id_funcionario foreign key (id_funcionario) references funcionario (id)
);
create table item_atendimento(

id bigint not null auto_increment,
id_atendimento bigint not null,
quantidade integer not null,
id_servico bigint not null,
valor_item decimal not null,
primary key(id),
constraint fk_item_atendimento_id_atendimento foreign key (id_atendimento) references atendimento (id),
constraint fk_item_atendimento_id_servico foreign key (id_servico) references servico (id)
);
