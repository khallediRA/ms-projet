DROP TABLE IF EXISTS transaction;

CREATE TABLE `transaction` (
  `Transaction_id` int AUTO_INCREMENT  PRIMARY KEY,
  `Customer_id` int,
  `Transaction_amount` int ,
  `Transaction_type` varchar(20) ,
  `Transaction_date` varchar(20)
);


INSERT INTO `transaction` (`Customer_id`,`Transaction_amount`,`Transaction_type`,`Transaction_date`)
 VALUES ('1','2','Loyer','2022-02-02'); 
