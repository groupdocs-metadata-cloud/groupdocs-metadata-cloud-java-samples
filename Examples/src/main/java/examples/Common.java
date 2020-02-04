package examples;

import com.groupdocs.cloud.metadata.client.Configuration;

public class Common{
	// TODO: Get your AppSID and AppKey at https://dashboard.groupdocs.cloud (free
	// registration is required).

	public static String MyAppSID = "xxxxxxxxxx";
	public static String MyAppKey = "xxxxxxxxxx";
	public static String MyStorage = "xxxxxxxxx";
	
	public static Configuration GetConfiguration()
	{
		Configuration cfg = new Configuration(Common.MyAppSID, Common.MyAppKey);		
		cfg.setTimeout(120000);
		return cfg;
	}
}
