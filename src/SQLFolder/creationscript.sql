CREATE DATABASES 

CREATE TABLE userTable(
User_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Username varchar(255) UNIQUE,
Email varchar(255),
Password binary(60) NOT NULL
);


CREATE TABLE shared_burden(
User_id INT NOT NULL,
Item_id INT AUTO_INCREMENT NOT NULL,
Item_name varchar(255),
T_timetamp TIMESTAMP,
Price varchar(255),

PRIMARY KEY (Item_id),
CONSTRAINT share_burden_FK
	FOREIGN KEY (User_id) 
	REFERENCES userTable(User_id)
	ON DELETE CASCADE 
	ON UPDATE CASCADE
);

-- When collecting information to Item object use this join command 
SELECT Item_name,UT.Username,Price, T_timetamp FROM shared_burden AS SB
JOIN userTable AS UT  ON  SB.User_ID = UT.User_ID;

SELECT * FROM userTable


