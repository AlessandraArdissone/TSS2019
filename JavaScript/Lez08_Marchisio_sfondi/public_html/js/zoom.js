/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#beatles").onmousemove = function(e) {
    console.log(e.clientX, e.clientY);
    let x = e.clientX-100; //100px 100px è la posizione del div #beatles
    let y = e.clientY-100; //100px 100px è la posizione del div #beatles

    document.querySelector("#lente").style.backgroundPositionX =  -x + "px";
    document.querySelector("#lente").style.backgroundPositionY =  -y + "px";
};

