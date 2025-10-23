-- Ensure the 'goods' table exists
CREATE TABLE IF NOT EXISTS goods (
    id UUID PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    product_type VARCHAR(100) NOT NULL,
    quantity_available INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    harvest_date DATE NOT NULL,
    expiry_date DATE NOT NULL
);

-- Insert product records only if they don't already exist

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789000',
       'Cow Milk',
       'Dairy',
       150,
       1.20,
       '2024-08-28',
       '2024-09-02'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789000');

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789001',
       'Chicken Eggs',
       'Eggs',
       200,
       0.15,
       '2024-08-27',
       '2024-09-10'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789001');

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789002',
       'Wheat',
       'Crop',
       500,
       0.30,
       '2024-07-15',
       '2025-07-15'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789002');

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789003',
       'Tomatoes',
       'Vegetable',
       100,
       0.80,
       '2024-08-25',
       '2024-09-05'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789003');

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789004',
       'Honey',
       'Bee Product',
       30,
       5.00,
       '2024-06-10',
       '2025-06-10'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789004');

INSERT INTO goods (id, product_name, product_type, quantity_available, unit_price, harvest_date, expiry_date)
SELECT '987e6543-e21b-45d3-a789-123456789005',
       'Corn',
       'Crop',
       400,
       0.25,
       '2024-07-20',
       '2025-07-20'
WHERE NOT EXISTS (SELECT 1 FROM goods WHERE id = '987e6543-e21b-45d3-a789-123456789005');
