/******************************************************************************************************************************************************

	File Name : NetClientPost.java

	Description : Java client to send data input to the API
	
	Purpose : To test the API for handling file input from local server
	
	Author : Swetha Sivakumar
	
	Date Of Creation : 19-05-18
	
	Date Of Last Modification : 25-05-18

*******************************************************************************************************************************************************/




/******************************************************************************************************************************************************
								Start Of Module
*******************************************************************************************************************************************************/

//import required modules
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection; // java class used to create http connections
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.*;

public class NetClientPost {

	public static void main(String[] args) {

	  try {
		
		long start_time = System.nanoTime();
		URL url = new URL("http://10.8.7.77:3000/mean"); // URL of API  end-point
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Creating a http connection between the client and the API
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = "{\"a\":0,\"b\":\"150\"}";
		//Creating an output stream on which the post request parameters can be written
		OutputStream os = conn.getOutputStream();
		//Writing the POSTed parameter into the OutputStream Object for passing to the server
		os.write(input.getBytes());
		os.flush();

		// Receiving and reading response from the server
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		
		long end_time = System.nanoTime();
		long total_time = end_time - start_time;
		System.out.println("The total running time of the program is " + total_time );

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }

	}

}
/******************************************************************************************************************************************************
								End Of Module
*******************************************************************************************************************************************************/

