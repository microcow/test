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
		System.out.println("< 익명클래스 >");
		Supplier<Integer> as = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return (int)(Math.random()*10);
			}
		};
		System.out.println(as.get());
		
		System.out.println("< Supplier >");
		Supplier<Integer> s = () -> (int)(Math.random()*10);
		// 익명클래스의 코드를 더욱 줄여주는게 람다식이다 즉,(위 19~24줄의 코드와 28줄의 코드는 같은 코드이다)
		// ★★ 람다식으로 구현할 인터페이스는 추상메소드가 하나여야한다 (익명클래스와 차이점)		
		/// 부모클래스의 메소드도 익명클래스로 즉시 오버라이딩해서 사용할 수 있나 : 가능
		/// 굳이 추상메소드가 아닌 메소드를 오버라이딩할 수도 있는데 그 땐 람다식을 못쓰는 것인가 : 가능하겠지?
		
		// 강의 2:00부터
		
		System.out.println(s.get());
		System.out.println();
		
		System.out.println("< Consumer >");
		Consumer<Integer> c = i -> System.out.println(i);
		c.accept(7);
		System.out.println();
		
		System.out.println("< Function >");
		Function<Integer, Double> f = i -> i/2.0;
		System.out.println(f.apply(5));
		System.out.println();
		
		System.out.println("< Predicate >");
		Predicate<Integer> p = i -> i == 22;
		System.out.println(p.test(15));
		Predicate<Integer> p2 = i -> i < 10;
		Predicate<Integer> p3 = i -> i < 20;
		Predicate<Integer> p4 = p.or(p2.negate().and(p3));
		System.out.println(p4.test(19));
		Predicate<String> p5 = Predicate.isEqual("ok");
		System.out.println(p5.test("ok"));
		System.out.println();
		
		System.out.println("< UnaryOperator >");
		UnaryOperator<Integer> u = i -> i*10;
		System.out.println(u.apply(7));
		System.out.println();
		
		System.out.println("< BiConsumer >");
		BiConsumer<String, Integer> bc = (str, i) -> System.out.println(str + ": " + i);
		bc.accept("A", 7);
		BiConsumer<String, Integer> bc2 = (str, i) -> System.out.println(str + "*10: " + (i * 10));
		bc.andThen(bc2).accept("A", 8);
		System.out.println();
		
		System.out.println("< BiFunction >");
		BiFunction<Integer, Integer, Double> bf = (i1, i2) -> i1/(double)i2;
		System.out.println(bf.apply(5, 2));
		System.out.println();
		
		System.out.println("< IntSupplier >");
		IntSupplier is = () -> (int)(Math.random()*20);
		System.out.println(is.getAsInt());
		System.out.println();
		
		System.out.println("< IntToLongFunction >");
		IntToLongFunction it = i -> i*10000000000L;
		System.out.println(it.applyAsLong(7));
		System.out.println();
		
		System.out.println("< BooleanSupplier >");
		boolean bool = true;
		BooleanSupplier bs = () -> !bool;
		System.out.println(bs.getAsBoolean());
		System.out.println();
		
		System.out.println("< ObjIntConsumer >");
		ObjIntConsumer<LocalDateTime> oi = (time, i) -> System.out.println(time.plusYears(i));
		oi.accept(LocalDateTime.now(), 5);
		System.out.println();
		
		System.out.println("< ToIntFunction >");
		ToIntFunction<String> tif = str -> Integer.parseInt(str);
		System.out.println(tif.applyAsInt("777") + 10);
		System.out.println();		
	}
}
