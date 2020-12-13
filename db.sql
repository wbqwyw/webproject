show databases ;
create database mydb1;
use mydb1;
select database();
create user 'wangbq'@'localhost' identified by '123456';
grant all on mydb1.* to 'wangbq'@'localhost' identified by '123456';
create table manager(
    usercode int primary key ,
    username varchar(20) not null
)charset =utf8;

select * from manager;

insert into manager (usercode, username) VALUES (1,"zhangsan");
insert into manager (usercode, username) VALUES (2,"ภ๎หน");
insert into manager (usercode, username) VALUES (3,"ู๘ีþ");