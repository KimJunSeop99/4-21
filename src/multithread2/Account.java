package multithread2;

public class Account {
//	통장 잔액 1000원
	int balance = 1000;

//	 통장에서 돈 인출하기 메소드
//	lock 설정 : synchronized 예약어 설정(크리티컬 섹션 알고리즘)
	public synchronized void withDraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("에러가 발생했습니다");
			}
			balance = balance - money;

		}
	}

}
