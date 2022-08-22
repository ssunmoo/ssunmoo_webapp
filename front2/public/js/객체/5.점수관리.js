/*
	
	* 함수 : 1. 정의[만들기] 2. 호출[불러오기]
		- 특징	
			1. 함수 안에서 할당된 메모리는 함수 종료시 초기화[사라짐]
	
	
	* 학생 점수 프로그램
		1. 학생 객체 선언
		2. 점수 등록 버튼을 눌렀을때
			1. 해당 js 함수 호출하기
				<button onclick="함수명()"></button>
		
			2. HTML에서 입력받은 데이터를 js 객체에 저장
				* 학생이름 중복체크 함수
					- 
				
				- 함수 등록 함수 사용
				- document.getElementById('id명').value;
						
			3. 여러개의 객체를 저장 ---> 배열
				- 배열은 다른 함수에서도 사용할 예정 [함수 밖에 선언]
			
			4. html	초기화
			
		3. 학생 점수 출력
			1. js 처음 열었을때 1번  2. 학생등록을 할때마다 	
			
 */
 
 
 let studentlist = []
 // 여러개의 객체를 저장할 배열 생성
 학생출력()
 
 // html에서 점수등록 버튼을 눌렀을때 점수 등록으로 저장한 함수 값이 출력됨
function 점수등록(){
	// 1. 객체
		// document.getElementById('kor').value : input에 입력된 문자열 가져오기[무조건 문자열]
		// Number(document.getElementById('kor').value) : input에 입력된 문자열을 숫자열로 변환해서 가져오게됨
	
	const student = {
	name : document.getElementById('name').value ,			// 이름 속성[ 키 : 값 ]
	kor : Number(document.getElementById('kor').value) ,	// 국어 속성
	eng : Number(document.getElementById('eng').value) ,	// 영어 속성
	mat : Number(document.getElementById('mat').value) 	// 수학 속성


	}
	

	
	// *배열에 저장하기전[학생등록 전]에 중복체크
	if(이름중복체크(student.name)){	// 이름 중복체크 함수에서 결과가 true 이면
		return
	}	// 리턴은 함수를 종료하는 의미로 리턴될 경우 아래 함수는 실행되지 않는다.
	
	
	// 2. 객체를 배열에 담기
	studentlist.push( student )
		// 배열명.push(데이터) : 배열에 데이터 추가
	
	// 3. 알림/확인
	alert('점수 등록이 완료되었습니다.')
	console.log(studentlist)
	
	// 4. html 초기화 입력한 내용 지우기
	document.getElementById('name').value = '' 
	document.getElementById('kor').value = '' 
	document.getElementById('eng').value = '' 
	document.getElementById('mat').value = '' 	
	
	학생출력()
} 


// 동명이인 불가

function 이름중복체크( name ){	// 학생 이름 중복체크 함수 정의
	for( let i = 0; i < studentlist.length; i++ ){
		// 만약에 배열에 객체가 3개 있을 경우 -->  길이 : 1~3	인덱스 : 0~2
		// i는 0부터(인덱스는 0부터라 0으로시작) i는 배열의 길이[배열내 객체수]미만까지 1씩 증가 반복 
		if(studentlist[i].name === name ){	// === 강력비교!!
			// 배열내 i번째 인덱스의 객체내 이름이 새로 입력받은 이름과 같으면
			alert('이미 존재하는 학생명입니다.')
			return true	// 배열내 name과 동일한 이름이 있다
		}
	}
	return false	// 배열내 name과 동일한 이름이 없다
}

function 학생출력(){
	// 1. 변수에 html 태그[문자열]를 저장하기
	let html = '<tr>' + 
					'<th>등수</th>' +
					'<th>학생명</th>' +
					'<th>국어</th>' +
					'<th>영어</th>' +
					'<th>수학</th>' +
					'<th>총점</th>' +
					'<th>평균</th>' +
					'<th>비고</th>' +
				'</tr>'
				
	// *** 배열내 객체들을 하나씩 꺼내기 -> 객체 정보를 html화 시키기
	for(let i = 0; i < studentlist.length; i++){
		// i는 0부터 배열내 마지막 인덱스까지[배열의 길이 -1 혹은 미만으로 조건문 쓰면됨]
		
		let sum = studentlist[i].kor + studentlist[i].eng + studentlist[i].mat
		let avg = sum / 3

		
		// 객체에 들어있는 데이터를 html로 출력
		html += '<tr>' + 
					'<th>' +  + '</th>' +
					'<th>'+ studentlist[i].name +'</th>' +
					'<th>'+ studentlist[i].kor +'</th>' +
					'<th>'+ studentlist[i].eng +'</th>' +
					'<th>'+ studentlist[i].mat +'</th>' +
					'<th>'+ sum +'</th>' +
					'<th>'+ avg +'</th>' +
					'<th><button onclick="학생삭제('+i+')"> 삭제 </button></th>' +
						//	버튼 눌렀을때 누구를 삭제할건지?
				'</tr>'
		
		// 변수는 문자처리 x
			// 변수는 앞전에 미리 정의된 단어[키워드 = 컴퓨터가 알고 있는 단어]
	}			
				
			
	// 2. 해당 변수를 html에 출력하기
	document.getElementById('listtable').innerHTML = html
}

function 학생삭제( i ){	// 저장된 학생을 삭제하는 함수 [매개변수 : 삭제할 식별번호(배열내 저장된 순서번호=인덱스)]
	alert(studentlist[i].name + '의 점수를 삭제 합니다.')
	studentlist.splice( i, 1 )	// i번째 인덱스의 1개 삭제
	
	학생출력()	//	위까지 삭제명령어를 실행하고 html에 최신화 시켜야하기 때문에
				//	학생출력 한번 더 호출해야함
}




// 등수ㅊㅔ크!!!
// studentlist 랑 sum 값 비교한담에 내림차순 순위 설정
// 반복문쓰기

// sum 값에 있는 애들을 비교해서 순위를 매길건데... 어케하죠...
// 출력된 값을 등수에 넣는건 또... 





// 4트

let 등수확인 = []
let tmp = 0;
let sum = studentlist[i].kor + studentlist[i].eng + studentlist[i].mat

등수확인.push( sum );

for(i = 0; i < 등수확인[i].length-1; i++){	// 등수확인 인덱스 0부터니까 3까지일때 0 1 2
	
	for(j = 1; j < 등수확인[j].length; j++){
		if(등수확인[i] > 등수확인[j]){
			let tmp = 등수확인[j]
			등수확인[j] = 등수확인[j]
			등수확인[j] = tmp			
		}
	}	
}









/*
// 3트

let 등수매기기 = []
let tem = 0
let sum = studentlist[i].kor + studentlist[i].eng + studentlist[i].mat

등수매기기.push( sum ); // sum 값을 배열에 추가

	for(i = 0; i < 등수매기기.length-1; i++){
		for(j = 0; j < 등수매기기.length-1-i; j++){
			if(등수매기기[j] < 등수매기기[j+1]){
				let tmp = 등수매기기[j]
				등수매기기[j] = 등수매기기[j+1]
				등수매기기[j+1] = tmp
			} 
		}
	} 
	
	
*/





/*

2트

let 등수매기기 = []
let temp = 0

등수매기기.push( sum ); // sum 값을 배열에 추가

	for(i = 0; i < 등수매기기.length-1; i++){
		for(j = i+1; j < 등수매기기.length; j++){
			if(i < j){
				let tmp = 등수매기기[i]
				등수매기기[i] = 등수매기기[j]
				등수매기기[j] = tmp
			}
		}
	}



1트

let temp = 0 	// 임시 교환 변수!!! 여기다 값 넣어 놓고 새로운 값과 계속 비교할거다!!
function 등수매기기( i ){	// [매개변수 i : 비교할 식별번호(배열내 저장된 순서번호=인덱스)]
	for( let i = 0; i < studentlist.length; i++ ){
		// 인덱스는 0부터 시작하니까 0부터,, 마지막 인덱스 길이까지,,,
		// 값을 계속 비교해서 순위를 바꿔야 하잔ㄴ나....어케하는데....
		if( i > sum[i] ){
			temp = i
			
		}
	}학생출력()	// 값을 비교해주고 html에 최신화 시켜야하기 때문에 호출함더하자!
}


*/






















