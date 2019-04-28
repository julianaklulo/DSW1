create table Usuarios (
email varchar(150) not null,
senha varchar(300) not null,
papel varchar(20) not null,
ativo boolean not null,

CONSTRAINT Usuarios_PK PRIMARY KEY (email));

create table Teatros (
cnpj varchar(19) not null,
nome varchar(200) not null,
cidade varchar(200) not null,
email varchar(150) not null,

CONSTRAINT Teatros_PK PRIMARY KEY (cnpj),
CONSTRAINT Teatros_FK FOREIGN KEY (email) REFERENCES Usuarios(email));

create table Sites (
url varchar(200) not null,
nome varchar(200) not null,
telefone varchar(11) not null,
email varchar(150) not null,

CONSTRAINT Sites_PK PRIMARY KEY (url),
CONSTRAINT Sites_FK FOREIGN KEY (email) REFERENCES Usuarios(email));

create table Promocoes (
url varchar(200) not null,
cnpj varchar(19) not null,
nomepeca varchar(150) not null,
preco float not null,
datahora date,

CONSTRAINT Promocoes_PK PRIMARY KEY (url, cnpj, datahora),
CONSTRAINT Promocoes_FK1 FOREIGN KEY (url) REFERENCES Sites(url),
CONSTRAINT Promocoes_FK2 FOREIGN KEY (cnpj) REFERENCES Teatros(cnpj));

insert into Usuarios(email, senha, papel, ativo) values ('teatrostop@email.com', '123', 'ROLE_TEATRO', true);
insert into Usuarios(email, senha, papel, ativo) values ('roberto@email.com', '123', 'ROLE_TEATRO', true);
insert into Usuarios(email, senha, papel, ativo) values ('rogerio@email.com', '123', 'ROLE_TEATRO', true);

insert into Teatros(email, cnpj, nome, cidade) values ('teatrostop@email.com', '23.765.345/2019-04', 'Teatro São Carlos', 'São Carlos');
insert into Teatros(email, cnpj, nome, cidade) values ('roberto@email.com', '28.715.865/2019-04', 'Teatro São Paulo', 'São Paulo');
insert into Teatros(email, cnpj, nome, cidade) values ('rogerio@email.com', '68.845.578/2018-04', 'Teatro Municipal de Campinas', 'Campinas');


insert into Usuarios(email, senha, papel, ativo) values ('teatrostop@email.com', '123', 'ROLE_TEATRO', true);insert into Usuarios(email, senha, papel, ativo) values ('teatrostop@email.com', '123', 'ROLE_TEATRO', true);
insert into Usuarios(email, senha, papel, ativo) values ('teatrostop@email.com', '123', 'ROLE_TEATRO', true);
insert into Usuarios(email, senha, papel, ativo) values ('teatrostop@email.com', '123', 'ROLE_TEATRO', true);

insert into Sites(email, senha, url, nome, telefone) values ('vendasbco@email.com', 'tfgbhnii', 'www.vendasbco.com.br', 'vendasbco', '1623456789');
insert into Sites(email, senha, url, nome, telefone) values ('vendasbcc@email.com', 'tfnii', 'www.vendasbcc.com.br', 'vendasbcc', '1698765432');
insert into Sites(email, senha, url, nome, telefone) values ('vendasdelano@email.com', 'professordeweb', 'www.vendasdelano.com.br', 'vendasdelano', '1639573659');

insert into Usuarios(email, senha, papel, ativo) values ('vendasbco@email.com', '123', 'ROLE_SITE', true);
insert into Usuarios(email, senha, papel, ativo) values ('vendasbcc@email.com', '123', 'ROLE_SITE', true);
insert into Usuarios(email, senha, papel, ativo) values ('vendasdelano@email.com', '123', 'ROLE_SITE', true);

insert into Sites(email, url, nome, telefone) values ('vendasbco@email.com', 'www.vendasbco.com.br', 'vendasbco', '1623456789');
insert into Sites(email, url, nome, telefone) values ('vendasbcc@email.com', 'www.vendasbcc.com.br', 'vendasbcc', '1698765432');
insert into Sites(email, url, nome, telefone) values ('vendasdelano@email.com', 'www.vendasdelano.com.br', 'vendasdelano', '1639573659');

insert into Promocoes(url, cnpj, nomepeca, preco, datahora) values ('www.vendasbco.com.br', '23.765.345/2019-04', 'Fantasma da Ópera', 15.00, '2019-04-16 20:00:00.000');
insert into Promocoes(url, cnpj, nomepeca, preco, datahora) values ('www.vendasbcc.com.br', '28.715.865/2019-04', 'Os Cavaleiros do DM', 5.00, '2019-04-16 21:00:00.000');
insert into Promocoes(url, cnpj, nomepeca, preco, datahora) values ('www.vendasdelano.com.br', '68.845.578/2018-04', 'Professor nas alturas', 50.00, '2019-04-22 10:00:00.000');