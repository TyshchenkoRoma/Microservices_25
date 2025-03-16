

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
    uniq_id                varchar(200) ,
    available              boolean
);

/*move file to .data
*/
COPY product
    FROM 'file.csv'
    WITH (FORMAT CSV, HEADER true, DELIMITER ',');

\copy my_table FROM '/tmp/file.csv' DELIMITER ',' CSV HEADER;


SELECT * FROM product LIMIT 10;