CREATE DATABASE courierdb;
USE courierdb;

CREATE TABLE courier (
    id INT PRIMARY KEY,
    sender VARCHAR(100),
    receiver VARCHAR(100),
    status VARCHAR(50),
    price DOUBLE
);

CREATE TABLE delivery_history (
    id INT AUTO_INCREMENT PRIMARY KEY,
    parcel_id INT,
    delivery_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (parcel_id) REFERENCES courier(id)
);
