package mcs.code.sml.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@XmlType(name = "DBUtility", namespace = "http://utils.sml.code.mcs")
public class DBUtility {
	private static Connection connection = null;

	public static String driverName;
	public static String serverName;
	public static String portNumber;
	public static String sid;
	public static String url;
	public static String username;
	public static String password;

	public static void close(Connection con) {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet resultSet, Statement statement,
			Connection connection) {
		close(resultSet);
		close(statement);
		close(connection);
	}

	public static void rollBack(Connection con) {
		try {
			if (con != null) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static Connection getConnection() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/sml_db?user=root&password=");

			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		return connection;

	}

	public static void getDbUrl() {
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("DBConfig.xml"));

			doc.getDocumentElement().normalize();

			NodeList whichSession = doc.getElementsByTagName("which-session");
			Element whichSessionElement = (Element) whichSession.item(0);
			NodeList useThisSession = whichSessionElement.getChildNodes();
			int useSessionNo = Integer.parseInt(((Node) useThisSession.item(0)).getNodeValue().trim());

			NodeList listOfSession = doc.getElementsByTagName("session");
			Node selectedSessionNode = listOfSession.item(useSessionNo);

			if (selectedSessionNode.getNodeType() == Node.ELEMENT_NODE) {

				Element selectedSessionElement = (Element) selectedSessionNode;

				Element userNameElement = (Element) selectedSessionElement.getElementsByTagName("username").item(0);
				Node textUserName = (Node) userNameElement.getChildNodes().item(0);
				username = textUserName.getNodeValue().trim();

				Element passwordElement = (Element) selectedSessionElement.getElementsByTagName("password").item(0);
				Node textPassword = (Node) passwordElement.getChildNodes().item(0);
				password = textPassword.getNodeValue().trim();

				Element driverNameElement = (Element) selectedSessionElement.getElementsByTagName("driverName").item(0);
				Node textDriverName = (Node) driverNameElement.getChildNodes().item(0);
				driverName = textDriverName.getNodeValue().trim();

				Element serverNameElement = (Element) selectedSessionElement.getElementsByTagName("serverName").item(0);
				Node textServerName = (Node) serverNameElement.getChildNodes().item(0);
				serverName = textServerName.getNodeValue().trim();

				Element portNumberElement = (Element) selectedSessionElement.getElementsByTagName("portNumber").item(0);
				Node textPortNumber = (Node) portNumberElement.getChildNodes().item(0);
				portNumber = textPortNumber.getNodeValue().trim();

				Element sidElement = (Element) selectedSessionElement.getElementsByTagName("sid").item(0);
				Node textSid = (Node) sidElement.getChildNodes().item(0);
				sid = textSid.getNodeValue().trim();

				Element urlElement = (Element) selectedSessionElement.getElementsByTagName("connection-url").item(0);
				Node textUrl = (Node) urlElement.getChildNodes().item(0);
				url = textUrl.getNodeValue().trim() + serverName + ":"+ portNumber + ":" + sid;
			}

		} catch (SAXParseException err) {
			System.out.println("** XML Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
