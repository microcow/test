package cha19;
import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.IntToLongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class Ex01FunctionalInterface {
	public static void main(String[] args) {
		
		// 람다식(선언형 프로그래밍)을 쓰는 이유
		
		// 명령형 : 내가 원하는 값을 어떻게(How) 가져올건지(for each, 반복문, if문 등) 코딩하고 명령해야한다
			// 장점 : 가져오는 방식을 직접 코딩하여 디테일하게 설정 가능
			// 단점 : 시간이 오래걸리는 등 효율성이 다소 떨어짐
		
		// 선언형 : 무엇을(what) 가져올 것인지 미리 만들어져있는 메소드를 호출만 하여 값을 가져옴 (How가 미리 만들어져 있음)
			// 장점 : 직접 코딩하지 않고 구하고자 하는 값을 미리 만들어져있는(FunctionalInterface) 메소드의 아규먼트 등으로만 넘겨주기만 하면 됨 (람다식은 함수를 넘기는 것 처럼 보이지만 정확히는 인스턴스를 넘기는 것이다)
		
		// ★★ 람다식의 인터페이스들은 각각 반드시 오버라이딩해야하는 추상메소드가 하나씩 있으며(람다식으로 오버라이딩 해야하는 메소드), 해당 추상메소드 외 메소드(디폴트메소드)도 가지고 있다. 
		// 디폴트 메소드는 오버라이딩 한 추상메소드와 함께 사용하거나 추상메소드를 동작하고 활용하는데 도움을 준다. 
		
		System.out.println("< 익명클래스 >");
		Supplier<Integer> as = new Supplier<Integer>() {
			
			@Override
			public Integer get() {
				return (int)(Math.random()*10);
			}
		};
		System.out.println(as.get());
		
		System.out.println("< Supplier >");
		Supplier<Integer> s = () -> (int)(Math.random()*10); // 제네릭스는 기본형(int)를 받을 수 없기에 int타입을 받더라도 Integer를 제네릭스로 적어야함 (기본형을 쓰려면 IntSupplier 사용) 참조형을 받는 인터페이스(Integer 등)에 기본형을 사용하더라도 큰 문제는 없으나 기능적으로 매우 비효율적
		// 익명클래스의 코드를 더욱 줄여주는게 람다식이다 즉,(위 익명클래스 코드와 같은 코드이다)
		// ★★ 람다식으로 구현할 인터페이스는 추상메소드가 하나여야한다 (익명클래스와 차이점) (즉, 람다식(오버라이딩)을 쓰고 호출할 수 있는 메소드는 하나이다. 단, 추상메소드가 아닌 메소드가 있을 수도 있으며 해당 메소드들은 오버라이딩 하지 않고 사용 가능하다)
		// 빈 괄호는 파라미터 부분이다 (get메소드는 파라미터가 없기에 빈 괄호이다)
		// 해당 메소드의 return타입과 일치하다면 retrun을 굳이 적지 않아도 된다.
		// ★ Supplier 인터페이스는 파라미터는 필요 없고 retrun(Integer 타입)을 필요로 하는 메소드가 람다식으로 필요로 할 때 사용
				
		/// 굳이 추상메소드가 아닌 메소드를 오버라이딩할 수도 있는데 그 땐 람다식을 못쓰는 것인가
		/// 인터페이스가 아닌 부모클래스의 추상메소드도 람다식으로 사용 가능한다
		/// 부모클래스의 메소드도 익명클래스로 즉시 오버라이딩(람다식x)해서 사용할 수 있나 : 가능
		
		System.out.println(s.get());
		System.out.println();
		
		System.out.println("< Consumer >");
		Consumer<Integer> c = i -> System.out.println(i); //제네릭타입은 파라미터 타입
		// ★ Consumer 인터페이스는 파라미터로 던지(받)기만 하고 retrun할 필요가 없을 때 람다식으로 사용
		// 파라미터가 하나만 있다면 괄호를 하지않아도 된다.
		c.accept(7);
		// Cunsumer의 accept 메소드는 아규먼트(7)를 넘겨주면 파라미터 (i)가 받는다 
		System.out.println();
		
		System.out.println("< Function >");
		Function<Integer, Double> f = i -> i/2.0;
		// Function 인터페이스는 Interger타입으로 던지(받)고 Double타입으로 retrun받는 인터페이스이다
		System.out.println(f.apply(5));
		// 줄때는 정수(Integer) 받을때는 Double(실수)
		// Function<Integer, Double> f 이기에 정수, 실수 모두 저장할 수 있음
		System.out.println();
		
		System.out.println("< Predicate >");
		Predicate<Integer> p = i -> i == 22;
		// Predicate 인터페이스는 파라미터(i)를 boolean타입으로 return한다
		System.out.println(p.test(15));
		Predicate<Integer> p2 = i -> i < 10;
		Predicate<Integer> p3 = i -> i < 20;
		Predicate<Integer> p4 = p.or(p2.negate().and(p3));
		//or 메소드는 || 연산자와 비슷하다. p.test 거나 뒤(아규먼트)가 참일 경우 true를 리턴한다 
		//negate 메소드는 식을 반대로 바꾼다 (i가 10보다 크거나 같다면으로 바뀜)
		//and 메소드는 && 연산자와 비슷하다. and의 앞의 것이 참이고 뒤의 것도 참일 경우
		// 총 해석 : p.test(15)의 식인 i == 22 이거나(or) i가 10보다 크거나 같으면서 i가 20보다 작을 경우 true를 return
		System.out.println(p4.test(19));
		Predicate<String> p5 = Predicate.isEqual("ok");
		// isEqual 메소드는 해당 문자열과 일치하는 문자열이 test의 아규먼트로 호출할 경우 true를 retrun한다.
		/// Predicate 람다식은 파라미터랑 ->가 없는데 : 그냥 클래식 메소드 호출하고 있는 것임 람다식은 ()와 ->가 있어야함
		System.out.println(p5.test("ok"));
		System.out.println();
		// Predicate의 추상메소드는 test 하나 뿐이다
		
		System.out.println("< UnaryOperator >");
		UnaryOperator<Integer> u = i -> i*10;
		// UnaryOperator 인터페이스는 Function 인터페이스와 유사하지만, 주고 받는(return) 타입이 같을 때 더욱 효율적이다 (기능은 같음)
		System.out.println(u.apply(7));
		System.out.println();
		
		System.out.println("< BiConsumer >");
		BiConsumer<String, Integer> bc = (str, i) -> System.out.println(str + ": " + i);
		bc.accept("A", 7);
		BiConsumer<String, Integer> bc2 = (str, i) -> System.out.println(str + "*10: " + (i * 10));
		// BiConsumer는 Consumer와 유사하지만 파라미터를 두개 던지(받)기만 하고 retrun은 하지 않는다
		bc.andThen(bc2).accept("A", 8);
		// andThen 메소드는 bc를 실행하고 연속적으로 bc2를 실행하고 싶을 때 사용한다
		// bc의 식에 bc2를 파라미터로 던졌고 바로 bc2의 식을 실행
		System.out.println();
		
		System.out.println("< BiFunction >");
		BiFunction<Integer, Integer, Double> bf = (i1, i2) -> i1/(double)i2;
		// BiFunction 인터페이스는 Interger타입 두개를 던지(받)고 Double타입으로 retrun받는 인터페이스이다
		System.out.println(bf.apply(5, 2));
		System.out.println();
		
		System.out.println("< IntSupplier >");
		IntSupplier is = () -> (int)(Math.random()*20);
		System.out.println(is.getAsInt());
		System.out.println();
		// 기본형을 받지 못하는 Supplier와 반대로 기본형만 받을 수 있는 인터페이스이다
		// IntSupplier 인터페이스는 파라미터는 필요 없고 retrun(기본형)을 필요로 하는 메소드가 람다식으로 필요로 할 때 사용
		
		System.out.println("< IntToLongFunction >");
		IntToLongFunction it = i -> i*10000000000L;
		System.out.println(it.applyAsLong(7));
		System.out.println();
		// IntToLongFunction 과 유사한 인터페이스는 To~~ 가 retrun 타입(long)이고 To가 없는 부분이(Int) 파라미터타입이다
		// Function과 기능은 동일하나 Int타입으로 던지고 Long타입으로 return 받는다
		
		System.out.println("< BooleanSupplier >");
		boolean bool = true;
		BooleanSupplier bs = () -> !bool;
		System.out.println(bs.getAsBoolean());
		System.out.println();
		// BooleanSupplier 인터페이스는 파라미터는 필요 없고 retrun(boolean)을 필요로 하는 메소드가 람다식으로 필요로 할 때 사용
		
		System.out.println("< ObjIntConsumer >");
		ObjIntConsumer<LocalDateTime> oi = (time, i) -> System.out.println(time.plusYears(i)); // 지금시각으로부터 5년 후 시각을 출력하는 코드
		oi.accept(LocalDateTime.now(), 5);
		System.out.println();
		// ObjIntConsumer 인터페이스는 Consumer 인터페이스와 마찬가지로 파라미터로 던지기만 하고 retrun할 필요가 없을 때 람다식으로 사용
		// 단, 파라미터를 2개 던질(받을) 수 있는데 첫번째는 Object 타입, 두번째는 Int타입을 던질 수 있다 (Object 타입이라고 한건 모든 클래스를 다 받을 수 있다는말. 실제론 T t로 받고있기에 ObjIntConsumer의 첫번째 제네릭 타입으로 받고 있음)
		/* 위 구조 람다식 이해하기 (return 타입이 없는데 제네릭 타입이 적혀있는 이유?) : Object라 적어도 상관 없으나 요소(LocalDateTime)의 메소드를 사용하기 위해서 LocalDateTime을 제네릭타입으로 사용했다
		Object라 적었다면 time은 Object클래스 소속이 되었으므로 plusYears 메소드 사용 불가 Int은 기본형이기에 제네릭타입에 기입하지 않음 */
		
		System.out.println("< ToIntFunction >");
		ToIntFunction<String> tif = str -> Integer.parseInt(str);
		System.out.println(tif.applyAsInt("777") + 10); // 777이란 문자열을 Int타입으로 바꾼 뒤 +10을 연산하여 return한다
		System.out.println();		
		// ToIntFunction 인터페이스는 제네릭스 타입을 던지(받)고 Int타입으로 return받는다
	}
}
