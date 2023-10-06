
// 로그아웃 버튼 얻어오기 (없으면 null)
const logoutBtn = document.getElementById("logout-btn");

if(logoutBtn != null){ // 로그아웃 버튼이 있을 때

   logoutBtn.addEventListener("click", () => {
      location.href = "/logout"
   });

}

