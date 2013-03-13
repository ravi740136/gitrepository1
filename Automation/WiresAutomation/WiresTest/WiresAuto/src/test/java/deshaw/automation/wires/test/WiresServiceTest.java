package deshaw.automation.wires.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WiresServiceTest
{
	//static String url = "http://wiresuat.nyc.deshaw.com/services/wiresService";
	//static String url = "http://desh0009.hyd.deshaw.com:11188/services/wiresService";
	static String url = "http://testwiresqa.nyc.deshaw.com/services/wiresService";

	// Given a Request Id, this method returns corresponding Wire Request
	public static void readById() throws MalformedURLException, IOException
	{
		String readByIdXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<soapenv:Envelope " +
            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<base:readById>" +
            "<requestId>179572</requestId>" +
            "</base:readById>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";

		getResponse(readByIdXml);
	}
	
	// Given a list of Request Ids, this method returns a list of Wire Requests
	public static void readByIds() throws MalformedURLException, IOException
	{
		String readByIdXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<soapenv:Envelope " +
            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<base:readByIds>" +
            "<requestIds>179263</requestIds>" +
            "<requestIds>179287</requestIds>" +
            "<requestIds>179288</requestIds>" +
            "</base:readByIds>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";

		getResponse(readByIdXml);
	}
	
	// Given a list of Wire Id, this method return a list of Wires.
	public static void readWiresByIds() throws MalformedURLException, IOException
	{
		String readByIdXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<soapenv:Envelope " +
            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<base:readWiresByIds>" +
            "<wireIds>370602</wireIds>" +
            "<wireIds>370603</wireIds>" +
            "</base:readWiresByIds>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";

		getResponse(readByIdXml);
	}

	public static void logWire() throws MalformedURLException, IOException
	{
		String requestXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<soapenv:Envelope " +
            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<base:createRequest>" +
            "<wireRequest>" +
            "<subject>Testing the Wires SOAP service</subject>" +
            "<subscribers>guptapra</subscribers>" +
            "<cc>guptapra</cc>" +
            "<priorityLevel>Normal</priorityLevel>" +
            "<isPrivate>0</isPrivate>" +
            "<sourceId>DESCap</sourceId>" +
            "<comments>Testing the Wires SOAP service</comments>" +
//          "<emailNotification>NONE</emailNotification>" +
            "<createdBy>vijayara</createdBy>" +
            "<wires>" +
            "<sourceAccount>" +
            "<accountId>2709</accountId>" +
            "</sourceAccount>" +
            "<destinationAccount>" +
            "<accountId>2213</accountId>" +
            "</destinationAccount>" +
            "<amount>10</amount>" +
            "<category>" +
            "<categoryId>7</categoryId>" +
            "</category>" +
            "<isActive>true</isActive>" +
            "<wireDate>2011-09-01</wireDate>" +
            "<valueDate>2011-09-21</valueDate>" +
            "<wrsSourceMap>" +
            "<sourceId>DESCap</sourceId>" +
            "</wrsSourceMap>" +
            "</wires>" +
            "<wires>" +
            "<sourceAccount>" +
            "<accountId>2709</accountId>" +
            "</sourceAccount>" +
            "<destinationAccount>" +
            "<accountId>2213</accountId>" +
            "</destinationAccount>" +
            "<amount>10</amount>" +
            "<category>" +
            "<categoryId>4</categoryId>" +
            "</category>" +
            "<isActive>true</isActive>" +
            "<wireDate>2011-09-01</wireDate>" +
            "<valueDate>2011-09-21</valueDate>" +
            "<uploadStatus>" +
            "<id>1</id>" +
            "</uploadStatus>" +
            "<wrsSourceMap>" +
            "<sourceId>DESCap</sourceId>" +
            "</wrsSourceMap>" +
            "</wires>" +
            "</wireRequest>" +
            "<ignoreWarnings>1</ignoreWarnings>" +
            "</base:createRequest>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";

			getResponse(requestXml);
	}

	public static void logOutgoingWire() throws MalformedURLException, IOException
	{
		String requestXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<soapenv:Envelope " +
            "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
            "<soapenv:Header/>" +
            "<soapenv:Body>" +
            "<base:createRequest>" +
            "<wireRequest>" +
            "<subject>Testing the Wires SOAP service</subject>" +
            "<subscribers>guptapra</subscribers>" +
            "<cc>guptapra</cc>" +
            "<priorityLevel>Normal</priorityLevel>" +
            "<isPrivate>0</isPrivate>" +
            "<sourceId>DESCap</sourceId>" +
            "<comments>Testing the Wires SOAP service</comments>" +
//          "<emailNotification>NONE</emailNotification>" +
            "<wires>" +
            "<sourceAccount>" +
            "<accountId>2710</accountId>" +
            "</sourceAccount>" +
            "<destinationAccount>" +
            "<accountId>1550</accountId>" +
            "</destinationAccount>" +
            "<amount>10</amount>" +
            "<category>" +
            "<categoryId>7</categoryId>" +
            "</category>" +
            "<uploadStatus><id>1</id></uploadStatus>" +
            "<isActive>true</isActive>" +
            "<wireDate>2011-09-01</wireDate>" +
            "<valueDate>2011-09-21</valueDate>" +
            "<wrsSourceMap>" +
            "<sourceId>DESCap</sourceId>" +
            "</wrsSourceMap>" +

			"<wireInstructions>" +
				"<account><id>1550</id></account>" +

				"<isIndividualAccount>true</isIndividualAccount>" +

				"<intermediaryBank><id>-1</id></intermediaryBank>" +
				"<intermediaryBankName>test Bank</intermediaryBankName>" +
				"<intermediaryBankProtocol><id>S</id></intermediaryBankProtocol>" +
				"<intermediaryBankCountryCode><id>AU</id></intermediaryBankCountryCode>" +
				"<intermediaryBankSortCode>12345678</intermediaryBankSortCode>" +

				"<bank><id>470</id></bank>" +
				"<bankProtocol><id>S</id></bankProtocol>" +
				"<clearingBankCountryCode><id>SE</id></clearingBankCountryCode>" +
				"<ABASwiftNumber>ABNASESS</ABASwiftNumber>" +

				"<intermediaryAccountNumber>IntermediaryAccountNo</intermediaryAccountNumber>" +
				"<accountName>Account Name</accountName>" +
				"<accountNumber>AccountNo</accountNumber>" +
				"<fctAccountName>FCT Account Name</fctAccountName>" +
				"<fctAccountNumber>FCTAccountNo</fctAccountNumber>" +
				"<ffcAccountName>FFC Account Name</ffcAccountName>" +
				"<ffcAccountNumber>FFCAccountNo</ffcAccountNumber>" +
				"<reference1>Reference1</reference1>" +
				"<reference2>Reference2</reference2>" +
			"</wireInstructions>" +

            "</wires>" +
            "</wireRequest>" +
            "<ignoreWarnings>1</ignoreWarnings>" +
            "</base:createRequest>" +
            "</soapenv:Body>" +
            "</soapenv:Envelope>";

			getResponse(requestXml);
	}

	public static void logWireWithSplitAmounts() throws MalformedURLException, IOException {
		String requestXml =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<soapenv:Envelope " +
			"xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
			"xmlns:base=\"http://base.service.server.wires.deshaw/\">" +
			"<soapenv:Header/>" +
			"<soapenv:Body>" +
			"<base:createRequest>" +

				"<wireRequest>" +
					"<subject>Testing the Wires SOAP service</subject>" +
					"<subscribers>guptapra</subscribers>" +
					"<cc>guptapra</cc>" +
					"<priorityLevel>Normal</priorityLevel>" +
					"<isPrivate>0</isPrivate>" +
					"<sourceId>SwapResetRec</sourceId>" +
					"<comments>Testing the Wires SOAP service</comments>" +
					//"<emailNotification>NONE</emailNotification>" +
					"<createdBy>guptapra</createdBy>" +

					"<wires>" +
						"<sourceAccount><id>2397</id></sourceAccount>" +
						"<destinationAccount><id>5587</id></destinationAccount>" +
						//"<destinationPortfolio><id>1202</id></destinationPortfolio>" +

						"<amount>10</amount>" +
						"<category><id>9</id></category>" +
						"<uploadStatus><id>1</id></uploadStatus>" +
						"<strategy><id>1202</id></strategy>" +

						"<isActive>true</isActive>" +
						"<wireDate>2012-11-16</wireDate>" +
						"<valueDate>2012-11-20</valueDate>" +
						//"<valueDate>2012-11-13T00:00:00-05:00</valueDate>" +
						"<wrsSourceMap><sourceId>SwapResetRec</sourceId></wrsSourceMap>" +
						//"<createdBy>guptapra</createdBy>" +
						//"<action>NONE</action>" +
						"<action>APPROVAL_NEEDED</action>" +

						"<splitAmounts>" +
							"<transactionType>S</transactionType>" +
							"<financialType><id>1</id></financialType>" +
							"<amount>-10</amount>" +
						"</splitAmounts>" +
						"<splitAmounts>" +
							"<transactionType>S</transactionType>" +
							"<financialType><id>16</id></financialType>" +
							"<tradeId>SR55019684,SR55019633</tradeId>" +
							"<gboType><gboType>10</gboType></gboType>" +
							"<amount>7</amount>" +
						"</splitAmounts>" +
						"<splitAmounts>" +
							"<transactionType>S</transactionType>" +
							"<financialType><id>16</id></financialType>" +
							"<tradeId>SR55019685,SR55019633</tradeId>" +
							"<gboType><gboType>40</gboType></gboType>" +
							"<amount>3</amount>" +
						"</splitAmounts>" +
						"<splitAmounts>" +
							"<transactionType>D</transactionType>" +
							"<financialType><id>1</id></financialType>" +
							"<amount>10</amount>" +
						"</splitAmounts>" +
						"<splitAmounts>" +
							"<transactionType>D</transactionType>" +
							"<financialType><id>0</id></financialType>" +
							"<amount>-10</amount>" +
						"</splitAmounts>" +
					"</wires>" +

				"</wireRequest>" +

				"<ignoreWarnings>1</ignoreWarnings>" +
			"</base:createRequest>" +
			"</soapenv:Body>" +
			"</soapenv:Envelope>";

		getResponse(requestXml);
	}

	private static void getResponse(String input) throws MalformedURLException, IOException
	{
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");

		OutputStream out = connection.getOutputStream();
		Writer wout = new OutputStreamWriter(out);
		wout.write(input);
		wout.flush();
		wout.close();

		InputStream is = null;
		try
		{
			is = connection.getInputStream();
		}
		catch (Exception e)
		{
			// This code prints the stack-trace. so test the changes by specifying invalid wire id. 
			throw new RuntimeException(getResponse(connection.getErrorStream()).toString(), e);
		}

		File f = new File("wires-out.xml");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		for (int c = is.read(); c != -1; c = is.read()) {
			bw.write((char)c);
		}
		bw.flush();
		bw.close();
		System.out.println("Please check wires-out.xml for the output generated.");
	}

	private static StringBuilder getResponse(InputStream is) throws IOException
	{
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		for (String line = rd.readLine(); line != null; line = rd.readLine())
			sb.append(line).append("\n");
		rd.close();
		return sb;
	}

	public static void main(String[] args) throws MalformedURLException, IOException
	{
		// readById();
		// readByIds();
		// readWiresByIds();
		// logWire();
		// logOutgoingWire();
		logWireWithSplitAmounts();
	}
}