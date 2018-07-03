#*******************************************************************************************************************************************************
#
# File Name : server1.py
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

# Import required modules 
from flask import Flask
import requests
import json
from flask import request

# Create an instance of class Flask and __name__ mentions path to look for resources
app = Flask(__name__)

# Create a route (Maps the URL to the function)
@app.route('/',methods=['POST'])
def sort_array():
	data = request.get_json()
	#a=[4,5,1,9,3,8,11,98]
	data.sort(key=int)
	return (json.dumps(data))


# Run the app if executed directly
if __name__ == "__main__" :
	app.run(host="0.0.0.0" ,port=3000 ,debug=True )

#*******************************************************************************************************************************************************
#                                                             End Of Module
#******************************************************************************************************************************************************
