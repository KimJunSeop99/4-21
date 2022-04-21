package multithread2;

public class BankTest {

	public static void main(String[] args) {
		DongSungBank r = new DongSungBank(); // 월드은행생성

		Thread t1 = new Thread(r); //
		Thread t2 = new Thread(r); //

		t1.start();
		t2.start();

	}

}
