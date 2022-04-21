package Ex16_6;

import java.net.*;
import java.io.*;
	
//	클래스 설명 : 한번 실행하고 결과 확인 후 종료
public class TcpIpClient {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
//			서버쪽 주소(ip주소 + 7777)를 세팅해서 소켓생성
			Socket socket = new Socket(serverIp, 7777);
//			네트웍 패킷 정보를 받는 부분
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
//			readUTF : 실제 네트웍으로 들어온 메시지를 읽는메소드 (문자열) 
			System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");

			dis.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
