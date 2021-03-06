package tableCreateQuery;

import dbConnection.ReadProjectProperties;

public class StudentQuerys
{
	public static String getStudentPersonalCreateQuery()
	{
		return studentPersonalCreateQuery;
	}
	
	private static final String studentPersonalCreateQuery = "CREATE TABLE `Nascom`.`"+
												ReadProjectProperties.getProp("TNSTDPERSONALDETAILS")+"` ("
												+ "`stdid` VARCHAR(50) NOT NULL,"
												+ "`fname` VARCHAR(30) NOT NULL,"
												+ "`mname` VARCHAR(30) NULL,"
												+ "`lname` VARCHAR(30) NOT NULL,"
												+ "`dob` DATE NOT NULL,"
												+ "`gender` VARCHAR(15) NOT NULL,"
												+ "`branch` VARCHAR(10) NOT NULL,"
												+ "`email` VARCHAR(250) NOT NULL,"
												+ "`mobno` BIGINT NOT NULL,"
												+ "`category` VARCHAR(15) NOT NULL,"
												+ "`imagepath` VARCHAR(250) NULL,"
												+ "`addid` INT NOT NULL,"
												+ "`corespaddid` INT NOT NULL,"
												+ "`clsxrollno` VARCHAR(45) NOT NULL,"
												+ "`clsxiirollno` VARCHAR(45) NOT NULL,"
												+ "`fatherid` INT NULL,"
												+ "`motherid` INT NULL,"
												+ "`guardianid` INT NULL,"
												+ "PRIMARY KEY (`stdid`),"
												+ "CONSTRAINT `fk_stdid`"
												+ " FOREIGN KEY (`stdid`)"
												+ " REFERENCES `Nascom`.`USERS` (`userid`)"
												+ " ON DELETE RESTRICT"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_addid`"
												+ " FOREIGN KEY (`addid`)"
												+ " REFERENCES `Nascom`.`ADDRESS` (`addid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_corespaddid`"
												+ " FOREIGN KEY (`corespaddid`)"
												+ " REFERENCES `Nascom`.`ADDRESS` (`addid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_clsxid`"
												+ " FOREIGN KEY (`clsxrollno`)"
												+ " REFERENCES `Nascom`.`EDUCATION` (`rollno`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_clsxiiid`"
												+ " FOREIGN KEY (`clsxiirollno`)"
												+ " REFERENCES `Nascom`.`EDUCATION` (`rollno`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_fatherid`"
												+ " FOREIGN KEY (`fatherid`)"
												+ " REFERENCES `Nascom`.`GUARDIAN` (`gid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_motherid`"
												+ " FOREIGN KEY (`motherid`)"
												+ " REFERENCES `Nascom`.`GUARDIAN` (`gid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_guardianid`"
												+ " FOREIGN KEY (`guardianid`)"
												+ " REFERENCES `Nascom`.`GUARDIAN` (`gid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT );";
}
