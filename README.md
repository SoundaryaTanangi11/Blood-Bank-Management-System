# Blood-Bank-Management-System
A desktop-based application designed to efficiently manage donor records and blood stock availability. The system ensures accurate data handling, simplifies blood inventory tracking, and improves accessibility of critical information for healthcare support.

The application is built using Java (Swing) for the user interface and MySQL for database management, providing a reliable and structured approach to handling blood donation data.

📌 Project Overview

The Blood Bank Management System is designed to:

- Maintain donor information in an organized manner
- Track available blood units in real-time
- Automatically update blood stock after each donation
- Provide a simple and user-friendly interface for managing records

The system ensures data consistency and reduces manual errors in managing blood bank operations.

⚙️ System Functionality

- Donor Registration
- Add new donor details including name, age, blood group, and contact information.
- Blood Stock Management
- Automatically updates the number of available blood packets after each donation.
- Database Integration
- Uses MySQL to store and retrieve donor and blood stock data efficiently.
- Data Validation & Retrieval
- Ensures correct data entry and allows quick access to stored records.

🛠️ Tech Stack

Frontend: Java Swing
Backend: Java (JDBC)
Database: MySQL
IDE Used: Eclipse

🗄️ Database Tables
donor
-donorId
- name
- age
- bloodGroup
- contact
bloodquantity
- bloodGroup
- packetsofBlood
 
🔄 Working Flow

- User enters donor details through the form
- Data is stored in the MySQL database
- Blood quantity is updated based on donor's blood group
- System allows retrieval and management of stored records
  
✨ Key Highlights

- Developed a fully functional desktop application using Java Swing
- Implemented JDBC connectivity for real-time database operations
- Designed a structured database schema for efficient data storage
- Automated blood stock updates to reduce manual effort
  
🚀 Future Enhancements

Add search and filter functionality for donors
Implement role-based access (Admin/User)
Convert into a full-stack web application (React + Java + MySQL)
Add real-time availability dashboard

📁 Project Purpose
This project demonstrates practical implementation of:

- Core Java concepts
- Database connectivity (JDBC)
- GUI development using Swing
- Real-world problem-solving in healthcare systems
