create table member(
	member_id varchar(30) primary key,
	member_pwd varchar(50) not null,
	member_name varchar(30) not null,
	member_email varchar(50) not null,
	member_date date not null
)

select *from member