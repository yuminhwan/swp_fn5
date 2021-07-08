<?php 
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	
	$User_name = $_POST["User_name"];	
    $User_id = $_POST["User_id"];
    $User_pass = $_POST["User_pass"];
	$User_birth = $_POST["User_birth"];
    $User_sex = $_POST["User_sex"];
	$User_location = $_POST["User_location"];

    $statement = mysqli_prepare($con, "INSERT INTO USER(User_name,User_id, User_pass , User_birth , User_sex , User_location) VALUES (?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssssss",$User_name,$User_id, $User_pass, $User_birth, $User_sex, $User_location);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>