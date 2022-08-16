/*

	매개변수(인수) : 함수 안으로 들어오는 수[변수/메모리]
	가변 매개변수 함수 : 매개 변수가 정해져있지 않는 경우 
		- 나머지 매개변수 문법 사용
		- function 함수명(... 나머지 매개변수){ }
		- 매개변수가 배열로 들어온다. 
	
	전개 연산자 : 함수를 호출할 때 매개 변수의 개수가 정확하지 않을때
		- 함수명(데이터, 데이터)
		- 함수명(...데이터)
		- 
 */
 
 //	1. 가변 매개변수 함수 선언
 
 function sample( ...items){
	console.log( items )
}

 // 2. 함수 호출[ 인수 3개 전달 ]
sample(1, 2, 3)

 // 2. 함수 호출 [ 인수 4개 전달]
 sample(1, 2, 3, 4)
 
 // 2. 함수 호출 [ 인수 7개 전달]
 sample(1, 2, 3, 4, 'java', true, '안녕하세요')
 

 
 // 1. 가변 매개변수 / 일반매개변수 조합 함수[p.208]
 function sample2(a, b, ...c){
	console.log(a, b, c)
}

sample2(1, 2)
sample2(1, 2, 3)
sample2(1, 2, 3, 4)
sample2(1)


 // 1. 전개 연산자 ---> 가변 매개변수에 넣는 것 [p.211]
 
 function sample3(...items){
	console.log(items)
}

 // 2. 함수호출
 const array = [1, 2, 3, 4]
 console.log("# 전개 연산자를 사용하지 않는 경우")
 sample3(array)
 
 console.log("# 전개 연산자를 사용한 경우")
 sample3(...array)
 

















