CREATE DATABASE IF NOT EXISTS Employee_Performance;
USE Employee_Performance;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    vacation_days_taken INT NOT NULL,
    working_days_in_month INT NOT NULL,
    rate_per_day INT NOT NULL
);

select * from EMPLOYEES