package cha18;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
public class Ex07Dequetest {
	public static void main(String[] args) {
		Alarmmanager alarm = new Alarmmanager();
		alarm.addLDAlarm(new Alarm(1, "첫 번째 알람"));
		alarm.addLDAlarm(new Alarm(2, "두 번째 알람"));
		alarm.addLDAlarm(new Alarm(3, "세 번째 알람"));
		alarm.addLDAlarm(new Alarm(4, "네 번째 알람"));
		
		System.out.println("=== 알람 등록 ===");
		alarm.viewAlarm(); // List에 인덱스 0에 저장된 내용 출력
		alarm.addDAlarm(); // List에 인덱스 0에 저장된 내용을 Stack타입으로 저장 및 인덱스 ++
		alarm.viewAlarm(); // List에 인덱스 1에 저장된 내용 출력
		alarm.addDAlarm(); // List에 인덱스 1에 저장된 내용을 Stack타입으로 저장 및 인덱스 ++
		alarm.viewAlarm(); // List에 인덱스 2에 저장된 내용 출력
		alarm.addDAlarm(); // List에 인덱스 2에 저장된 내용을 Deque에 Stack타입으로 저장 및 인덱스 ++
		alarm.viewAlarm(); // List에 인덱스 3에 저장된 내용 출력
		alarm.addDAlarm(); // List에 인덱스 3에 저장된 내용을 Deque에 Stack타입으로 저장 및 인덱스 ++
		
		System.out.println("=== 알람 삭제 ===");
		alarm.previewAlarm(); // Dequq에 Stack타입에 저장된 내용 중 가장 최근에 저장된 내용(index(3))을 추출 후 삭제
		alarm.previewAlarm();
		alarm.previewAlarm();
		alarm.previewAlarm();
		
			
	
	}
}
class Alarm{
	int clock;
	String title;
	
	public Alarm(int clock, String title) {
		this.clock = clock;
		this.title = title;				
	}
	@Override
	public String toString() {
		return "등록 순서" + clock + " - " + title;
	}
}
class Alarmmanager{
	private Deque<Alarm> manageD = new ArrayDeque<>();
	private List<Alarm> manageL = new LinkedList<>();
	int see;
	
	public void addLDAlarm(Alarm alarm) {
		manageL.add(alarm);
	}
	public void addDAlarm() {
		manageD.push(manageL.get(see++));
	}
	void viewAlarm() {
		System.out.println(manageL.get(see));
	}
	void previewAlarm() {
		System.out.println(manageD.pop());
	}
	
}
/* 
문제 1.
스마트폰의 알림기능은 마지막 알림부터 확인할 수 있습니다.
알림 등록, 확인, 확인 시 제거 기능을 구현하세요.
*/