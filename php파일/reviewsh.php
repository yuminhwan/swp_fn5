<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Review_hos = $_POST["Review_hos"];
	
    $statement = "SELECT * FROM Review WHERE Review_hos='$Review_hos'";
    $rs = mysqli_query($con, $statement);
	$response = array();	

	while($row =mysqli_fetch_array($rs)){
		array_push($response, array("Review_num" =>$row[0], "Review_score"=>$row[1],
			"Review_time"=>$row[2],   "Review_contents" =>$row[3] 
			, "Review_user" =>$row[4] , "Review_hos" =>$row[5] ,"User_id" =>$row[6] ) );
	}
	
   echo json_encode(array("response" =>$response));
?>