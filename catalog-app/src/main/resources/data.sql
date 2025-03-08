DROP TABLE IF EXISTS product;

CREATE TABLE product (
                          uniq_id VARCHAR(200),
                          sku VARCHAR(1000),
                          name_title VARCHAR(200),
                          description TEXT,
                          list_price VARCHAR(100),
                          sale_price VARCHAR(100),
                          category VARCHAR(255),
                          category_tree TEXT,
                          average_product_rating VARCHAR(20),
                          product_url TEXT,
                          product_image_urls TEXT,
                          brand VARCHAR(255),
                          total_number_reviews VARCHAR(100),
                          reviews TEXT
);

DROP TABLE IF EXISTS inventory;

create table inventory
(
--     id                     int primary key,
    uniq_id                varchar(200) ,
--    sku                    varchar(1000) ,
    available              boolean
);


COPY product
    FROM '/tmp/file.csv'
    WITH (FORMAT CSV, HEADER true, DELIMITER ',');

SELECT * FROM product LIMIT 10;