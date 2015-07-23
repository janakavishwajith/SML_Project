package mcs.code.sml.clientutils;

import java.awt.Font;

public class CommonProperty
{
	public static Font getlableFont()
	{
		Font labelFont = new Font( "Serif", Font.PLAIN, 14 );
		return labelFont;
	}

	public static Font getlableValueFont()
	{
		Font labelFont = new Font( "Serif", Font.BOLD, 14 );
		return labelFont;
	}

	public static Font getHeadingFont()
	{
		Font headingFont = new Font( "Serif", Font.BOLD, 28 );
		return headingFont;
	}

	public static int getButtonHeight()
	{
		return 30;
	}

}
