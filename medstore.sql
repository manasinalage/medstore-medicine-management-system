CREATE TABLE users (
 id SERIAL PRIMARY KEY,
 username VARCHAR(50) UNIQUE NOT NULL,
 password VARCHAR(255) NOT NULL,
 email VARCHAR(100) UNIQUE NOT NULL,
 mobile VARCHAR(15),
 age INT,
 role VARCHAR(20) NOT NULL
);

INSERT INTO users (username, password, email, mobile, age, role)
VALUES ('mansi', 'mansi123', 'mansi1926@gmail.com', '9421464001', 21, 'admin');


CREATE TABLE medicine (
 id SERIAL PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 category VARCHAR(50) NOT NULL,
 company VARCHAR(100) NOT NULL,
 price DECIMAL(10,2) NOT NULL,
 qty INT NOT NULL,
 expiry_date DATE NOT NULL
);
