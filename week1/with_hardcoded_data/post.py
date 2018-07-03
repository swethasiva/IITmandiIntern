#*******************************************************************************************************************************************************
#
# File Name : post.py
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
from flask import Flask
import math
import sys
import json

app = Flask(__name__)


@app.route('/mean',methods=['GET','POST'])
def sd_calc():
    
    n=len(ls)
    if n <= 1:
        return str(0.0)

    mean, sd = avg_calc(ls), 0.0

    # calculate stan. dev.
    for element in ls:
        sd += (float(element) - mean)**2
    sd = math.sqrt(sd / float(n-1))

    return str(sd)
    

def avg_calc(ls):
    n, sum1 = len(ls), 0.0

    if n <= 1:
        return ls[0]

    # calculate average
    for element in ls:
        sum1 = sum1 + float(element)
    mean = sum1 / float(n)

    return mean
ls=[1,2,3,4]
if __name__ == '__main__':
	app.run(debug=True)	
	
#*******************************************************************************************************************************************************
#                                                             End Of Module
#******************************************************************************************************************************************************
