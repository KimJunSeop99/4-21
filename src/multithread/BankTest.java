package multithread;

public class BankTest {

	public static void main(String[] args) {
		WorldBank r = new WorldBank(); // 월드은행생성

		Thread t1 = new Thread(r); //
		Thread t2 = new Thread(r); //

		t1.start();
		t2.start();

	}

}
