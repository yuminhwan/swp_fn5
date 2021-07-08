<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Sick_user = $_POST["Sick_user"];
	
    $statement = mysqli_prepare($con,"SELECT * FROM SICK WHERE Sick_user= ? ");
	mysqli_stmt_bind_param($statement,"s",$Sick_user);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$Sick_num,$Sick_user,$Sick_A1,$Sick_A2,$Sick_A3,$Sick_A4,$Sick_A41,$Sick_A42,$Sick_A7,$Sick_A8,$Sick_A9,$Sick_A10,$Sick_A11);

    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
		$response["Sick_A1"] = $Sick_A1;
        $response["Sick_A2"] = $Sick_A2;
        $response["Sick_A3"] = $Sick_A3;
        $response["Sick_A4"] = $Sick_A4;
        $response["Sick_A41"] = $Sick_A41;
		$response["Sick_A42"] = $Sick_A42; 
		$response["Sick_A7"] = $Sick_A7; 
		$response["Sick_A8"] = $Sick_A8; 
		$response["Sick_A9"] = $Sick_A9; 
		$response["Sick_A10"] = $Sick_A10; 
		$response["Sick_A11"] = $Sick_A11; 
    }


	
   echo json_encode($response);
?>