

let datalist = null; // 전역 변수로 사용하기위해 선언

getdata()

/* --- 공공데이터 API 호출 ---- */
function getdata(){
	
	$.ajax({
	url: "/JSPWEB/board/api",
	success: function(re) {
			let json = JSON.parse(re);	// 공공데이터 전체 데이터
			datalist = json.data;		// 가져온 전체 데이터 객체 중 data 속성 [ 키, 값 ] 만 호출
			dataprint();				// 검색이 없을 때 모든 약국 호출
		}
	})
} // getdata e


// 2. 검색 버튼을 눌렀을 때 메소드
function addrsearch(){
	
	let addr = document.querySelector('.addrinput').value;
	dataprint( addr ); 	// 검색이 있을 경우 검색어 전달
	
} // addrsearch e


// 3. html에 약국 리스트 출력 메소드
function dataprint( search ){	// search : 검색어
	// console.log( search );
	// console.log( "타입확인 : "+typeof(search) );
		// 1. undefined 2. "undefined" 3. nill 타입확인 : 셋중 어떤 것인지
	
	if( search !== undefined ){	// 검색이 있을 경우
		let searchlist = [];
		for( let i = 0; i < datalist.length; i++ ){
			let addr = datalist[i].주소;
			console.log(addr);
			
			if( addr.indexOf(search) !== -1 ){ // 입력한 검색어가 포함되어 있으면 : indexOf에서 -1은 없는 것 
				searchlist.push( datalist[i] ) // 리스트 추가
			}
		} // for e
		datalist = searchlist; // 약국리스트를 검색된 약국 리스트로 대입
		
		if( search == '' ){	// 키워드 값이 없고 검색 시 초기화
			getdata();	
		} // if e
		
	} // if e

	
	let html = '<tr>'
		+ '<th> 약국명 </th> <th> 전화번호 </th> <th> 주소 </th>'	
		+ '</tr>';
	
	for( let i = 0; i < datalist.length; i++ ){	// 약국 리스트 중 1개씩 호출	
		let data = datalist[i]	// i번째 약국 임시 변수

		html += '<tr onclick="mapview('+ i +')">' // 해당 행 클릭 시 map 메소드 실행 [ 클릭한 인덱스를 매개변수로 전달 ]
			+ '<td>'+ data.약국명 +'</td> <td>'+ data.대표전화 +'</td> <td>'+ data.주소 +'</td>'
			+ '</tr>';
	}
	document.querySelector('.data1').innerHTML = html;
	
	
} // dataprint e



// 카카오 지도 생성 메소드
function mapview( i ){	// i값을 매개변수로 받음
	
	/* --- 카카오 지도 API ---- */
	// 2. 지도 옵션
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨 [ 숫자가 적을수록 확대 1이 최대 확대 ]
	    };
	
	// 3. 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 4. 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 5. 주소로 좌표를 검색합니다 [ 클릭한 i번째 약국의 주소 ]
	geocoder.addressSearch( datalist[i].주소 , function(result, status) {
	    
	    // 정상적으로 검색이 완료됐으면 
	    if (status === kakao.maps.services.Status.OK) {
			console.log(result[0].y, result[0].x);
	        
	        // 주소로 검색된 좌표 생성 객체
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	 	       
	     	// 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,				// 해당 마커를 표시할 map 객체
	            position: coords		// 마커의 좌표 대입
	        });   
	        
	        
	        // 마커에 클릭이벤트 등록
			kakao.maps.event.addListener(marker, 'click', function() {
			      detailview( i ); // 약국 상세 div 출력
			});
	        
	        
	        // 인포윈도우 : 마커의 설명 [ 말풍선 ] 달기
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ datalist[i].약국명 +'</div>'
	        });
	        infowindow.open(map, marker);
	        
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
      		map.setCenter(coords);
		     
	/* ---- 카카오 지도 API ---- */
		        
	     } 
	}) 
} // mapview e


function detailview( i ){
	
	let html = '<div>'+ datalist[i].약국명 +'</div>'
			+ '<div>'+ datalist[i].주소 +'</div>'
			+ '<div>'+ datalist[i].대표전화 +'</div>'
			+ '<div><button> 평점주기 </button></div>'
			+ '<div><button> 문의하기 </button></div>'
			
	document.querySelector('.detailbox').innerHTML = html;
	
} // detailview e



getdata2();
// csv 를 사용한 db 사용
function getdata2(){
	
	$.ajax({
	url: "/JSPWEB/board/api2",
	success: function(re) {
		let json = JSON.parse(re)
		console.log(json)

			let html = '';
			
			html = '<tr>'
				+ '<th> 시군구 </th>'
				+ '<th> 번지 / 본번 / 부번 </th>'
				+ ''
				+ '<th> 전용면적 </th>'
				+ '<th> 계약년월 </th>'
				+ '<th> 계약일 </th>'
				+ '<th> 계약금액(만원) </th>'
				+ '<th> 층 </th>'
				+ '<th> 건축년도 </th>'
				+ '<th> 도로명 </th>'
				+ '<th> 해제사유발생일 </th>'
				+ '<th> 거래유형 </th>'
				+ '<th> 중개사소재지 </th>'
			+ '</tr>'
			
			
			for( let i = 0; i < json.length; i++ ){
				html = '<tr>'
						+ '<td>' + json[i].시군구 +'</td>'
						+ '<td>' + json[i].번지본번부번 +'</td>'
						+ '<td>' + json[i].단지명 +'</td>'
						+ '<td>' + json[i].전용면적 +'</td>'
						+ '<td>' + json[i].계약년월 +'</td>'
						+ '<td>' + json[i].계약일 +'</td>'
						+ '<td>' + json[i].거래금액 +'</td>'
						+ '<td>' + json[i].층 +'</td>'
						+ '<td>' + json[i].건축년도 +'</td>'
						+ '<td>' + json[i].도로명 +'</td>'
						+ '<td>' + json[i].해제사유발생일 +'</td>'
						+ '<td>' + json[i].거래유형 +'</td>'
						+ '<td>' + json[i].중개사소재지 +'</td>'
						+ '</tr>';
			document.querySelector('.data2').innerHTML += html;
			}	
			

		}
		
		
	})
}





