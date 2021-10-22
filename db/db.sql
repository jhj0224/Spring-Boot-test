create table member
(
    id int(10) unsigned not null primary key auto_increment,
    regDate datetime not null,
    updateDate datetime not null,
    loginId char(20) not null,member
    loginPw char(60) not null,
    name char(20) not null,
    nickname char(20) not null,
    cellphone char(20) not null,
    email char(50) not null
);

show tables;

insert into member(regDate, updateDate, loginId, loginPw, name, nickname, cellphone, email) values(now(), now(), 'user1', 'user1', '정형준', '정형준', '010-1111-2222', 'jhj8664@gmail.com');
insert into member(regDate, updateDate, loginId, loginPw, name, nickname, cellphone, email) values(now(), now(), 'user2', 'user2', '홍길동', '홍길동', '010-2222-3333', 'user2@gmail.com');
insert into member(regDate, updateDate, loginId, loginPw, name, nickname, cellphone, email) values(now(), now(), 'user3', 'user3', '이순신', '이순신', '010-3333-5555', 'user3@gmail.com');

select *
from member;
