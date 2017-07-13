package userRegLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beanClasses.FacultyUser;
import beanClasses.StudentUser;
import dbConnection.GetDBConnection;
import tableCreateQuery.CommonQuerys;

public class RegisterUser
{
    public static boolean registerStudentUser(StudentUser user) throws SQLException, ClassNotFoundException
    {
    	int addid,fid,mid,corespAddId = 0;
    	
    	Connection con = GetDBConnection.getConnection();
    	con.setAutoCommit(false);
    	PreparedStatement prest;
        
    	prest = con.prepareStatement(CommonQuerys.getInsertUserQuery());
        prest.setString(1, user.getUserName());
        prest.setString(2, user.getUserType());
        prest.setString(3, user.getPassword());

        try
        {
        	if( prest.executeUpdate()>0 )
        	{
        		prest = con.prepareStatement(CommonQuerys.getInsertAddressQuery());
                prest.setString(1, user.getState());
                prest.setString(2, user.getCity());
                prest.setInt(3, user.getPinconde());
                prest.setString(4, user.getAdd());
                
                if( prest.executeUpdate()>0 )
                {
                	addid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryAddressId(), true);
                	if( !user.isCorespFlag() )
            		{
                		prest = con.prepareStatement(CommonQuerys.getInsertAddressQuery());
                        prest.setString(1, user.getCorespState());
                        prest.setString(2, user.getCorespCity());
                        prest.setInt(3, user.getCorespPinconde());
                        prest.setString(4, user.getCorespAdd());
                        
                        if( prest.executeUpdate()>0 )
                        {
                        	corespAddId = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryAddressId(), true);
                        }
                        else
                        {
                        	con.rollback();
                        	return false;
                        }
            		}
                	prest = con.prepareStatement(CommonQuerys.getInsertEducationQuery());
                    prest.setString(1, user.getClsXRollNo());
                    prest.setInt(2, user.getClsXPassingYr());
                    prest.setString(3, user.getClsXSchool());
                    prest.setString(4, user.getClsXBoard());
                    prest.setString(5, user.getClsXMedium());
                    prest.setFloat(6, user.getClsXPercentage());
                    
                    if( prest.executeUpdate()>0 )
                    {
                    	prest = con.prepareStatement(CommonQuerys.getInsertEducationQuery());
                        prest.setLong(1, user.getClsXIIRollNo());
                        prest.setInt(2, user.getClsXIIPassingYr());
                        prest.setString(3, user.getClsXIISchool());
                        prest.setString(4, user.getClsXIIBoard());
                        prest.setString(5, user.getClsXIIMedium());
                        prest.setFloat(6, user.getClsXIIPercentage());
                        
                        if( prest.executeUpdate()>0 )
                        {
                        	prest = con.prepareStatement(CommonQuerys.getInsertGuardianQuery());
                            prest.setString(1, user.getFatherName());
                            prest.setLong(2, user.getFatherMobNo());
                            prest.setString(3, user.getFatherOccupation());
                            prest.setString(4, user.getFatherEMail());
                            
                            if( prest.executeUpdate()>0 )
                            {
                                fid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryGuardianId(), false);
                            	prest = con.prepareStatement(CommonQuerys.getInsertGuardianQuery());
                                prest.setString(1, user.getMotherName());
                                prest.setLong(2, user.getMotherMobNo());
                                prest.setString(3, user.getMotherOccupation());
                                prest.setString(4, user.getMotherEMail());
                                
                                if( prest.executeUpdate()>0 )
                                {
                                	mid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryGuardianId(), false);
                                	prest = con.prepareStatement(CommonQuerys.getInsertStudentPersonalQuery());
                                    prest.setString(1, user.getUserName());
                                    prest.setString(2, user.getfName());
                                    prest.setString(3, user.getmName());
                                    prest.setString(4, user.getlName());
                                    prest.setDate(5, user.getDOB());
                                    prest.setString(6, user.getGender());
                                    prest.setString(7, user.geteMail());
                                    prest.setLong(8, user.getMobNo());
                                    prest.setString(9, user.getCategory());
                                    prest.setString(10, user.getImagePath());
                                    prest.setInt(11, addid);
                                    if( !user.isCorespFlag() )
                                    	prest.setInt(12, corespAddId);
                                    else
                                    	prest.setInt(12, addid);
                                    prest.setString(13, user.getClsXRollNo());
                                    prest.setLong(14, user.getClsXIIRollNo());
                                    prest.setInt(15, fid);
                                    prest.setInt(16, mid);
                                    prest.setNull(17, 0);
                                    prest.setString(18, user.getBranch());
                                    
                                    if( prest.executeUpdate()>0 )
                                    {
                                    	con.commit();
                                    	con.setAutoCommit(true);
                                    	return true;
                                    }
                                }
                                else
                                	con.rollback();
                            }
                            else
                            	con.rollback();
                        }
                        else
                        	con.rollback();
                    }
                    else
                    	con.rollback();
                }
                else
                	con.rollback();
        	}
        	else
        	{
        		con.rollback();
        	}
        }
    	catch(Exception e)
        {
			System.out.println("Rolling Back due to Exception --> "+e.getMessage());
			con.rollback();
		}
    	
    	return false;
    }
    
    public static boolean registerFacultyUser(FacultyUser user) throws SQLException, ClassNotFoundException
    {
    	int addid,gid,hqid,subid,corespAddId = 0;
    	
    	Connection con = GetDBConnection.getConnection();
    	con.setAutoCommit(false);
    	PreparedStatement prest;
        
    	prest = con.prepareStatement(CommonQuerys.getInsertUserQuery());
        prest.setString(1, user.getUserName());
        prest.setString(2, user.getUserType());
        prest.setString(3, user.getPassword());

        try
        {
        	if( prest.executeUpdate()>0 )
        	{
        		prest = con.prepareStatement(CommonQuerys.getInsertAddressQuery());
                prest.setString(1, user.getState());
                prest.setString(2, user.getCity());
                prest.setInt(3, user.getPinCode());
                prest.setString(4, user.getAdd());
                
                if( prest.executeUpdate()>0 )
                {
                	addid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryAddressId(), true);
                	if( !user.isCorespAddFlag() )
            		{
                		prest = con.prepareStatement(CommonQuerys.getInsertAddressQuery());
                        prest.setString(1, user.getCorespState());
                        prest.setString(2, user.getCorespCity());
                        prest.setInt(3, user.getCorespPinCode());
                        prest.setString(4, user.getCorespAdd());
                        
                        if( prest.executeUpdate()>0 )
                        {
                        	corespAddId = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryAddressId(), true);
                        }
                        else
                        {
                        	con.rollback();
                        	return false;
                        }
            		}
                	prest = con.prepareStatement(CommonQuerys.getInsertEducationQuery());
                    prest.setString(1, user.getClsXRollNo());
                    prest.setInt(2, user.getClsXPassingYr());
                    prest.setString(3, null);
                    prest.setString(4, user.getClsXBoard());
                    prest.setString(5, null);
                    prest.setString(6, null);
                    
                    if( prest.executeUpdate()>0 )
                    {
                    	prest = con.prepareStatement(CommonQuerys.getInsertEducationQuery());
                        prest.setLong(1, user.getClsXIIRollNo());
                        prest.setInt(2, user.getClsXIIPassingYr());
                        prest.setString(3, null);
                        prest.setString(4, user.getClsXIIBoard());
                        prest.setString(5, user.getClsXIIMedium());
                        prest.setFloat(6, user.getClsXIIPercentage());
                        
                        if( prest.executeUpdate()>0 )
                        {
                        	prest = con.prepareStatement(CommonQuerys.getInsertGuardianQuery());
                        	prest.setString(1, user.getGuardianName());
                            prest.setLong(2, user.getGuardianMobNo());
                            prest.setString(3, user.getGuardianOccupation());
                            prest.setString(4, user.getGuardianEMail());
                            
                            if( prest.executeUpdate()>0 )
                            {
                            	gid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryGuardianId(), false);
                            	prest = con.prepareStatement(CommonQuerys.getInsertHigherEduQuery());
                            	prest.setString(1, user.getHighestQual());
                            	prest.setString(2, user.getHighestQualFrom());
                            	prest.setInt(3, user.getHighestQualPassingYr());
                            	prest.setFloat(4, user.getHighestQualAggregate());
                            	
                            	if( prest.executeUpdate()>0 )
                            	{
                            		hqid = RegisterUtility.getFacHighQualSubId(CommonQuerys.getQueryHigherEduId(), true);
                                	prest = con.prepareStatement(CommonQuerys.getInsertFacSubQuery());
                                	prest.setString(1, user.getSubject1());
                                	prest.setString(2, user.getSubject2());
                                	prest.setString(3, user.getSubject3());
                                	
                                	if( prest.executeUpdate()>0 )
                                	{
                                		subid = RegisterUtility.getFacHighQualSubId(CommonQuerys.getQueryFacSubId(), false);
                                		prest = con.prepareStatement(CommonQuerys.getInsertFacultyPersonalQuery());
                                        prest.setString(1, user.getUserName());
                                        prest.setString(2, user.getfName());
                                        prest.setString(3, user.getmName());
                                        prest.setString(4, user.getlName());
                                        prest.setDate(5, user.getDob());
                                        prest.setString(6, user.getGender());
                                        prest.setString(7, user.getBranch());
                                        prest.setString(8, user.geteMail());
                                        prest.setLong(9, user.getMobNo());
                                        prest.setLong(10, user.getAadhar());
                                        prest.setString(11, user.getImgPath());
                                        prest.setInt(12, addid);
                                        if( !user.isCorespAddFlag() )
                                        	prest.setInt(13, corespAddId);
                                        else
                                        	prest.setInt(13, addid);
                                        prest.setString(14, user.getClsXRollNo());
                                        prest.setLong(15, user.getClsXIIRollNo());
                                        prest.setInt(16, gid);
                                        prest.setInt(17, hqid);
                                        prest.setInt(18, user.getExperienceYr());
                                        prest.setString(19, user.getLastTaught());
                                        prest.setInt(20, subid);
                                        prest.setString(21, user.getNameOfPersuingCourse());
                                		if( prest.executeUpdate()>0 )
                                        {
                                        	con.commit();
                                        	con.setAutoCommit(true);
                                        	return true;
                                        }
                                	}
                                	else
                                		con.rollback();
                            	}
                            	else
                            		con.rollback();
                            }
                            else
                            	con.rollback();
                        }
                        else
                        	con.rollback();
                    }
                    else
                    	con.rollback();
                }
                else
                	con.rollback();
        	}
        	else
        		con.rollback();
        }
    	catch(Exception e)
        {
			System.out.println("Rolling Back due to Exception --> "+e.getMessage());
			con.rollback();
		}
    	
    	return false;
    }
}