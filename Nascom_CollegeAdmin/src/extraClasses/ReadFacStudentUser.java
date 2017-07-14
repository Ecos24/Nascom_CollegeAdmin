package extraClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beanClasses.FacultyUser;
import beanClasses.StudentUser;
import dbConnection.GetDBConnection;
import dbConnection.ReadProjectProperties;

public class ReadFacStudentUser
{
	public static StudentUser readUser(String stdid)
			throws ClassNotFoundException, SQLException
	{
		StudentUser user = new StudentUser();
		Connection con = GetDBConnection.getConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNSTDPERSONALDETAILS")+" WHERE stdid = '"+stdid+"';");
		while( rs.next() )
		{
			user.setfName(rs.getString("fname"));
			user.setmName(rs.getString("mname"));
			user.setlName(rs.getString("lname"));
			user.setDOB(rs.getDate("dob"));
			user.setGender(rs.getString("gender"));
			user.setBranch(rs.getString("branch"));
			user.seteMail(rs.getString("email"));
			user.setMobNo(rs.getLong("mobno"));
			user.setCategory(rs.getString("category"));
			user.setImagePath(rs.getString("imagepath"));
			int addid = rs.getInt("addid");
			@SuppressWarnings("unused")
			int corespaddid = rs.getInt("corespaddid");
			user.setClsXRollNo(rs.getString("clsxrollno"));
			user.setClsXIIRollNo(Long.parseLong(rs.getString("clsxiirollno")));
			int fid = rs.getInt("fatherid");
			int mid = rs.getInt("motherid");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNADDRESS")+" WHERE addid = '"+addid+"';");
			while( rs1.next() )
			{
				user.setAdd(rs1.getString("address"));
				user.setCity(rs1.getString("city"));
				user.setState(rs1.getString("state"));
				user.setPinconde(rs1.getInt("pincode"));
				user.setCorespAdd(rs1.getString("address"));
				user.setCorespCity(rs1.getString("city"));
				user.setCorespState(rs1.getString("state"));
				user.setCorespPinconde(rs1.getInt("pincode"));
			}
			
			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNGUARDIAN")+" WHERE gid = '"+fid+"';");
			while( rs2.next() )
			{
				user.setFatherName(rs2.getString("name"));
				user.setFatherMobNo(rs2.getLong("mobno"));
				user.setFatherEMail(rs2.getString("email"));
				user.setFatherOccupation(rs2.getString("occupation"));
			}
			Statement st3 = con.createStatement();
			ResultSet rs3 = st3.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNGUARDIAN")+" WHERE gid = '"+mid+"';");
			while( rs3.next() )
			{
				user.setMotherName(rs3.getString("name"));
				user.setMotherMobNo(rs3.getLong("mobno"));
				user.setMotherEMail(rs3.getString("email"));
				user.setMotherOccupation(rs3.getString("occupation"));
			}
			Statement st4 = con.createStatement();
			ResultSet rs4 = st4.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNEDUCATION")+" WHERE rollno = '"+user.getClsXRollNo()+"';");
			while( rs4.next() )
			{
				user.setClsXBoard(rs4.getString("board"));
				user.setClsXMedium(rs4.getString("medium"));
				user.setClsXSchool(rs4.getString("school"));
				user.setClsXPassingYr(rs4.getInt("passingyr"));
				user.setClsXPercentage(rs4.getFloat("percentage"));
			}
			Statement st5 = con.createStatement();
			ResultSet rs5 = st5.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNEDUCATION")+" WHERE rollno = '"+user.getClsXIIRollNo()+"';");
			while( rs5.next() )
			{
				user.setClsXIIBoard(rs5.getString("board"));
				user.setClsXIIMedium(rs5.getString("medium"));
				user.setClsXIISchool(rs5.getString("school"));
				user.setClsXIIPassingYr(rs5.getInt("passingyr"));
				user.setClsXIIPercentage(rs5.getFloat("percentage"));
			}
		}
		return user;
	}

	public static FacultyUser readFacUser(String facid)
			throws ClassNotFoundException, SQLException
	{
		FacultyUser user = new FacultyUser();
		Connection con = GetDBConnection.getConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNFACPERSONAL")+" WHERE facid = '"+facid+"';");
		while( rs.next() )
		{
			user.setfName(rs.getString("fname"));
			user.setmName(rs.getString("mname"));
			user.setlName(rs.getString("lname"));
			user.setDob(rs.getDate("dob"));
			user.setGender(rs.getString("gender"));
			user.setBranch(rs.getString("branch"));
			user.seteMail(rs.getString("email"));
			user.setMobNo(rs.getLong("mobno"));
			user.setAadhar(rs.getLong("aadhar"));
			user.setImgPath(rs.getString("imagepath"));
			int addid = rs.getInt("addid");
			@SuppressWarnings("unused")
			int corespaddid = rs.getInt("corespaddid");
			user.setClsXRollNo(rs.getString("clsxrollno"));
			user.setClsXIIRollNo(Long.parseLong(rs.getString("clsxiirollno")));
			int gid = rs.getInt("guardianid");
			int higheduid = rs.getInt("highestqualid");
			user.setExperienceYr(rs.getInt("experienceyr"));
			user.setLastTaught(rs.getString("lasttaught"));
			int subid = rs.getInt("subid");
			user.setNameOfPersuingCourse(rs.getString("persuingcourse"));
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNADDRESS")+" WHERE addid = '"+addid+"';");
			while( rs1.next() )
			{
				user.setAdd(rs1.getString("address"));
				user.setCity(rs1.getString("city"));
				user.setState(rs1.getString("state"));
				user.setPinCode(rs1.getInt("pincode"));
				user.setCorespAdd(rs1.getString("address"));
				user.setCorespCity(rs1.getString("city"));
				user.setCorespState(rs1.getString("state"));
				user.setCorespPinCode(rs1.getInt("pincode"));
			}
			
			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNGUARDIAN")+" WHERE gid = '"+gid+"';");
			while( rs2.next() )
			{
				user.setGuardianName(rs2.getString("name"));
				user.setGuardianMobNo(rs2.getLong("mobno"));
				user.setGuardianEMail(rs2.getString("email"));
				user.setGuardianOccupation(rs2.getString("occupation"));
			}
			Statement st3 = con.createStatement();
			ResultSet rs3 = st3.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNFACHIGHEREDU")+" WHERE fachighid = '"+higheduid+"';");
			while( rs3.next() )
			{
				user.setHighestQual(rs3.getString("highqual"));
				user.setHighestQualFrom(rs3.getString("highqualfrom"));
				user.setHighestQualPassingYr(rs3.getInt("passingyr"));
				user.setHighestQualAggregate(rs3.getFloat("aggregate"));
			}
			Statement st4 = con.createStatement();
			ResultSet rs4 = st4.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNEDUCATION")+" WHERE rollno = '"+user.getClsXRollNo()+"';");
			while( rs4.next() )
			{
				user.setClsXBoard(rs4.getString("board"));
				user.setClsXPassingYr(rs4.getInt("passingyr"));
			}
			Statement st5 = con.createStatement();
			ResultSet rs5 = st5.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNEDUCATION")+" WHERE rollno = '"+user.getClsXIIRollNo()+"';");
			while( rs5.next() )
			{
				user.setClsXIIBoard(rs5.getString("board"));
				user.setClsXIIMedium(rs5.getString("medium"));
				user.setClsXIIPassingYr(rs5.getInt("passingyr"));
				user.setClsXIIPercentage(rs5.getFloat("percentage"));
			}
			Statement st6 = con.createStatement();
			ResultSet rs6 = st6.executeQuery("SELECT * FROM "+ReadProjectProperties.getProp("TNFACSUB")+" WHERE facsubid = '"+subid+"';");
			while( rs6.next() )
			{
				user.setSubject1(rs6.getString("sub1"));
				user.setSubject2(rs6.getString("sub2"));
				user.setSubject3(rs6.getString("sub3"));
			}
		}
		return user;
	}
}
