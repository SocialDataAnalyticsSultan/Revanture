ALTER TABLE asya_bank.customer 
ADD CONSTRAINT customer_id_fk 
FOREIGN KEY (customer_id) 
REFERENCES asya_bank.customer_account(customer_id);


ALTER TABLE asya_bank.customer_account
ADD CONSTRAINT branch_id_fk 
FOREIGN KEY (branch_id) 
REFERENCES asya_bank.bank(branch_id);

ALTER TABLE asya_bank.customer_account
ADD CONSTRAINT employee_id_fk 
FOREIGN KEY (approving_employee_id) 
REFERENCES asya_bank.employee(employee_id);

ALTER TABLE asya_bank.customer_loan
ADD CONSTRAINT customer_id_fk 
FOREIGN KEY (customer_id) 
REFERENCES asya_bank.customer_account(customer_id);

ALTER TABLE asya_bank.customer_loan
ADD CONSTRAINT loan_id_fk 
FOREIGN KEY (loan_id) 
REFERENCES asya_bank.bank_loan(loan_id);

ALTER TABLE asya_bank.customer_loan
ADD CONSTRAINT employee_id_fk 
FOREIGN KEY (approving_employee_id) 
REFERENCES asya_bank.employee(employee_id);

ALTER TABLE asya_bank.customer_transaction
ADD CONSTRAINT customer_id_fk 
FOREIGN KEY (customer_id) 
REFERENCES asya_bank.customer_account(customer_id);

ALTER TABLE asya_bank.bank
ADD CONSTRAINT manager_id_fk 
FOREIGN KEY (manager_id) 
REFERENCES asya_bank.employee(employee_id);

ALTER TABLE asya_bank.employee
ADD CONSTRAINT branch_id_fk 
FOREIGN KEY (branch_id) 
REFERENCES asya_bank.bank(branch_id);

