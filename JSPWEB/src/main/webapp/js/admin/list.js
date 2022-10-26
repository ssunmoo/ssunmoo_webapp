
getproduct()
function getproduct(){
	$.ajax({
		url : "/JSPWEB/admin/regist",
		type : "get",
		success : function( re ){
			let json = JSON.parse( re );
			console.log(json)
			/* let img = '/JSPWEB/admin/pimg/'*/
			let html = '';
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
		}
		
	})
}