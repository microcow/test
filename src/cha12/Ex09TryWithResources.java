package cha12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex09TryWithResources {
	public static void main(String[] args) {
		try1();
		
		System.out.println("\n\n----------\n");
		
		try2();
		
	}
	
	public static void try1() { //TryWithResources 구문
		try ( // 사용한 자원을 무조건 반납해야하는 코드가 있다면 try문 () 안에 작성해준다.
			  // 즉, try2()에 있는 finally 키워드를 통해 close하는 코드를 생략해준다.
			// 괄호안에 있는 모든 클래스를 모두 닫아줄 수 있는가 = no. java.io패키지에서 가능한 것(AutoCloseable)을 확인해야함
			FileReader fr = new FileReader("./src/com/lcomputerstudy/books/java/ch12/Ex01TryCatch.java");
			BufferedReader br = new BufferedReader(fr);
		) {
			int data;
			while ((data = br.read()) != -1) {
				char ch = (char)data;
				System.out.print(ch);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void try2() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try { 
			fr = new FileReader("./src/com/lcomputerstudy/books/java/ch12/Ex01TryCatch.java");
			//FileReader 메소드는 외부운영 체젤부터 자원을 사용하게 되는 메소드이다 사용 후 close 메소드로 닫아주어야 한다
			br = new BufferedReader(fr);
			
			int data;
			while ((data = br.read()) != -1) {
				char ch = (char)data;
				System.out.print(ch);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
