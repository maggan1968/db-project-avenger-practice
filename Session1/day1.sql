-- 1. get me all data from employees table

SELECT * froM EMPLOYEES;

-- 2. get me first_name, phone_number and salary from employees
select FIRST_NAME, PHONE_NUMBER, SALARY from EMPLOYEES;

-- 3. get me unique job_id from _____ table
select distinct JOB_ID from EMPLOYEES;

-- 4. get me all ST_CLERK from employee table
select JOB_ID, FIRST_NAME from EMPLOYEES
where JOB_ID = 'ST_CLERK';

-- 5. get me postal_code from JP,UK,CA
select POSTAL_CODE, COUNTRY_ID from LOCATIONS
where COUNTRY_ID = 'JP' or COUNTRY_ID = 'UK' or COUNTRY_ID = 'CA';

select POSTAL_CODE, COUNTRY_ID from LOCATIONS
where COUNTRY_ID in ('JP','UK','CA');

-- 6. get me city not in CH,US
select CITY, COUNTRY_ID from LOCATIONS
where COUNTRY_ID not in ('CH','US');


-- 7. get me job_title whose min_salary is more than 4000 and less than 9000
SELECT JOB_TITLE, MIN_SALARY from JOBS
where MIN_SALARY > 4000 and MIN_SALARY < 9000;

select JOB_TITLE, MIN_SALARY from JOBS
where MIN_SALARY between 4000 and 9000;

-- 8. get me null state_province in locations table
select STATE_PROVINCE from LOCATIONS
where STATE_PROVINCE is null;

-- 9. get me manager_id in departments table
select MANAGER_ID from DEPARTMENTS
where MANAGER_ID is not null;

-- 10. get me employee_id and start_date who starts in 2001
select EMPLOYEE_ID, START_DATE from JOB_HISTORY
where START_DATE like '%2001%';

-- 11. get me all employee first_name who works in some CLERK position
select FIRST_NAME, JOB_ID from EMPLOYEES
where JOB_ID like '%CLERK%';

-- 12. get me email whose email is 6 letter and 4th letter of email is E
select EMAIL from EMPLOYEES
where EMAIL like '___E__';

select FIRST_NAME from EMPLOYEES
where FIRST_NAME like '_____';

-- 13. get me last_name according to their hire_date
select LAST_NAME, HIRE_DATE from EMPLOYEES
order by HIRE_DATE;

-- 14. get me first_name ascending and salary descending
select FIRST_NAME, SALARY from EMPLOYEES
order by FIRST_NAME asc , SALARY asc;

-- aggregate functions  count, max, min, sum, avg

-- 15. get me the count of manager_id from departments
select MANAGER_ID from DEPARTMENTS;

select count(MANAGER_ID) from DEPARTMENTS;

-- 16. get me maximum salary of IT_PROG
select max(SALARY) from EMPLOYEES
where JOB_ID = 'IT_PROG';

-- minimum salary of SA_REP
select min(SALARY) from EMPLOYEES
where JOB_ID = 'SA_REP';

-- total salary of ST_MAN
select sum(SALARY) from EMPLOYEES
where JOB_ID = 'ST_MAN';

-- average salary of ST_CLERK
select avg(salary) from EMPLOYEES
where JOB_ID = 'ST_CLERK';

-- average salary of all employees
select avg(SALARY) from EMPLOYEES;

select round(avg(SALARY)) from EMPLOYEES;

-- 17. get me all city name uppercase and address losercase
select upper(CITY), lower(STREET_ADDRESS) from LOCATIONS;

-- 18. get me every job_title length
select JOB_TITLE , length(JOB_TITLE) from JOBS;

-- get me firstname + last name
select FIRST_NAME || ' ' || LAST_NAME as full_name from EMPLOYEES;

-- 19. get me maximum salary of each department_id
select DEPARTMENT_ID, max(SALARY) from EMPLOYEES
group by DEPARTMENT_ID;

-- 20. get me how many employees in each job_id
select JOB_ID, count(JOB_ID) from EMPLOYEES
group by JOB_ID;


-- 21. get me salary information( min, max, sum, avg) of each job_id
select JOB_ID, min(SALARY), max(SALARY), sum(SALARY), avg(SALARY) from EMPLOYEES
group by JOB_ID;

-- 22. get me job_id that total salary is more than 50000
select JOB_ID, sum(SALARY) from EMPLOYEES
group by JOB_ID
having sum(SALARY) > 50000;

-- 23. get me department_id who has more than 10 employee
select DEPARTMENT_ID, count(DEPARTMENT_ID) from EMPLOYEES
group by DEPARTMENT_ID
having count(DEPARTMENT_ID) > 10;

select DEPARTMENT_ID,count(*)
from EMPLOYEES
having count(*)>10
group by DEPARTMENT_ID;


-- 24. get me which job_id has average commission_pct over 20%
select JOB_ID, avg(COMMISSION_PCT) from EMPLOYEES
group by JOB_ID
having avg(COMMISSION_PCT) > 0.2;

-- 25. get me each manager_id max salary and find out those more than 10000
select MANAGER_ID , max(SALARY) from EMPLOYEES
group by MANAGER_ID
having max(SALARY) > 10000;