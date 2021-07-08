<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$Sick_user = $_POST["Sick_user"];
	
	$sql = "DELETE FROM SICK WHERE Sick_user='$Sick_user'";
    $response["success"] = false;
	$statement = "alter table review auto_increment =1";
  if (mysqli_query($con, $sql)) {
  $response["success"] = true;
   mysqli_query($con, $statement);}


	
   echo json_encode($response);
?>