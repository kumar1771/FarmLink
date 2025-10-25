-- Create tables first
CREATE TABLE IF NOT EXISTS order_request (
    order_id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    status VARCHAR(20) NOT NULL,
    order_date TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS goods_item (
    id UUID PRIMARY KEY,
    goods_id UUID NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    order_id UUID NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY(order_id) REFERENCES order_request(order_id)
);

CREATE TABLE IF NOT EXISTS orders (
    order_id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    email VARCHAR(255) NOT NULL,
    goods_id UUID NOT NULL,
    quantity INT NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    status VARCHAR(20) NOT NULL,
    order_date TIMESTAMP NOT NULL
);

-- Insert sample data into order_request
INSERT INTO order_request (order_id, customer_id, status, order_date)
SELECT 'b23e4567-e89b-12d3-a456-426614174000',
       '123e4567-e89b-12d3-a456-426614174001',
       'PENDING',
       TIMESTAMP '2025-10-25 08:00:00'
WHERE NOT EXISTS (SELECT 1 FROM order_request WHERE order_id = 'b23e4567-e89b-12d3-a456-426614174000');

-- Insert sample data into goods_item
INSERT INTO goods_item (id, goods_id, quantity, price, order_id)
SELECT 'c23e4567-e89b-12d3-a456-426614174000',
       '987e6543-e21b-45d3-a789-123456789000',
       2,
       1.20,
       'b23e4567-e89b-12d3-a456-426614174000'
WHERE NOT EXISTS (SELECT 1 FROM goods_item WHERE id = 'c23e4567-e89b-12d3-a456-426614174000');

INSERT INTO goods_item (id, goods_id, quantity, price, order_id)
SELECT 'c23e4567-e89b-12d3-a456-426614174001',
       '987e6543-e21b-45d3-a789-123456789003',
       5,
       0.80,
       'b23e4567-e89b-12d3-a456-426614174000'
WHERE NOT EXISTS (SELECT 1 FROM goods_item WHERE id = 'c23e4567-e89b-12d3-a456-426614174001');

-- Insert sample data into orders table
INSERT INTO orders (order_id, customer_id, email, goods_id, quantity, total_price, status, order_date)
SELECT 'a23e4567-e89b-12d3-a456-426614174000',
       '123e4567-e89b-12d3-a456-426614174000',
       'john.doe@example.com',
       '987e4567-e89b-12d3-a456-426614174000',
       2,
       49.99,
       'PENDING',
       TIMESTAMP '2024-04-01 10:15:00'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE order_id = 'a23e4567-e89b-12d3-a456-426614174000');

INSERT INTO orders (order_id, customer_id, email, goods_id, quantity, total_price, status, order_date)
SELECT 'a23e4567-e89b-12d3-a456-426614174001',
       '123e4567-e89b-12d3-a456-426614174001',
       'jane.smith@example.com',
       '987e4567-e89b-12d3-a456-426614174001',
       1,
       19.99,
       'CONFIRMED',
       TIMESTAMP '2024-03-15 09:00:00'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE order_id = 'a23e4567-e89b-12d3-a456-426614174001');

INSERT INTO orders (order_id, customer_id, email, goods_id, quantity, total_price, status, order_date)
SELECT 'a23e4567-e89b-12d3-a456-426614174002',
       '123e4567-e89b-12d3-a456-426614174002',
       'alice.johnson@example.com',
       '987e4567-e89b-12d3-a456-426614174002',
       5,
       99.95,
       'SHIPPED',
       TIMESTAMP '2024-02-28 16:45:00'
WHERE NOT EXISTS (SELECT 1 FROM orders WHERE order_id = 'a23e4567-e89b-12d3-a456-426614174002');
