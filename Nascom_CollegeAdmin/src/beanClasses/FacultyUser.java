package beanClasses;

import java.sql.Date;

public class FacultyUser extends User
{
	private String fName;
	private String mName;
	private String lName;
	private Date dob;
	private String gender;
	private String eMail;
	private long mobNo;
	private long aadhar;
	private String imgPath;
	private String state;
	private String city;
	private int pinCode;
	private String add;
	private boolean corespAddFlag;
	private String corespState;
	private String corespCity;
	private int corespPinCode;
	private String corespAdd;
	private String guardianName;
	private long guardianMobNo;
	private String guardianEMail;
	private String guardianOccupation;
	private String clsXRollNo;
	private int clsXPassingYr;
	private String clsXBoard;
	private long clsXIIRollNo;
	private int clsXIIPassingYr;
	private String clsXIIBoard;
	private float clsXIIPercentage;
	private String clsXIIMedium;
	private String highestQual;
	private String highestQualFrom;
	private float highestQualAggregate;
	private int highestQualPassingYr;
	private int experienceYr;
	private String lastTaught;
	private String subject1;
	private String subject2;
	private String subject3;
	private boolean persuingCourse;
	private String nameOfPersuingCourse;
	
	public String getGuardianOccupation()
	{
		return guardianOccupation;
	}
	public void setGuardianOccupation(String guardianOccupation)
	{
		this.guardianOccupation = guardianOccupation;
	}
	public boolean isPersuingCourse()
	{
		return persuingCourse;
	}
	public void setPersuingCourse(boolean persuingCourse)
	{
		this.persuingCourse = persuingCourse;
	}
	public boolean isCorespAddFlag()
	{
		return corespAddFlag;
	}
	public void setCorespAddFlag(boolean corespAddFlag)
	{
		this.corespAddFlag = corespAddFlag;
	}
	public Date getDob()
	{
		return dob;
	}
	public void setDob(Date dob)
	{
		this.dob = dob;
	}
	public String getfName()
	{
		return fName;
	}
	public void setfName(String fName)
	{
		this.fName = fName;
	}
	public String getmName()
	{
		return mName;
	}
	public void setmName(String mName)
	{
		this.mName = mName;
	}
	public String getlName()
	{
		return lName;
	}
	public void setlName(String lName)
	{
		this.lName = lName;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String geteMail()
	{
		return eMail;
	}
	public void seteMail(String eMail)
	{
		this.eMail = eMail;
	}
	public long getMobNo()
	{
		return mobNo;
	}
	public void setMobNo(long mobNo)
	{
		this.mobNo = mobNo;
	}
	public long getAadhar()
	{
		return aadhar;
	}
	public void setAadhar(long aadhar)
	{
		this.aadhar = aadhar;
	}
	public String getImgPath()
	{
		return imgPath;
	}
	public void setImgPath(String imgPath)
	{
		this.imgPath = imgPath;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public int getPinCode()
	{
		return pinCode;
	}
	public void setPinCode(int pinCode)
	{
		this.pinCode = pinCode;
	}
	public String getAdd()
	{
		return add;
	}
	public void setAdd(String add)
	{
		this.add = add;
	}
	public String getCorespState()
	{
		return corespState;
	}
	public void setCorespState(String corespState)
	{
		this.corespState = corespState;
	}
	public String getCorespCity()
	{
		return corespCity;
	}
	public void setCorespCity(String corespCity)
	{
		this.corespCity = corespCity;
	}
	public int getCorespPinCode()
	{
		return corespPinCode;
	}
	public void setCorespPinCode(int corespPinCode)
	{
		this.corespPinCode = corespPinCode;
	}
	public String getCorespAdd()
	{
		return corespAdd;
	}
	public void setCorespAdd(String corespAdd)
	{
		this.corespAdd = corespAdd;
	}
	public String getGuardianName()
	{
		return guardianName;
	}
	public void setGuardianName(String guardianName)
	{
		this.guardianName = guardianName;
	}
	public long getGuardianMobNo()
	{
		return guardianMobNo;
	}
	public void setGuardianMobNo(long guardianMobNo)
	{
		this.guardianMobNo = guardianMobNo;
	}
	public String getGuardianEMail()
	{
		return guardianEMail;
	}
	public void setGuardianEMail(String guardianEMail)
	{
		this.guardianEMail = guardianEMail;
	}
	public String getClsXRollNo()
	{
		return clsXRollNo;
	}
	public void setClsXRollNo(String clsXRollNo)
	{
		this.clsXRollNo = clsXRollNo;
	}
	public int getClsXPassingYr()
	{
		return clsXPassingYr;
	}
	public void setClsXPassingYr(int clsXPassingYr)
	{
		this.clsXPassingYr = clsXPassingYr;
	}
	public String getClsXBoard()
	{
		return clsXBoard;
	}
	public void setClsXBoard(String clsXBoard)
	{
		this.clsXBoard = clsXBoard;
	}
	public long getClsXIIRollNo()
	{
		return clsXIIRollNo;
	}
	public void setClsXIIRollNo(long clsXIIRollNo)
	{
		this.clsXIIRollNo = clsXIIRollNo;
	}
	public int getClsXIIPassingYr()
	{
		return clsXIIPassingYr;
	}
	public void setClsXIIPassingYr(int clsXIIPassingYr)
	{
		this.clsXIIPassingYr = clsXIIPassingYr;
	}
	public String getClsXIIBoard()
	{
		return clsXIIBoard;
	}
	public void setClsXIIBoard(String clsXIIBoard)
	{
		this.clsXIIBoard = clsXIIBoard;
	}
	public float getClsXIIPercentage()
	{
		return clsXIIPercentage;
	}
	public void setClsXIIPercentage(float clsXIIPercentage)
	{
		this.clsXIIPercentage = clsXIIPercentage;
	}
	public String getClsXIIMedium()
	{
		return clsXIIMedium;
	}
	public void setClsXIIMedium(String clsXIIMedium)
	{
		this.clsXIIMedium = clsXIIMedium;
	}
	public String getHighestQual()
	{
		return highestQual;
	}
	public void setHighestQual(String highestQual)
	{
		this.highestQual = highestQual;
	}
	public String getHighestQualFrom()
	{
		return highestQualFrom;
	}
	public void setHighestQualFrom(String highestQualFrom)
	{
		this.highestQualFrom = highestQualFrom;
	}
	public float getHighestQualAggregate()
	{
		return highestQualAggregate;
	}
	public void setHighestQualAggregate(float highestQualAggregate)
	{
		this.highestQualAggregate = highestQualAggregate;
	}
	public int getHighestQualPassingYr()
	{
		return highestQualPassingYr;
	}
	public void setHighestQualPassingYr(int highestQualPassingYr)
	{
		this.highestQualPassingYr = highestQualPassingYr;
	}
	public int getExperienceYr()
	{
		return experienceYr;
	}
	public void setExperienceYr(int experienceYr)
	{
		this.experienceYr = experienceYr;
	}
	public String getLastTaught()
	{
		return lastTaught;
	}
	public void setLastTaught(String lastTaught)
	{
		this.lastTaught = lastTaught;
	}
	public String getSubject1()
	{
		return subject1;
	}
	public void setSubject1(String subject1)
	{
		this.subject1 = subject1;
	}
	public String getSubject2()
	{
		return subject2;
	}
	public void setSubject2(String subject2)
	{
		this.subject2 = subject2;
	}
	public String getSubject3()
	{
		return subject3;
	}
	public void setSubject3(String subject3)
	{
		this.subject3 = subject3;
	}
	public String getNameOfPersuingCourse()
	{
		return nameOfPersuingCourse;
	}
	public void setNameOfPersuingCourse(String nameOfPersuingCourse)
	{
		this.nameOfPersuingCourse = nameOfPersuingCourse;
	}
}
