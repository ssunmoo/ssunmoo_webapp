/**
 * 
 */
let 저장=[]
let 승리 = ''
let count = 0
 
    function 게임판만들기(){
       count = 0
       let 게임판생성 = ''
       저장=[null,null,null,null,null,null,null,null,null]
       
      for( let i = 0 ; i < 9 ; i++ ){
         게임판생성 += `<button id=${i} onclick="버튼클릭(${i})">${i}</button>`
         if( i % 3 == 2 ){
            게임판생성 += `<br>`
         }
      }
      document.getElementById('게임판').innerHTML = 게임판생성 
   }

   
   
   function 버튼클릭(a){
      
      if(중복검사(a)){
         alert('이미 둔 자리입니다.')
         return   
      }
      
      count++
      저장[a]='O'
      document.getElementById(a).innerHTML = 'O'
      
      if(승리판단()){   
         alert('내가이김')   
         return
      }
      if(count==9){
         alert('무승부')
      }      
      
      let 난수= 0            
      while(true){
         난수 = Math.floor(Math.random()*9)
         if(저장[난수]==null){
         break
         }
      }
      count++
      저장[난수]='X'
      document.getElementById(난수).innerHTML = 'X'
      if(승리판단()){   
         alert('쟤가이김')   
         return
      }
   }
      
   function 중복검사(i){
      if(저장[i]!=null){
         return
      }      
   }
   
   // 
   
   
   function 승리판단(){//가로 승리 조건 012 345 678 //세로 승리 조건 036 147 258 //대각선 승리 조건 048 246
      for(let i=0;i<=6;i+=3){//for1 s
         if(저장[i]!=null&&저장[i]==저장[i+1] && 저장[i+1]==저장[i+2]){//if s
            return true
         }//if e
      }//for1 e
      for(let i=0;i<=2;i++){//for2 s
         if(저장[i]!=null&&저장[i]==저장[i+3]&&저장[i]==저장[i+6]){
            return true
         }
      }//for2 e
      if(저장[0]!=null&&저장[4]!=null&&저장[8]!=null&&저장[0]==저장[4]&&저장[4]==저장[8]){
         return true
      }
      if(저장[2]!=null&&저장[2]==저장[4]&&저장[4]==저장[6]){
         return true
      }      
   }//fuc e
   
   