package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		int port = 8888;
		ServerSocket socketServer = new ServerSocket(port);

		while (true) {
			Socket sock = socketServer.accept();
			System.out.println("ip : " + sock.getInetAddress() + "와 연결 되었습니다.");
//			메세지 받는 쓰레드 실행
			ReceiveThread reciveThread = new ReceiveThread(sock);
			reciveThread.start();

			SendThead sendThead = new SendThead(sock);
			sendThead.start();

		}
	}

}
