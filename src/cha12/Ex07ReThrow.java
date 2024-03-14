package cha12;
import java.util.Scanner;
public class Ex07ReThrow {
	public static void main(String[] args) {
		while (true) {
			User3 user = null;
			
			user = LoginService3.form();
			
			try {
				LoginService3.login(user);
				
			} catch (IDMismatchException3 e) {
				System.out.println("문의사항은 000-1234-5678 로 연락주세요.\n");
				
			} catch (PasswordMismatchException3 e) {
				System.out.println("문의사항은 000-1234-5678 로 연락주세요.\n");
			}
			
			if (user.isLogin()) {
				LoginService3.success(user);
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

class LoginService3 {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User3 user) throws IDMismatchException3, PasswordMismatchException3 {
		// try catch 문과 throws문이 같이 적용되어 있을 경우엔 try catch문이 우선권이 있다
		// 즉, 해당 메소드 내에서 try catch를 통해 1차적으로 오류를 처리한 후 catch문에서 throw를 통해 이슈를 재발생 시키게 되면, throws된 catch문에서 2차적으로 오류를 처리한다. 이를 rethrow라 한다.

/* rethrow 사용 이유 : 내가 LoginService3 클래스만 제작했다면, 오류 발생 시 해당 메소드 내에 try catch문을 통해 내가 1차적으로 오류를 처리한 후
   throw 키워드를 통해 다시 throws로 넘겨주어, 해당 메소드는 호출한 코드를 제작한 사람이 try catch문을 통해 2차적으로 오류를 처리하게 한다. */

		
		try {
			if (!DB_ID.equals(user.getId())) {
				throw new IDMismatchException3("잘못된 아이디를 입력하였습니다.");
				// 해당 오류 발생 시 메소드 내에 있는 catch IDMismatchException3로 넘어간다. 
				
			} else if (!DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException3("잘못된 패스워드를 입력하였습니다.");
				
			} else {
				user.setLogin(true);
			}
		} catch (IDMismatchException3 e) {
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
			throw e;
			// 발생한 e 오류를 throw를 통해 재발생 시키고 있다.
			// 재발생한 e 는 throws된 catch IDMismatchException3로 넘어간다.
			
		} catch (PasswordMismatchException3 e) {
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
			throw e;
			
		} finally {
			increaseCount();
		}
	}
	
	public static User3 form() {
		Scanner scanner = new Scanner(System.in);
		User3 user = new User3();
		
		System.out.println("- 로그인 화면 -");
		System.out.print("아이디를 입력하세요: ");
		user.setId(scanner.nextLine());
		System.out.print("패스워드를 입력하세요: ");
		user.setPassword(scanner.nextLine());
		
		return user;
	}
	
	public static void success(User3 user) {
		System.out.println(user.getId() + " 님 환영합니다.\n");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("로그인 시도 " + count + "회");
	}
}

class User3 {
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

class IDMismatchException3 extends Exception {
	public IDMismatchException3(String message) {
		super(message);
	}
}

class PasswordMismatchException3 extends Exception {
	public PasswordMismatchException3(String message) {
		super(message);
	}
}
