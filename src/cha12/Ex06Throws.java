package cha12;
import java.util.Scanner;
public class Ex06Throws {
	public static void main(String[] args) {
		while (true) {
			User2 user = null;
			
			user = LoginService2.form();
			
			try { 
				LoginService2.login(user);
				//(①) 해당부분에서 login 메소드에 throws된 오류발생클래스들 예외처리
			} catch (IDMismatchException2 e) {
				System.out.println(e.getMessage());
				System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
				System.out.println("문의사항은 000-1234-5678 로 연락주세요.\n");
				
			} catch (PasswordMismatchException2 e) {
				System.out.println(e.getMessage());
				System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
				System.out.println("문의사항은 000-1234-5678 로 연락주세요.\n");
				
			} finally {
				LoginService2.increaseCount();
			}
			
			if (user.isLogin()) {
				LoginService2.success(user);
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

class LoginService2 {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User2 user) throws IDMismatchException2, PasswordMismatchException2 {
		// ★ 오류가 발생되는 예외를 메소드 옆에 throws와 함께 적는다면, 해당 예외는 try catch로 처리하지 않아도 된다.
		// ★ 단, 발생되는 예외는 해당 메소드를 호출한 부분(①)에서 try catch 처리해주어야 한다. (위 두 throws 클래스에 한해)
		// 즉, 위 두가지 예외클래스에 한해서는 오류를 메소드를 호출한 부분으로 처리하게 넘기겠다는 뜻
		// 만약 Exception 클래스도 throws 처리를 하고 싶다면 throws에 기입한 후 호출한 부분에서 처리해주면 된다.
		
// ★★ throws 사용 이유 : 실무에서 내가 해당 LoginService2라는 클래스만 제작하였다면, 오류 발생 시 그 오류는 throws되었기에 내가 여기서 그 오류를 try catch 처리하지 않아도 된다.(즉, 이 메소드를 호출한 코드가 있는 클래스를 제작한 사람에게 해당 오류를 try catch 처리하도록 떠넘기는 것)
// 반대로, throws를 사용하지 않고 try catch가 해당 메소드 내에 있었다면, 오류 발생 시 어떻게 처리될지도 내가 제작해야한다.
// ★ throws 메커니즘 : ① 메서드 내 오류 발생 → ② 발생된 오류 클래스를 해당 메소드가 throws 하고 있음 → ③ 해당 메소드를 호출한 곳이 try문 내에 있고 catch가 구현되어 있어야함 → ④ 오류를 해당 catch로 던짐
// ★ throws 조건 : ① 발생한 오류 클래스를 해당 메서드가 throws하고 있어야함 ② 해당 메소드를 호출한 곳이 try문 내에 존재해야함 ③ 호출한 곳에서 발생한 오류 클래스를 catch하고 있어야함
		
		if (!DB_ID.equals(user.getId())) {
			throw new IDMismatchException2("잘못된 아이디를 입력하였습니다.");
			// ★ 런타임, 컴파일에러가 발생하진 않으나 조건에 일치하지 않을 때 오류를 발생시키고 싶은 경우 throw를 사용
			
		} else if (!DB_PW.equals(user.getPassword())) {
			throw new PasswordMismatchException2("잘못된 패스워드를 입력하였습니다.");
			
		} else {
			user.setLogin(true);
		}
	}
	
	public static User2 form() {
		Scanner scanner = new Scanner(System.in);
		User2 user = new User2();
		
		System.out.println("- 로그인 화면 -");
		System.out.print("아이디를 입력하세요: ");
		user.setId(scanner.nextLine());
		System.out.print("패스워드를 입력하세요: ");
		user.setPassword(scanner.nextLine());
		
		return user;
	}
	
	public static void success(User2 user) {
		System.out.println(user.getId() + " 님 환영합니다.\n");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("로그인 시도 " + count + "회");
	}
}

class User2 {
	private String id;
	private String password;
	private boolean login;
	
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
	
}

class IDMismatchException2 extends Exception {
	public IDMismatchException2(String message) {
		super(message);
	}
}

class PasswordMismatchException2 extends Exception {
	public PasswordMismatchException2(String message) {
		super(message);
	}
}
