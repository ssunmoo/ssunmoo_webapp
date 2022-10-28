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

import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.json.simple.JSONObject;

import javax.websocket.*;				// 웹 소켓에 관한 내용 다 임포트해 오겠다 *[와일드카드]

// @WebServlet("/chatting")				// 서블릿 URL 만들기
@ServerEndpoint("/chatting/{mid}")		// 웹 서버에 웹 소켓 URL 만들기 -> /URL/{ 변수명 }

public class chatting {
	// arraylist vs vector [ 비동기화 동기화 차이 ]
	
	// 서버 소켓에 접속한 클라이언트 소켓 명단 ( 세션 ) vector --> hashtable 변경한 이유 [ 2개씩 저장하기 위해 ] 벡터는 1개만 저장 가능
	// 0. 접속 명단
	public static Hashtable< Session, String > clients = new Hashtable<>(); // 동기화[웨이팅] 지원 클래스
					// 키[set=중복불가], 값 -> 엔트리 [ 모든 키 호출 : clients.keySet() , 값 호출 : clients.get(키) ]
	
	// * 접속 알람 메세지 구성
	public JSONObject jsonAlarm( String content ) throws IOException {
		
		JSONObject object = new JSONObject();
		object.put("type", "alarm");
		object.put("content", content);
		return object;
		
	} // sendAlarm e

	// ** 알람 메세지 전송
	public void sendmsg( JSONObject object ) throws IOException {
		
		// 현재 접속한 모든 세션에게 메세지 전송
		for( Session s : clients.keySet() ) {
			s.getBasicRemote().sendText( object.toString() );
		}
		
	} // sendmsg e
	
	// 1. 입장
	@OnOpen	// 서버 소켓에 들어왔을 때 [ Session = 클라이언트 소캣 = 접속된 유저 ]
	public void onOpen( Session session , @PathParam("mid") String mid ) throws IOException {	// @PathParam(경로상의 변수명) : 경로상의 변수 호출
		
		clients.put( session, mid ); // 접속된 클라이언트 소켓을 저장
		sendmsg( jsonAlarm( mid + " 님이 들어오셨습니다." ) );

	} // onOpen e
	
	// 2. 퇴장
	@OnClose // 서버 소켓에 나갔을 때 [ 서버 소캣이 재부팅, 시작 등] 꺼지거나 클라이언트 소캣이 닫기 요청 시
	public void onClosse( Session session ) throws IOException {
		
		JSONObject object = jsonAlarm( clients.get(session)+ " 님이 퇴장하셨습니다.");
		clients.remove(session); // **서버 소켓에서 해당 세션 지우기
			
	} // onClosse e
	
	// 3. 메세지 받기
	@OnMessage // 서버 소켓에 메세지가 왔을 때
	public void onMessage( Session session , String msg ) throws IOException {
		
		for( Session s : clients.keySet() ) { // 서버 소켓이 받은 메세지를 접속된 클라이언트 소켓을 하나씩 호출 함
			s.getBasicRemote().sendText(msg);
		}// for e
		
	} // onMessage e

	
			
}
