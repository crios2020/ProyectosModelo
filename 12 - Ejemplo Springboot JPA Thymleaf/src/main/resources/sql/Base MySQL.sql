drop database if exists colegio;
create database colegio;
use colegio;

create table cursos(
    id int auto_increment primary key,
    titulo varchar(20) not null,
    profesor varchar(20) not null,
    dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES') default 'LUNES',
    turno enum('MAÑANA','TARDE','NOCHE') default 'TARDE'
);

create table alumnos(
    id int auto_increment primary key,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    edad int not null,
    id_curso int not null
);

alter table alumnos
    add constraint FK_Alumnos_Cursos
    foreign key(id_curso)
    references cursos(id);

select version();
select * from cursos;
select * from alumnos;