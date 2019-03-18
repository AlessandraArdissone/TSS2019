/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelectorAll(".numero").forEach(function (elm, k) {
        elm.setAttribute("num", k);
        elm.innerHTML = k;
    });
