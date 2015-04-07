create table member(
	member_id varchar(30) primary key,
	member_pwd varchar(50) not null,
	member_name varchar(30) not null,
	member_email varchar(50) not null,
	member_date date not null
)

select *from member

select to_char(sysdate,'yyyy-mm-dd hh-mi-ss') from dual
select to_char(1235342938498.34,'9,999,999,999,999.000') from dual
select to_char(to_date(to_char(member_date,'yyyymmdd'),'yyyy-mm-dd hh:mi:ss'),'yyyy-dd-mm') from member