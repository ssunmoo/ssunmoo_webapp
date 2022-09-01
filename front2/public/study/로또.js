

let board = ''

let select_box = []

function 번호판(){
   board = ''
   for(let i = 0 ; i<=45 ; i++){
      board += `<button id=${i} onclick="번호선택(${i})">${i}</button>`
   }
   document.getElementById('number_board').innerHTML = board 
}


function 번호선택(event){
   if(select_box.length == 6){
      alert('숫자 선택 완료')
      return
   }   
   select_box.push(event)
}





/*
function 중복검사(i){
   if(select_box.indexOf(i)==1){
      
      
   }
   
}

*/