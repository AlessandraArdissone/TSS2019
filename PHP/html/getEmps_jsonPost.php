<?php

$servername = "localhost";
$username = "root";
$password = "ghiglieno";
$dbname = "classicmodels";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$country = $_POST["country"];
$stmt = $conn->prepare('SELECT * FROM v_emps WHERE country = ?');
$stmt->bind_param('s', $country); // 's' specifies the variable type => 'string'
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    $outp = $result->fetch_all(MYSQLI_ASSOC);
    echo json_encode($outp);
} else {
    echo `[{"ris":"0"}]`;
}
$conn->close();
?>
