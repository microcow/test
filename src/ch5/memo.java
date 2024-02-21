package ch5;

public class memo {
	public static void main(String[] args) {
		int mon = -1;
		String name = "계절";
		
		if (mon == 3) name = "봄";
		else if (mon == 4) name = "봄";
		else if (mon == 5) name = "봄";
		else if (mon >= 6 && mon <= 8) name = "여름";
			if (mon == 8) name = "휴가철";
		else if (mon == 9) name = "가을";
		else if (mon == 10) name = "가을";
		else if (mon == 11) name = "가을";
		else if (mon == 12) name = "겨울";
		else if (mon == 1) name = "겨울";
		else if (mon == 2) name = "겨울";
		else if (mon > 12 && mon < 1) name = "잘 못 입력하였습니다.";
		
		if (6 <= mon && mon <= 8) System.out.printf("현재 %d월이며, %s입니다.", mon, name);
			else if (mon > 12 && mon < 1) System.out.printf(name);
			else System.out.printf("현재 %d월이며, %s입니다.", mon, name);
	}
}
