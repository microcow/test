package cha18;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class Ex04Queue {
	public static void main(String[] args) {
		
		// ★ Queue란 선입 선출을 의미한다 (fifo). (!= 스택)
		// 먼저 들어온 데이터를 먼저 처리해야할 경우 사용한다.
		
		
		
		QueueTicketDispenser.takeNum();
		QueueTicketDispenser.takeNum();
		QueueTicketDispenser.takeNum();
		QueueTicketDispenser.takeNum();
		QueueTicketDispenser.takeNum();
		
		System.out.println("첫 번째 손님은 " + Restaurant.firstGuest() + "번 손님입니다.");
		System.out.println();
		
		Restaurant.printQueue();
				
		while (Restaurant.q.size() > 0) {
			Restaurant.serving();
		}
		System.out.println();
		
		Restaurant.printQueue();
	}
}

class QueueTicketDispenser {
	private static int num = 1;
	
	public static int takeNum() {
		Restaurant.q.offer(num);
		// ★★ Queue 인터페이스는 offer메소드를 활용해 저장 (List, Set의 add 메소드와 동일)
		return num++;
	}
}

class Restaurant {
	public static Queue<Integer> q = new LinkedList<>(); // 업캐스팅
	// LinkedList 클래스는 Queue 인터페이스를 구현하고 있다.
	
	
	public static void serving() {
		int num = q.poll();
		// ★★ Queue 인터페이스의 poll메소드는 저장되어있는 값 중 가장 처음 입력된 값을 추출한 후 그 값을 삭제하는 메소드이다.
		System.out.println(num + "번 손님에게 서빙되었습니다.");
	}
	
	public static void printQueue() {
		System.out.println("대기열\n-----");
		for (Iterator<Integer> it = q.iterator(); it.hasNext(); ) {
			int num = it.next();
			
			System.out.println(num + "번 손님");
		}
		System.out.println();
	}
	
	public static int firstGuest() {
		return q.peek();
		// ★ Queue 인터페이스의 peek메소드는 제일 먼저 추출될 데이터(가장 먼저 입력된 값)가 무엇인지 확인하는 메소드이다.
	}
}
