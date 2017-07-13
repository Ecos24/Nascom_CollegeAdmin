package tableCreateQuery;

import dbConnection.ReadProjectProperties;

public class CommonQuerys
{
	public static String getAddressCreateQuery()
	{
		return addressCreateQuery;
	}
	public static String getGuardianCreateQuery()
	{
		return guardianCreateQuery;
	}
	public static String getEducationCreateQuery()
	{
		return educationCreateQuery;
	}
	public static String getUsersCreateQuery()
	{
		return usersCreateQuery;
	}

	public static String getInsertUserQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNUSERS")+"(userid, usertype, password) VAlUES( ? , ? , ?);";
	}
	
	public static String getInsertAddressQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNADDRESS")+"(state, city, pincode, address) VAlUES( ?, ?, ?, ?);";
	}
	
	public static String getInsertEducationQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNEDUCATION")+"(rollno, passingyr, school, board, medium, percentage) VAlUES( ?, ?, ?, ?, ?, ?);";
	}
	
	public static String getInsertGuardianQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNGUARDIAN")+"(name, mobno, occupation, email) VAlUES( ?, ?, ?, ?);";
	}
	
	public static String getInsertStudentPersonalQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNSTDPERSONALDETAILS")+"(stdid, fname, mname, lname, dob, gender, email, mobno, category, imagepath, addid, corespaddid, clsxrollno, clsxiirollno, fatherid, motherid, guardianid, branch) VAlUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	}

	public static String getInsertFacultyPersonalQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNFACPERSONAL")+"(facid, fname, mname, lname, dob, gender, branch, email, mobno, aadhar, imagepath, addid, corespaddid, clsxrollno, clsxiirollno, guardianid, highestqualid, experienceyr, lasttaught, subid, persuingcourse) VAlUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	}

	public static String getInsertHigherEduQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNFACHIGHEREDU")+"(highqual, highqualfrom, passingyr, aggregate) VALUES(?, ?, ?, ?);";
	}

	public static String getInsertFacSubQuery()
	{
		return "INSERT INTO "+ReadProjectProperties.getProp("TNFACSUB")+"(sub1, sub2, sub3) VALUES(?, ?, ?);";
	}
	
	public static String getLatestFacIdQuery()
	{
		return "SELECT userid from "+ReadProjectProperties.getProp("TNUSERS")+" WHERE usertype = 'faculty' ORDER BY userid;";
	}
	public static String getLatestStdIdQuery()
	{
		return "SELECT userid from "+ReadProjectProperties.getProp("TNUSERS")+" WHERE usertype = 'student' ORDER BY userid DESC LIMIT 1;";
	}
	
	public static String getQueryAddressId()
	{
		return "SELECT addid from "+ReadProjectProperties.getProp("TNADDRESS")+" ORDER BY addid DESC LIMIT 1";
	}
	
	public static String getQueryGuardianId()
	{
		return "SELECT gid from "+ReadProjectProperties.getProp("TNGUARDIAN")+" ORDER BY gid DESC LIMIT 1";
	}
	
	public static String getQueryHigherEduId()
	{
		return "SELECT fachighid from "+ReadProjectProperties.getProp("TNFACHIGHEREDU")+" ORDER BY fachighid DESC LIMIT 1";
	}
	
	public static String getQueryFacSubId()
	{
		return "SELECT facsubid from "+ReadProjectProperties.getProp("TNFACSUB")+" ORDER BY facsubid DESC LIMIT 1";
	}
	
	public static String getSubjectCreateQuery()
	{
		return subjectCreateQuery;
	}

	private static final String usersCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNUSERS")+"` ("
			+ "`userid` VARCHAR(50) NOT NULL,"
			+ "`usertype` VARCHAR(20) NOT NULL,"
			+ "`password` VARCHAR(100) NOT NULL,"
			+ "PRIMARY KEY (`userid`,`usertype`));";

	private static final String subjectCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNSUBJECT")+"` ("
			+ "`subcode` VARCHAR(10) NOT NULL,"
			+ "`subname` VARCHAR(80) NOT NULL,"
			+ "PRIMARY KEY (`subcode`));";
	
	private static final String addressCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNADDRESS")+"` ("
			+ "`addid` INT NOT NULL AUTO_INCREMENT,"
			+ "`state` VARCHAR(50) NOT NULL,"
			+ "`city` VARCHAR(50) NOT NULL,"
			+ "`pincode` INT NOT NULL,"
			+ "`address` VARCHAR(250) NOT NULL,"
			+ "PRIMARY KEY (`addid`));";

	private static final String guardianCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNGUARDIAN")+"` ("
			+ "`gid` INT NOT NULL AUTO_INCREMENT,"
			+ "`name` VARCHAR(30) NOT NULL,"
			+ "`mobno` BIGINT NOT NULL,"
			+ "`occupation` VARCHAR(50) NOT NULL,"
			+ "`email` VARCHAR(250) NOT NULL,"
			+ "PRIMARY KEY (`gid`));";

	private static final String educationCreateQuery = "CREATE TABLE `Nascom`.`"+ReadProjectProperties.getProp("TNEDUCATION")+"` ("
			+ "`rollno` VARCHAR(45) NOT NULL,"
			+ "`passingyr` INT NOT NULL,"
			+ "`school` VARCHAR(250) NULL,"
			+ "`board` VARCHAR(30) NOT NULL,"
			+ "`medium` VARCHAR(45) NULL,"
			+ "`percentage` FLOAT NULL,"
			+ "PRIMARY KEY (`rollno`));";
}
