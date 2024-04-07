package cha20;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Settings(version=1.1, author={"A", "B"}) // 메타데이터
public class Ex01Annotation {
	
	// 어노테이션은 메타데이터를 설정할 수 있게 해준다
	// 클래스에 대한 정보를 메타데이터라 한다
	// 어노테이션은 리플렉션과 함께 자주 사용된다
	
	public static void main(String[] args) {
		System.out.println("< Annotation 값 얻어 오기 >");
		Settings settings = Ex01Annotation.class.getAnnotation(Settings.class);
		// 클래스명.class를 입력할 경우 해당 어노테이션의 메타데이터를 가지고있는 인스턴스를 return해준다
		// getAnnotation 메서드는 해당 클래스에 적용된 어노테이션을 가져올 수 있다
		// getAnnotation의 아규먼트로 어노테이션명.클래스명 입력 시 가져오고자 하는 어노테이션을 가져올 수 있다
		// Settings settings와 같이 어노테이션 명을 타입으로 사용할 수 있다.
		System.out.println(settings.version());
		// 어노테이션에 저장된 버전이 return된다.
		System.out.println(Arrays.toString(settings.author()));
		// 어노테이션에 저장된 author이 return된다.
		System.out.println();
		
		
		System.out.println("< @Repeatable >");
		Role[] arrRole = Car.class.getAnnotationsByType(Role.class);
		// getAnnotationsByType 메서드는 해당 클래스에 적용된 어노테이션(아규먼트)을 배열로 가져올 수 있다.
		for (Role role : arrRole) {
			System.out.println(role.value());
		}
		System.out.println();
		
		
		System.out.println("< @Inherited >");
		System.out.println(Arrays.toString(NewCar.class.getAnnotations()));
		// getAnnotations 메서드는 모든 어노테이션을 가져오는 메서드이다
		/* NewCar 클래스는 어노테이션이 업으나 상속받고있는 Car클래스에 적용되어있는 어노테이션 RULE과 RULES가 @Inherited 하고있기에 
		   Car에 적용되어있는 어노테이션이 상속되었으므로 NewCar에서 가져올 수 있다*/
		System.out.println();
				
		Scanner scanner = new Scanner(System.in);
		Map<String, Method> handlerMapping = new HashMap<>();
		
		for (Method method : Car.class.getDeclaredMethods()) {
			// Method 클래스는 java의 메서드 정보를 담는 메서드이다. (즉, 하나의 메서드 정보가 Method 클래스의 인스턴스가 된다) 
			// getDeclaredMethods 메서드로 Car클래스의 모든 메서드를 배열로 return한다. (메서드는 Method 클래스이며 각 메서드들의 정보묶음이 배열로 저장된다)
			/* 즉, getDeclaredMethods로 Car클래스의 모든 메서드를 배열로 가져온다음,
			 *  foreach문이기에 요소(메서드) 하나하나를 Method method에옮긴다 (Method 클래스의 요소(메서드)에는 각 메소드들의 정보가 담겨있다) */
			RequestMapping requestMapping = method.getAnnotation(RequestMapping.class); 
			/* forEach문으로 추출한 n번째 메서드에 적용된 RequestMapping 어노테이션을 requestMapping 인스턴스에 저장.
			   (n번째 메서드에 RequestMapping 어노테이션이 적용되어 있지 않다면 null이 저장)*/
			if (requestMapping != null)
				handlerMapping.put(requestMapping.value(), method);
			// n번째 메서드의 RequestMapping 어노테이션이 적용 중일 경우 어노테이션.value를 key값, 메서드를 value값으로 handlerMapping 저장
		}
		handlerMapping.forEach((k, v) -> System.out.println("command: " + k + ", method: " + v.getName()));
		// RequestMapping 어노테이션이 적용 중인 메서드만 저장된 handlerMapping 인스턴스의 내용(요소) 출력
		// Method 클래스의 getName메소드를 사용하면 해당 메서드의 이름을 return한다.
		System.out.println();
		
		while (true) {
			System.out.println("명령어를 입력하세요(engine, name, quit): ");
			String command = scanner.nextLine();
			try {
				if (handlerMapping.get(command) != null) {
					String returnStr = (String)handlerMapping.get(command).invoke(Car.class.newInstance());
					// 입력받은 문자열이 key값인 value가 존재할(null이 아닐)경우 해당 value(여기선 value에 메소드가 저장되어있음)를 실행(invoke)시키고 있다.
					// invoke의 return값이 String타입이지만, 리턴이 Object 클래스이기에 (String)으로 다운캐스팅을 해주는 모습
					/* invoke 메서드는 호출자가 Method클래스의 인스턴스(메서드정보)이므로, 해당 인스턴스 즉, 인스턴스에 저장되어 있는 메서드를 실행(호출)시키는 메서드이다.
					   아규먼트에는 클래스명.class.newInsteance() 를 입력하면된다.*/ 
					 
					System.out.println(returnStr);
				} else {
					System.out.println("잘못된 명령어를 입력하였습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// @Documented -> Javadoc
		// @Inherited	
	}

}

@Role("Manager") // = @Role(value = "Manager") value = 생략
@Role("User")
class Car {
	@SuppressWarnings("rawtypes") 
	private List tires = new ArrayList();
	
	@RequestMapping("name")  // = (value = "name")
	public String getName() {
		return "자동차의 이름은 소나타입니다.";
	}
	@RequestMapping("engine")
	public String runEngine() {
		return "엔진이 가동됩니다.";
	}
	@RequestMapping("quit")
	public String quit() {
		System.out.println("프로그램이 종료됩니다.");
		System.exit(0);
		return null;
	}
	
	@SuppressWarnings({"unchecked", "unused", "deprecation"})
	public void addTire(String tire) {
		tires.add(tire);					// unchecked
		String tireName = "Abc Tire";		// unused
		Date date = new Date();
		date.getYear();						// deprecation
	}
	@Deprecated
	public static void printVersion() {
		System.out.println("v1.0");
	}
	
}

class NewCar extends Car {
	@Override
	public String getName() {
		return "[New]" + super.getName();
	}
}

@Deprecated
class OldCar {
	
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface RequestMapping {	
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
// Retention 어노테이션은 생성한 어노테이션(Settings)을 어느 시점에 사용할지를 나타내는 어노테이션이다
@Target(ElementType.TYPE)
// Target 어노테이션은 생성한 어노테이션이 어디에 사용 가능한지(클래스 or 메서드 or 인스턴스 등)를 나타내는 어노테이션이다 (맨 아래 주석 참고)
@Documented
// Documented 어노테이션은 API에 생성한 어노테이션의 정보가 출력(문서화)되게 된다 (원래 어노테이션은 출력되지 않음)
@interface Settings {
// 어노테이션 만드는 방법
   String lang() default "kor";
   // default는 해당 인스턴스변수에 아무 값도 입력하지 않았을 경우의 기본값이다
   double version() default 1.0;
   String[] author();
}

@Inherited
@Repeatable(value = Roles.class)
// Repeatable 어노테이션은 생성 어노테이션을 여러번 반복해서 사용할 수 있게 한다
// 또한 ()내에 생성 어노테이션을 배열로 담을 수 있는 어노테이션을 적어주어야한다.
/// @Repeatable을 사용하면 어떤 방식으로 Role을 반복해서 사용할 수 있지
@Retention(RetentionPolicy.RUNTIME)
@interface Role {
	String value();
}

@Inherited
// Inherited는 상속이며, 해당 어노테이션이 적용된 클래스가 상속될 때 그 자식클래스에서도 해당 어노테이션이 사용가능하다 (즉, 해당 어노테이션도 함께 상속) (원래 불가)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Roles {
    Role[] value();
}

@Target(ElementType.FIELD)
@interface Autowired{
	String vlaue();
}

/*
 * <메타 어노테이션>
 * @Retention
 * 		RetentionPolicy.SOURCE
 * 		RetentionPolicy.CLASS
 * 		RetentionPolicy.RUNTIME
 *
 * @Target
 * 		ElementType.ANNOTATION_TYPE
 * 		ElementType.CONSTRUCTOR
 * 		ElementType.FIELD
 * 		ElementType.LOCAL_VARIABLE
 * 		ElementType.METHOD
 * 		ElementType.PACKAGE
 * 		ElementType.PARAMETER
 * 		ElementType.TYPE : TYPE은 클래스 레벨(이넘, 인터페이스, 클래스)에만 사용할 수 있도록 한다.
 * 
 * @Inherited
 * @Repeatable
 * @Documented
 */
/*
문제 1.
필드에 @Autowired("원하는 내용") 어노테이션을 적용 할 경우 필드의 값을 value로 초기화하는 코드를 작성하세요. 
*/