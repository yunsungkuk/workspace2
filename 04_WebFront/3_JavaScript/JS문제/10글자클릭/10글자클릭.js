const clear = document.getElementById("clear");
const clickNumber = document.getElementById("click-number")

const cols = document.querySelectorAll(".col");


for(let col of cols){
   col.addEventListener("click", () => {

      if(clickNumber.innerText.length >= 10){
         alert("10글자 까지만 입력 가능");
         return;
      }

      clickNumber.innerText += col.innerText;
   });

}

clear.addEventListener("click", ()=> {
   clickNumber.innerText = "";
});