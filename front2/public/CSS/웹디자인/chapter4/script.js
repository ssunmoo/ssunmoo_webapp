

/* chartist.js 이용한 차트 구현 */
/*
	변수 = 값
	배열 = [값1, 값2]
	객체 = {키1:값1, 키2:값2}




 */



/* 파이차트[원형차트] 데이터 객체 선언 
let pieData = {
	
	// 항목의 이름
	labels: ['웹디자이너', '웹개발자', '서버엔지니어', '영업직'],
	// 항목의 값
	series: [14, 9, 8, 6]
	
}


let pieOptions = {
	width : '100%',
	height : '440px' 
}


// 차트 적용하기 : new Chartist.Pie('표시할식별자', 데이터객체, 옵션객체)
// Chartist.Pie 클래스
new Chartist.Pie('.pie_chart', pieData, pieOptions)





/* 막대차트 */
/*

let barData = {
	lables : ['2018년', '2019년', '2020년'],
	series : [ [10, 16, 29] ]
}

let barOption = {
	// y축
	axisy: {		// * let 객체명 = { 키 : { } }	객체안에 객체 가능 객체안에 함수 가능
		offset: 60,								// 1. 
		scaleMinSpace: 50,						// 2. 선 간격[px] 조절
		labelInterpolationFnc: function(value){	// 3. y축 눈금 표시
			return value + ' 명'
		}
		
	},
	width : '100%',
	height : '400px;'
}


new Chartist.Bar('.bar_chart', barData, barOption)




/* 본문4 막대차트 */

/*
	직원 급여 차트 순서도
	1. 등록버튼 클릭
	2. 클릭이벤트[사건=행동] 발생
	3. 반복적인 이벤트 발생 -> 함수[메소드]
			* 함수호출 : 함수명()
			* 함수정의 : function 함수명(){ }
	---------------테스트-------------------
	4. 차트 그리기[앞전코드 복사 = 식별자만 변경]
	5. html에 입력된 데이터(input)를 js로 이동
	---------------테스트-------------------
	6. 객체내 속성[키:값]에 데이터 추가
		1. [객체 속성 호출] 객체명.키값
		2. [배열에 데이터 추가] 배열명.push
					객체명.키.push

 */

/*
	
	// 막대차트
let barData2 = {
	// 항목
	labels : [],
	// 값
	series : [ [ ], [ ] ]
}

let barOption2 = {
	// y축
	axisy: {		// * let 객체명 = { 키 : { } }	객체안에 객체 가능 객체안에 함수 가능
		offset: 60,								// 1. 
		scaleMinSpace: 50,						// 2. 선 간격[px] 조절
		labelInterpolationFnc: function(value){	// 3. y축 눈금 표시
			return value + ' 명'
		}
		
	},
	width : '100%',
	height : '400px'
}
	
function 차트그리기(){
	
	const name = document.getElementById('name').value
	const money = document.getElementById('money').value
	const money2 = document.getElementById('money2').value
	
	barData2.labels.push( name )
	barData2.series[0].push( money )
	barData2.series[1].push( money2 )
	
	// 차트적용
	new Chartist.Bar('.bar_chart2', barData2, barOption2)
	
}
	
*/	






let 지원자리스트 = []

function 지원자등록(){


	let 입력리스트 = document.querySelectorAll('input')
	let 목록상자 = document.querySelector('select')
	let 긴글상자 = document.querySelector('textarea')

	console.log(입력리스트)
	console.log(목록상자)
	console.log(긴글상자)

	
	let 지원자 = {
		성명 : 입력리스트[0].value,
		영문명 : 입력리스트[1].value,
		메일주소 : 입력리스트[2].value,
		포트폴리오 : 입력리스트[3].value,
		희망근무지 : 입력리스트[4].value, 
		현재상태 : 긴글상자.value,
		자기소개 : 긴글상자.value,
	}
	console.log(지원자)
	지원자리스트.push(지원자)
	console.log(지원자리스트)

}
	
	
	
	
/*	
function 지원자출력(){
	
	post = 
			'<tr>'+
				'<th>'+'</th>'+'<th>'+'</th>'+'<th>'+'</th>'+
				'<th>'+'</th>'+'<th>'+'</th>'+'<th>'+'</th>'+
			'</tr>'	
			
			
			
	for(i = 0; i < listget.length; i++){
			
	post += 
			
			'<tr>'+
				'<th>'+ listget[i].name +'</th>'+'<th>'+listget[i].egname+'</th>'+'<th>'+listget[i].email+'</th>'+
				'<th>'+listget[i].url+'</th>'+'<th>'+listget[i].workplace+'</th>'+'<th>'+listget[i].option+'</th>'+
			'</tr>'	
			
		}	
			
}


*/

















