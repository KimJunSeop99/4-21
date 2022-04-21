package multithread;

public class WorldBank implements Runnable {
	@Override
	public void run() {
//		잔액이 > 0 동안 반복
		while(acc.balance > 0) {
			int money = 100;
			acc.withDraw(money);
//			현재 잔액 출력
			System.out.println("잔액(" + Thread.currentThread().getName() + ") : " + acc.balance);
		}
	}

	Account acc = new Account(); // 통장
	
	
}
