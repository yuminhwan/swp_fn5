<?php
	session_start();
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');

    $User_id = $_POST["User_id"];
    $User_pass = $_POST["User_pass"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE User_id = ? AND User_pass = ?");
    mysqli_stmt_bind_param($statement,"ss",$User_id, $User_pass);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,$User_name,$User_num,$User_id, $User_pass, $User_birth, $User_sex, $User_location);

    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
		$response["User_name"] = $User_num;
		$response["User_num"] = $User_num;
        $response["User_id"] = $User_id;
        $response["User_pass"] = $User_pass;
        $response["User_birth"] = $User_birth;
        $response["User_sex"] = $User_sex;
		$response["User_location"] = $User_location; 
    }

    echo json_encode($response);



?>