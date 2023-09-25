
// JS 객체 다루는 방법
// checkList.["KEY"] (GET)
// checkList.["KEY"] = true; (SET)
const checkList = {
   "input-id" : false,
   "input-pw" : false,
   "input-pw-check" : false,
   "input-email" : false,
   "input-address" : false
};

const signupForm = document.signupForm;
const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCheck = document.getElementById("input-pw-check");
const inputEmail = document.getElementById("input-email");
const inputAddress = document.getElementById("input-address");
const inputTr = document.getElementById("input-tr");

const inputList = document.querySelectorAll(".input");

const inputSpan = document.querySelector(".iuput-span");


/* inputPw.addEventListener("click", () => {

   // inputTr.innerHTML = "";
   
   const inputTr1 = document.createElement("tr");
   inputTr1.classList.add("input-tr");
   
   const inputTd1 = document.createElement("td");
   const inputTd2 = document.createElement("td");
   inputTd2.classList.add("input-td2");
   
   const inputSpan1 = document.createElement("span");
   inputSpan1.classList.add("input-trsult");
   inputSpan1.innerText = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
   
   inputTd2.append(inputSpan1);
   inputTr1.append(inputTd1, inputTd2);
   inputPw.append(inputTr1);

}); */


/* 아이디 */
inputId.addEventListener("input", e => {
   
   // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
   const val = inputId.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   inputId.value = val; // 공백이 제거된 값을 input 값으로 대입

   console.log(val);

   if(val.length === 0){ // 입력된 값이 없을 경우
      span.innerText = "필수 입력 항목 입니다"
      span.classList.remove("check");
      span.classList.remove("error");

      checkList["input-id"] = false;
   } else { // 입력 되었을 경우
      span.innerText = "";
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-id"] = true;
   }

});

/* 비밀번호 유효성 검사 */
inputPw.addEventListener("input", e => {
   
   const val = e.target.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   e.target.value = val;

   const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,20}$/;

   if(regEx.test(val)){ 
      span.innerText = "유효한 비밀번호 형식입니다"
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-pw"] = true;


   } else { 
      span.innerText = "비밀번호가 유효하지 않습니다"
      span.classList.add("error");
      span.classList.remove("check");

      checkList["input-pw"] = false;
   }

});

/* 비밀번호 확인 */
inputPwCheck.addEventListener("input", e => {
   
   // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
   const val = inputId.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   inputId.value = val; // 공백이 제거된 값을 input 값으로 대입

   if(val.length === 0){ // 입력된 값이 없을 경우
      span.innerText = "필수 입력 항목입니다";
      span.classList.remove("check");
      span.classList.remove("error");

      checkList["input-pw-check"] = true;


   } else { // 입력 되었을 경우
      span.innerText = "";
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-pw-check"] = false;

   }

});

/* 이메일 */
inputEmail.addEventListener("input", e => {
   
   // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
   const val = inputId.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   inputId.value = val; // 공백이 제거된 값을 input 값으로 대입

   if(val.length === 0){ // 입력된 값이 없을 경우
      span.innerText = "필수 입력 항목입니다";
      span.classList.remove("check");
      span.classList.remove("error");

      checkList["input-email"] = true;

   } else { // 입력 되었을 경우
      span.innerText = "";
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-email"] = false;

   }

});

/* 주소 */
inputAddress.addEventListener("input", e => {
   
   // 양쪽 공백을 제거한 입력 값을 얻어와 val에 저장
   const val = inputId.value.trim();
   const span = e.target.nextElementSibling.nextElementSibling;

   inputId.value = val; // 공백이 제거된 값을 input 값으로 대입

   if(val.length === 0){ // 입력된 값이 없을 경우
      span.innerText = "필수 입력 항목입니다";
      span.classList.remove("check");
      span.classList.remove("error");

      checkList["input-address"] = true;


   } else { // 입력 되었을 경우
      span.innerText = "";
      span.classList.add("check");
      span.classList.remove("error");

      checkList["input-address"] = false;

   }

});









