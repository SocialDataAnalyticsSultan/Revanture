-- my_company.employee_info definition

-- Drop table

-- DROP TABLE my_company.employee_info;

CREATE TABLE my_company.employee_info (
	employee_id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	gender varchar(7) NULL,
	date_of_birth date NOT NULL,
	country varchar(20) NOT NULL,
	state varchar(20) NOT NULL,
	city varchar(20) NOT NULL,
	street varchar(100) NULL,
	cellphone varchar(20) NULL,
	department_id int4 NOT NULL,
	CONSTRAINT employee_info_csv_pk PRIMARY KEY (employee_id),
	CONSTRAINT employee_info_csv_un UNIQUE (email, cellphone)
);


-- my_company.employee_private_info definition

-- Drop table

-- DROP TABLE my_company.employee_private_info;

CREATE TABLE my_company.employee_private_info (
	employee_id int4 NOT NULL,
	ssn varchar(50) NOT NULL,
	account_number varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	CONSTRAINT employee_private_info_csv_pk PRIMARY KEY (employee_id),
	CONSTRAINT employee_private_info_csv_un UNIQUE (ssn, account_number, username, password)
);


-- my_company.employee_private_info foreign keys

ALTER TABLE my_company.employee_private_info ADD CONSTRAINT employee_private_info_csv_fk FOREIGN KEY (employee_id) REFERENCES my_company.employee_info(employee_id) ON UPDATE CASCADE ON DELETE CASCADE;


-- my_company.department_info definition

-- Drop table

-- DROP TABLE my_company.department_info;

CREATE TABLE my_company.department_info (
	department_id int4 NOT NULL,
	department_name varchar(30) NOT NULL,
	country varchar(20) NOT NULL,
	state varchar(20) NOT NULL,
	city varchar(20) NOT NULL,
	manager_id int4 NOT NULL,
	CONSTRAINT department_info_csv_pk PRIMARY KEY (department_id),
	CONSTRAINT department_info_csv_un UNIQUE (manager_id)
);


-- my_company.department_info foreign keys

ALTER TABLE my_company.department_info ADD CONSTRAINT department_info_csv_fk FOREIGN KEY (manager_id) REFERENCES my_company.employee_info(employee_id) ON UPDATE CASCADE ON DELETE SET NULL;


-- my_company.client_info definition

-- Drop table

-- DROP TABLE my_company.client_info;

CREATE TABLE my_company.client_info (
	client_id int4 NOT NULL,
	client_company_name varchar(100) NOT NULL,
	client_first_name varchar(20) NOT NULL,
	client_last_name varchar(20) NOT NULL,
	client_email varchar(50) NOT NULL,
	client_gender varchar(7) NULL,
	client_phone_number varchar(20) NOT NULL,
	CONSTRAINT client_info_csv_pk PRIMARY KEY (client_id),
	CONSTRAINT client_info_csv_un UNIQUE (client_email, client_phone_number)
);


-- my_company.sales_info definition

-- Drop table

-- DROP TABLE my_company.sales_info;

CREATE TABLE my_company.sales_info (
	sales_id int4 NOT NULL,
	employee_id int4 NOT NULL,
	"date" date NOT NULL,
	client_id int4 NOT NULL,
	sales_amount numeric(15,2) NOT NULL,
	CONSTRAINT sales_info_csv_pk PRIMARY KEY (sales_id)
);


-- my_company.sales_info foreign keys

ALTER TABLE my_company.sales_info ADD CONSTRAINT sales_info_csv_fk FOREIGN KEY (employee_id) REFERENCES my_company.employee_info(employee_id) ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE my_company.sales_info ADD CONSTRAINT sales_info_csv_fk_1 null;
