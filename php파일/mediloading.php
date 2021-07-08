<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Review_hos = $_POST["Review_hos"];
	
    $statement = "SELECT * FROM medi";
    $rs = mysqli_query($con, $statement);
	$response = array();	

	while($row =mysqli_fetch_array($rs)){
		array_push($response, array("Medi_num" =>$row[0],"Medi_name" =>$row[1], "Medi_tel"=>$row[2],
			  "Medi_location" =>$row[3] , "Medi_M" =>$row[4] , "Medi_Tu" =>$row[5] , "Medi_W" =>$row[6] , "Medi_Th" =>$row[7]
			, "Medi_F" =>$row[8] , "Medi_Sa" =>$row[9] ,"Medi_Su" =>$row[10] , "Medi_H" =>$row[11] , "Medi_lat" =>$row[12] , "Medi_long" =>$row[13]   ) );
	}
	
   echo json_encode(array("response" =>$response));
?>
