
 
 
 
 // 1. html 요소 가져오기
 const input = document.querySelector('#todo')				// html에 id값을 todo로 지정해준 요소 가져오기
 const addbutton = document.querySelector('#add_button')	// html에 id값을 add_button로 지정해준 요소 가져오기
 const todolist = document.querySelector('#todo_list')		// html에 id값을 todo_list로 지정해준 요소 가져오기
 
 
 /* ---- 추가영역 ---- */
 
 // 2. 값을 추가 및 조작할 수 있는 코드 생성
  
  let keycount = 0	// 2-1. 새로 등록하는 내용을 저장할 변수 생성
  
 	// 2-3. 입력된 값이 있는지 확인하는 변수
 const addtodo = () => { 			// addtodo 라는 이름의 변수를 익명함수로 생성(addtodo를 호출했을때 아래 함수가 실행 됨)
	if (input.value.trim() === ''){	// input 변수에 들어있는 value 값에서 trim으로 양쪽 공백을 삭제했을때 값과 ''(공백)이 같다면 = 입력 값이 없다면
									// * trim : 문자열의 시작과 끝에 있는 공백을 삭제하는 함수
	
	alert('할 일을 입력해주세요.')		// 시스템 팝업 메세지로 '할 일을 입력해주세요.' 출력
	return							// alert를 출력했다면 새로운 값을 입력할 수 있도록 함수 종료 
	}
 
	// 2-2. 값을 추가할 경우 html이 새로 생성될 수 있도록 저장변수 만들기
	 const item = document.createElement('div')				// html에 있는 div에 item 변수에 들어가는 값을 생성해주겠다
	 const checkbox = document.createElement('input')		// html에 있는 input에 checkbox 변수에 들어가는 값을 생성해주겠다
	 const text = document.createElement('span')			// html에 있는 span에 text 변수에 들어가는 값을 생성해주겠다
	 const button = document.createElement('button')		// html에 있는 button에 button 변수에 들어가는 값을 생성해주겠다
	
	 const key = keycount	// 새로 등록하는 내용이 담긴 변수를 key 변수에 넣겠다
	 keycount += 1			// keycount의 값이 추가될때마다 1씩 누적 증가한다


	 // 2-4. appendChild 상위문서객체에 하위문서객체를 생성해주겠다
	 // 여기서 item은 div를 말함 왜냐하면 const item = document.createElement('div') 으로 선언했기 때문
	 item.setAttribute( 'data-key', key )	
	 	// div 안에 data-key라는 이름을 가진 key 변수를 추가한다
	 item.appendChild( checkbox )
	 	// div 안에 input을 추가한다
	 	// const checkbox = document.createElement('input') 으로 변수를 생성해줬기 때문에 checkbox는 input이다
	 item.appendChild( text )
	 	// div 안에 span을 추가한다
	 	// const text = document.createElement('span') 으로 변수를 생성해줬기 때문에 text는 span이다
	 item.appendChild( button )
	 	// div 안에 button을 추가한다
	 	// const button = document.createElement('button') 으로 변수를 생성해줬기 때문에 button은 button이다
	 todolist.appendChild( item )
	 	// todolist html 내 id 값이 todo_list인 div에 item(div)를 생성하겠다
	 	// const todolist = document.querySelector('#todo_list')로 변수를 생성해줬기 떄문에 todolist는 html에있는 id가 todo_list인 div
	 
	 
	 // 2-4. 취소선 이벤트 추가
	 checkbox.type = 'checkbox'								// input type = "checkbox"와 같은 요소를 만들겠다
	 checkbox.addEventListener( 'change', ( event ) => {	// 체크박스에 이벤트를 생성하겠다
	 												  		// 값이 바뀔경우(change) 이벤트를 출력하겠다
		
		item.style.textDecoration	// 아이템에 스타일 리스트를 추가해주겠다
			= event.target.checked ? 'line-through' : ''	
	})	// item에 텍스트 스타일을 추가해줄건데 체크박스 이벤트를 클릭했을때
		// ?는 조건이 true이면 line-through(취소선)을 추가한다
		// :는 조건이 false이면 ''(공백)을 넣는다
		
	 text.textContent = input.value	// text 객체(span을 생성해주는 변수명)를 실행해서 input(입력창)을 생성해주겠다
	 
	 // 2-5. 제거하기 버튼 및 기능 추가
	 button.textContent = '제거하기'	// button 객체(button을 생성해주는 변수명)를 실행해서 버튼에 제거하기 텍스트를 넣겠다
	 button.addEventListener( 'click', ( ) => {	// 제거하기 boutton을 클릭하는 이벤트를 실행할 경우
		removeTodo(key)							// key 값을 삭제하도록 만들어둔 함수를 실행하겠다	
	})
	 
	 input.value = ''	//	input(입력창) 내용 초기화 
 }
 

/* ---- 제거영역 ---- */ 
 
 const removeTodo = (key) => {		// removetodo를 실행할 경우 key 저장된 값을 삭제하는 함수를 실행하겠다
	const item = document.querySelector(`[data-key = "${key}"]`)	// html에 있는 item(div)값을  
	todolist.removeChild(item)	// todolist(div)안에 생성되어있는 item(div)를 삭제하겠다
 }									// 부모속성				  // 자식속성
 
 
 addbutton.addEventListener( 'click', addtodo )	// addbuton(html에있는 id 값이 add_button인 추가하기 버튼)을
 												// 클릭할 경우 addtodo 함수 실행(2-3에 등록한 입력된 값이 있는지 확인하는 함수)
 	input.addEventListener( 'keyup', ( event ) => { // 인풋박스에(html에 있는 id 값이 todo인 input) 키업 이벤트가 발생하면
		const ENTER = 13					// (13은 엔터키의 코드네임) 엔터키를 눌렀을때 이벤트를 변수명으로 
		if( event.keyCode === ENTER ){		// 엔터 이벤트가 발생할 경우
			addtodo()						// addtodo 함수 실행(입력한 값이 있는지 확인하는 함수)
		}									
 })
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 