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

$stmt = $conn->prepare('SELECT country FROM v_country');
$stmt->execute();
$result = $stmt->get_result();

$ht = "";

if ($result->num_rows > 0) {
    // output data of each row
    while ($row = $result->fetch_assoc()) {
        $ht .= '<option value = "' . $row["country"] . '">' . $row["country"] . '</option>';
    }
}
$conn->close();
?>

<script>
    function showEmp() {
        let str = document.getElementById("scountry").value;
        if (str.length == 0) {
            document.getElementById("myemp").innerHTML = "";
            return;
        } else {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("myemp").innerHTML = this.responseText;
                }
            };
            xmlhttp.open("GET", "getEmps.php?country=" + str, true);
            xmlhttp.send();
        }
    }
</script>

<style>
    table {
        border-collapse: collapse;
    }

    tr th {
        border: 2px solid black;
    }

    tr td {
        border: 1px solid black;
    }
</style>

<html>
    <body>

        <form action="ris1.php" method="post">
            Name: <input type="text" name="name"><br>
            E-mail: <input type="text" name="email"><br>
            <input type="submit"><br>
            <input type="text" id = "intest">
            <input type="hidden" name = "paramhid" value="nascosto hidden">
        </form>

        <form action="risdb.php" method="post">
            Country: <select name="country" id="scountry">
                <?php
                echo $ht;
                ?>
            </select><br>
            <input type="submit"><br>
            <input type="button" value="ajax load" onclick="showEmp();">
        </form>

        <div id ="myemp">nessuno</div>
    </body>
</html>
