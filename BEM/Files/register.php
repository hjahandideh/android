<?php

	error_reporting(0);
	$con = mysql_connect('http://185.27.134.10/db_structure.php?db=ngi6_17091508_bem&token=8d0528cea084a264bfc3c8926f8af92b','ngi6_17091508','9311811212');
	
	
	$user=$_POST['username'];
	$pass=$_POST['pass'];
	
	if($con){
		
		
		mysql_select_db('ngi6_17091508_bem',$con);
		mysql_set_charset('utf8');
		
		$q="INSERT INTO users (username,pass) VALUES('$user','$pass')";
		
		if(mysql_query($q)){
			
			echo "Done";
			
		}else{echo "Error";}
		
	}

 ?>
