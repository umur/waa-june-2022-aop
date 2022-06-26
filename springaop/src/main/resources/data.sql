
--Users
INSERT INTO users (id, email, firstname, lastname, password) VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '5631'); --123

INSERT INTO users (id, email, firstname, lastname, password) VALUES (2, 'john@miu.edu', 'john', 'doe', '5823'); --123

INSERT INTO users (id, email, firstname, lastname, password) VALUES (3, 'muhyidean@miu.edu', 'muhyidean', 'al-tarawneh', '1234'); --123

INSERT INTO users (id, email, firstname, lastname, password) VALUES (4, 'levi@miu.edu', 'keith', 'levi', '103'); --123

INSERT INTO users (id, email, firstname, lastname, password) VALUES (5, 'okalu@miu.edu', 'obinna', 'kalu', '896'); --123

INSERT INTO users (id, email, firstname, lastname, password) VALUES (6, 'tina@miu.edu', 'tina', 'xing', '8569'); --123
-- REVIEWS

INSERT INTO reviews (id,comment,usersi_id) VALUES (1,'awesome phone',1);

INSERT INTO reviews (id,comment,usersi_id) VALUES (2,'amazing phone',1);

INSERT INTO reviews (id,comment,usersi_id) VALUES (3,'awesome tablet',2);


--Address
INSERT INTO address  (id,street,zip,city,user_id) VALUES (1,'2803 winfield',52553,'charlotte',2);

INSERT INTO address  (id,street,zip,city,user_id) VALUES (2,'1000 4th street',62553,'Fairfield',3);

INSERT INTO address  (id,street,zip,city,user_id) VALUES (3,'1578 drive ave',36553,'Otumam',1);

--category
INSERT INTO Category (id,name) VALUES(1,'animals');
INSERT INTO Category (id,name) VALUES(2,'bread');
INSERT INTO Category (id,name) VALUES(3,'electronics');

-- PRODUCTS

INSERT INTO product (id, name, rating,price,category_id, userp_id) VALUES (1, 'iPhone',3, 1200,3,1);

INSERT INTO product (id, name,rating, price,category_id,userp_id) VALUES (2, 'iPad', 4, 900,3,2);

INSERT INTO product (id, name, rating,price,category_id,userp_id) VALUES (3, 'cat', 5, 100,1,1);


