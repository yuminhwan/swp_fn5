<?php
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');
	mysqli_query($con,"set session character_set_connection=utf8;");
	mysqli_query($con,"set session character_set_results=utf8;");
	mysqli_query($con,"set session character_set_client=utf8;");	
	
	$User_id = $_POST["Review_user"];
	$Review_time = $_POST["Review_time"];
	$Review_contents = $_POST["Review_contents"];
	
	$sql = "DELETE FROM review WHERE User_id='$User_id' AND Review_time='$Review_time' AND Review_contents='$Review_contents' ";
	$statement = "alter table review auto_increment =1";
	$statement1 = "set @count = 0";
	$statement2 = "UPDATE review SET Review_num = @COUNT:=@COUNT+1;";
    $response["success"] = false;
	
  if (mysqli_query($con, $sql)) {
  $response["success"] = true;
  mysqli_query($con, $statement);
   mysqli_query($con, $statement1);
  mysqli_query($con, $statement2);

  }


	
   echo json_encode($response);
?>