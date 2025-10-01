INSERT INTO students (id, name, email, phone) VALUES (1001, 'Student 1', 'Email 1', 'Phone 1');
INSERT INTO students (id, name, email, phone) VALUES (1002, 'Student 2', 'Email 2', 'Phone 2');
INSERT INTO students (id, name, email, phone) VALUES (1003, 'Student 3', 'Email 3', 'Phone 3');

-- @OneToMany
INSERT INTO categories (name) VALUES ('Category 1');
INSERT INTO categories (name) VALUES ('Category 2');
INSERT INTO categories (name) VALUES ('Category 3');
--
INSERT INTO products (name, price, category_id) VALUES ('Product 1', 11, 1);
INSERT INTO products (name, price, category_id) VALUES ('Product 2', 12, 2);
INSERT INTO products (name, price, category_id) VALUES ('Product 3', 13, 3);