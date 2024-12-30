drop database hibernatebug;
create database hibernatebug;
use hibernatebug;
-- 创建clazz_inf表
create table clazz_inf
(
    clazz_code int primary key auto_increment,
    name varchar(255)
);
-- 创建student_inf表
create table student_inf
(
    student_id int primary key auto_increment,
    name varchar(255),
    age int,
    address varchar(255),
    gender char(2)
);
insert into clazz_inf
values
    (null, '疯狂Java训练营'),
    (null, '疯狂Java就业班'),
    (null, '疯狂Java基础班'),
    (null, '疯狂Java提高班');

insert into student_inf
values
    (null, 'aaa', 500, 'aaaaaa', 'M'),
    (null, 'bbb', 800, 'bbbbbb', 'M'),
    (null, 'ccc', 600, 'cccccc', 'M'),
    (null, 'ddd', 580, 'dddddd', 'M'),
    (null, 'eee', 23, 'eeeeee',  'F'),
    (null, 'fff', 18, 'ffffff', 'F'),
    (null, 'ggg', 21, 'gggggg', 'F'),
    (null, 'hhh', 19, 'hhhhhh', 'F');

create table student_clazz
(
    student_id int,
    clazz_code  int,
    active     boolean,
    foreign key(clazz_code) references clazz_inf(clazz_code),
    foreign key(student_id) references student_inf(student_id)
);

insert into student_clazz
values
    (1, 1, true),
    (1, 2, true),
    (1, 3, false),
    (1, 4, true),
    (2, 1, true),
    (2, 2, true),
    (2, 4, false),
    (3, 1, true),
    (3, 3, true),
    (3, 4, false),
    (4, 1, true),
    (4, 2, true),
    (4, 4, false);