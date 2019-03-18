/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let obj1 = document.createElement("div");
obj1.classList.add("palla");
obj1.innerHTML = "1";

let obj2 = document.createElement("div");
obj2.classList.add("palla");
obj2.style.backgroundColor = "green";
obj2.innerHTML = "2";

document.querySelector("body").appendChild(obj1);
document.querySelector("body").insertBefore(obj2,obj1);
document.querySelector("body").removeChild(obj1);
