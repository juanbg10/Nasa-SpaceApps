create database nasarenos;

create table usuario (cd_usuario int primary key, nm_usuario varchar(25), ds_cep varchar(9), dt_nascimento date, cd_tipo int, ds_moradia varchar(5), nm_instituicao varchar(30), ds_comprovante varchar(30));
create table login (cd_login int primary key, nm_email varchar(50) not null , ds_senha varchar(20) not null, cd_usuario int);
create table local (cd_local int primary key, ds_lat varchar(20), ds_long varchar(10), ds_temperatura varchar(5), dt_local date, dt_repar date, ds_vegetacao varchar(20), ds_plurometrico varchar(20));
create table criterio (cd_criterio int primary key, nm_criterio varchar(25));	


insert into nasarenos.login (1, "adm@adm.com", "adm", 1);

insert into nasarenos.usuario(1, "Giovana Alves", "11045010", "1997-05-21", 1,"02", "Fatec Santos", "matricula");

insert into criterio(1,"temperatura");
insert into criterio(2,"vegetacao");
insert into criterio(3,"plurometrico");

insert into local (1, "72.18", "-121.82," "25", "2010-02-26", "20-10-2010", null, "0.02");
insert into local (2, "80.99", "162.51", "20", "2010-02-26", "20-10-2010", null, null);

