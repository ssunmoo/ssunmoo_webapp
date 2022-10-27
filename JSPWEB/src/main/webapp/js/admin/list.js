
getproduct()
function getproduct(){
	$.ajax({
		url 	: "/JSPWEB/admin/regist",
		type 	: "get",	// 해당 서블릿의 doGet 으로 통신
		success : function( re ){
			let json = JSON.parse( re );
			console.log(json)
			/* let img = '/JSPWEB/admin/pimg/'*/
			let html = '';
			json.forEach( list => {
				
				html += '<tr>'
					+ '<td><img alt="" src="/JSPWEB/admin/pimg/'+list.pimg+'" style= "width:100%"></td>'
					+ '<td>'+ list.pno +'</td>'
					+ '<td>'+ list.pcno +'</td>'
					+ '<td>'+ list.pname +'</td>'
					+ '<td>'+ list.pprice +'</td>'
					+ '<td>'+ list.pdiscount +'</td>'
					+ '<td>'+ list.pprice*(1-list.pdiscount) +'</td>'
					+ '<td>'+ list.pactive +'</td>'
					+ '<td>'+ list.pdate +'</td>'
					+ '<td> <button type="button"> 수정 </button> '
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


// 2. 수정 메소드

// 3. 삭제 메소드
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






