<?php 
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');

    $Sick_A1 = $_POST["Sick_A1"];
    $Sick_A2 = $_POST["Sick_A2"];
	$Sick_A3 = $_POST["Sick_A3"];
    $Sick_A4 = $_POST["Sick_A4"];
	$Sick_A41 = $_POST["Sick_A41"];
	$Sick_A42 = $_POST["Sick_A42"];
    $Sick_A7 = $_POST["Sick_A7"];
	$Sick_A8 = $_POST["Sick_A8"];
	$Sick_A9 = $_POST["Sick_A9"];
	$Sick_A10 = $_POST["Sick_A10"];
    $Sick_A11 = $_POST["Sick_A11"];
	$Sick_user = $_POST["User_id"];
	

    $statement = mysqli_prepare($con, "INSERT INTO SICK(Sick_A1,Sick_A2,Sick_A3,Sick_A4,Sick_A41,Sick_A42,Sick_A7,Sick_A8,Sick_A9,Sick_A10,Sick_A11,Sick_user ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssssssssssss",$Sick_A1,$Sick_A2,$Sick_A3,$Sick_A4,$Sick_A41,$Sick_A42,$Sick_A7,$Sick_A8,$Sick_A9,$Sick_A10,$Sick_A11,$Sick_user);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>