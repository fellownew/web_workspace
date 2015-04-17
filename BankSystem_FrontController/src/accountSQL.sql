create table account_type(
	type_name varchar(30) primary key,
	interest number(4,2) not null
);

create table account(
	account_id varchar(30) primary key,
	account_password varchar(50) not null,
	amount number(10) not null,
	account_type varchar(50), 
	own_id varchar(30),
	foreign key(account_type) references account_type(type_name),
	foreign key(own_id) references customer(customer_id)
);


create table account_list(
	customer_id varchar(30),
	account_id varchar(30),
	foreign key (customer_id) references customer(customer_id), 
	foreign key (account_id) references account(account_id)
)

select *from customer
select *from account



drop table account_list;
drop table account_type;
drop table account;
drop table customer;