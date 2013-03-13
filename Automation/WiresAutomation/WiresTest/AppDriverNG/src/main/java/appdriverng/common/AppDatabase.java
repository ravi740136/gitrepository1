package appdriverng.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class AppDatabase {
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	static String password = Setup.passWord;
	static String username = Setup.userName;
	static String connURL = "jdbc:jtds:sqlserver://" + Setup.dbServer + "/"
			+ Setup.dbName;
	static Connection con = null;
	static Statement s = null;
	static List wireList = null;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
if (con == null){
		try {
			con = DriverManager.getConnection(connURL, username, password);
			LOG.info("Getting the connection");

		}

		catch (Exception e) {

			e.printStackTrace();
			Setup.shutDown();

		}
}

		return con;
	}

	public static void changeWireLogger(String requestId)
			throws ClassNotFoundException, SQLException {

		try {
			con = getConnection();
			s = con.createStatement();
			String updateString = "update twire set createdby = 'misrav' where requestid = "
					+ requestId;
			s.executeUpdate(updateString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();

			if (con != null)
				con.close();
		}

	}
	
	public static void changeRequestLogger(String requestId, String logger)
			throws ClassNotFoundException, SQLException {

		try {
			con = getConnection();
			s = con.createStatement();
			String updateString = "update twirerequest set createdby = '"+logger+"' where requestid = "
					+ requestId;
			s.executeUpdate(updateString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();

			if (con != null)
				con.close();
		}

	}

	public static String getLatestWireId(String requestId)
			throws ClassNotFoundException, SQLException {
		String wireId = "";
		try {
			con = getConnection();
			s = con.createStatement();

			String queryString = "select wireid from twire where  requestid = "
					+ requestId + " order by wireid desc";
			ResultSet r = s.executeQuery(queryString);

			while (r.next()) {
				wireId = r.getString("wireid");
				LOG.warn("Database results: Wire id is " + wireId
						+ " for the Request Id: " + requestId);
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (s != null)
				s.close();

			if (con != null)
				con.close();
		}

		return wireId;

		// html body div.ui-dialog div.ui-dialog-buttonpane button.ui-button
	}

	public static String getRequestId(String wireId)
			throws ClassNotFoundException, SQLException {
		String requestId = "";
		try {
			con = getConnection();
			s = con.createStatement();

			String queryString = "select top 1 requestid from twire  where  wireid = "
					+ wireId + " order by wireid desc";
			ResultSet r = s.executeQuery(queryString);
			r.next();
			requestId = r.getString("requestid");
			LOG.warn("Database results: Request id is " + requestId
					+ " for the Wire Id: " + wireId);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (s != null)
				s.close();

			if (con != null)
				con.close();
		}

		return requestId;

		// html body div.ui-dialog div.ui-dialog-buttonpane button.ui-button
	}

	public static List getAllWires(String requestId)
			throws ClassNotFoundException, SQLException {

		try {
			con = getConnection();
			s = con.createStatement();

			String queryString = "select wireid from twire where  requestid = "
					+ requestId + " order by wireid desc";
			ResultSet r = s.executeQuery(queryString);
			wireList = new ArrayList<String>();
			while (r.next()) {
				wireList.add(r.getString("wireid"));				
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (s != null)
				s.close();

			if (con != null)
				con.close();
		}

		return wireList;

		// html body div.ui-dialog div.ui-dialog-buttonpane button.ui-button
	}

	
}
