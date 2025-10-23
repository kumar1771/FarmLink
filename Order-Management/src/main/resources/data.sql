CREATE TABLE IF NOT EXISTS orders (
    order_id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    email VARCHAR(255) NOT NULL,
    goods_id UUID NOT NULL,
    quantity INT NOT NULL,
    total_price DOUBLE PRECISION NOT NULL,
    status VARCHAR(20) NOT NULL,  -- e.g., PENDING, CONFIRMED, etc.
    order_date TIMESTAMP NOT NULL
);

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
