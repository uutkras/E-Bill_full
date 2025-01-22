CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    consumer_id VARCHAR(50),
    customer_name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    country_code VARCHAR(5),
    mobile VARCHAR(15),
    role VARCHAR(20) NOT NULL,
    registered_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS bills (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bill_number VARCHAR(50) UNIQUE NOT NULL,
    user_id BIGINT,
    amount DECIMAL(10,2) NOT NULL,
    bill_date DATE NOT NULL,
    due_date DATE NOT NULL,
    is_paid BOOLEAN DEFAULT FALSE,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
); 