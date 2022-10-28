
// 1. 모든 제품 호출 메소드
getproduct()
function getproduct(){
	$.ajax({
		url 	: "/JSPWEB/admin/regist",
		data	: { "type" : 1 , "option" : "all" },	// 타입이 1이면 모든 제품 전체 출력  
		type 	: "get",			// 해당 서블릿의 doGet 으로 통신
		success : function( re ){
			let json = JSON.parse( re );
			/* let img = '/JSPWEB/admin/pimg/'*/
			let html = '';
			json.forEach( list => {
				
				html += '<tr>'
					+ '<td><img alt="" src="/JSPWEB/admin/pimg/'+list.pimg+'" style= "width:100%"></td>'
					+ '<td>'+ list.pno +'</td>'
					+ '<td>'+ list.pcno +'</td>'
					+ '<td>'+ list.pname +'</td>'
					+ '<td>'+ list.pprice.toLocaleString('ko-KR') +'원</td>'
					+ '<td>'+ list.pdiscount*100 +'%</td>'
					+ '<td>'+ (list.pprice*(1-list.pdiscount)).toLocaleString('ko-KR') +'원</td>'
					+ '<td>'+ list.pactive +'</td>'
					+ '<td>'+ list.pdate +'</td>'
					+ '<td> <button type="button" onclick="updatemodal('+list.pno+')"> 수정 </button> '
					+ '<button type="button" onclick="deleteproduct('+list.pno+')"> 삭제 </button></td>'
					+ '</tr>'
			})
			document.querySelector('.table').innerHTML += html;
			
			/*
			for( let i = 0; i < json.length; i++){
				let list = json[i];
				html += '<tr>'
					+ '<td><img alt="" src="/JSPWEB/admin/pimg/'+list.pimg+'"></td>'
					+ '<td>'+ list.pno +'</td>'
					+ '<td>'+ list.pcno +'</td>'
					+ '<td>'+ list.pname +'</td>'
					+ '<td>'+ list.pprice +'</td>'
					+ '<td>'+ list.pdiscount +'</td>'
					+ '<td>'+ list.pprice*(1-list.pdiscount) +'</td>'
					+ '<td>'+ list.pactive +'</td>'
					+ '<td>'+ list.pdate +'</td>'
					+ '</tr>'
			}
			document.querySelector('.table').innerHTML += html;
			*/
		}
	})
} // getproduct e


// 2-1. 제품 수정 모달 메소드
function updatemodal( pno ){
	// 실제 부트스트랩 모달 버튼은 디스플레이 논으로 숨겨놓고 내가 만든 버튼을 누르면 모달이 켜지도록 작동하는 것
	
	// 1. 해당 모달을 열어주는 버튼에 강제 클릭 이벤트 실행
	document.querySelector('.updatemodalbtn').click() // 해당 버튼을 클릭하는 이벤트를 강제로 넣기
	
	// 2. 해당 모달에 기존 내용 출력
		// 2-1. 해당 pno의 제품 정보 호출
	$.ajax({
		url		: "/JSPWEB/admin/regist",
		data	: { "type" : 2 , "pno" : pno },	// 타입이 2면 개별 제품 호출
		type 	: "get",
		success : function( re ){
			let json = JSON.parse( re );
			// 인풋 박스 내 value 값에 출력하기
			document.querySelector('.pno').value = json.pno;
			document.querySelector('.pname').value = json.pname;
			document.querySelector('.pcomment').value = json.pcomment;
			document.querySelector('.pprice').value = json.pprice;
			document.querySelector('.pdiscount').value = json.pdiscount;
			document.querySelector('.pcpactivebox').value = json.pactive;
			
			$.ajax({	// 서버랑 연결
				url : "/JSPWEB/board/pcategory",
				type : "get",
				success : function( re ){		// 성공 시 스트림 언어로 받아오기
					let json2 = JSON.parse(re);	// 스트림 언어를 제이슨 언어로 변환 
					
					let html = '';
					for( let i = 0; i < json2.length; i++ ){
						
						let categroy = json2[i];	// json 객체의 i 번째에 있는 정보를 담기
						
						if( categroy.pcno == json.pcno){ // 선택한 카테고리 번호와 불러온 카테고리 번호가 같을 경우
							// 라디오 버튼에 checked 넣고 출력하기
							html += '<input type="radio" name="pcno" value="'+ categroy.pcno +'" checked>' + categroy.pcname;
						}else{
							// checked 없이 출력하기
							html += '<input type="radio" name="pcno" value="'+ categroy.pcno +'">' + categroy.pcname;
							
						}
					}
				document.querySelector('.pcategoryaddbox').innerHTML = html
				}
			})	
		}
	})
} // updatemodalt e

// 2-2. 제품 수정 처리 메소드
function updateproduct(){
	
	// 1. 수정할 정보 정보 가져오기
	let form = document.querySelector('.updateform')
	let formdata = new FormData( form );
			
	// 속성추가
	// formdata 속성 추가 : formdata.set('속성명' : 데이터 )
	
	$.ajax({
		url		: "/JSPWEB/admin/regist",
		type 	: "put",
		data	: formdata,
		processData : false,
		contentType : false,
		success : function( re ){
			if( re == 'true' ){
				alert('수정 완료')
				
				// 1. 모달 닫기
				document.querySelector('.modalclosebtn').click() // 해당 버튼을 클릭하는 이벤트를 강제로 넣기
				// 2. 새로고침
				pagechage('list.jsp');
				
			}else{
				alert('수정 실패')
			}
		}
	})
} // updateproduct e


// 3. 제품 삭제 메소드
function deleteproduct( pno ){
	
	if( confirm('정말 삭제하시겠습니까?')){	// 확인 버튼을 눌렀을 때
	
		$.ajax({
			url		: "/JSPWEB/admin/regist", // 톰캣 서버의 기본 설정값은 get, post 방식만 data 속성 사용 함
			data	: { "pno" : pno },
			// 서버 프로젝트 폴더 클릭 -> server.xml ->
			// 원본 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
			// 수정 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="GET,POST,PUT,DELETE"/>
			type 	: "delete",	// 해당 서블릿의 doDelete 으로 통신
			success : function( re ){
				if( re == 'true'){
					alert('삭제 성공');
					pagechage('list.jsp');
					// dachboard.jsp 내 포함되어있기 때문에 호출 가능
					// 현재 구조 상 대쉬보드.jsp 내 특정태그에 list.jsp 가 포함되어있기 때문
				}
				else{
					alert('삭제 실패')
				}
			}
		})
	}
} // deleteproduct e







