
// 입력요소 값 두개 다 읽어오기
// 입력요소.value : 입력 요소에 작성된 값 반환(string)
const in1 = document.getElementById("in1");
const in2 = document.getElementById("in2");
const result = document.getElementById("result");


// 더하기 버튼
function plus() {
   // 두 값 더하기
   //Number("123") == 123 (숫자로 변환)
   console.log(Number(in1.value) + Number(in2.value));

   // 요소.innerText = <시작>내용</종료> -> 나중에 글자 대입
   result.innerText = Number(in1.value) + Number(in2.value);
}

function minus() {
   console.log(Number(in1.value) - Number(in2.value));
   result.innerText = Number(in1.value) - Number(in2.value);
}

function multi() {
   console.log(Number(in1.value) * Number(in2.value));
   result.innerText = Number(in1.value) * Number(in2.value);
}

function div() {
   console.log(Number(in1.value) / Number(in2.value));
   result.innerText = Number(in1.value) / Number(in2.value);
}

function mod() {
   console.log(Number(in1.value) % Number(in2.value));
   result.innerText = Number(in1.value) % Number(in2.value);
}