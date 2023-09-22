const countBtn = document.getElementById("count-btn");

const numberApple = document.querySelector(".number-apple");
const countSum = document.querySelector("#count-sum")


countBtn.addEventListener("click", () => {
   
   const clicked = document.querySelectorAll(".fruit:checked");

   let sum = 0;
   let str = "";

   for(let i=0 ; i < clicked.length ; i++){
      const price = clicked[i].value // 2000
      const fruit = clicked[i].nextElementSibling.innerText // 사과
      const amount = clicked[i].parentElement.nextElementSibling.children[0].value;

      sum += price * amount;

      str += `${fruit} ${amount}개 `;
   }
   
   str += `총합 ${sum}원`;

   countSum.innerText = str;
   
   
   
   

});