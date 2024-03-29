package cha19;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Ex02Lambdatest {
	public static void main(String[] args) {
		Map<String, User2> user = UserGet.getUser();
		
		// 문제 2. (출력 방법 1)
		Map<String, User2> timeuser = UserGet.search2(user, i -> i.getIn()>=5 && i.getIn()<=9);
		UserGet.printTime(timeuser);
		
		// 문제 2. (출력 방법 2. 디폴트 메소드 활용)
		Predicate<User2> p1 = i -> i.getIn()>=5;
		Predicate<User2> p2 = i -> i.getIn()<=9;			
		timeuser = UserGet.search2(user, p1.and(p2));
		// timeuser = UserGet.search2(user, i -> i.getIn()>=5.and(i.getIn()<=9));
		/// 디폴트 메소드 사용 시 식을 직접 입력하면 안되고 식이 저장되어있는 인스턴스를 사용해야만하는지 
		UserGet.printTime(timeuser);
				
		
	}

}
class UserGet {
	private static Map<String, User2> user= new HashMap<>();
	
	static {
		UserGet.add("admin", new User2("admin", 1));
		UserGet.add("test1", new User2("test1", 6));
		UserGet.add("test2", new User2("test2", 8));
		UserGet.add("test3", new User2("test3", 3));
		UserGet.add("test4", new User2("test4", 9));
	}
	
	public static Map<String, User2> getUser() {
		return user;
	}
	
	public static void add(String name, User2 in) {
		user.put(name, in);
	}
	public static Map<String, User2> search2(Map<String, User2>users, Predicate<User2> c) {
		Map<String, User2> condUsers = new HashMap<>();
		
		for (Map.Entry<String, User2> entry : users.entrySet()) {
			if (c.test(entry.getValue())) {
				condUsers.put(entry.getKey(), entry.getValue());
			}
		}	
		return condUsers;
	}
	public static void printTime(Map<String, User2> users) {
		for (Map.Entry<String, User2> entry : users.entrySet()) {
			System.out.println("이름 + 출입시간 : " + entry.getValue());
			// getValue인데 키값과 value값이 모두 출력되는 이유? =value값만 출력되고 있음 value값이 User 타입인데 key값의 내용과 User의 id인스턴스변수의 내용이 똑같아서 key값과 value값이 일치하게 출력되는 것 처럼 보였던 것
	
		}
	}
}

@FunctionalInterface
interface Time {
	public abstract boolean intime(User user);
}
	
class User2 {
	private String name;
	private int in;	
	public User2(String name, int in) {
		this.name = name;
		this.in = in;
	}
	public String getName() {
		return name;
	}
	public int getIn() {
		return in;
	}

	@Override
	public String toString() {
		return "name=" + name + ", in time=" + in;
	}

}
/*
문제 1. → Ex02Lamda.java에 풀이
회원에 레벨 속성을 추가하고 레벨이 2이상인 회원만 출력하는 코드를 람다식을 사용하여 코딩하세요.

문제 2.
차량 출입 시간이 5시에서 9시 사이인 차량만 출력하는 프로그램을 코딩하세요.
위 회원 검색 프로그램과 같이 함수형 인터페이스를 작성하고 람다식을 사용해야 합니다.  
*/