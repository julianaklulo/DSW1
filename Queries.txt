create table Teatros (
nome varchar(200) not null,
cidade varchar(200) not null,
cnpj varchar(19) not null,
email varchar(150) not null,
senha varchar(150) not null,

CONSTRAINT Teatros_PK PRIMARY KEY (cnpj));

create table Sites (
nome varchar(200) not null,
telefone varchar(11) not null,
url varchar(200) not null,
email varchar(150) not null,
senha varchar(150) not null,

CONSTRAINT Sites_PK PRIMARY KEY (url));

create table Promocoes (
id integer not null generated always as identity (start with 1, increment by 1),
url varchar(200) not null,
cnpj varchar(19) not null,
nome_peça varchar(150) not null,
preco float not null,
data_hora date,

CONSTRAINT Promocoes_PK PRIMARY KEY (id),
CONSTRAINT Promocoes_FK1 FOREIGN KEY (url) REFERENCES Sites (url),
CONSTRAINT Promocoes_FK2 FOREIGN KEY (cnpj) REFERENCES Teatros (cnpj));

insert into Teatros(email, senha, cnpj, nome, cidade) values ('teatrostop@email.com', 'xdrghuji', '23.765.345/2019-04', 'Teatro São Carlos', 'São Carlos');
insert into Teatros(email, senha, cnpj, nome, cidade) values ('roberto@email.com', 'huji', '28.715.865/2019-04', 'Teatro São Paulo', 'São Paulo');
insert into Teatros(email, senha, cnpj, nome, cidade) values ('rogério@email.com', 'uygfvnçl', '68.845.578/2018-04', 'Teatro Municipal de Campinas', 'Campinas');

insert into Sites(email, senha, url, nome, telefone) values ('vendasbco@email.com', 'tfgbhnii', 'www.vendasbco.com.br', 'vendasbco', '1623456789');
insert into Sites(email, senha, url, nome, telefone) values ('vendasbcc@email.com', 'tfnii', 'www.vendasbcc.com.br', 'vendasbcc', '1698765432');
insert into Sites(email, senha, url, nome, telefone) values ('vendasdelano@email.com', 'professordeweb', 'www.vendasdelano.com.br', 'vendasdelano', '1639573659');

insert into Promocoes(url, cnpj, nome_peça, preco, data_hora) values ('www.vendasbco.com.br', '23.765.345/2019-04', 'Fantasma da Ópera', 15.00, '2019-04-16 20:00:00.000');
insert into Promocoes(url, cnpj, nome_peça, preco, data_hora) values ('www.vendasbcc.com.br', '28.715.865/2019-04', 'Os Cavaleiros do DM', 5.00, '2019-04-16 21:00:00.000');
insert into Promocoes(url, cnpj, nome_peça, preco, data_hora) values ('www.vendasdelano.com.br', '68.845.578/2018-04', 'Professor nas alturas', 50.00, '2019-04-22 10:00:00.000');
