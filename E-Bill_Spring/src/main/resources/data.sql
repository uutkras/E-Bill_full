-- Insert admin user
INSERT INTO users (user_id, password, customer_name, email, country_code, mobile, role, registered_at) 
VALUES ('uutkrasadmin', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'Administrator', 'admin@weenergy.com', '+91', '0000000000', 'ADMIN', CURRENT_TIMESTAMP);

-- Insert some test customers
INSERT INTO users (user_id, password, consumer_id, customer_name, email, country_code, mobile, role, registered_at) 
VALUES ('testuser1', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'CONS001', 'Test User 1', 'user1@test.com', '+91', '9876543210', 'CUSTOMER', CURRENT_TIMESTAMP);

-- Insert some test bills
INSERT INTO bills (bill_number, user_id, amount, bill_date, due_date, is_paid, status) 
VALUES ('BILL001', 2, 1500.00, CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE), false, 'PENDING'); 