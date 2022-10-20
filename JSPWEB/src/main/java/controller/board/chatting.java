package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;				// 웹 소켓에 관한 내용 다 임포트해 오겠다 *[와일드카드]

// @WebServlet("/chatting")				// 서블릿 URL 만들기
@ServerEndpoint("/chatting/{mid}")		// 웹 서버에 웹 소켓 URL 만들기 -> /URL/{ 변수명 }

public class chatting {
	// arraylist vs vector [ 비동기화 동기화 차이 ]
	
	// 서버 소켓에 접속한 클라이언트 소켓 명단 ( 세션 ) vector --> hashtable 변경한 이유 [ 2개씩 저장하기 위해 ] 벡터는 1개만 저장 가능
	public static Hashtable< Session, String > clients = new Hashtable<>();
					// 키[set=중복불가], 값 -> 엔트리 [ 모든 키 호출 : clients.keySet() , 값 호출 : clients.get(키) ]
	
	
	@OnOpen	// 서버 소켓에 들어왔을 때 [ Session = 클라이언트 소캣 = 접속된 유저 ]
	public void onOpen( Session session , @PathParam("mid") String mid ) throws IOException {	// @PathParam(경로상의 변수명) : 경로상의 변수 호출
		
		clients.put( session, mid );		// 접속된 클라이언트 소켓을 저장
		// System.out.println( session );	// session은 접속마다 자동할당 = 식별 불가
		
		// 접속 시 다른 사람에게 알림
		for( Session s : clients.keySet() ){ // map에 저장된 모든 key[ 접속된 모든 클라이언트 소켓 세션 ] 호출 [ .keySet() ]
			s.getBasicRemote().sendText( clients.get(s) + " 님이 접속했습니다");
										// map.get(키) --> 값 호출 [ mid 호출 ]
		}
	}
	
	@OnClose // 서버 소켓에 나갔을 때 [ 서버 소캣이 재부팅, 시작 등] 꺼지거나 클라이언트 소캣이 닫기 요청 시
	public void onClosse( Session session ) {
		// 1. 종료된 세션을 접속 명단에서 제거
		clients.remove(session); // map객체명.remove(key) : 해당 key의 엔트리 삭제
		
	}
	
	@OnMessage // 서버 소켓에 메세지가 왔을 때
	public void onMessage( Session session , String msg ) throws IOException {
		
		for( Session s : clients.keySet() ) { // 서버 소켓이 받은 메세지를 접속된 클라이언트 소켓을 하나씩 호출 함
			s.getBasicRemote().sendText(msg);
		}// for e
		
	}

	
			
}
