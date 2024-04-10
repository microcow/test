package cha21;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class Ex01ByteStreamstest {
	public static void main(String[] args) {
		// 예시 1
		try (
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/cha21/hello.txt"));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/cha21/outPuthello.txt"));
				) {
			int c;
			while ((c = in.read()) != -1) {
				// c는 int타입인데 in.read = c? read에 리턴되는게 뭐지 = 바이트 값이 return
				// c는 파일에서 읽어온 바이트 값
				out.write(c);
				// 바이트값(c)을 white 메소드를 통해 아규먼트로 쓸경우 읽어온 값이 출력
			}
			System.out.println("< File I/O Stream -> Buffered I/O Stream >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();		
			
		// 예시 2
		try (
				FileInputStream in2 = new FileInputStream("src/cha21/hello.txt");
				FileOutputStream out2 = new FileOutputStream("src/cha21/outPuthello2.txt");
				) {
			int c;
			while ((c = in2.read()) != -1) {
				out2.write(c);
			}
			System.out.println("< File I/O Stream2 -> Buffered I/O Stream2 >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();	
	}

}
/*
문제 1.
임의의 내용이 입력된 hello.txt파일을 생성하세요.
hello.txt파일의 내용을 복사하는 코드를 작성하세요.
*/