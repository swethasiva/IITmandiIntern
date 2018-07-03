/******************************************************************************************************************************************************

	File Name : profiler_client.java

	Description : Java client to send dataset to BLSTM model
	
	Purpose : To test the API for handling array input .
	
	Author : Swetha Sivakumar
	
	Date Of Creation : 23-05-18
	
	Date Of Last Modification : 24-05-18

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
		long start = System.nanoTime();
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
		String fileName = "cont1_full.csv";
		File file = new File(fileName);
		Scanner inputStream = new Scanner(file);
		String input = inputStream.nextLine();
		//String input = inputStream.toString();
		//System.out.println(input);
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

		long end = System.nanoTime();
		long total_time = end-start;
		
		System.out.println("The total turn around is " + total_time);

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
