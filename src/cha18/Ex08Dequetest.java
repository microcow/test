package cha18;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class Ex08Dequetest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		Manager test = new Manager();
		while (true) {
			System.out.println("저장할 메시지를 입력하세요 : ");
			Message ms = new Message(s.nextLine());
			if (ms.message.equals("quit")) {
				test.addMessage(ms);
				break;
			}
			else test.addMessage(ms);
		}
		System.out.println("===가장 오래된 메시지===");
		test.firstMessage2();
		System.out.println("===최근 입력된 메시지===");
		test.lastMessage();
		System.out.println("===최근 입력된 메시지 3개===");
		test.printLastThreeMessage();
		
		
	}
}

class Message{
String message;

Message(String message) {
	this.message = message;
	}
@Override
public String toString() {
	return message;
}
}

class Manager {
	public static Deque<Message> q = new ArrayDeque<>();
	
	public void addMessage (Message message) {
		q.add(message);
	}
	/* public Deque<Message> firstMessage() {
		return (Deque<Message>)q.peek();
	}*/ /// retrun타입으로 Collection이 오려면 retrun되는 인스턴스에도 제네릭스타입을 적어야하는건가
	public void firstMessage2() {
		System.out.println(q.peekFirst());
	}
	public void lastMessage() {
		System.out.println(q.peekLast());
	}
	public void printLastThreeMessage() {
		System.out.println(q.pollLast());
		System.out.println(q.pollLast());
		System.out.println(q.pollLast());
		// poll 메소드는 값을 추출 후 retrun한 뒤 그 값을 삭제함
	}
}
/*
문제 1.
반복문을 이용해 사용자가 입력한 메세지들을 저장하세요. 
마지막으로 입력한 메세지 세개만 화면에 출력되도록 코딩하세요.
quit가 입력되면 반복문은 종료되어야 합니다.
*/