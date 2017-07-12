package userRegLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beanClasses.FacultyUser;
import beanClasses.StudentUser;
import dbConnection.GetDBConnection;
import dbConnection.ReadProjectProperties;
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
                                fid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryFatherId(), false);
                            	prest = con.prepareStatement(CommonQuerys.getInsertGuardianQuery());
                                prest.setString(1, user.getMotherName());
                                prest.setLong(2, user.getMotherMobNo());
                                prest.setString(3, user.getMotherOccupation());
                                prest.setString(4, user.getMotherEMail());
                                
                                if( prest.executeUpdate()>0 )
                                {
                                	mid = RegisterUtility.getAddressGuardianId(CommonQuerys.getQueryFatherId(), false);
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
                                    if( user.isCorespFlag() )
                                    	prest.setInt(12, corespAddId);
                                    else
                                    	prest.setInt(12, addid);
                                    prest.setString(13, user.getClsXRollNo());
                                    prest.setLong(14, user.getClsXIIRollNo());
                                    prest.setInt(15, fid);
                                    prest.setInt(16, mid);
                                    prest.setNull(17, 0);
                                    
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
    	Connection con = GetDBConnection.getConnection();
    	
        String insertQuesry = "INSERT INTO " + ReadProjectProperties.getProp("tableName") +" VAlUES( ? , ? , ?);";
        PreparedStatement prest = con.prepareStatement(insertQuesry);
        prest.setString(1, user.getUserName());
        prest.setString(2, user.getUserType());
        prest.setString(3, user.getPassword());

    	return prest.executeUpdate()>0;
    }
}