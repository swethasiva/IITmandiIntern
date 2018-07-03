#*******************************************************************************************************************************************************
#
# File Name : post_file_2.py
#
# DESCRIPTION : SIMPLE REST API TO READ INPUT FROM LOCAL SERVER AND RETURN THE MEAN AND STANDARD DEVIATION FOR THE GIVEN RANGE TO THE CLIENT. THE #
#               CLIENT SENDS THE POST REQUEST WITH STARTING AND ENDING TIME RANGE.
#
# Purpose : To test the API for handling file inputs .
#
# AUTHOR : SWETHA SIVAKUMAR
#
# DATE OF CREATION : 17-05-2018
#
# DATE OF LAST MODIFICATION : 20-05-2018
#
#*******************************************************************************************************************************************************


#******************************************************************************************************************************************************
#								Start Of Module
#******************************************************************************************************************************************************/

#import required modules
from flask import Flask
import math
import sys
import json
import requests
from flask import request
import time
import os
import psutil

current_process = psutil.Process()

# Crwating a Flask instance 
app = Flask(__name__)

# Creating a Route ie. binding a function to an URL
@app.route('/mean',methods=['GET','POST'])
def avg_calc():
	
	process = psutil.Process(os.getpid())
	print("Memory used in bytes" + str(process.memory_info().rss))
	sum1,sd=0,0.0
	file1 = open("data1.txt","rb")
	data = json.load(file1)
	time = request.get_json()
	i=int(time["a"])
	k=i
	j=int(time["b"])
	#n=len(data["DataValue"])
	n = j-i
	while(i<j):
		sum1+= int(data["DataValue"][str(i)])
		i=i+1
	mean = sum1 / n
	while(i<j):
		sd+= (float(data["DataValue"][str(i)])-mean)**2
	sd = math.sqrt(sd / float(n))
	return json.dumps({'STARTING TIME':k,'ENDING TIME':j,'MEAN':mean,'STANDARD DEVIATION' : sd})
	
    	
	
      
if __name__ == '__main__':
	app.run(host='0.0.0.0',port=3000,debug=True)	
	
	#******************************************************************************************************************************************************
#								End Of Module
#******************************************************************************************************************************************************/
