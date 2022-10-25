
// 1. 사이드바 호출
let sideber = document.querySelector('.sideber');
let mainbox = document.querySelector('#mainbox');


// 2. 사이드바 클릭 시 이벤트 발생
sideber.addEventListener( 'click', function(){
	// 3. 해당 사이드바의 css 변경 -> left를 0으로 수정
	sideber.style.left = 0;
})

// 3. 사이드바 닫기 : 본문 구역을 클릭했을 때 사이드바 닫기
mainbox.addEventListener( 'click', function(){
	sideber.style.left = '-170px';
})

/* ---- 본문 전환 이벤트 ---- */
function pagechage( page ){
	// 특정 태그에 해당 파일 로드
	$('#mainbox').load( page );
	
}










