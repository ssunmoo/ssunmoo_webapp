
/* ---- 회원정보 호출 ---- */

getmember();

function getmember(){

	$.ajax({
		url : "/JSPWEB/member/info" ,
		success : function( result ) {
	
			// HTTP 스트림[바이트단위] json 형식의 문자타입을 json 타입으로 형변환
			//alert ( member.maddress )
						// 객체.속성
			let member = JSON.parse( result )
			document.querySelector("#mno").innerHTML = member.mno
			document.querySelector("#mid").innerHTML = member.mid
			document.querySelector("#mdate").innerHTML = member.mdate
			document.querySelector("#mpoint").innerHTML = member.mpoint
			
			document.querySelector("#mname").value = member.mname
			document.querySelector("#mphone").value = member.mphone
			document.querySelector("#memail").value = member.memail
			
			document.querySelector("#sample4_postcode").value = member.maddress.split(",")[0]
			document.querySelector("#sample4_roadAddress").value = member.maddress.split(",")[1]
			document.querySelector("#sample4_jibunAddress").value = member.maddress.split(",")[2]
			document.querySelector("#sample4_detailAddress").value = member.maddress.split(",")[3]
			
			
		
			// getmemberlist(); // 모든 회원 호출 메소드 
		}
	});
} // getmember 메소드 종료

/* ---- 모든 회원 호출 ---- */
function getmemberlist(){
	
	$.ajax({
		url : "/JSPWEB/member/infolist",
		success : function( result ){
			//alert("나와라!!!!")
			let memberlist = JSON.parse( result );
			// console.log( memberlist );
			// 1. tag 가져오기
			
			let table = document.querySelector("#memberlisttable")
			//alert(table);
			
			// 2. 테이블 HTML에 넣을 문자열 삽입 [ 제목 부분 ]
			let tag = '<tr>'
					+ '<th> 회원번호 </th>'
					+ '<th> 아이디 </th>'
					+ '<th> 이름 </th>'
					+ '<th> 전화번호 </th>'
					+ '<th> 이메일 </th>'
					+ '<th> 주소 </th>'
					+ '<th> 가입날자 </th>'
					+ '<th> 포인트 </th>'
					+ '</tr>';
			
			// 3. tag에 값 넣기
			for ( let i = 0; i < memberlist.length; i++ ){
				// 4. 해당 인덱스의 객체 호출
				// memberlist의 i 번째를 가져와서 
				let m = memberlist[i];
				
				// 5. 해당 객체의 정보를 html에 저장
				tag += '<tr>'
					+ '<td> '+ m.mno +' </td>'
					+ '<td> '+ m.mid +' </td>'
					+ '<td> '+ m.mname +' </td>'
					+ '<td> '+ m.mphone +' </td>'
					+ '<td> '+ m.memail +' </td>'
					+ '<td> '+ m.maddress +' </td>'
					+ '<td> '+ m.mdate +' </td>'
					+ '<td> '+ m.mpoint +' </td>'
					+ '</tr>';
			} // for 종료
			
			// 6. innerHTML로 table 에 전송
			table.innerHTML = tag;
		}
	});

} // getmemberlist 메소드 종료


/* ---- 회원 탈퇴 ---- */

function viewdelete(){
	
	// 1. tag 가져오기
	let deletebox = document.querySelector("#deletebox")
	
	// 2. tag에 넣을 html 구성
	let tag = '<span> ! 정말 탈퇴하시겠습니까? </span><br>'
			+ '<input type="password" id = "mpw">'
			+ '<button onclick="mdelete()"> 확인 </button>';
			
	// 3. tag에 html 넣기
	deletebox.innerHTML = tag;
	
} // viewdelete 메소드 종료

function mdelete(){
	// 1. tag에 입력된 비밀번호 가져오기
	let mpw = document.querySelector("#mpw").value;
	
	// 2. ajax 를 이용한 회원 탈퇴처리
	$.ajax({
		url : "/JSPWEB/member/delete",
		data : { "mpw" : mpw } ,
		success : function( result ){
			alert( result );
			if( result === 'true'){
				alert('탈퇴성공');
				location.href ='/JSPWEB/member/logout.jsp';
			}
			else{
				alert(mpw)
				alert('동일하지 않은 비밀번호 입니다.');
			}
		}
	});
} // mdeldte 메소드 종료


let buttons = document.querySelectorAll("button")
// 현재 페이지의 모든 버튼 출력

function update_action(){
	let mname = document.querySelector("#mname");
	// 입력한 데이터를 가지고옴
	
	if( buttons[1].innerHTML === "확인" ){
	// 버튼이 확인일 경우 클릭하면 수정을 전송하는 아래 코드 실행!

		$.ajax({
			url : "/JSPWEB/member/update",
			data : { "mname" : mname.value },
			success : function( re ){
				if( re == "true" ){
					alert("수정 성공")
				}
				else{
					alert("수정 실패")
				}
			}
		})
		buttons[1].innerHTML = "수정"
		mname.readOnly = true;	// 버튼 누르면 수정할 수 있도록 열어줌
		location.reload;	// 새로고침
	}
	else{
		alert("수정 완료 후 확인 버튼 클릭 시 수정이 완료됩니다");
		mname.readOnly = false;	// 수정못하게 닫기
		buttons[1].innerHTML = "확인"
	}
	
}










