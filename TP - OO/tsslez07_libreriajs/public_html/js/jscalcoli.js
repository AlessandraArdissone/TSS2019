/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var n_num1 = 0;
var n_num2 = 0;

function get_values(){
    n_num1 = document.getElementById("in_num1").value*1;
    n_num2 = document.getElementById("in_num2").value*1;
}

function do_power() {
    get_values();
    document.getElementById("div_result").innerHTML=power(n_num1, n_num2);
}

function do_sum() {
    get_values();
    document.getElementById("div_result").innerHTML=sum(n_num1, n_num2);
}
