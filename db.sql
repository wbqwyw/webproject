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
insert into manager (usercode, username) VALUES (2,"ÀîË¹");
insert into manager (usercode, username) VALUES (3,"ÙøÕş");
insert into manager (usercode, username) VALUES (4,"ÕÔ¸ß");
insert into manager (usercode, username) VALUES (5,"ÃÉÒã");
insert into manager (usercode, username) VALUES (6,"·öËÕ");
insert into manager (usercode, username) VALUES (7,"Áõ°î");
insert into manager (usercode, username) VALUES (8,"ÏîÓğ");
insert into manager (usercode, username) VALUES (9,"ÂÀïô");