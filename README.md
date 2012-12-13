vyshakIIITB
===========

DatabaseName: travelagency
Username: root
password:password

All the above details are to be changed in the 
queryinsert method in the  MyWizard class(MyWizard.java)

changes in the line:
conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagency", "root", "password");


In the database Table name is traveldetails

Table's create statement is as shown below.

create table traveldetails(
travelname varchar(200),
fromcity varchar(50),
tocity varchar(50),
via varchar(150),
traveldate varchar(20),
agent varchar(100));



Wizard name is wizardTravel.

