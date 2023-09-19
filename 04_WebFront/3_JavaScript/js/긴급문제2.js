// document.querySelector("[name='fw']:checked").value

const width = document.getElementById('width');
const height = document.getElementById('height');
const ness = document.getElementById('ness');
const cor = document.getElementById('cor');
const bcor = document.getElementById('bcor');
const letter = document.getElementById('letter');


btn.addEventListener('click', function () {
   
   const point = document.querySelector ("[name='point']:checked");
   const sort1 = document.querySelector ("[name='sort1']:checked");
   const sort2 = document.querySelector ("[name='sort2']:checked");

   box.style.width = width.value + 'px';
   box.style.height = height.value + 'px';
   box.style.fontSize = ness.value + 'px';
   box.style.color = cor.value;
   box.style.backgroundColor = bcor.value;
   box.innerText = letter.value;
   
   if(point != null) {
      box.style.fontWeight = point.value;
   }
   if(sort1 != null) {
      box.style.justifyContent = sort1.value;
   }
   if(sort2 != null){
      box.style.alignItems = sort2.value;
   }





});



