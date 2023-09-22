const createBtn = document.getElementById("create-btn");
const sumBtn = document.getElementById("sum-btn");
const btn1 = document.querySelector(".btn1");

const container = document.querySelector(".container");

// 생성 버튼 클릭했을 때 개수만큼 생성
createBtn.addEventListener("click", () => {

   // input 생성
   for(let i=0 ; i<btn1.value ; i++){
      const row = document.createElement("div");

      row.classList.add("row");

      const input = document.createElement("input");

      input.setAttribute("type", "number");

      input.classList.add("input-number");

      row.append(input);

      container.append(row);
   }
});

// 더하기 버튼 클릭 했을 때
sumBtn.addEventListener("click", () => {
   // 모든 input-number 얻어오기
   const number = document.querySelectorAll(".input-number");

   // for문에서 더하는 값 저장하는 객체 만들기
   let sum = 0;

   for(let i=0 ; i<number.length ; i++){
      sum += Number(number[i].value);
   }
   console.log(sum);

   
   result.innerText = sum;

});