package Ch3;

public class Ex05RelationalOperatorstest {
	public static void main(String[] args) {
		int a = 200, b = 400, c = 500, d = 600;
		System.out.printf("a TV의 가격이 300원 보다 작거나 500원 보다 크고 600원 보다 작은가(%b)%n", a < 300 || a > 500 && a < 600);
		System.out.printf("b TV의 가격이 300원 보다 작거나 500원 보다 크고 600원 보다 작은가(%b)%n", b < 300 || b > 500 && b < 600);
		System.out.printf("c TV의 가격이 300원 보다 작거나 500원 보다 크고 600원 보다 작은가(%b)%n", c < 300 || c > 500 && c < 600);
		System.out.printf("d TV의 가격이 300원 보다 작거나 500원 보다 크고 600원 보다 작은가(%b)%n", d < 300 || d > 500 && d < 600);
	}

}
/*
문제 1.
TV의 가격이 300원 보다 작거나 500원 보다 크고 600원 보다 작은 경우 true를 반환하는 코드를 작성하고 결과를 출력하세요. 
*/