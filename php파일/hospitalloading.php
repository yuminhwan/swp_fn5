<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Review_hos = $_POST["Review_hos"];
	
    $statement = "SELECT * FROM hospital";
    $rs = mysqli_query($con, $statement);
	$response = array();	

	while($row =mysqli_fetch_array($rs)){
		array_push($response, array("Hospital_num" =>$row[0],"Hospital_name" =>$row[1], "Hospital_category"=>$row[2],
			"Hospital_location"=>$row[3],  "Hospital_tel" =>$row[4] , "Hospital_M" =>$row[5] 
			, "Hospital_Tu" =>$row[6] , "Hospital_W" =>$row[7] , "Hospital_Th" =>$row[8]
			, "Hospital_F" =>$row[9] , "Hospital_Sa" =>$row[10] ,"Hospital_Su" =>$row[11] , "Hospital_H" =>$row[12]
			, "Hospital_lat" =>$row[13] , "Hospital_long" =>$row[14]) );
	}
	
   echo json_encode(array("response" =>$response));
?>


