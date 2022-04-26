/*

Server	tuffi.db.elephantsql.com (tuffi-01)
Region	amazon-web-services::sa-east-1
Created at	2021-04-14 13:12 UTC+00:00
User & Default database	gdyhittm
Password 3pJiSBDlGj5FbzcM-gTRP4y_NIu81RJg
URL postgres://gdyhittm:3pJiSBDlGj5FbzcM-gTRP4y_NIu81RJg@tuffi.db.elephantsql.com/gdyhittm

*/


-- drop database if exists colegio;
-- create database colegio;
-- use colegio;

drop table if exists alumnos;
drop table if exists cursos;

create table cursos(
    id serial,
    titulo varchar(20) not null,
    profesor varchar(20) not null,
    dia varchar(20) not null,
    turno varchar(20) not null
);

create table alumnos(
    id serial,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    edad int not null,
    idCurso int not null
);

select version();
select * from cursos;
select * from alumnos;