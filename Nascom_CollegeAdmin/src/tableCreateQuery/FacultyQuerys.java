package tableCreateQuery;

import dbConnection.ReadProjectProperties;

public class FacultyQuerys
{
	public static String getFacpercreatequery()
	{
		return facPerCreateQuery;
	}
	public static String getFacsubcreatequery()
	{
		return facSubCreateQuery;
	}
	public static String getHigheducreatequery()
	{
		return highEduCreateQuery;
	}

	private static final String facPerCreateQuery = "CREATE TABLE `Nascom`.`"+
												ReadProjectProperties.getProp("TNFACPERSONAL")+"` ("
												+ "`facid` VARCHAR(50) NOT NULL,"
												+ "`fname` VARCHAR(30) NOT NULL,"
												+ "`mname` VARCHAR(30) NULL,"
												+ "`lname` VARCHAR(30) NOT NULL,"
												+ "`dob` DATE NOT NULL,"
												+ "`gender` VARCHAR(15) NOT NULL,"
												+ "`branch` VARCHAR(10) NOT NULL,"
												+ "`email` VARCHAR(250) NOT NULL,"
												+ "`mobno` BIGINT NOT NULL,"
												+ "`aadhar` BIGINT NOT NULL,"
												+ "`imagepath` VARCHAR(250) NULL,"
												+ "`addid` INT NOT NULL,"
												+ "`corespaddid` INT NOT NULL,"
												+ "`clsxrollno` VARCHAR(45) NOT NULL,"
												+ "`clsxiirollno` VARCHAR(45) NOT NULL,"
												+ "`guardianid` INT NULL,"
												+ "`highestqualid` INT NOT NULL,"
												+ "`experienceyr` INT NOT NULL,"
												+ "`lasttaught` VARCHAR(250) NULL,"
												+ "`subid` INT NOT NULL,"
												+ "`persuingcourse` VARCHAR(250) NULL,"
												+ "PRIMARY KEY (`facid`),"
												+ "CONSTRAINT `fk_facid`"
												+ " FOREIGN KEY (`facid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNUSERS")+"` (`userid`)"
												+ " ON DELETE RESTRICT"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_facaddid`"
												+ " FOREIGN KEY (`addid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNADDRESS")+"` (`addid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_faccorespaddid`"
												+ " FOREIGN KEY (`corespaddid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNADDRESS")+"` (`addid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_facclsxid`"
												+ " FOREIGN KEY (`clsxrollno`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNEDUCATION")+"` (`rollno`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_facclsxiiid`"
												+ " FOREIGN KEY (`clsxiirollno`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNEDUCATION")+"` (`rollno`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_facguardianid`"
												+ " FOREIGN KEY (`guardianid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNGUARDIAN")+"` (`gid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_subid`"
												+ " FOREIGN KEY (`subid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNFACSUB")+"` (`facsubid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT,"
												+ "CONSTRAINT `fk_highestqualid`"
												+ " FOREIGN KEY (`highestqualid`)"
												+ " REFERENCES `Nascom`.`"
												+ReadProjectProperties.getProp("TNFACHIGHEREDU")+"` (`fachighid`)"
												+ " ON DELETE CASCADE"
												+ " ON UPDATE RESTRICT );";
	
	private static final String facSubCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNFACSUB")+"` ("
			+ "`facsubid` INT NOT NULL  AUTO_INCREMENT,"
			+ "`sub1` VARCHAR(100) NOT NULL,"
			+ "`sub2` VARCHAR(100) NULL,"
			+ "`sub3` VARCHAR(100) NULL,"
			+ "PRIMARY KEY (`facsubid`));";
	
	private static final String highEduCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNFACHIGHEREDU")+"` ("
			+ "`fachighid` INT NOT NULL  AUTO_INCREMENT,"
			+ "`highqual` VARCHAR(100) NOT NULL,"
			+ "`highqualfrom` VARCHAR(250) NULL,"
			+ "`passingyr` INT NOT NULL,"
			+ "`aggregate` FLOAT NOT NULL,"
			+ "PRIMARY KEY (`fachighid`));";
}