#*******************************************************************************************************************************************************
#
# File Name : server3.py
#
# Description : Python API to accept json input and calculate mean and standard deviation
# 
# Purpose :  To learn and handle json data structure in api. 
#
# Author : Swetha Sivakumar
#
# Date Of Creation : 21-05-18
#
# Date Of Last Modification : 21-05-18
#
#*******************************************************************************************************************************************************


#*******************************************************************************************************************************************************
# 								Start of Module 
#*******************************************************************************************************************************************************

# Import required modules 
from flask import Flask
import requests
import json
from flask import request
import math
import sys

# Create an instance of class Flask and __name__ mentions path to look for resources
app = Flask(__name__)

# Create a route (Maps the URL to the function)
@app.route('/',methods=['POST'])
def sort_array():
	data = request.get_json()
	print(data);
	n=len(data["DataValue"]);
	sum1,mean,sd=0,0.0,0.0;
	for i in range(0,n):
		sum1+=int(data["DataValue"][str(i)])
	
	mean=sum1/n
	for i in range(0,n):
		sd+=(float(data["DataValue"][str(i)])-mean)**2
	sd = math.sqrt(sd/float(n))
	return json.dumps({'Standard Deviation': sd , 'Mean': mean})


# Run the app if executed directly
if __name__ == "__main__" :
	app.run(host="0.0.0.0" ,port=3000 ,debug=True )

#*******************************************************************************************************************************************************
#                                                             End Of Module
#******************************************************************************************************************************************************
