package cha12;
import java.util.Scanner;
public class Ex08ChainedException {
	public static void main(String[] args) {
		while (true) {
			User4 user = null;
			
			user = LoginService4.form();
			
			try {
				LoginService4.login(user);
				
			} catch (LoginException e) {
				System.out.println("문의사항은 000-1234-5678 로 연락주세요.\n");
				e.printStackTrace();
				// rethrow된 오류는 해당 부분에서 받게되며, printStackTrace(); 코드를 통해 상세 내용 확인 가능
			}
			
			if (user.isLogin()) {
				LoginService4.success(user);
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

class LoginService4 {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User4 user) throws LoginException {
		try {
			if (!DB_ID.equals(user.getId())) {
				throw new IDMismatchException4("잘못된 아이디를 입력하였습니다.");
				// 해당 부분(상세 오류내용)이 오류 코드의 Caused by에 출력됨
				// 결국 던져지는건 rethrow를 통한 LoginException클래스 이기에 해당 예외 클래스는 throws될 필요 없음
				
			} else if (!DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException4("잘못된 패스워드를 입력하였습니다.");
				
			} else {
				user.setLogin(true);
			}
		} catch (IDMismatchException4 e) {
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
			throw new LoginException("로그인 예외가 발생하였습니다.", e); // 해당 부분이 오류의 코드의 큰 카테고리로 출력됨 (같은 카테고리의 다른 catch에서 문구 통일)
			// ★ throw로 e를 즉시 재발생 시켜 위의 catch문에 바로 던지는 것이 아닌, 문자열와 함께 e를 아규먼트로 LoginException 메소드를 재호출한 후 위의 catch 문에 던지고 있는 모습.( *cha12 Ex05 throw 메커니즘 참고)
			// LoginException은 호출된 부분에 throws로 던져야 하기에 해당 메소드의 throws에 LoginException클래스가 있어야한다.
			
		} catch (PasswordMismatchException4 e) {
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
			throw new LoginException("로그인 예외가 발생하였습니다.", e);
// ★ 사용 이유 : 오류가 발생하는 이유는 여러가지 일 수 있으나, 모두 묶어서 큰 카테고리로 오류를 출력할 때, 오류의 상세 내역을 확인하기위해 사용하는 것을 chainedException이라 한다.
	// 즉, id가 일치하지 않든 pw가 일치하지않든 모두 큰 카테고리인 "로그인 오류"로 출력되지만, 상세한 오류 원인을 파악하기 위해 오류가 발생하는 부분과 메시지를 오류코드에 넣어 출력한다
			
		} finally {
			increaseCount();
		}
	}
	
	public static User4 form() {
		Scanner scanner = new Scanner(System.in);
		User4 user = new User4();
		
		System.out.println("- 로그인 화면 -");
		System.out.print("아이디를 입력하세요: ");
		user.setId(scanner.nextLine());
		System.out.print("패스워드를 입력하세요: ");
		user.setPassword(scanner.nextLine());
		
		return user;
	}
	
	public static void success(User4 user) {
		System.out.println(user.getId() + " 님 환영합니다.\n");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("로그인 시도 " + count + "회");
	}
}

class User4 {
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

class LoginException extends Exception {
	public LoginException(String message, Exception e) {
		super(message, e); // 받은 메시지와 
		// ★★ 파라미터로 받은 메시지와 e를 super을 통해 넘겨줄 경우, catch에서 printStackTrace(); 키워드를 사용하면 발생한 에러의 Exception종류와 메시지를 오류 로그를 확인할 수 있다.
		// ★ 즉, 각기 다른 원인으로 발생한 로그인 관련 에러를 LoginException으로 rethrow해줄 경우 상단에 공통적인 키워드인 "로그인 예외가 발생하였습니다."가 출력되고 그 아래에 상세 에러 원인이 출력된다.
	}
}

class IDMismatchException4 extends Exception {
	public IDMismatchException4(String message) {
		super(message);
	}
}

class PasswordMismatchException4 extends Exception {
	public PasswordMismatchException4(String message) {
		super(message);
	}
}
