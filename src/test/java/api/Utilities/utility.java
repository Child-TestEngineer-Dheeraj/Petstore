package api.Utilities;

import java.util.ResourceBundle;

public class utility {
	//Ulitity to load property file
	public static ResourceBundle getURL()
	{
		ResourceBundle bundle=ResourceBundle.getBundle("Routes"); //Load the URL from Properties files
		return bundle;
	}

}
