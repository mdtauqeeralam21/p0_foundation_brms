use p0_brms;
drop procedure if exists get_status;
DELIMITER &&  
CREATE PROCEDURE get_status (in var1 varchar(10))  
BEGIN  
    SELECT * FROM seat_status WHERE Bus_Reg_No= var1;  
END &&  
DELIMITER ;
call get_status("AB-9998");
SELECT COUNT(Bus_Reg_No) AS Total_Seats FROM seat_status WHERE Bus_Reg_No= "AB-9998";