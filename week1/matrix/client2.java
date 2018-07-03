/******************************************************************************************************************************************************

	File Name : client2.java

	Description : Java client to send data input to the API
	
	Purpose : To test the API for handling array input .
	
	Author : Swetha Sivakumar
	
	Date Of Creation : 19-05-18
	
	Date Of Last Modification : 21-05-18

*******************************************************************************************************************************************************/




/******************************************************************************************************************************************************
								Start Of Module
*******************************************************************************************************************************************************/

//Import required modules
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class client2 {

	public static void main(String[] args) {

	  try {

		URL url = new URL("http://10.8.7.77:3000/"); // enter url of the server to which to connect
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		
		StringBuilder x = new StringBuilder();
		//Getting array input from user / ML model
		/*int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		for(int i = 0;i<3;i++)
		{
			String input1 = Arrays.toString(mat[i]);
			x.append(input1);
			
		}
		String input = x.toString();
		System.out.println(input);*/
		String input = new Scanner(new File("data2.txt")).useDelimiter("\\Z").next();
		System.out.println(input);
		//Sending input parameters through the post request
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		//Reading response from the server
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

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

