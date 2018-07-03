/******************************************************************************************************************************************************
	File Name : client3.java

	Description : Java client to read a file and send the file content as  data input to the API
	
	Purpose : To test the API for handling file input .
	
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
import java.io.OutputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class client3 {

	public static void main(String[] args) {

	  try {

		URL url = new URL("http://10.8.7.77:3000/"); // enter url of the server to which to connect
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		
		//Getting array input from user / ML model
		/*System.out.println("Enter the Number of elements");
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int arr [] = new int [n];
		System.out.println("Enter the "+n+" array values ");
		for(int i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(s.nextLine());
		}
		String input = Arrays.toString(arr);*/
		/*for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);       Checking if array input was taken correctly
		}*/
		String input = new Scanner(new File("data1.txt")).useDelimiter("\\Z").next();
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

