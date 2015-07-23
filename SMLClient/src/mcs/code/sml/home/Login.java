/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mcs.code.sml.home;

/**
 *
 * @author Nishan
 * forcus is not work
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import mcs.code.sml.clientutils.ServerConnection;
import mcs.code.sml.service.SMLService;

final class Session extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SMLService SMLService;
	private JPanel panel;
	private JPanel doctorsList;
	private JLabel labelHeading;

	Session()
	{
		initGUI();
	}

	public void initGUI()
	{
		final ImageIcon imageIcon = new ImageIcon( "img/backGround.png" );
		labelHeading = new JLabel();
		labelHeading.setText( "Available Doctors" );
		labelHeading.setBounds( 60, 5, 450, 30 );
		labelHeading.setForeground( Color.blue );
		labelHeading.setFont( new Font( "Serif", Font.PLAIN, 24 ) );

		JSeparator sep = new JSeparator( SwingConstants.HORIZONTAL );
		sep.setBounds( 0, 42, 270, 2 );
		
		doctorsList = new JPanel();
		doctorsList.setLayout( null );
		doctorsList.setBounds( 0, 40, 450, 500 );
		
		JScrollPane scContent = new JScrollPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Image image = imageIcon.getImage();
			{
				setOpaque( false );
			}

			public void paintComponent( Graphics g )
			{
				g.drawImage( image, 0, 0, getWidth(), getHeight(), this );
				super.paintComponent( g );
			}
		};
		scContent.setSize( 500, 500 );
		scContent.setLayout( null );
		scContent.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		SMLService = ServerConnection.connectToSunWebService();
		if ( SMLService != null )
		{
			List<String> doctorsNames = SMLService.getDoctorsList();
			int y = 5;
			if( doctorsNames != null && doctorsNames.size() != 0 )
			{
				for(String name : doctorsNames){
					JLabel doc1 = new JLabel();
					doc1.setText( name );
					doc1.setBounds( 20, y, 450, 50 );
					scContent.add( doc1 );
					JSeparator sep2 = new JSeparator( SwingConstants.HORIZONTAL );
					sep2.setBounds( 0, y+50, 270, 2 );
					scContent.add(sep2);
					y += 55;
					
				}
			}
			else
			{
				JLabel doc1 = new JLabel();
				doc1.setText( "No Doctors Available" );		
				doc1.setBounds( 20, y, 450, 50 );
				scContent.add( doc1 );
			}
		}
		
		doctorsList.add( scContent );
		

		

		panel = new JPanel()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Image image = imageIcon.getImage();
			{
				setOpaque( false );
			}

			public void paintComponent( Graphics g )
			{
				g.drawImage( image, 0, 0, getWidth(), getHeight(), this );
				super.paintComponent( g );
			}
		};

		panel.setLayout( null );
		panel.add( labelHeading );
		panel.add( sep );
		panel.add( doctorsList );
		
		add( panel, BorderLayout.CENTER );
		setTitle( "Available Doctors" );
		this.setSize( 500, 575 );
		setLocationRelativeTo( null );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.setResizable( false );
	}

}

public class Login
{

	public static void main( String[] args )
	{
		try
		{
			initApp();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}
	}

	public static void initApp()
	{
		Session frame = new Session();
		frame.setVisible( true );
	}

}
