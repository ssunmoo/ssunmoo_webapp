/*

	[ 호출 ]
	객체명.textContent
	객체명.innerHTML
	객체명.value [input, option 입력상자 등 / div, span, p 등은 불가]



	[저장 = 대입 ]
	객체명.textContent = 값
	객체명.innerHTML = 값
	객체명.value = 값 		: 입력상자, 선택상자	value 값을 가지고 있는 애들만 사용가능!!!
	


*/

// 1. HTML 요소 가져오기
const input = document.querySelector('#inchbox')
const button = document.querySelector('#inchbtn')
const p = document.querySelector('#inchp')

// 2. 버튼을 눌렀을 때
button.addEventListener('click',()=> {
	
	const inch = Number( input.value )	// 문자를 숫자로 형변환
	// isNaN(데이터) : 숫자인지 아닌지 판단해줌 / 숫자가 아니면 true, 숫자이면 false
	if( isNaN( inch ) ){	// 입력 값이 숫자가 아니면
		p.textContent ='숫자를 입력해주세요'
		return				// 숫자가 아니면 끝남
	}
	// 입력한 값이 숫자이면

	const cm = inch * 2.54
	p.textContent = `${cm} cm`
})



/* p.341 */

const emailbox = document.querySelector('#emailbox')
const emailp = document.querySelector('#emailp')

// 이메일 검증 확인 함수 [익명함수]
const isemail = ( value ) => {
	return ( value.indexOf( '@' ) > 1 ) && ( value.split( '@' )[1].indexOf(".") > 1 )
			// 입력데이터의 @가 있는지 	이면서	입력데이터의 @ 뒤문자
			//									asdffs@naver.com
			//										   naver.com -> .가 있는지
}

/*
// [기본함수]
function 함수( value ){
	return ( value.indexOf( '@' ) > 1 ) && ( value.split( '@' )[1].indexOf(".") > 1 )
}
*/



// 이메일 입력상자에서 키보드를 입력할때마다 이벤트 발생
emailbox.addEventListener('keyup', ( event ) => {
	const value = event.currentTarget.value		// *currentTarget : 현재 이벤트중인 객체
	if( isemail( value ) ){
		p.style.color = 'green'
		p.textContent = `이메일 형식입니다. ${ value }`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다. ${ value }`
	}
	
})


/* 
	배열명.indexOf('검색어입력') : 배열내 해당 데이터의 인덱스 번호 찾기 
	문자열.indexOf('@') : 문자열내 @의 인덱스 번호 찾기
		만약 0보다 작으면 못찾았다는 뜻	
	문자열.split('기준문자') : 문자열 내 기준문자 기준으로 분리[자르기]
		예) 
			문자열 = 유재석/강호동/신동엽/하하
			문자열.split("/") -> / 기준으로 짜른다! : 유재석, 강호동, 신동엽, 하하 4개로 나뉨
			문자열.split("/")[0] : 유재석
			문자열.split("/")[3] : 하하
	
*/



// p.343
// 1. HTML 요소 가져오기
const selectbox = document.querySelector('#selectbox')
const selectp = document.querySelector('#selectp')

// 2. selectbox 의 데이터가 변경될때마다 실행되는 이벤트 [ change ]
selectbox.addEventListener( 'change', (event) => {
	
	// 옵션목록 = selectbox 의 모든 option 호출 [ select.객체.option ]
	const options = event.currentTarget.options
	
	// 선택한목록번호 = options 중에서 [사용자] 선택된 번호 호출
	const index = event.currentTarget.options.selectedIndex
	
	selectp.textContent = `선택 : ${options[index].textContent}`
								// 옵션목록 [선택한목록번호].텍스트 호출
})




// p.344

const selectbox2 = document.querySelector('#selectbox2')
const selectp2 = document.querySelector('#selectp2')

// selectbox2 의 데이터가 변경 이벤트 발생 
selectbox2.addEventListener('change', ( event ) => {
	
	// 옵션 목록 = selectbox2 모든 옵션을 호출
	const options = event.currentTarget.options
	const list = [ ]	// 선택된 옵션을 저장하는 배열 선언
	
	for( const option of options ){
		// 배열[옵션목록]중 하나씩 option 대입반복
		if( option.selected ){	// 만약에 해당 옵션에 selected 속성[선택생성자]이 있으면
			// 배열에 선택된 옵션의 텍스트를 추가
			list.push(option.textContent)
		}
	}
	
	selectp2.textContent = `선택 : ${list.join(',')}`
	// 배열명.join('연결문자')	: 배열내 모든 요소들을 연결문자 기준으로 하나의 문자열로 변환
		// 학생명 = ['유재석', 강호동, 신동엽]
		// 학생명.join('<->')
		// 출력 : 유재석<->강호동<->신동엽		
})



// p.345

let 현재값				// input에 입력된 데이터를 저장하는 변수
let 변환상수 = 10			// select에 선택된 단위별 값을 저장하는 변수

// 0. HTML 요소 가져오기
const cminput = document.querySelector('#cminput')
const cmspan = document.querySelector('#cmspan')
const cmselect = document.querySelector('#cmselect')


// 3. select 상자의 데이터를 변경했을때 이벤트
cmselect.addEventListener('change', ( event ) => {
	// 3-1. 목록 상자에서 모든 option 호출
	const options = event.currentTarget.options
	
	// 3-2. 목록상자[currentTarget]에서 선택된 인덱스 번호 호출
	const index = event.currentTarget.selectedIndex
	// 3-3. 목록상자에서 선택된 인덱스 번호의 value 값을 호출해서 변환상수에 대입
	변환상수 = Number( options[index].value )
								// value 값을 빼온다
	calculate() // 출력함수 실행
})


const calculate = () => {
	// 2. span에 계산된 결과물 출력 [toFixed(2) : 소수점 표시(소수점 개수) 2자리까지 보겠다]
	cmspan.textContent = ( 현재값 * 변환상수 ).toFixed(2)
}

// 1. input 에 입력할때마다 현재값 변수를 입력된 값으로 변환해주는 이벤트
cminput.addEventListener('keyup', ( event ) =>{
	// 2. input에 입력된 데이터(vlaue)를 숫자형으로 변환 후 현재 값 변수에 저장
	현재값 = Number( event.currentTarget.value )
	calculate()
})



// p.347

let timer = 0	// 타이머 시간(초)을 저장하는 변수
let timerId = 0	// 타이머 함수[setInterval]를 저장하는 변수

const timerinput = document.querySelector('#timerinput')
const timerh1 = document.querySelector('#timerh1')

// 1. 체크박스의 상태가 변경되었을때 
timerinput.addEventListener('change', ( event ) => {
	// 1-1. 체크박스가 checked 상태인지 확인
	if( event.currentTarget.checked ){	// 체크가 되어있는 상태
		timerId = setInterval( () => {
			timer += 1	// 타이머 시간 변수 1씩 증가
			timerh1.textContent = `${ timer }초`	// span 태그에 변수 출력
			
		}, 1000 )
	}else{	// 체크가 안되어있는 상태
		clearInterval( timerId )	// 타이머 함수 종료 [clearInterval(타이머객체)]
	}	// timer 라는 변수에 저장하는거라 clearInterval 써도 초기화안댐
})





/* p.349 */

/*
	js 선택자
	name => [ name = name명 ]	[복수]


	querySelector

*/

// 1. HTML 요소
const radios = document.querySelectorAll('[name=pet]')
const output = document.querySelector('#output')

// 2. radio [배열] 반복문
	// 배열명.forEach( ( 반복변수 ) => { })
		// 배열명 = [강아지, 고양이, 햄스터, 기타]
	
radios.forEach( ( radio ) => {
	radio.addEventListener('change', ( event ) => {
		const current = event.currentTarget
		if( current.checked ){
			output.textContent = `좋아하는 애완동물은 ${current.value} 이시군요!`
		}
	})
})




















