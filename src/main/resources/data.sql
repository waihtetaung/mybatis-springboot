DROP DATABASE mybatis;
CREATE DATABASE mybatis;
USE mybatis;

CREATE TABLE Category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO Category(name) VALUES ("Ancient Weapon");
INSERT INTO Category(name) VALUES ("Modern Weapon");

CREATE TABLE Product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES Category(id)
);

INSERT INTO Product(name, status, category_id) VALUES ("Ruyi Jingu Bang", false, 1);
INSERT INTO Product(name, status, category_id) VALUES ("Light Saber", true, 2);
INSERT INTO Product(name, status, category_id) VALUES ("Xcalibar", true, 1);
INSERT INTO Product(name, status, category_id) VALUES ("Gae Blog", true, 1);
INSERT INTO Product(name, status, category_id) VALUES ("Holy Grail", false, 1);
INSERT INTO Product(name, status, category_id) VALUES ("Phaser", false, 2);

SELECT p.name AS product_name, c.name AS category_name, p.status FROM Product p JOIN Category c ON p.categoryId = c.id;