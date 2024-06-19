package Ch1;

	// 인터페이스
interface userService {
	 void createUser();
	}

	//인터페이스 구현 클래스
class userService2 implements userService {
	 @Override
	 public void createUser() {
	     System.out.println("User created in userService2");
	 }
}

	//사용 예시
class Main {
	 public static void main(String[] args) {
	     userService service = new userService2();
	     service.createUser();  // 이 호출은 userService2 클래스의 createUser 메소드를 실행함
	 }
}


