package mcs.code.sml.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import mcs.code.sml.entity.EntDoctors;
import mcs.code.sml.utils.DBUtility;

@XmlType(name = "User", namespace = "http://controller.sun.trn.com")
public class Doctors
{
//edited
	public List<EntDoctors> getDoctors()
	{
		EntDoctors docObj = new EntDoctors();
		List<EntDoctors> records = new ArrayList<EntDoctors>();
		try
		{
			Connection con = null;
			con = DBUtility.getConnection();
			List<String> fields = new ArrayList<String>();
			fields.add( "*" );
			records = docObj.getRecords( con, fields, null );
			
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
		
		return records;
	}
	
}
