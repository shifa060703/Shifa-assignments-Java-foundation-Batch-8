CREATE DATABASE final;
USE final;
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    ContactNumber VARCHAR(20),
    Address TEXT
);
CREATE TABLE Courier (
    CourierID INT PRIMARY KEY,
    UserID INT,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    ReceiverName VARCHAR(255),
    ReceiverAddress TEXT,
    Weight DECIMAL(5,2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20) UNIQUE,
    DeliveryDate DATE,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);
CREATE TABLE CourierServices (
    ServiceID INT PRIMARY KEY,
    ServiceName VARCHAR(100),
    Cost DECIMAL(8,2)
);
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    ContactNumber VARCHAR(20),
    Role VARCHAR(50),
    Salary DECIMAL(10,2)
);
CREATE TABLE Location (
    LocationID INT PRIMARY KEY,
    LocationName VARCHAR(100),
    Address TEXT
);
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    CourierID INT,
    LocationID INT,
    Amount DECIMAL(10,2),
    PaymentDate DATE,
    FOREIGN KEY (CourierID) REFERENCES Courier(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID)
);

INSERT INTO User (UserID, Name, Email, Password, ContactNumber, Address) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'pass123', '1234567890', '123 Main St'),
(2, 'Bob Smith', 'bob@example.com', 'pass456', '0987654321', '456 Elm St'),
(3, 'Charlie Adams', 'charlie@example.com', 'pass789', '5671238901', '789 Pine St'),
(4, 'David Brown', 'david@example.com', 'pass234', '6789012345', '101 Oak St'),
(5, 'Eve Watson', 'eve@example.com', 'pass567', '7890123456', '202 Maple St'),
(6, 'Frank Miller', 'frank@example.com', 'pass678', '8901234567', '303 Cedar St'),
(7, 'Grace Lee', 'grace@example.com', 'pass789', '9012345678', '404 Birch St'),
(8, 'Henry White', 'henry@example.com', 'pass890', '1230984567', '505 Redwood St'),
(9, 'Ivy Thomas', 'ivy@example.com', 'pass901', '3214567890', '606 Aspen St'),
(10, 'Jack Wilson', 'jack@example.com', 'pass012', '6547891230', '707 Oakwood St');

INSERT INTO Courier (CourierID, UserID, SenderName, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate) VALUES
(1, 1, 'Alice Johnson', '123 Main St', 'David Brown', '789 Oak St', 2.5, 'In Transit', 'TRK12345', '2025-03-30'),
(2, 2, 'Bob Smith', '456 Elm St', 'Eve Adams', '101 Pine St', 1.2, 'Delivered', 'TRK67890', '2025-03-28'),
(3, 3, 'Charlie Adams', '789 Pine St', 'Frank Miller', '303 Cedar St', 3.0, 'Pending', 'TRK13579', '2025-04-01'),
(4, 4, 'David Brown', '101 Oak St', 'Grace Lee', '404 Birch St', 4.5, 'Shipped', 'TRK24680', '2025-04-02'),
(5, 5, 'Eve Watson', '202 Maple St', 'Henry White', '505 Redwood St', 2.8, 'In Transit', 'TRK11223', '2025-04-05'),
(6, 6, 'Frank Miller', '303 Cedar St', 'Ivy Thomas', '606 Aspen St', 1.5, 'Delivered', 'TRK33445', '2025-04-03'),
(7, 7, 'Grace Lee', '404 Birch St', 'Jack Wilson', '707 Oakwood St', 2.0, 'Pending', 'TRK55667', '2025-04-07'),
(8, 8, 'Henry White', '505 Redwood St', 'Alice Johnson', '123 Main St', 3.7, 'Shipped', 'TRK77889', '2025-04-06'),
(9, 9, 'Ivy Thomas', '606 Aspen St', 'Bob Smith', '456 Elm St', 2.3, 'In Transit', 'TRK99001', '2025-04-08'),
(10, 10, 'Jack Wilson', '707 Oakwood St', 'Charlie Adams', '789 Pine St', 1.8, 'Delivered', 'TRK11234', '2025-04-09');

INSERT INTO CourierServices (ServiceID, ServiceName, Cost) VALUES
(1, 'Standard Delivery', 50.00),
(2, 'Express Delivery', 100.00),
(3, 'Same Day Delivery', 150.00),
(4, 'Overnight Shipping', 200.00),
(5, 'International Shipping', 300.00),
(6, 'Heavy Parcel Delivery', 400.00),
(7, 'Secure Delivery', 250.00),
(8, 'Scheduled Delivery', 180.00),
(9, 'Eco-Friendly Delivery', 130.00),
(10, 'Drone Delivery', 500.00);

INSERT INTO Employee (EmployeeID, Name, Email, ContactNumber, Role, Salary) VALUES
(1, 'John Doe', 'john.doe@example.com', '1122334455', 'Delivery Agent', 40000.00),
(2, 'Emily Clark', 'emily.clark@example.com', '2233445566', 'Manager', 60000.00),
(3, 'Michael Johnson', 'michael.johnson@example.com', '3344556677', 'Supervisor', 55000.00),
(4, 'Jessica Lee', 'jessica.lee@example.com', '4455667788', 'Courier Handler', 42000.00),
(5, 'David Wilson', 'david.wilson@example.com', '5566778899', 'Delivery Agent', 40000.00),
(6, 'Sarah Brown', 'sarah.brown@example.com', '6677889900', 'Customer Support', 45000.00),
(7, 'James White', 'james.white@example.com', '7788990011', 'Delivery Agent', 41000.00),
(8, 'Linda Green', 'linda.green@example.com', '8899001122', 'Finance Manager', 70000.00),
(9, 'Robert Black', 'robert.black@example.com', '9900112233', 'Warehouse Manager', 50000.00),
(10, 'Olivia Harris', 'olivia.harris@example.com', '1111222333', 'Delivery Agent', 40000.00);

INSERT INTO Location (LocationID, LocationName, Address) VALUES
(1, 'Downtown Hub', '500 Center St'),
(2, 'Uptown Hub', '600 North St'),
(3, 'East End Hub', '700 East St'),
(4, 'West End Hub', '800 West St'),
(5, 'South Side Hub', '900 South St'),
(6, 'North Side Hub', '100 North St'),
(7, 'City Center Hub', '200 Central St'),
(8, 'Airport Hub', '300 Airport Rd'),
(9, 'Harbor Hub', '400 Dock St'),
(10, 'Industrial Hub', '500 Factory Ln');

INSERT INTO Payment (PaymentID, CourierID, LocationID, Amount, PaymentDate) VALUES
(1, 1, 1, 50.00, '2025-03-29'),
(2, 2, 2, 100.00, '2025-03-28'),
(3, 3, 3, 150.00, '2025-03-27'),
(4, 4, 4, 200.00, '2025-03-26'),
(5, 5, 5, 250.00, '2025-03-25'),
(6, 6, 6, 300.00, '2025-03-24'),
(7, 7, 7, 350.00, '2025-03-23'),
(8, 8, 8, 400.00, '2025-03-22'),
(9, 9, 9, 450.00, '2025-03-21'),
(10, 10, 10, 500.00, '2025-03-20');

SELECT * FROM User;
SELECT * FROM Courier;
SELECT * FROM CourierServices;
SELECT * FROM Employee;
SELECT * FROM Location;
SELECT * FROM Payment;

-- Retrieve all customer details from the User table
SELECT * FROM User;
-- Retrieve all orders placed by a specific customer (UserID = 1)
SELECT * FROM Courier WHERE UserID = 1;
-- Retrieve all courier (shipment) details
SELECT * FROM Courier;
-- Retrieve package details for a specific order (CourierID = 1)
SELECT * FROM Courier WHERE CourierID = 1;
-- Retrieve details of a courier using its tracking number
SELECT * FROM Courier WHERE TrackingNumber = 'TRK12345';
-- Retrieve all packages that have NOT been delivered yet
SELECT * FROM Courier WHERE Status <> 'Delivered';
-- Retrieve all packages scheduled for delivery today
SELECT * FROM Courier WHERE DeliveryDate = CURDATE();
-- Retrieve all packages with a specific delivery status (e.g., 'In Transit')
SELECT * FROM Courier WHERE Status = 'In Transit';
-- Count the total number of orders placed by each customer (UserID)
SELECT UserID, COUNT(CourierID) AS Total_Packages 
FROM Courier 
GROUP BY UserID;
-- Calculate the average delivery time for each package
SELECT CourierID, AVG(DATEDIFF(DeliveryDate, NOW())) AS Avg_Delivery_Time 
FROM Courier 
GROUP BY CourierID;
-- Retrieve all packages with a weight between 1.5kg and 3.0kg
SELECT * FROM Courier WHERE Weight BETWEEN 1.5 AND 3.0;
-- Retrieve all employees whose names contain 'John' anywhere
SELECT * FROM Employee WHERE Name LIKE '%Jessica Lee%';
-- Retrieve all courier records where payment amount is greater than $50
SELECT * 
FROM Courier 
WHERE CourierID IN (SELECT CourierID FROM Payment WHERE Amount > 50);

-- 14. Find the total number of couriers handled by each employee.
-- Since there is no direct Employee-Courier relation in your schema, this query is not possible 
-- unless you have an assignment table linking employees to couriers.
-- If employees are supposed to handle couriers, you need to create that relation.

-- 15. Calculate the total revenue generated by each location.
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS TotalRevenue
FROM Payment p
JOIN Location l ON p.LocationID = l.LocationID
GROUP BY l.LocationID, l.LocationName;

-- 16. Find the total number of couriers delivered to each receiver address.
SELECT ReceiverAddress, COUNT(CourierID) AS TotalCouriersDelivered
FROM Courier
WHERE Status = 'Delivered'
GROUP BY ReceiverAddress
ORDER BY TotalCouriersDelivered DESC;

-- 17. Find the courier with the highest average delivery time.
-- Since there is no dispatch date in your schema, this cannot be calculated correctly.
-- However, if we assume all deliveries started on the date of payment, we can use:
SELECT c.CourierID, c.TrackingNumber, AVG(DATEDIFF(c.DeliveryDate, p.PaymentDate)) AS AvgDeliveryTime
FROM Courier c
JOIN Payment p ON c.CourierID = p.CourierID
WHERE c.DeliveryDate IS NOT NULL
GROUP BY c.CourierID, c.TrackingNumber
ORDER BY AvgDeliveryTime DESC
LIMIT 1;

-- 18. Find locations with total payments less than a certain amount (e.g., $2000).
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS TotalPayments
FROM Payment p
JOIN Location l ON p.LocationID = l.LocationID
GROUP BY l.LocationID, l.LocationName
HAVING TotalPayments < 2000;

-- 19. Calculate total payments per location.
SELECT LocationID, SUM(Amount) AS TotalPayments
FROM Payment
GROUP BY LocationID
ORDER BY TotalPayments DESC;

-- 20. Retrieve couriers who have received payments totaling more than $1000 in a specific location.
SELECT c.CourierID, c.SenderName, c.ReceiverName, SUM(p.Amount) AS TotalPayment
FROM Payment p
JOIN Courier c ON p.CourierID = c.CourierID
WHERE p.LocationID = 2  -- Replace X with the specific LocationID
GROUP BY c.CourierID, c.SenderName, c.ReceiverName
HAVING TotalPayment < 1000;


-- 21. Retrieve couriers who have received payments totaling more than $1000 after a certain date.
SELECT c.CourierID, c.SenderName, c.ReceiverName, SUM(p.Amount) AS TotalPayment
FROM Payment p
JOIN Courier c ON p.CourierID = c.CourierID
WHERE p.PaymentDate > '2025-03-29'  -- Replace YYYY-MM-DD with your specific date
GROUP BY c.CourierID, c.SenderName, c.ReceiverName
HAVING TotalPayment < 1000;



-- 22. Retrieve locations where the total amount received is more than $5000 before a certain date.
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS TotalPayments
FROM Payment p
JOIN Location l ON p.LocationID = l.LocationID
WHERE p.PaymentDate < '2025-03-29'  -- Change the date as needed
GROUP BY l.LocationID, l.LocationName
HAVING TotalPayments < 5000;

-- 23. Retrieve Payments with Courier Information
SELECT p.*, c.* 
FROM Payment p
INNER JOIN Courier c ON p.CourierID = c.CourierID;

-- 24. Retrieve Payments with Location Information
SELECT p.*, l.* 
FROM Payment p
INNER JOIN Location l ON p.LocationID = l.LocationID;

-- 25. Retrieve Payments with Courier and Location Information
SELECT p.*, c.*, l.*
FROM Payment p
INNER JOIN Courier c ON p.CourierID = c.CourierID
INNER JOIN Location l ON p.LocationID = l.LocationID;

-- 26. List all payments with courier details
SELECT p.*, c.* 
FROM Payment p
LEFT JOIN Courier c ON p.CourierID = c.CourierID;

-- 27. Total payments received for each courier
SELECT CourierID, SUM(Amount) AS TotalPayments
FROM Payment
GROUP BY CourierID;

-- 28. List payments made on a specific date
SELECT * FROM Payment WHERE PaymentDate = '2025-03-29';

-- 29. Get Courier Information for Each Payment
SELECT p.*, c.* 
FROM Payment p
INNER JOIN Courier c ON p.CourierID = c.CourierID;

-- 30. Get Payment Details with Location
SELECT p.*, l.* 
FROM Payment p
INNER JOIN Location l ON p.LocationID = l.LocationID;

-- 31. Calculating Total Payments for Each Courier
SELECT CourierID, SUM(Amount) AS TotalPayments
FROM Payment
GROUP BY CourierID;

-- 32. List Payments Within a Date Range
SELECT * FROM Payment WHERE PaymentDate BETWEEN '2025-03-20' AND '2025-03-29';

-- 33. Retrieve a list of all users and their corresponding courier records (including unmatched cases)
SELECT u.*, c.* 
FROM User u
LEFT JOIN Courier c ON u.UserID = c.UserID;

-- 34. Retrieve a list of all couriers and their corresponding services (including unmatched cases)
SELECT c.*, cs.* 
FROM Courier c
LEFT JOIN CourierServices cs ON c.CourierID = cs.ServiceID;

-- 35. Retrieve a list of all employees and their corresponding payments (including unmatched cases)
SELECT e.*, p.* 
FROM Employee e
LEFT JOIN Payment p ON e.EmployeeID = p.PaymentID;

-- 36. List all users and all courier services (cross join for all possible combinations)
SELECT * FROM User CROSS JOIN CourierServices;

-- 37. List all employees and all locations (cross join for all possible combinations)
SELECT * FROM Employee CROSS JOIN Location;

-- 38. Retrieve a list of couriers and their corresponding sender information
SELECT CourierID, SenderName, SenderAddress FROM Courier;

-- 39. Retrieve a list of couriers and their corresponding receiver information
SELECT CourierID, ReceiverName, ReceiverAddress FROM Courier;

-- 40. Retrieve a list of couriers along with the courier service details
SELECT c.*, cs.* 
FROM Courier c
LEFT JOIN CourierServices cs ON c.CourierID = cs.ServiceID;

-- 41. Retrieve a list of employees and the number of couriers assigned to each (assuming an assignment table is missing)
SELECT e.EmployeeID, e.Name, COUNT(c.CourierID) AS TotalCouriers
FROM Employee e
LEFT JOIN Courier c ON e.EmployeeID = c.CourierID
GROUP BY e.EmployeeID, e.Name;

-- 42. Retrieve a list of locations and the total payment amount received at each location
SELECT l.LocationID, l.LocationName, SUM(p.Amount) AS TotalPayments
FROM Payment p
JOIN Location l ON p.LocationID = l.LocationID
GROUP BY l.LocationID, l.LocationName;

-- 43. Retrieve all couriers sent by the same sender
SELECT SenderName, COUNT(CourierID) AS TotalCouriers
FROM Courier
GROUP BY SenderName;

-- 44. List all employees who share the same role
SELECT Role, COUNT(EmployeeID) AS TotalEmployees
FROM Employee
GROUP BY Role;

-- 45. Retrieve all payments made for couriers sent from the same location
SELECT c.SenderAddress, SUM(p.Amount) AS TotalPayments
FROM Courier c
JOIN Payment p ON c.CourierID = p.CourierID
GROUP BY c.SenderAddress;

-- 46. Retrieve all couriers sent from the same location
SELECT SenderAddress, COUNT(CourierID) AS TotalCouriers
FROM Courier
GROUP BY SenderAddress;

-- 47. List employees and the number of couriers they have delivered
SELECT e.EmployeeID, e.Name, COUNT(c.CourierID) AS TotalDelivered
FROM Employee e
LEFT JOIN Courier c ON e.EmployeeID = c.CourierID
WHERE c.Status = 'Delivered'
GROUP BY e.EmployeeID, e.Name;

-- 48. Find couriers that were paid an amount greater than the cost of their respective courier services
SELECT c.CourierID, p.Amount, cs.Cost
FROM Payment p
JOIN Courier c ON p.CourierID = c.CourierID
JOIN CourierServices cs ON c.CourierID = cs.ServiceID
WHERE p.Amount > cs.Cost;

-- 49. Find couriers that have a weight greater than the average weight of all couriers
SELECT * FROM Courier WHERE Weight > (SELECT AVG(Weight) FROM Courier);

-- 50. Find employees with a salary greater than the average salary
SELECT * FROM Employee WHERE Salary > (SELECT AVG(Salary) FROM Employee);

-- 51. Find the total cost of all courier services where the cost is less than the maximum cost
SELECT SUM(Cost) AS TotalCost FROM CourierServices WHERE Cost < (SELECT MAX(Cost) FROM CourierServices);

-- 52. Find all couriers that have been paid for
SELECT * FROM Courier WHERE CourierID IN (SELECT DISTINCT CourierID FROM Payment);

-- 53. Find the locations where the maximum payment amount was made
SELECT LocationID, MAX(Amount) AS MaxPayment FROM Payment GROUP BY LocationID;

-- 54. Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender
SELECT * FROM Courier WHERE Weight > ALL (SELECT Weight FROM Courier WHERE SenderName = 'Alice Johnson');







