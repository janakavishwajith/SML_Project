package mcs.code.sml.utils;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */

import java.sql.SQLException;


import javax.xml.bind.annotation.XmlType;
@XmlType(name = "SavingSQLException", namespace="http://utils.sml.code.mcs")
public class SavingSQLException extends SQLException
{
    private static final long serialVersionUID = 3965461634937831074L;

	public SavingSQLException()
    {
        super();
    }

    public SavingSQLException( String reason )
    {
        super( reason );
    }

    public SavingSQLException( String reason, String sqlState )
    {
        super( reason, sqlState );
    }

    public SavingSQLException( String reason, String sqlState, int vendorCode )
    {
        super( reason, sqlState, vendorCode );
    }

    public SavingSQLException( SQLException se )
    {
        super( se.getMessage(), se.getSQLState(), se.getErrorCode() );
    }

    public String getMessage()
    {
        String msg = _getTBXErrorMsg();

        if( msg.trim().equals( "" ) )
        {
            return super.getMessage();
        }
        else
        {
            return msg;
        }

    }

    private String _getTBXErrorMsg()
    {
        if( super.getMessage().indexOf( "SUPPLIER_CODE_UNIQUE" ) >= 0 )
        {
            return "A unique code is required. \nPlease enter an unique code ";
        }
//        else if ( super.getMessage().indexOf( "PK_MARKUP" ) >=0 )
//        {
//            return "A unique code is required for markup. \nPlease enter an unique code ";
//        }

        return "";
    }
}
