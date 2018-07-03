#!/bin/bash
 
 while true; 
 do 
 pid=$(pgrep python);
 echo `ps -p $pid -o pid,time,%cpu,%mem,cmd >>try3.csv`;
 sleep 5; 
 done
