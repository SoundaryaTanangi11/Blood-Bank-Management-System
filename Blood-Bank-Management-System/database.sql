CREATE TABLE donor (
  donorId INT PRIMARY KEY,
  name VARCHAR(50),
  age INT,
  bloodGroup VARCHAR(5),
  contact VARCHAR(15)
);

CREATE TABLE bloodquantity (
  bloodGroup VARCHAR(5),
  packetsofBlood INT
);
