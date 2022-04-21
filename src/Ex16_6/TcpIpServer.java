package Ex16_6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		클라이언트로 부터 응답대기
//		무한루프 : 데몬 형태(계속 실행 대기 프로세스)
		while (true) {
			try {
				System.out.println(getTime() + "연결요청을 기다립니다.");
//				클라이언트로부터 소켓을(ip, port)연결
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");
//				Output : 메세지 전송을 위한부분
//				네트웍 패킷 전송을 위한 준비 단계
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
//				writeUTF : 네트웍 메세지를 전송 메소드(문자열 메세지)
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "데이터를 전송했습니다.");

				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}
