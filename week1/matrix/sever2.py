#*******************************************************************************************************************************************************
#
#	File Name : sever2.py
#
#	Description : This module is an API which accepts a Matrix from client and returns the transpose of it .
#
#	Purpose : To learn handling of Matrix argument passing between server api and client
#
#	Author : Swetha sivakumar
#
#	Date Of Creation : 21-05-18
#
#	Date Of Modification : 21-05-18	
#
#*******************************************************************************************************************************************************


#*******************************************************************************************************************************************************
#								Start Of Module 
#*******************************************************************************************************************************************************

# import required packages
from flask import Flask
import json
from flask import request
import numpy as np

# Create an instance of class Flask
app = Flask(__name__)

# Create Route to Required URl , here root url "http://localhost:3000/"
@app.route('/', methods=['POST'])
def transpose():
	"""file1 = open("data2.txt","rb")
	data = json.load(file1)"""
	data = request.get_json()
	m=int(data["m"])
	n=int(data["n"])
	for i in range (0,m):
		for j in range(0,n):
			data["Matrix"][i][j]=data["Matrix"][i][j]*100
	return json.dumps(data["Matrix"])
	
	return json.dumps(data["Matrix"])
#
# Running the app
#a = np.array([
#		[1,2,3,4],
#		[5,6,7,8],
#		[9,10,11,12]
#])
if __name__ == "__main__" :
	app.run(host="0.0.0.0" ,port=3000,debug=True)

#*******************************************************************************************************************************************************
#								End Of Module
#*******************************************************************************************************************************************************
