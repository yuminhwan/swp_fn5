<?php 
    $con = mysqli_connect("localhost", "hos", "123", "test","3308");
    mysqli_query($con,'SET NAMES utf8');


    $Review_contents = $_POST["Review_contents"];
	$Review_score = $_POST["Review_score"];
    $Review_time = $_POST["Review_time"];
	$Review_user = $_POST["Review_user"];
	$Review_hos = $_POST["Review_hos"];
	$User_id = $_POST["User_id"];

	
	
	

    $statement = mysqli_prepare($con, "INSERT INTO Review(Review_score, Review_time  , Review_contents , Review_user,Review_hos , User_id ) VALUES (?,?,?,?,?,?)");
    mysqli_stmt_bind_param($statement,"ssssss",$Review_score, $Review_time,  $Review_contents,$Review_user,$Review_hos,$User_id);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);

?>
