-- asya_bank.bank definition

-- Drop table

-- DROP TABLE asya_bank.bank;

CREATE TABLE asya_bank.bank (
	branch_id int4 NOT NULL,
	street varchar(50) NOT NULL,
	city varchar(20) NOT NULL,
	state varchar(20) NOT NULL,
	country varchar(20) NOT NULL,
	zipcode varchar(5) NOT NULL,
	manager_id int4 NOT NULL,
	CONSTRAINT bank_pk PRIMARY KEY (branch_id),
	CONSTRAINT bank_un UNIQUE (manager_id, zipcode)
);


-- asya_bank.bank foreign keys

ALTER TABLE asya_bank.bank ADD CONSTRAINT manager_id_fk FOREIGN KEY (manager_id) REFERENCES asya_bank.employee(employee_id);


-- asya_bank.bank_loan definition

-- Drop table

-- DROP TABLE asya_bank.bank_loan;

CREATE TABLE asya_bank.bank_loan (
	loan_id int4 NOT NULL,
	loan_type varchar(20) NOT NULL,
	interest_rate float8 NOT NULL,
	CONSTRAINT bank_loan_pk PRIMARY KEY (loan_id)
);



-- asya_bank.customer definition

-- Drop table

-- DROP TABLE asya_bank.customer;

CREATE TABLE asya_bank.customer (
	customer_id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	date_of_birth date NOT NULL,
	gender varchar(10) NOT NULL,
	marital_status varchar(10) NULL,
	social_security_number varchar(20) NULL,
	nationality varchar(40) NULL,
	phone_number varchar(20) NOT NULL,
	email varchar(40) NOT NULL,
	street varchar(50) NOT NULL,
	city varchar(20) NOT NULL,
	state varchar(20) NOT NULL,
	country varchar(20) NOT NULL,
	zipcode varchar(5) NOT NULL,
	occupation varchar(50) NULL,
	yearly_income numeric(10) NOT NULL,
	credit_score int4 NOT NULL,
	username varchar(20) NOT NULL,
	"password" varchar(20) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (customer_id),
	CONSTRAINT customer_un UNIQUE (social_security_number, phone_number, email, username, password)
);


-- asya_bank.customer foreign keys

ALTER TABLE asya_bank.customer ADD CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES asya_bank.customer_account(customer_id);


-- asya_bank.customer_account definition

-- Drop table

-- DROP TABLE asya_bank.customer_account;

CREATE TABLE asya_bank.customer_account (
	customer_id int4 NOT NULL,
	account_type varchar(10) NOT NULL,
	account_number varchar(20) NOT NULL,
	open_date date NOT NULL,
	balance int4 NOT NULL,
	branch_id int4 NOT NULL,
	approving_employee_id int4 NOT NULL,
	CONSTRAINT customer_account_pk PRIMARY KEY (customer_id),
	CONSTRAINT customer_account_un UNIQUE (account_number)
);


-- asya_bank.customer_account foreign keys

ALTER TABLE asya_bank.customer_account ADD CONSTRAINT branch_id_fk FOREIGN KEY (branch_id) REFERENCES asya_bank.bank(branch_id);
ALTER TABLE asya_bank.customer_account ADD CONSTRAINT employee_id_fk FOREIGN KEY (approving_employee_id) REFERENCES asya_bank.employee(employee_id);

-- asya_bank.customer_loan definition

-- Drop table

-- DROP TABLE asya_bank.customer_loan;

CREATE TABLE asya_bank.customer_loan (
	loan_application_id varchar(20) NOT NULL,
	customer_id int4 NOT NULL,
	loan_id int4 NOT NULL,
	date_of_application date NOT NULL,
	status varchar(20) NOT NULL,
	loan_amount numeric(10) NOT NULL,
	duration_year int4 NOT NULL,
	approving_employee_id int4 NOT NULL,
	total_payment_amount numeric(8) NULL,
	monthly_payment_amount numeric(8) NULL,
	CONSTRAINT customer_loan_pk PRIMARY KEY (loan_application_id)
);


-- asya_bank.customer_loan foreign keys

ALTER TABLE asya_bank.customer_loan ADD CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES asya_bank.customer_account(customer_id);
ALTER TABLE asya_bank.customer_loan ADD CONSTRAINT employee_id_fk FOREIGN KEY (approving_employee_id) REFERENCES asya_bank.employee(employee_id);
ALTER TABLE asya_bank.customer_loan ADD CONSTRAINT loan_id_fk FOREIGN KEY (loan_id) REFERENCES asya_bank.bank_loan(loan_id);


-- asya_bank.customer_transaction definition

-- Drop table

-- DROP TABLE asya_bank.customer_transaction;

CREATE TABLE asya_bank.customer_transaction (
	transaction_id varchar(20) NOT NULL,
	customer_id int4 NOT NULL,
	transaction_time timestamp(0) NOT NULL,
	transaction_type varchar(20) NOT NULL,
	transaction_amount numeric(10) NOT NULL,
	balance numeric(10) NOT NULL,
	CONSTRAINT customer_transaction_pk PRIMARY KEY (transaction_id)
);


-- asya_bank.customer_transaction foreign keys

ALTER TABLE asya_bank.customer_transaction ADD CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES asya_bank.customer_account(customer_id);

-- asya_bank.employee definition

-- Drop table

-- DROP TABLE asya_bank.employee;

CREATE TABLE asya_bank.employee (
	employee_id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	date_of_birth date NOT NULL,
	gender varchar(10) NOT NULL,
	marital_status varchar(10) NULL,
	social_security_number varchar(20) NOT NULL,
	nationality varchar(50) NULL,
	phone_number varchar(20) NOT NULL,
	email varchar(40) NOT NULL,
	street varchar(50) NOT NULL,
	city varchar(20) NOT NULL,
	state varchar(20) NOT NULL,
	country varchar(20) NOT NULL,
	zipcode varchar(5) NOT NULL,
	yearly_income numeric(10) NOT NULL,
	credit_score int4 NOT NULL,
	username varchar(20) NOT NULL,
	"password" varchar(20) NOT NULL,
	account_number varchar(20) NOT NULL,
	balance numeric(10) NULL,
	date_of_start date NOT NULL,
	branch_id int4 NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (employee_id),
	CONSTRAINT employee_un UNIQUE (social_security_number, phone_number, email, username, password, account_number)
);


-- asya_bank.employee foreign keys

ALTER TABLE asya_bank.employee ADD CONSTRAINT branch_id_fk FOREIGN KEY (branch_id) REFERENCES asya_bank.bank(branch_id);


