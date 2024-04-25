CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

INSERT INTO customers VALUES (1, 'Nguyen', 'Phu', 'trong1@example.com');
INSERT INTO customers VALUES (2, 'Nguyen', 'Phu', 'trong2@example.com');
INSERT INTO customers VALUES (3, 'Nguyen', 'Phu', 'trong3@example.com');
INSERT INTO customers VALUES (4, 'Nguyen', 'Phu', 'trong4@example.com');
INSERT INTO customers VALUES (5, 'Nguyen', 'Phu', 'trong5@example.com');

SELECT * FROM customers;


