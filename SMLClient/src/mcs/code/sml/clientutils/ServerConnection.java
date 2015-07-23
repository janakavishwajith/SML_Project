package mcs.code.sml.clientutils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mcs.code.sml.service.SMLService;
import mcs.code.sml.service.SMLServiceService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ServerConnection
{

	// public static String sunServiceURL = "http://192.168.5.113:4311/SunService/SunServiceService?WSDL";
	public static String sunServiceURL;
	public static SMLService SMLService;

	public static SMLService connectToSunWebService()
	{
		initConnection();
		URL baseUrl = mcs.code.sml.service.SMLService.class.getResource( "." );
		URL serverUrl;
		try
		{
			serverUrl = new URL( baseUrl, sunServiceURL );
			QName qname = new QName( "http://service.sml.code.mcs", "SMLServiceService" );
			SMLServiceService service = new SMLServiceService( serverUrl, qname );
			SMLService = service.getSMLServicePort();
		}
		catch ( MalformedURLException e )
		{
			e.printStackTrace();
		}

		return SMLService;
	}

	public static void initConnection()
	{
		try
		{

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse( new File( "serverConfig/SeverConfig.xml" ) );

			doc.getDocumentElement().normalize();

			NodeList whichSession = doc.getElementsByTagName( "which-session" );
			Element whichSessionElement = ( Element ) whichSession.item( 0 );
			NodeList useThisSession = whichSessionElement.getChildNodes();
			int useSessionNo = Integer.parseInt( ( ( Node ) useThisSession.item( 0 ) ).getNodeValue().trim() );

			NodeList listOfSession = doc.getElementsByTagName( "session" );
			Node selectedSessionNode = listOfSession.item( useSessionNo );

			if ( selectedSessionNode.getNodeType() == Node.ELEMENT_NODE )
			{

				Element selectedSessionElement = ( Element ) selectedSessionNode;

				Element userNameElement = ( Element ) selectedSessionElement.getElementsByTagName( "ServiceURL" ).item( 0 );
				Node textUserName = ( Node ) userNameElement.getChildNodes().item( 0 );
				sunServiceURL = textUserName.getNodeValue().trim();

			}

		}
		catch ( SAXParseException err )
		{
			System.out.println( "** XML Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId() );
			System.out.println( " " + err.getMessage() );

		}
		catch ( SAXException e )
		{
			Exception x = e.getException();
			( ( x == null ) ? e : x ).printStackTrace();

		}
		catch ( Throwable t )
		{
			t.printStackTrace();
		}
	}

}
