package cha19;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
public class Ex02Lambda {
	public static void main(String[] args) {
		Map<String, User> allUsers = UserService.getUserMap();
		Map<String, User> condUser = null;
		
		condUser = UserService.search(allUsers, new Criteria() {
			@Override
			public boolean where(User user) {
				return user.getAge() < 30;
			}
		});
		// Criteria인스턴스를 생성해 where 추상메소드를 생성한 후 익명클래스로 자신이 원하는 조건을 오버라이딩 해서 원하는 값을 얻고있다 (람다식 사용 전)
		
		UserService.printUsers(condUser);
		System.out.println();
		
		condUser = UserService.search(allUsers, u -> u.getAge() > 25); //c.where 호출 시점에 해당 람다식이 실행
		// 람다식 사용
		/// u 변수는 where의 User user에 대응하는 변수??
		/// search 호출 시 두번째 파라미터 타입은 Criteria인데 자동으로 Criteria()의 인스턴스 역할을 하는건가 (Criteria의 추상메소드를 람다식으로 표현하고 있으니?)
		UserService.printUsers(condUser);
		System.out.println("ss");
		
		condUser = UserService.search2(allUsers, u -> u.getAge() > 25);
		UserService.printUsers(condUser);
		System.out.println("dd");
		// search와 search2의 결과가 동일하지만 search는 람다식을 사용하기 위한 인터페이스를 직접 구현하여 사용하였고 search2는 이미 생성되어있던 인터페이스를 사용해 불필요한 인터페이스 생성을 하지 않았다
		
		condUser = UserService.search(allUsers, u -> u.getId().startsWith("test"));
		// startsWith 메소드는 호출자가 아규먼트의 문자열로 시작한다면 true를 return한다. (* cha14. Ex03)
		UserService.printUsers(condUser);
		System.out.println();
		
		// 문제 1.
		condUser = UserService.search(allUsers, u -> u.getLv() >= 2);
		UserService.printUsers(condUser);
		System.out.println();
	}

}

@FunctionalInterface
// 람다식을 받기위한 인터페이스는 @FunctionalInterface(어노테이션)이 작성되어 있어야한다.
interface Criteria {
	public abstract boolean where(User user);
	
	// Consumer<Integer> c = i -> System.out.println(i); 와 같은 식과 위 방식의 차이
	// 위 인터페이스는 람다식을 사용하기 위해 생성한 인터페이스이고 Consumer와 같은 펑셔널인터페이스는 java에서 미리 생성된 인터페이스이다.
	// 따라서, boolean 타입의 결과를 retrun받고 싶다면 Predicate 인터페이스를 사용 후 test메소드를 오버라이딩 해서 사용
}

class UserService {
	private static Map<String, User> userMap;
	
	static {
		userMap = new HashMap<>();
		UserService.add("admin", new User("admin", 27, 1));
		UserService.add("test1", new User("test1", 30, 2));
		UserService.add("test2", new User("test2", 22, 5));
		UserService.add("test3", new User("test3", 19, 1));
		UserService.add("test4", new User("test4", 35, 4));
	}
	
	public static Map<String, User> getUserMap() {
		return userMap;
	}
	
	public static void add(String id, User user) {
		userMap.put(id, user);
	}
	
	public static Map<String, User> search(Map<String, User>users, Criteria c) {
		Map<String, User> condUsers = new HashMap<>();
		
		for (Map.Entry<String, User> entry : users.entrySet()) {
			if (c.where(entry.getValue())) {
				condUsers.put(entry.getKey(), entry.getValue());
			}
		}	
		return condUsers;
		
		
	}
	public static Map<String, User> search2(Map<String, User>users, Predicate<User> c) {
		Map<String, User> condUsers = new HashMap<>();
		
		for (Map.Entry<String, User> entry : users.entrySet()) {
			if (c.test(entry.getValue())) {
				condUsers.put(entry.getKey(), entry.getValue());
			}
		}	
		return condUsers;
	}
	// 바로 위 search 메소드와 동일하지만 Predicate 인터페이스를 활용했다
	// java에 있는 Predicate인터페이스를 사용하면 위처럼 인터페이스를 새로 생성(Criteria)하여 추상메소드(where)를 생성하지 않고 사용할 수 있다. (코드 간결화)
	
	
	
	public static void printUsers(Map<String, User> users) {
		for (Map.Entry<String, User> entry : users.entrySet()) {
			System.out.println(entry.getValue());
			// getValue인데 키값과 value값이 모두 출력되는 이유? =value값만 출력되고 있음 value값이 User 타입인데 key값의 내용과 User의 id인스턴스변수의 내용이 똑같아서 key값과 value값이 일치하게 출력되는 것 처럼 보였던 것
	
		}
	}
}

class User {
	private String id;
	private int age;	
	private int lv;
	public User(String id, int age, int lv) {
		this.id = id;
		this.age = age;
		this.lv = lv;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public int getLv() {
		return lv;
	}
	@Override
	public String toString() {
		return "id=" + id + ", age=" + age + ", lv=" + lv;
	}

}
