 /**
 
 	p. 226
 		* 타이머함수 : 콜백함수 [내장함수]
 		setTimeout( 함수, 시간[밀리초] ) : 시간이후에 한번 함수 실행
 		setInterval( 함수, 시간[밀리초] ) : 매시간마다 함수 실행
 
 */ 
 
 
 const li_floor = [ ]
 let rooftop = Number(prompt('최고 층수'))
 // let x = Number(prompt('목표 층수'))
 let y = Number(prompt('출발 층수'))
 let z = Number(prompt('EV 현재 위치'))
 
document.getElementById('ev_display').innerHTML = `현재 엘레베이터의 위치는 ${z}층 입니다.`



// 1. 엘레베이터 층 배열 생성
function input_floor( rooftop ){
	for(let i = 1 ; i<=rooftop ; i++ ){
		if(i>0){li_floor.push(i)} // if end
	}//for end
}

// 2. up, down 버튼 생성
function up_f(){
	z++
	ev_img()
	console.log(z)
	if(z>rooftop){
		alert('최고 층수 입니다.')
		return
	}document.getElementById('ev_display').innerHTML = `현재 엘레베이터의 위치는 ${z}층 입니다.` ;
}

function down_f(){
	z--
	ev_img()
	console.log(z)
	if(z<1){
		alert('최저 층수 입니다.')
		return
	}document.getElementById('ev_display').innerHTML = `현재 엘레베이터의 위치는 ${z}층 입니다.`  ;
}


//3. 엘레베이터 호출

function call_ev(){
			if(y<z){
			let stop = setInterval( ()=> { 
					let count = 0
					down_f() 
					count++
					if(count == z-y+1){
						clearInterval(stop)
						
						alert('엘레베이터에 탑승해주세요.')
					}
					
					}, 1*1000)
			}else if(y>z){
			let stop = setInterval( ()=> { 
					let count = 0
					up_f() 
					count++
					if(count == y-z+1){
						clearInterval(stop)
						
						alert('엘레베이터에 탑승해주세요.')
					}
					
					}, 1*1000) 
			}
			
}

//4. 엘레베이터 탑승 후 버튼 출력


let btn_board = ''
function make_btn(){
		for(let i = rooftop ; i >= 1 ; i--){
			if(z!=y){
				alert('엘레베이터를 호출해 주세요.')
				return}
			btn_board += `<button id="${i}" onclick="start_ev(${i})">${i}</button>`
			if(i%2==1){
				btn_board+= '<br>'
			}
		}
		alert('목표층을 입력해 주세요.')
		document.getElementById('select_floor').innerHTML = btn_board
}
//5 ev출발



// ev img 

function ev_img(){
	let floorimg = ''
	for(let i = rooftop ; i>=1 ; i--){
		if(i!=z){
			floorimg += `<div class="box_${i}">${i}</div>`
		}else if(i==z){
			floorimg += `<div class="box_${i}" style='border: solid 3px red;'>${i}</div>`
		}
				
	}
	document.getElementById('ev_img').innerHTML = floorimg
}


function start_ev( i ){
			if(i<z){
			let stop = setInterval( ()=> {
					let count = 0
					down_f() 
					count++
					if(count == z-i+1){
						clearInterval(stop)
						
						alert('목적지에 도착했습니다.')
					}
					
					}, 1*1000) 
			}else if(i>z){
			let stop = setInterval( ()=> { 
					let count = 0
					up_f() 
					count++
					if(count == i-z+1){
						clearInterval(stop)
						
						alert('목적지에 도착했습니다.')
					}
					
					}, 1*1000) 
			}
}





/*
function start_ev(i){
			if(i<z){
			let stop = setInterval( ()=> { 
					let count = 0
					down_f() 
					count++
					if(count == z-i+1){
						clearInterval(stop)
						
						alert('목적지 도착')
					}
					
					}, 1*1000) 
			}else if(i>z){
			let stop = setInterval( ()=> { 
					let count = 0
					up_f() 
					count++
					if(count == i-z+1){
						clearInterval(stop)
						
						alert('목적지 도착')
					}
					
					}, 1*1000) 
			}
			
}

*/


/*
function call_ev(){
				
				if(y>z){
					let stop = setInterval( ()=> { 
						let count = 0
						down_f() 
						count++
						if(count == z-y+1){
							clearInterval(stop)
						}
						
						}, 1*1000)
				}
				else if(y<z){
					let stop = setInterval( ()=> { 
						let count = 0
						down_u() 
						count++
						if(count == y-z){
							clearInterval(stop)
						}
						
						}, 1*1000)
					
					
					
				}
}
*/

/*
function call_ev(y, z){
	let count = 0
	if(y>z){
		setInterval(
			()=> {	up_f
					count ++
					if(count==(y-z)){
						clearInterval(intervalId)
			
					}
				}, 1*1000)
			}
}
	
	
*/


/*
function call_ev(y ,z){
	if(y>z){
		for(let i = z ; i<=y ; i++ ){
			up_f()
		}document.getElementById('ev_display').innerHTML = `엘레베이터가 ${y}층에 도착했습니다.`
	}else if(y<z){
		for(let i = z ; i>=y ; i--){
			down_f()
		}document.getElementById('ev_display').innerHTML = `엘레베이터가 ${y}층에 도착했습니다.`
	}else if(y==z){
		document.getElementById('ev_display').innerHTML = `엘레베이터가 도착했습니다.`
	}	
}

*/
