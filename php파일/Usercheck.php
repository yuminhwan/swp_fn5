<?php

    $con = mysqli_connect("localhost", "hos", "123", "test","3308");


     $User_id = $_POST["User_id"];


     $statement = mysqli_prepare($con, "SELECT User_id FROM USER WHERE User_id = ?");

   


     mysqli_stmt_bind_param($statement, "s", $User_id);

     mysqli_stmt_execute($statement);

     mysqli_stmt_store_result($statement);

     mysqli_stmt_bind_result($statement, $User_id);


     $response = array();

     $response["success"] = true;


     while(mysqli_stmt_fetch($statement)){

       $response["success"] = false;
       $response["User_id"] = $User_id;

     }


   -

     echo json_encode($response);

?>