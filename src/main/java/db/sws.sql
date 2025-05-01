CREATE TABLE product (
    id number generated always as identity primary key,
    name varchar2(150) not null,
    description varchar2(250) not null,
    price number(6, 2) not null,
    quantity int not null
);

create table users(
    id number generated always as identity primary key,
    username varchar2(50) not null,
    email varchar2(150),
    password varchar2(100)
);

create table admin(
    id number generated always as identity primary key,
    username varchar2(50) not null,
    email varchar2(150),
    password varchar2(100),
    domain varchar2(150)
);

select * from users;
select * from admin;