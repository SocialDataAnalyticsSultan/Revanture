-- Select All Employees
select * 
from employee_info


-- Sellect All Employee (Full Name, Adress)
select concat_ws(' ', first_name, last_name) as "Employee Name",
	concat_ws(', ', street, city, state, country) as "Adress"
from employee_info


-- Sort Employee By Last Name
select * 
from employee_info
order by last_name, first_name


-- Employee Number in Each Depertmant
select dept.department_name as "Department Name",
	SUM(emp.employee_id)  as "Number Of Employee"
from employee_info as emp
join department_info as dept
on dept.department_id = emp.department_id 
group by dept.department_id 


-- Employee Works for Sales Department
select concat_ws(' ', ei.first_name, ei.last_name) as "Employee Name"
from employee_info ei
where ei.department_id in (select department_id
							from department_info di
							where di.department_name = 'Sales')
order by ei.last_name 


-- Each Department Manager Information
select di.department_id as "Department ID", di.department_name as "Department Name",
	concat_ws(' ', ei.first_name, ei.last_name) as "Manager Name",
	ei.email as "Email", ei.cellphone as "Phone Number"
from department_info di 
join employee_info ei 
on di.manager_id = ei.employee_id 


-- Total Sales in Each Month
select to_char(date_trunc('month', si.date)::date, 'Month') as "Month", 
	SUM(si.sales_amount) as "Total Sales"
from sales_info si 
group by date_trunc('month', si.date)
order by date_trunc('month', si.date)


-- Each Female Sales Employee Total Sale
select upper(concat_ws('  ', ei.first_name, ei.last_name)) as "Employee Name",
	sum(si.sales_amount) as "Total Sale" 
from employee_info ei
join sales_info si 
on ei.employee_id = si.employee_id 
where ei.gender = 'Female'
group by ei.employee_id
having ei.department_id in (select department_id
							from department_info di
							where di.department_name = 'Sales')
							and sum(si.sales_amount) > 70000::money
order by sum(si.sales_amount) desc


-- Each Sales Employee Client Number
select upper(concat_ws('  ', ei.first_name, ei.last_name)) as "Employee Name",
	count(distinct (si.client_id)) as "Total Client Number"
from employee_info ei
join sales_info si
on ei.employee_id = si.employee_id 
group by ei.employee_id
order by ei.last_name


-- Client Expenditure Information
select ci.client_company_name as "Company", 
	concat_ws('  ', ci.client_first_name , ci.client_last_name) as "Client Name",
	sum(si.sales_amount) as "Total Expenditure"
from client_info ci 
join sales_info si 
on ci.client_id = si.client_id 
group by ci.client_id 
order by sum(si.sales_amount)


-- Each Sales Employee Average Sales
select concat_ws('  ', ei.first_name, ei.last_name) as "Employee Name",
	sum(si.sales_amount)/count(si.employee_id) as "Average Sale"
from employee_info ei
join sales_info si
on ei.employee_id = si.employee_id 
group by ei.employee_id 
order by "Average Sale" desc