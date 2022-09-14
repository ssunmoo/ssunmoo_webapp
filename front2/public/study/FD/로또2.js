/*


	1. 로또 시작하기 버튼을 눌렀을때 로또 버튼 45개 출력
	2. 45개 버튼 중 선택한 번호가 누적되어 출력되도록
	3. 중복 숫자는 누를 수 없음
	4. 6개까지만 선택 가능
		- 번호 추첨
	5. 당첨번호 6개가 랜덤으로 출력되도록(6개 한번에, 6개 까지만)
	6. 중복 숫자는 출력될 수 없음
	7. 내가 선택한 번호와 추첨된 번호 비교
	8. 당첨된 번호가 어떤 것인지 출력
	9. 당첨자 발표(1등. 22억! 2등. 3천만원! 3등. 100만원 4등. 5만원 5등. 5천원 꽝!)

*/

let btn_select_box = [];


// 로또 버튼 출력하기
function lottostart(){
	
	let btn_box = '';
	for(let i = 1; i < 46; i++){
		btn_box += `<button onclick="${i}"> ${i} </button>`
		
		if( i % 5 == 0 ){
			btn_box += `<br>`
		}
	}
	document.getElementById('lottostart').innerHTML = btn_box
	console.log(btn_box)
	
	
}

// 로또 숫자 고르기
function btn_select( i ){

	// 고른 숫자가 저장되기 위해 함수 밖에다가 변수를 배열로 추가하기
	if ( btn_select_box.indexOf(i) == -1 ){
		// 선택한 수가 배열에 존재하지 않을 경우
		// -1은 없다 0이상은 있다는 뜻 
	
		if( btn_select_box.length == 6 ){
			// 6개가되면 멈추기
			alert("더이상 선택할 수 없습니다")
			console.log(i)
			return;
		} // if 종료
		
	} // if 종료
	else{ // 선택한 수가 배열에 있을 경우
		alert("이미 선택된 번호입니다")
		btn_select_box.splice(i, 1)
		// 선택했던 번호를 빼주기
		
		btn_select_box.push(i);
	} // else 종료
	
	document.getElementById('select_box').innerHTML = btn_select_box;	
} // 함수 종료 


