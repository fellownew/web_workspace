select *from CUSTOMER

select department_id,department_name,location from DEPARTMENT

select customer_id,customer_pwd from customer where customer_id='id-1'

insert into customer values ('id-2','2222','임꺽정',9,'남',33,'도둑','경기','010-2333-2444')

create table customer(
	customer_id varchar(30) primary key,
	customer_pwd varchar(30) not null,
	customer_name varchar(30) not null,
	credit_rating number(4) not null,
	job varchar(30) not null,
	age number(3) not null,
	sex varchar(6) not null,
	phone_Number varchar(30) not null,
	address varchar(30) not null
);

