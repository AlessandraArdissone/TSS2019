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

$country = $_GET["country"];
$stmt = $conn->prepare('SELECT * FROM v_emps WHERE country = ?');
$stmt->bind_param('s', $country); // 's' specifies the variable type => 'string'
$stmt->execute();
$result = $stmt->get_result();
$data = "";

if ($result->num_rows > 0) {
    $data .= "<table>";
    $data .= "<tr><th>CITT&Agrave;</th><th>COGNOME</th><th>NOME</th><th>MANSIONE</th></tr>";
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        $data .= "<tr><td>" . $row["city"] . "</td><td>" . $row["lastName"] . "</td><td>" . $row["firstName"] . "</td><td>" . $row["jobTitle"] . "</td></tr>";
    }
    $data .= "</table>";
/*
    $data .= "<ol>";
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        $data .= "<li>" . $row["city"] . ": " . $row["lastName"] . " " . $row["firstName"] . " - " . $row["jobTitle"] . "</li>";
    }
    $data .= "</ol>";
*/
    echo $data;
} else {
    echo "0 results";
}
$conn->close();
?>
