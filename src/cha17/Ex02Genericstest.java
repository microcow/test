package cha17;

import java.util.List;

public class Ex02Genericstest {
	public static void main(String[] args) {
		Box<Pencil> pencil = new Box<Pencil>();
		Box<Tv> Tv = new Box<Tv>();
	}
}
class Pencil {
	
}

class Tv{
	
}

class Box<T> {
	private List<T> Box;
	
}
/*
문제 1.
상자에 연필과 티비를 담는 프로그램을 코딩하세요.
상자에는 연필, 티비 외에 어떠한 타입도 받을 수 있도록 타입 파라미터를 사용하세요. 
*/