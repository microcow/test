package cha21;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class Ex01ByteStreams {
	public static void main(String[] args) {
		// 인풋스트림 ('i'o) (InpuyStream)
		// 아웃풋스트림 (i'o') (OutpuyStream)
		// 인풋,아웃풋스트림(io)은 외부로부터 값을 읽어오거나(입력,인풋) 내보내기(출력,아웃풋)위해 사용한다 (람다식의 stream과는 관계x)
		// 이런 io를 위한 패키지는 java의 io패키지에 있다
		FileInputStream oldIn = null;
		// 컴퓨터 내의 파일로 부터 값을 입력해오기 위해선 FileInputStream
		FileOutputStream oldOut = null;
		// 파일 생성 혹은 출력 등을 위해선 FileOutputStream
		
		try {
			oldIn = new FileInputStream("./src/cha21/test.txt");
			// 생성자의 아규먼트로 파일의 경로를 입력
			// 경로에 있는 txt를 읽어올 수 있는 FileInputStream이 생성된다
			// ./를 입력하게 되면 현재 디렉토리(test)부터 경로를 입력하면 된다
			oldOut = new FileOutputStream("./src/com/lcomputerstudy/books/java/ch21/out1-fileoutputstream1.txt");
			
			int c;
			while ((c = oldIn.read()) != -1) {
				oldOut.write(c);
			}
			System.out.println("< FileInputStream / FileOutputStream >");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oldIn != null) oldIn.close();
				if (oldOut != null) oldOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		try (
			FileInputStream in = new FileInputStream("src/com/lcomputerstudy/books/java/ch21/test.txt");
			FileOutputStream out = new FileOutputStream("src/com/lcomputerstudy/books/java/ch21/out1-fileoutputstream2.txt");
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("< FileInputStream / FileOutputStream > (try-with-resources)");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try (
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/com/lcomputerstudy/books/java/ch21/test.txt"));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/com/lcomputerstudy/books/java/ch21/out1-bufferedoutputstream.txt"));
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("< File I/O Stream -> Buffered I/O Stream >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try (
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/com/lcomputerstudy/books/java/ch21/test.txt"));
			PrintStream out = new PrintStream(new FileOutputStream("src/com/lcomputerstudy/books/java/ch21/out1-printstream.txt"));
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.println((char)c);
			}
			System.out.println("< FileOutputStream -> PrintStream >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
