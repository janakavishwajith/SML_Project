package mcs.code.sml.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import mcs.code.sml.utils.Savable;
import mcs.code.sml.utils.SavingSQLException;

@XmlType(name = "EntDoctors", namespace = "http://entity.sml.code.mcs")
public class EntDoctors extends Savable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int doctorId;
	private String fName;
	private String lName;
	private String hospital;
	private String email;
	private String address;
	private int specializationId = -1 ;
	private int status = Savable.NEW;


	/**
	 * This insert/modify or update depending on the action
	 */
	public void save( Connection con ) throws SavingSQLException
	{
		String action = "";
		try
		{
			if ( this.status == Savable.NEW )
			{
				action = "Inserting";
				insert( con );
			}
			else if ( this.status == Savable.MODIFIED )
			{
				action = "Updating";
				update( con );
			}
			else if ( this.status == Savable.DELETED )
			{
				action = "Deleting";
				delete( con );
			}
			else if ( this.status == Savable.UNCHANGED )
			{
				// Do nothing
			}
			else
			{
				throw new SavingSQLException( "Incorret setting of Status flag!" );
			}
		}
		catch ( SQLException se )
		{
			se.printStackTrace();
			throw new SavingSQLException( "Error in " + action + se.getMessage(), se.getSQLState(), se.getErrorCode() );
		}
	}

	/**
	 * This inserts the .........
	 */
	private void insert( Connection con ) throws SQLException
	{
		String str = "INSERT INTO doctor ( "+DoctorStructure.doctorId+","+DoctorStructure.fName+", "+DoctorStructure.lName+", "+DoctorStructure.hospital+","+DoctorStructure.email+","+DoctorStructure.adress+","+DoctorStructure.specialization+" )VALUES(?,?,?,?,?,?,? )";
		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.doctorId );
		if ( this.fName == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.fName );
		}
		if ( this.lName == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.lName );
		}
		
		if ( this.hospital == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.hospital );
		}
		
		if ( this.email == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.email );
		}
		
		if ( this.address == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.address );
		}
		
		if ( this.specializationId == -1 )
		{
			ps.setNull( ++count, java.sql.Types.INTEGER );
		}
		else
		{
			ps.setInt( ++count, this.specializationId );
		}
		
		ps.execute();
		ps.close();
	}

	/**
	 * This inserts the .........
	 */
	public List<EntDoctors> getRecords( Connection con,List<String> fields,String condition ) throws SQLException
	{
		List<EntDoctors> returnList = new ArrayList<EntDoctors>();
		if( fields == null || fields.size() == 0 ){
			return returnList;
		}
		StringBuffer fieldStr = new StringBuffer();
		for( String currField : fields ){
			fieldStr.append( currField );			
			fieldStr.append( "," );			
		}
		
		String fieldsToRetrive = fieldStr.toString();
		fieldsToRetrive = fieldsToRetrive.substring( 0, fieldsToRetrive.length() - 1 );
		
		String str = "select "+fieldsToRetrive+" from "+DoctorStructure.tableName;
		if( condition != null ){
			str += " where "+condition;
		}
		
		PreparedStatement ps = con.prepareStatement( str );
		ResultSet rs = ps.executeQuery(str );
		while (rs.next()) {
			EntDoctors newObj = new EntDoctors();
			this.load( rs,newObj );
			returnList.add( newObj );
		}
		
		ps.execute();
		ps.close();
		return returnList;
	}
	
	/**
	 * This deletes the ........
	 */
	private void delete( Connection con ) throws SQLException
	{
		String str = "DELETE FROM doctor WHERE "+DoctorStructure.doctorId+" = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		ps.setInt( ++count, this.doctorId );
		ps.execute();
		ps.close();
	}

	/**
	 * This updates the .......
	 */
	private void update( Connection con ) throws SQLException
	{
		String str = "UPDATE doctor SET "+DoctorStructure.fName+" = ?,"+DoctorStructure.lName+" = ?,"+DoctorStructure.hospital+" = ?, "+DoctorStructure.email+" = ?, "+DoctorStructure.adress+" = ?, "+DoctorStructure.specialization+" = ? WHERE "+DoctorStructure.doctorId+" = ? ";

		int count = 0;
		PreparedStatement ps = con.prepareStatement( str );
		if ( this.fName == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.fName );
		}
		if ( this.lName == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.lName );
		}
		if ( this.hospital == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.hospital );
		}
		if ( this.email == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count,  this.email );
		}
		if ( this.address == null )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setString( ++count, this.address );
		}
		if ( this.specializationId == -1 )
		{
			ps.setNull( ++count, java.sql.Types.VARCHAR );
		}
		else
		{
			ps.setInt( ++count, this.specializationId );
		}
		ps.setInt( ++count, this.doctorId );
		ps.execute();
		ps.close();
	}

	/**
	 * This loads the .......
	 */
	public void load( ResultSet rs,EntDoctors doctObj ) throws SQLException
	{
		if( doctObj == null ){
			doctObj = this;
		}
		doctObj.status = Savable.UNCHANGED;
		doctObj.doctorId = rs.getInt( DoctorStructure.doctorId );
		if ( rs.getObject( DoctorStructure.fName ) == null )
		{
			doctObj.fName = null;
		}
		else
		{
			doctObj.fName = rs.getString( DoctorStructure.fName );
		}
		if ( rs.getObject( DoctorStructure.lName ) == null )
		{
			doctObj.lName = null;
		}
		else
		{
			doctObj.lName = rs.getString( DoctorStructure.lName );
		}
		if ( rs.getObject( DoctorStructure.hospital ) == null )
		{
			doctObj.hospital = null;
		}
		else
		{
			doctObj.hospital = rs.getString( DoctorStructure.hospital );
		}

		if ( rs.getObject( DoctorStructure.email ) == null )
		{
			doctObj.email = null;
		}
		else
		{
			doctObj.email = rs.getString( DoctorStructure.email );
		}
		
		if ( rs.getObject( DoctorStructure.adress ) == null )
		{
			doctObj.address = null;
		}
		else
		{
			doctObj.address = rs.getString( DoctorStructure.adress );
		}
		
		if ( rs.getObject( DoctorStructure.specialization ) == null )
		{
			doctObj.specializationId = -1;
		}
		else
		{
			doctObj.specializationId = rs.getInt( DoctorStructure.specialization );
		}
	}


	public int getDoctorId()
	{
		return doctorId;
	}

	public void setDoctorId( int doctorId )
	{
		this.doctorId = doctorId;
	}

	public String getfName()
	{
		return fName;
	}

	public void setfName( String fName )
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName( String lName )
	{
		this.lName = lName;
	}

	public String getHospital()
	{
		return hospital;
	}

	public void setHospital( String hospital )
	{
		this.hospital = hospital;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getAdress()
	{
		return address;
	}

	public void setAdress( String adress )
	{
		this.address = adress;
	}

	public int getSpecializationId()
	{
		return specializationId;
	}

	public void setSpecializationId( int specializationId )
	{
		this.specializationId = specializationId;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}
	
	
	class DoctorStructure{
		public static final String tableName = "doctor";
		public static final int numFields = 7;
		public static final String fName = "fname";
		public static final String lName = "lname"; 
		public static final String hospital = "hospital";
		public static final String email = "email";
		public static final String adress = "address";
		public static final String specialization = "specialization_id";
		public static final String doctorId = "doctor_id";
		
	}
	

}
