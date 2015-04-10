create table account(
	account_id varchar(30) primary key,
	account_password varchar(50) not null,
	amount number(10) not null,
	account_type varchar(50) not null
);

create table account_type(
	type_name varchar(30) primary key,
	interest number(4,2) not null
)

create table account_list(
	customer_id varchar(30) constraint ac_cus_id foreign key customer_id references customer, 
	account_id varchar(30) constraint ac_ac_id foreign key account_id references account
)


select *from account



drop table account_list;
drop table account_type;
drop table account;
drop table customer;