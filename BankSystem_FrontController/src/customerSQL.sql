create table customer(
	customer_id varchar(30) primary key,
	customer_password varchar(50) not null,
	customer_name varchar(30) not null,
	customer_account CLOB,
	customer_creditRating number(1) not null,
	customer_job varchar(20) not null,
	customer_age number(3) not null,
	customer_sex varchar(10) not null,
	customer_phoneNumber varchar(30) not null,
	customer_address varchar(50) not null
)

select *from customer where customer_id='id-1'

