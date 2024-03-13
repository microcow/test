package cha12;
import java.util.Scanner;
public class Ex05Throw {
	public static void main(String[] args) {
		IDMismatchException test = new IDMismatchException("sd");
		test.getMessage();
		
		while (true) {
			User user = null;
			
			user = LoginService.form(); //return 타입이 User클래스라 가능
			LoginService.login(user);
			
			if (user.isLogin()) {
				//user.isLogin() 이 boolean 타입인데 if + boolean타입은 boolean타입이 참일 경우로 해석된다.
				LoginService.success(user);
				break;
			}
			
			System.out.println("로그인에 실패하였습니다.\n");
		}
		
		System.out.println("1. 회원정보");
		System.out.println("2. 커뮤니티");
		System.out.println("3. 쇼핑");
		System.out.println("4. 로그아웃");
		
		
	}
	
	
}

class LoginService {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User user) {
		try {
			if (!DB_ID.equals(user.getId())) {
				throw new IDMismatchException("잘못된 아이디를 입력하였습니다.");
				// DB_ID와user.getId()가 일치하지 않으면 throw 문이 실행된다.
				/* throw가 IDMismatchException이라는 클래스의 예외를 발생시켰다.(java에서 만든 Exception이 아님)
				 	즉, 원래라면 try문에서 오류가 발생할 경우 catch문에서 Exception클래스 등으로 예외를 받아야하지만
				 	throw는 if문 등을 통해 오류가 발생할 경우 throw문이 예외를 받아, 따로 만든 예외 클래스를 발생시킨다 (단, 해당 클래스가 Exception 클래스를 상속받고 있어야한다.)*/ 
				
//★ throw 메커니즘 : ①오류 발생(오류객체가 생성됨) → ②thorw가 오류를 받은 후 해당 예외클래스(java가 아닌 직접 만든 예외클래스) 생성자 호출(호출 가능한 생성자가 반드시 있어야함) → ③ catch블럭에서 해당 오류객체를 받은 후 실행(catch블럭에 해당 예외클래스가 구현되어 있을 경우에만) 
				 
				
				/// new를 입력하는 이유? → 예외 객체를 생성하고 클래스 생성자 호출을 위해서
				/// catch문에서는 오류를 받을 때 인스턴스 개념으로 받지만 throw는 인스턴스 생성개념? → yes. 인스턴스를 생성은 하지만(메모리는 있지만) 형체는 없음
				/// catch에서도 인스턴스 생성 개념이라면 생성자를 호출하지 않는가 → no. catch는 인스턴스 생성이 아닌 throw에서 생성한 인스턴스를 받은 후 그걸 형체화 함
				/// Exception타입의 인스턴스로 받는 개념이라면 그 인스턴스는 생성하지 않고 받는 즉시 생성되는것? → 오류 발생 시 인스턴스 속성들이 메모리에 올라가고(인스턴스생성) catch는 그 메모리(인스턴스)를 형체화시킴  
				/// throw가 발생시킨 오류를 catch가 안받아도 되는지 → 1.8버전에선 안받으면 안되는듯 (현재 버전은 가능)
				
				
			} else if (!DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException("잘못된 패스워드를 입력하였습니다.");
				
			} else {
				user.setLogin(true);
			}
		} catch (IDMismatchException e) {
			System.out.println(e.getMessage());
			/// getMessage? (java.lang.Throwable 소속) → Exception을 상속받은 클래스에서 super(스트링)을 통해 Exception 생성자를 호출하면서 넘겨준 스트링을 출력해주는 메소드인듯 
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
			/* 위에서 throw문이 예외를 받아 IDMismatchException 클래스로 넘겼다면,
			 IDMismatchException의 실행 가능한 생성자가 있을 경우 생성자의 내용을 실행시키고
			 해당 catch가 예외를 받게된다. */
			
		} catch (PasswordMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
			
		} catch (Exception e) {
			System.out.println("시스템 장애");
			
		} finally {
			increaseCount();
			// User.increaseCount(); → 다른 클래스의 동일 이름 메소드를 호출하고 싶으면 앞에 호출하고자 하는 메소드의 클래스를 붙이자 
		}
	}
	
	public static User form() { // 관련없는 다른 클래스의 인스턴스로 return할 수도 있음.
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		
		System.out.println("- 로그인 화면 -");
		System.out.print("아이디를 입력하세요: ");
		user.setId(scanner.nextLine());
		System.out.print("패스워드를 입력하세요: ");
		user.setPassword(scanner.nextLine());
		
		return user;
		// return 타입이 User클래스 이기에 User클래스의 인스턴스를 return
	}
	
	public static void success(User user) {
		System.out.println(user.getId() + " 님 환영합니다.");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("로그인 시도 " + count + "회");
	}
}

class User {
	private String id;
	private String password;
	private boolean login;
		//boolean 타입의 변수에 아무 값도 저장되어있지 않다면 기본 값은 false이다
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public static void increaseCount() {
		System.out.println("테스트 메소드");
	}
	
}

class IDMismatchException extends Exception {
	public IDMismatchException(String message) {// 생성자	 
		super(message); 
		// 예외가 발생했을 때 예외 메시지를 파라미터로 받고 받은 파라미터를 Exception의 생성자에게도 넘겨주면 된다.
		
		/// super()이 의미하는 것? : 부모클래스의 생성자 호출(부모클래스이기에 this가 아닌 super사용)(ch7 Ex10) 
		/// super에 massage 넘겨주는 이유? : 받은 메시지를 getMessage 메소드로 출력할 수 있게 하기 위해.(받은 메시지내용을 private로 된 인스턴스에 저장한 후 getMessage 메소드로 호출하게 만들어 주는듯)
	}
}

class PasswordMismatchException extends Exception {
	public PasswordMismatchException(String message) {
		super(message);
	}

}
