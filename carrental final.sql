CREATE DATABASE CarRentalfinal;
USE CarRentalfinal;

-- Vehicle Table
CREATE TABLE Vehicle (
    vehicleID INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    dailyRate DECIMAL(10,2) NOT NULL,
    status ENUM('available', 'notAvailable') NOT NULL,
    passengerCapacity INT NOT NULL,
    engineCapacity INT NOT NULL  -- Changed from DECIMAL(5,2) to INT
);

-- Customer Table
CREATE TABLE Customer (
    customerID INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phoneNumber VARCHAR(15) UNIQUE NOT NULL
);

-- Lease Table
CREATE TABLE Lease (
    leaseID INT AUTO_INCREMENT PRIMARY KEY,
    vehicleID INT,
    customerID INT,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    type ENUM('DailyLease', 'MonthlyLease') NOT NULL,
    FOREIGN KEY (vehicleID) REFERENCES Vehicle(vehicleID) ON DELETE CASCADE,
    FOREIGN KEY (customerID) REFERENCES Customer(customerID) ON DELETE CASCADE
);

-- Payment Table
CREATE TABLE Payment (
    paymentID INT AUTO_INCREMENT PRIMARY KEY,
    leaseID INT,
    paymentDate DATE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (leaseID) REFERENCES Lease(leaseID) ON DELETE CASCADE
);

-- Insert Data into Vehicle Table
INSERT INTO Vehicle (make, model, year, dailyRate, status, passengerCapacity, engineCapacity) VALUES
('Toyota', 'Camry', 2022, 50.00, 'available', 4, 1450),
('Honda', 'Civic', 2023, 45.00, 'available', 7, 1500),
('Ford', 'Focus', 2022, 48.00, 'notAvailable', 4, 1400),
('Nissan', 'Altima', 2023, 52.00, 'available', 7, 1200),
('Chevrolet', 'Malibu', 2022, 47.00, 'available', 4, 1800),
('Hyundai', 'Sonata', 2023, 49.00, 'notAvailable', 7, 1400),
('BMW', '3 Series', 2023, 60.00, 'available', 7, 2499),
('Mercedes', 'C-Class', 2022, 58.00, 'available', 8, 2599),
('Audi', 'A4', 2023, 55.00, 'notAvailable', 4, 2500),
('Lexus', 'ES', 2023, 54.00, 'available', 4, 2500);

-- Insert Data into Customer Table
INSERT INTO Customer (firstName, lastName, email, phoneNumber) VALUES
('John', 'Doe', 'johndoe@example.com', '555-555-5555'),
('Jane', 'Smith', 'janesmith@example.com', '555-123-4567'),
('Robert', 'Johnson', 'robert@example.com', '555-789-1234'),
('Sarah', 'Brown', 'sarah@example.com', '555-456-7890'),
('David', 'Lee', 'david@example.com', '555-987-6543'),
('Laura', 'Hall', 'laura@example.com', '555-234-5678'),
('Michael', 'Davis', 'michael@example.com', '555-876-5432'),
('Emma', 'Wilson', 'emma@example.com', '555-432-1098'),
('William', 'Taylor', 'william@example.com', '555-321-6547'),
('Olivia', 'Adams', 'olivia@example.com', '555-765-4321');

-- Insert Data into Lease Table
INSERT INTO Lease (vehicleID, customerID, startDate, endDate, type) VALUES
(1, 1, '2023-01-01', '2023-01-05', 'DailyLease'),
(2, 2, '2023-02-15', '2023-02-28', 'MonthlyLease'),
(3, 3, '2023-03-10', '2023-03-15', 'DailyLease'),
(4, 4, '2023-04-20', '2023-04-30', 'MonthlyLease'),
(5, 5, '2023-05-05', '2023-05-10', 'DailyLease'),
(4, 7, '2023-06-15', '2023-06-30', 'MonthlyLease'),
(7, 7, '2023-07-01', '2023-07-10', 'DailyLease'),
(8, 8, '2023-08-12', '2023-08-15', 'MonthlyLease'),
(9, 10, '2023-09-07', '2023-09-10', 'DailyLease'),
(10, 10, '2023-10-10', '2023-10-31', 'MonthlyLease');

-- Insert Data into Payment Table
INSERT INTO Payment (leaseID, paymentDate, amount) VALUES
(1, '2023-01-03', 200.00),
(2, '2023-02-20', 1000.00),
(3, '2023-03-12', 75.00),
(4, '2023-04-25', 900.00),
(5, '2023-05-07', 60.00),
(6, '2023-06-18', 1200.00),
(7, '2023-07-03', 40.00),
(8, '2023-08-14', 1100.00),
(9, '2023-09-09', 80.00),
(10, '2023-10-25', 1500.00);

SELECT * FROM Vehicle;
SELECT * FROM Customer;
SELECT * FROM Lease;
SELECT * FROM Payment ;

-- 1. Update the daily rate for a Mercedes car to 68.

UPDATE Vehicle 
SET dailyRate = 68.00 
WHERE vehicleID=8;
-- Verify the update
SELECT * FROM Vehicle WHERE vehicleID=8 ;

-- 2. Delete a specific customer and all associated leases and payments.
DELETE FROM Customer WHERE email = 'johndoe@example.com';

-- 3. Rename the "paymentDate" column in the Payment table to "transactionDate".
ALTER TABLE Payment CHANGE paymentDate transactionDate DATE;

-- 4. Find a specific customer by email.
SELECT * FROM Customer WHERE email = 'janesmith@example.com';

-- 5. Get active leases for a specific customer.
SELECT * FROM Lease WHERE customerID = (SELECT customerID FROM Customer WHERE email = 'robert@example.com');

-- 6. Find all payments made by a customer with a specific phone number.
SELECT Payment.* FROM Payment 
JOIN Lease ON Payment.leaseID = Lease.leaseID 
JOIN Customer ON Lease.customerID = Customer.customerID 
WHERE Customer.phoneNumber = '555-123-4567';

-- 7. Calculate the average daily rate of all available cars.
SELECT AVG(dailyRate) AS avgDailyRate FROM Vehicle WHERE status = 'available';

-- 8. Find the car with the highest daily rate.
SELECT * FROM Vehicle ORDER BY dailyRate DESC LIMIT 1;

-- 9. Retrieve all cars leased by a specific customer.
SELECT Vehicle.* FROM Vehicle 
JOIN Lease ON Vehicle.vehicleID = Lease.vehicleID 
JOIN Customer ON Lease.customerID = Customer.customerID 
WHERE Customer.email = 'sarah@example.com';

-- 10. Find the details of the most recent lease.
SELECT * FROM Lease ORDER BY startDate DESC LIMIT 1;

-- 11. List all payments made in the year 2023.
SELECT * FROM Payment WHERE YEAR(transactionDate) = 2023;

-- 12. Retrieve customers who have not made any payments.
SELECT * FROM Customer WHERE customerID NOT IN (SELECT Lease.customerID FROM Lease JOIN Payment ON Lease.leaseID = Payment.leaseID);

-- 13. Retrieve Car Details and Their Total Payments.
SELECT Vehicle.vehicleID, Vehicle.make, Vehicle.model, SUM(Payment.amount) AS totalPayments 
FROM Vehicle 
JOIN Lease ON Vehicle.vehicleID = Lease.vehicleID 
JOIN Payment ON Lease.leaseID = Payment.leaseID 
GROUP BY Vehicle.vehicleID, Vehicle.make, Vehicle.model;

-- 14. Calculate Total Payments for Each Customer.
SELECT Customer.customerID, Customer.firstName, Customer.lastName, SUM(Payment.amount) AS totalPaid 
FROM Customer 
JOIN Lease ON Customer.customerID = Lease.customerID 
JOIN Payment ON Lease.leaseID = Payment.leaseID 
GROUP BY Customer.customerID;

-- 15. List Car Details for Each Lease.
SELECT Lease.leaseID, Vehicle.make, Vehicle.model, Lease.startDate, Lease.endDate 
FROM Lease 
JOIN Vehicle ON Lease.vehicleID = Vehicle.vehicleID;

-- 16. Retrieve Details of Active Leases with Customer and Car Information.
SELECT Lease.leaseID, Customer.firstName, Customer.lastName, Vehicle.make, Vehicle.model, Lease.startDate, Lease.endDate 
FROM Lease 
JOIN Customer ON Lease.customerID = Customer.customerID 
JOIN Vehicle ON Lease.vehicleID = Vehicle.vehicleID 
WHERE Lease.endDate >= CURDATE() AND Lease.startDate <= CURDATE();

-- 17. Find the Customer Who Has Spent the Most on Leases.
SELECT Customer.customerID, Customer.firstName, Customer.lastName, SUM(Payment.amount) AS totalSpent 
FROM Customer 
JOIN Lease ON Customer.customerID = Lease.customerID 
JOIN Payment ON Lease.leaseID = Payment.leaseID 
GROUP BY Customer.customerID 
ORDER BY totalSpent DESC LIMIT 1;

-- 18. List All Cars with Their Current Lease Information.
SELECT Vehicle.vehicleID, Vehicle.make, Vehicle.model, Lease.startDate, Lease.endDate, Customer.firstName, Customer.lastName 
FROM Vehicle 
LEFT JOIN Lease ON Vehicle.vehicleID = Lease.vehicleID 
LEFT JOIN Customer ON Lease.customerID = Customer.customerID;


SELECT  
    L.leaseID,  
    L.startDate,  
    L.endDate,  
    L.type AS leaseType,  
    C.customerID,  
    C.firstName,  
    C.lastName,  
    C.email,  
    C.phoneNumber,  
    V.vehicleID,  
    V.make,  
    V.model,  
    V.year,  
    V.dailyRate,  
    V.status  
FROM Lease L  
JOIN Customer C ON L.customerID = C.customerID  
JOIN Vehicle V ON L.vehicleID = V.vehicleID  
WHERE L.endDate >= CURDATE();  -- Fetch only active leases
