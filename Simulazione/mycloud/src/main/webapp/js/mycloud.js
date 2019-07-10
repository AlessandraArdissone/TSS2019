/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#homeMenu").classList.add("active");

document.querySelector("#pLogin").onclick = function () {
    window.location.assign("login.jsp");
};

document.querySelector("#pRegister").onclick = function () {
    window.location.assign("register.jsp");
};

//console.log("pagina mycloud.js");