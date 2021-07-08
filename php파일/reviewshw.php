<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Review_hos = $_POST["Review_hos"];
	
    $res = mysqli_query($con,"SELECT * FROM Review WHERE Review_hos='$Review_hos'");

	$data = array(); 
	
	 while($row=mysqli_fetch_array($res)){

            array_push($data, 
                array('Review_score'=>$row["Review_score"],'Review_time'=>$row["Review_time"]
				,'Review_title'=>$row["Review_title"],'Review_contents'=>$row["Review_contents"],'Review_user'=>$row["Review_user"]
				,'User_id'=>$row["User_id"]
            ));
			
        }
	
	
   echo json_encode(array("response" =>$data));
   
   ?>