package cha18;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
public class Ex05ConcurrentLinkedQueue {
	public static void main(String[] args) {
		Thread printService = new Thread(new PrintService()); //쓰레드는 여러 기능을 동시에 할 수 있게 하는 기능 (멀티쓰레드)
		// ★ 쓰레드를 생성하기 위해선 Thread생성자에 Runnable 인터페이스를 구현하고 있는 인스턴스가 아규먼트로 와야한다.	
		printService.start(); // 쓰레드를 시작하는 메소드 start
		// ★ 아규먼트로 생성한 인스턴스의 오버라이딩한 run부분이 동작
		
		// 위에 printSetvice 쓰레드는 오버라이딩한 run메소드에서 돌아가고 있고, 아래는 main쓰레드가 따로 돌아간다
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("프린트할 내용을 입력하세요: ");
			Printer.print(new Paper(s.nextLine()));
		}
	}
}

class Printer {	
	public static void print(Paper p) {
		PrintService.q.offer(p);
	}	
}

class PrintService implements Runnable {
	//public static Queue<Paper> q = new LinkedList<>();	// 쓰레드로 인한 오류 발생
	public static Queue<Paper> q = new ConcurrentLinkedQueue<>();
		// LinkedList는 멀티쓰레드환경에서 불안정하다 ConcurrentLinkedQueue는 멀티쓰레드로부터 안전하다
	// ★★ Concurrent가 붙을경우 멀티쓰레드로부터 안전하다는 뜻
	
	@Override
	public void run() {
		while (true) {
			System.out.println("\n프린트 대기 중입니다...");
			try {
				while (!q.isEmpty()) { // isEmpty 메소드는 호출자에 저장된 데이터가 없을 경우 false를 return한다.
					Paper p = q.poll();
					System.out.println("\n프린트 중입니다...\n---");
					Thread.sleep(3000);
					System.out.println(p.getContents());
					System.out.println("프린트가 완료되었습니다!!!");
				}
				Thread.sleep(3000); //3초간 쓰레드를 정지시키는 코드
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Paper {
	private String contents;
	public Paper(String contents) {
		this.contents = contents;
	}
	public String getContents() {
		return contents;
	}
}
