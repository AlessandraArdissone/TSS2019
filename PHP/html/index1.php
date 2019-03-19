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
    function showEmpGet() {
        let str = document.getElementById("scountry").value;
        if (str.length == 0) {
            document.getElementById("myemp").innerHTML = "";
            return;
        } else {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    creaTabellaDaJson(JSON.parse(this.responseText), "", "tabEmp", "tabella", "#myemp");
                    let okHTML = prepareHTML(this.responseText);
                    document.getElementById("myemp").innerHTML += "<hr>";
                    document.getElementById("myemp").innerHTML += okHTML;
                    //document.getElementById("myemp").innerHTML = this.responseText;
                }
            };
//          xmlhttp.open("GET", "getEmps.php?country=" + str, true);
            xmlhttp.open("GET", "getEmps_jsonGet.php?country=" + str, true);
            xmlhttp.send();
        }
    }

    function showEmpPost() {
        let fd = new FormData(fcountry);

        let str = document.getElementById("scountry").value;
        if (str.length == 0) {
            document.getElementById("myemp").innerHTML = "";
            return;
        } else {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    creaTabellaDaJson(JSON.parse(this.responseText), "", "tabEmp", "tabella", "#myemp");
                    let okHTML = prepareHTML(this.responseText);
                    document.getElementById("myemp").innerHTML += "<hr>";
                    document.getElementById("myemp").innerHTML += okHTML;
                    //document.getElementById("myemp").innerHTML = this.responseText;
                }
            };
//          xmlhttp.open("GET", "getEmps.php?country=" + str, true);
            xmlhttp.open("POST", "getEmps_jsonPost.php", true);
            xmlhttp.send(fd);
        }
    }

    function prepareHTML(dbJSON) {
        let ar_rows = JSON.parse(dbJSON);
        let ht = "<table>";
        for (let i = 0; i < ar_rows.length; i++) {
            ht += "<tr><td>" + ar_rows[i].firstName
                    + "</td><td>" + ar_rows[i].lastName
                    + "</td><td>" + ar_rows[i].city + "</td></tr>";
        }
        ht += "</table>";
        return ht;
    }

    function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore = "body") {
        let tabella = document.createElement("table");
        tabella.id = idTabella;
        tabella.className = classeTabella;

        // riga intestazione
        let tHead = document.createElement("thead");
        let riga = document.createElement("tr");
        if (listaCampi == "") {
            let v = [];
            for (campo in oggJson[0]) {
                v.push(campo);
            }
            listaCampi = v.join(",");
        }
        let vCampi = listaCampi.split(",");
        vCampi.forEach(function (campo, i) {
            let th = document.createElement("th");
            th.innerHTML = campo;
            riga.appendChild(th);
        });
        tHead.appendChild(riga);
        tabella.appendChild(tHead);

        // tbody
        let tBody = document.createElement("tbody");
        oggJson.forEach(function (record, i) {
            riga = document.createElement("tr");
            vCampi.forEach(function (campo, j) {
                let cella = document.createElement("td");
                cella.innerHTML = record[campo];    // oggJson[j][campo]
                riga.appendChild(cella);
            });
            tBody.appendChild(riga);
        });
        tabella.appendChild(tBody);

        // append della tabella al contenitore
        document.querySelector(contenitore).innerHTML = "";
        document.querySelector(contenitore).appendChild(tabella);
    }

    function insNewOff() {
        let fd = new FormData(finsert);

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                let id = this.responseText;
                alert(id);
                document.location = "index1.php"; // ricarica la pagina!
            }
        };

        xmlhttp.open("POST", "insNewOffice.php", true);
        xmlhttp.send(fd);
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
        font-size: 12px;
    }

    table.tabella {
        border-collapse: collapse;
        font-family: "Arial";
    }

    table.tabella td, table.tabella th {
        border: 1px solid gray;
    }

    table.tabella th {
        background-color: blue;
        color: white;
    }

    table.tabella td {
        font-size: 12px;
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

        <hr>

        <form id="fcountry" action="risdb.php" method="post">
            Country: <select name="country" id="scountry">
                <?php
                echo $ht;
                ?>
            </select><br>
            <input type="submit"><br>
            <input type="button" value="ajax load GET" onclick="showEmpGet();"><br />
            <input type="button" value="ajax load POST" onclick="showEmpPost();">
        </form>

        <div id ="myemp">nessuno</div>

        <hr>

        <form id="finsert" method="post">
            <input type="text" name="country" placeholder="country" /><br>
            <input type="text" name="officeCode" placeholder="officeCode" /><br>
            <input type="text" name="city" placeholder="city" /><br>
            <input type="text" name="phone" placeholder="phone" /><br>
            <input type="text" name="addressLine1" placeholder="addressLine1" /><br>
            <input type="text" name="postalCode" placeholder="postalCode" /><br>
            <input type="text" name="territory" placeholder="territory" /><br>
            <input type="button" value="inserisci POST" onclick="insNewOff();">
        </form>
    </body>
</html>
