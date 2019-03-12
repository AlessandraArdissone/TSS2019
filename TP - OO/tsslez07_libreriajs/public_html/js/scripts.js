/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ar_students = [];
/*
 function view_students() {
 //    document.getElementById("div_students").innerHTML = create_listBR(ar_students);
 //    document.getElementById("div_studentsOL").innerHTML = create_orderedlist(ar_students);
 document.getElementById("div_studentsTable").innerHTML = create_listTable(ar_students);
 }
 */
function add_students() {
    let s_student = document.getElementById("in_student").value.trim();
    /*    
     alert("Quadrato di 2: " + squarePower(2));
     alert("Cubo di 2: " + cubePower(2));
     alert("2 elevato a 0: " + power(2, 0));
     alert("2 elevato a 1: " + power(2, 1));
     alert("2 elevato a 5: " + power(2, 5));
     alert("2 elevato a 10: " + power(2, 10));
     alert("3 elevato a default(2): " + power(3));
     alert("2 elevato a -1: " + power(2, -1));
     alert("2 elevato a -2: " + power(2, -2));
     alert("2 elevato a -3: " + power(2, -3));
     alert("0 elevato a 3: " + power(0, 3));
     alert("0 elevato a -2: " + power(0, -2));
     */
    if (s_student !== "")
        ar_students.push(s_student);
    
//    view_students();
    create_listBRObj(ar_students, document.getElementById("div_students"));
    create_orderedlistObj(ar_students, document.getElementById("div_studentsOL"));
    create_listTableObj(ar_students, document.getElementById("div_studentsTable"));
}