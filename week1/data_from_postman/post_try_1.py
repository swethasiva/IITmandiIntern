#*******************************************************************************************************************************************************
#
# File Name : post_try_1.py
#
# Description : Python API to accept array and return sorted array to client.
# 
# Purpose :  To learn and handle array data structure in api. 
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

# Import required modules from flask import Flask
import math
import sys
import json
import requests
from flask import request

app = Flask(__name__)


@app.route('/mean',methods=['GET','POST'])
def avg_calc():
	
	a=0
	data = request.get_json()
	n=len(data["a"])
    	if n <= 1:
         return str(0.0)

    	sd =  0.0

	for i in range(0,n):
	 a+=int(data["a"][i])
	mean=a/n
    	# calculate stan. dev.
    	for element in data["a"]:
         sd += (float(element) - mean)**2
    	sd = math.sqrt(sd / float(n-1))

    	return str(sd)
	
	
      
if __name__ == '__main__':
	app.run(host='0.0.0.0',port=3000,debug=True)	

#*******************************************************************************************************************************************************
#                                                             End Of Module
#******************************************************************************************************************************************************
