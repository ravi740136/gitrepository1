package appdriverng.common;

import org.apache.log4j.Logger;


public class AppConstants {
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	public static final String  ACTUAL_VALUE_DATE = AppDate.relativeDateFromToday(5);
	public static final String  WIRE_DATE = "06/24/2012"; 	
	public static final String  VALUE_DATE = AppDate.today();
	public static final String  ALLSPECIALCHAR = "~!@#$%^&*()_+{}:\"|?><`1234-=[];'\\/.,//'¶ unicode and special characters";
	public static final String  HSBCNET_CONFIRM =  "Transmission Type set to HSBCNet for the selected wires";
	public static final String  ADD_REQUEST_CONFIRM = "has been added";
	public static final String  UPDATE_REQUEST_CONFIRM =  "has been updated";
	public static final String APPROVER_KEY = Setup.properties.getProperty("app.wires.authentication");
}
