-- Categorias
INSERT INTO category (name) VALUES
('Bebidas Quentes'),
('Chás'),
('Snacks'),
('Doces');
SELECT * FROM category
-- Produtos
INSERT INTO product (product_name, category_id, quantity_per_unit, unit_price, units_in_stock, discontinued) VALUES 
('Café', 5, 10, 2.50, 100, FALSE),
('Chá', 6, 20, 12.00, 50, FALSE),
('Biscoito', 7, 30, 8.75, 75, FALSE),
('Chocolate Amargo', 8, 25, 18.90, 30, TRUE);

SELECT * FROM product

-- Funcionários
INSERT INTO employee (last_name, first_name, birth_date, hire_date, address, city, country) VALUES 
('Silva', 'Arthur', '1980-05-12', NULL, 'Rua das Flores, 123', 'São Paulo', 'Brasil'),
('Oliveira', 'Pedro', '1985-07-20', NULL, 'Av. Brasil, 456', 'Rio de Janeiro', 'Brasil');
INSERT INTO employee (last_name, first_name, birth_date, hire_date, address, city, country) VALUES 
('Silva', 'João', '1980-05-12', '2010-04-01', 'Rua das Flores, 123', 'São Paulo', 'Brasil'),
('Oliveira', 'Mariana', '1985-07-20', '2012-08-15', 'Av. Brasil, 456', 'Rio de Janeiro', 'Brasil'),
('Santos', 'Carlos', '1990-11-03', '2015-01-10', 'Rua A, 789', 'Belo Horizonte', 'Brasil'),
('Ferreira', 'Ana', '1993-02-28', '2018-06-20', 'Rua Central, 321', 'Curitiba', 'Brasil');
SELECT * FROM employee
-- Clientes
INSERT INTO customer (contact_name, company_name, contact_email, address, city, country) VALUES
('Paulo Mendes', 'TechSolutions', 'paulo@techsolutions.com', 'Av. Paulista, 1000', 'São Paulo', 'Brasil'),
('Laura Costa', 'InovaTI', 'laura@inovati.com', 'Rua das Acácias, 200', 'Rio de Janeiro', 'Brasil'),
('Rafael Lima', 'Construmax', 'rafael@construmax.com', 'Av. Atlântica, 333', 'Salvador', 'Brasil'),
('Fernanda Rocha', 'BioVida', 'fernanda@biovida.com', 'Rua das Palmeiras, 55', 'Fortaleza', 'Brasil');
SELECT * FROM customer
-- Compras
INSERT INTO purchase (customer_id, employee_id, total_price, purchase_date, shipped_date, ship_address, ship_city, ship_country) 
VALUES 
(1, 17, 15.50, '2024-06-01 10:00:00', '2024-06-03 12:00:00', 'Rua das Flores, 123', 'São Paulo', 'Brasil'),
(2, 18, 12.00, '2024-06-02 09:30:00', '2024-06-04 14:00:00', 'Av. Central, 456', 'Rio de Janeiro', 'Brasil'),
(1, 19, 8.75,  '2024-06-03 11:15:00', '2024-06-05 16:00:00', 'Rua da Paz, 789', 'Belo Horizonte', 'Brasil'),
(3,20, 18.90, '2024-06-04 15:45:00', '2024-06-06 10:00:00', 'Rua Alegre, 321', 'Curitiba', 'Brasil');
SELECT * FROM purchase
-- Itens da compra (usando preços coerentes com a tabela de produtos)
INSERT INTO purchase_item (purchase_id, product_id, unit_price, quantity) VALUES
(21, 21, 2.50, 3),  -- Café
(22, 22, 8.75, 1),  -- Biscoito
(23, 23, 18.90, 1); -- Chocolate Amargo

-- Produtos da categoria 2 ou 4 com preço > 3.5
SELECT product_name
FROM product
WHERE (category_id = 2 OR category_id = 4)
  AND unit_price > 3.5;

-- Produtos com nome da categoria
SELECT p.product_name, c.name AS category_name
FROM product p
JOIN category c ON p.category_id = c.category_id;

-- ordem alfabética
SELECT * FROM purchase;
SELECT * 
FROM category
ORDER BY name ASC;
-- funcionários por data de nascimento
SELECT last_name, first_name, birth_date
FROM employee
ORDER BY birth_date DESC;
--produtos por quantidade
SELECT * 
FROM product
ORDER BY units_in_stock DESC, product_name ASC;
--preço médio unitário de cada categoria
SELECT c.name AS name, 
       ROUND(AVG(p.unit_price), 2) AS average_unit_price
FROM category c
JOIN product p ON c.category_id = p.category_id
GROUP BY c.name
ORDER BY c.name;
SELECT city, COUNT(*) AS customers_quantity
FROM customer
--O número de clientes nas cidades
SELECT city, COUNT(*) AS customers_quantity
FROM customer
WHERE city NOT IN ('São Paulo')
GROUP BY city
ORDER BY city ASC;
-- porcentagem de dinheiro gasto pelo cliente na compra
SELECT 
  customer_id,
  purchase_id,
  ROUND((total_price / SUM(total_price) OVER (PARTITION BY customer_id)) * 100, 2) AS percent_spent
FROM purchase
ORDER BY customer_id, purchase_id;
--Funcionários com data de contratação desconhecida
SELECT last_name, first_name
FROM employee
WHERE hire_date IS NULL;