
getpactive1();
function getpactive1(){
	
	$.ajax({
	url: "/JSPWEB/admin/regist",
	data: { "type" : 1, "option" : "pactive1" },
	success : function ( re ) {
		let json = JSON.parse( re );
		let html = '';
		json.forEach( list => {

				html += '<div class="item">'
					+ '<a href="#">'
					+ '<img alt="" src="/JSPWEB/admin/pimg/'+list.pimg+'" style= "width:100%">'	
					+ '</a>'
					+ '<div class="item_info">'
					+ '<div class="item_title">'	
					+ list.pname
					+ '</div>' 
					+ '<div class="item_size"> 4/4 사이즈 </div>'	
					+ '<div class="item_price">' + list.pprice.toLocaleString('ko-KR') +'원</div>'	
					+ '<div class="item_dc_box">'	
					+ '<span class="item_discount">'+ list.pdiscount*100 +'% </span>'	
					+ '<span class="item_sals">'+(list.pprice*(1-list.pdiscount)).toLocaleString('ko-KR')+'원</span>'	
					+ '</div>'	
					+ '<div class="item_review"> 찜수 218 리뷰 수 412 </div>'	
					+ '<div>'	
					+ '<span class="badge rounded-pill text-bg-warning"> 당일배송 </span>'		
					+ '<span class="badge rounded-pill text-bg-danger"> 주문폭주 </span>'		
					+ '</div>'	
					+ '</div>'  
					+ '</div>'
		})
		document.querySelector('.itemlist').innerHTML += html;
		
		
		}
	})

} // getpactive1 e

	

