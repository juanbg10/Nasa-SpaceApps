create database nasarenos;

create table login {cd_login int primary key not null, nm_email string(50) not null , ds_senha string(20) not null, cd_usuario int foreign key};
create table usuario {cd_usuario int primary key not null, nm_usuario string(25), ds_cep string(9), dt_nascimento date, cd_tipo int, ds_moradia string(5), nm_instituicao string(30), ds_comprovante string(30)};
create table local {cd_local int primary key, ds_lat string(20), ds_long string(10), ds_temperatura string(5), dt_local date, dt_repar date, ds_vegetacao string(20), ds_plurometrico string(20)};
create table criterio {cd_criterio int primary key, nm_criterio string(25)};	


insert into nasarenos.login (1, "adm@adm.com", "adm", 1);

insert into nasarenos.usuario(1, "Giovana Alves", "11045010", "1997-05-21", 1,"02", "Fatec Santos", "matricula");

insert into nasarenos.criterio(1,"temperatura");
insert into nasarenos.criterio(2,"vegetacao");
insert into nasarenos.criterio(3,"plurometrico");

insert into nasarenos.local {1, "72.18", "-121.82," "25", "2010-02-26", "20-10-2010", null, "0.02"};
insert into nasarenos.local {2, "80.99", "162.51", "20", "2010-02-26", "20-10-2010", null, null};