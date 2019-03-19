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
$officeCode = $_POST["officeCode"];
$city = $_POST["city"];
$phone = $_POST["phone"];
$addressLine1 = $_POST["addressLine1"];
$postalCode = $_POST["postalCode"];
$territory = $_POST["territory"];

$stmt = $conn->prepare('INSERT INTO offices (officeCode, city, phone, addressLine1, country, postalCode, territory)'
        . 'VALUES (?, ?, ?, ?, ?, ?, ?);');

$stmt->bind_param('sssssss', $officeCode, $city, $phone, $addressLine1, $country, $postalCode, $territory);
$stmt->execute();
//$id = $conn->lastInsertId(); // la PK non ha l'Auto-Increment
//echo $id;
echo $officeCode;

$conn->close();
?>
