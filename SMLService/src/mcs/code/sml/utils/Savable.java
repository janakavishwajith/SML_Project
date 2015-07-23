package mcs.code.sml.utils;

import java.sql.Connection;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "Savable", namespace="http://utils.sml.code.mcs")
public class Savable implements Serializable
{
    public static final int MODIFIED = 20000;
    public static final int NEW = 30000;
    public static final int DELETED = 40000;
    public static final int UNCHANGED = 50000;
    
    public int getStatus(){return 0;};

    public void setStatus(int i){};

    void save( Connection con ) throws SavingSQLException{};
}