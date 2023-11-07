// 글쓰기 버튼이 존재할 때
// 클릭 시 해당 게시판 글쓰기 화면 요청(이동)

//  요청 주소 : /editBoard/{boardCode}/insert

const insertBtn = document.querySelector("#insertBtn");

if(insertBtn != null){
  insertBtn.addEventListener('click', () => {
    location.href = `/editBoard/${boardCode}/insert`;
  });
}