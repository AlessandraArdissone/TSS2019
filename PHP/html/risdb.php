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

//echo "123<br>";

$country = $_POST["country"];
$stmt = $conn->prepare('SELECT * FROM offices WHERE country = ?');
$stmt->bind_param('s', $country); // 's' specifies the variable type => 'string'
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        echo "code: " . $row["officeCode"] . " - citt&agrave;: " . $row["city"] . " " . $row["country"] . "<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>
