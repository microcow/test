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
		// putStream이 붙었을 경우 처리할 때 한 글자(한 바이트)씩 처리한다 즉, 한글이 깨질 수 있다
		// 따라서 ByteStreams는 문자열을 처리할 때는 잘 사용하지 않으며 이미지, 동영상 등 바이트단위의 처리가 필요한 경우 사용한다 (문자열은 캐릭터스트림스를 사용)
		// 디렉토리 = 폴더 같은 의미 // 출력 = write = 파일생성
		
		FileInputStream oldIn = null;
		// 컴퓨터 내의 파일로 부터 값을 입력해오기 위해선 FileInputStream
		FileOutputStream oldOut = null;
		// 파일 생성 혹은 출력 등을 위해선 FileOutputStream
		
		try {
			oldIn = new FileInputStream("./src/cha21/test.txt");
			// 생성자의 아규먼트로 파일의 경로를 입력
			// 경로에 있는 txt를 읽어올 수 있는 FileInputStream이 생성된다
			// ./를 입력하게 되면 현재 디렉토리(test)부터 경로를 입력하면 된다
			oldOut = new FileOutputStream("./src/cha21/out1-fileoutputstream1.txt");
			// 생성자의 아규먼트로 파일을 생성할 경로 및 파일명 입력
									
			int c;
			while ((c = oldIn.read()) != -1) {
				// read 메소드는 oldIn인스턴스에 저장된 경로의 텍스트의 문자를 한글자씩 읽어온 후 유니코드로 반환한다
				// 더이상 읽어올 게 없을 때는 -1을 반환한다
				// read() 메서드는 현재 입력 스트림(oldIn)에서 다음에 읽을 바이트를 반환합니다. 반환값은 int 형식인데, 이는 읽은 바이트의 값 자체일 수도 있고, EOF(End Of File)에 도달했을 때 -1일 수도 있습니다.
				// 만약에 입력 스트림(oldIn)에서 바이트를 읽을 수 없거나 더 이상 읽을 데이터가 없다면 read() 메서드는 -1을 반환합니다. 그렇지 않고 읽을 데이터가 있다면 해당 바이트 값을 반환합니다.
				// read() 메서드를 호출할 때마다 입력 스트림(oldIn)은 내부적으로 다음에 읽을 데이터를 가져옵니다. 따라서 반복문을 통해 여러번 read() 메서드를 호출하면 입력 스트림(oldIn)으로부터 데이터를 순차적으로 읽어올 수 있습니다.
				
				oldOut.write(c);
				// write 메소드는 oldOut인스턴스에 저장된 경로에 아규먼트의 내용을 작성(출력)한다
			}
			System.out.println("< FileInputStream / FileOutputStream >");
		} catch (IOException e) { // trycatch로 예외처리를 안해주었을 경우에 java에서 컴파일 오류를 발생시킨다. (IOException은 Checked Exception)
			e.printStackTrace();
		} finally {
			try {
				if (oldIn != null) oldIn.close(); // finally는 try catch 예외가 발생하지 않아도 무조건 실행되므로, try catch에서 예외가 발생되어 자원을 사용하지 않더라도 .close메소드가 실행될 때를 대비해 if문에 != null 부분을 추가
				if (oldOut != null) oldOut.close();
				// 자원을 사용하고 난 후에는 .close 메소드를 통해 반납해주어야한다.
				// close 메소드도 IOException이므로 trycatch로 예외처리하지 않을경우 오류발생
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		// 여기까지 io의 기본적 구조
		
		
		try ( // tryWithResources가 finally 키워드를 통해 close하는 코드를 생략하여도 자동으로 반납된다 (*cha12 Ex09)
			FileInputStream in = new FileInputStream("src/cha21/test.txt");
			FileOutputStream out = new FileOutputStream("src/cha21/out1-fileoutputstream1.txt");
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
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/cha21/test.txt"));
				// BufferedInputStream의 아규먼트에 FileInputStream 입력 시 파일인풋스트림에 Buffer인풋스트림의 기능이 추가된 인스턴스가 생성된다 (아웃풋도 마찬가지)
				// 결과는 동일하나 성능면에서 Bufferd가 우세 (기존 File인풋,아웃풋은 바이트마다 내용을 보내거나 읽어들이는 반면 Bufferd는 배열에 내용을 저장해두었다가 한번에 내용을 보내거나 읽어들인다)
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/cha21/out1-fileoutputstream1.txt"));
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
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/cha21/test.txt"));
			PrintStream out = new PrintStream(new FileOutputStream("src/cha21/out1-fileoutputstream123.txt"));
				// PrintStream은 println 이나 printf 등과 같은 메서드들이 있는 클래스이며 출력 시 해당 클래스의 메서드들의 사용이 필요할 때 사용을 고려한다
				// 이와같이 java에서는 스트림의 생성자에 다른 스트림을 입력하는 방식으로 스트림의 기능을 강화할 수 있도록 한다
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.println((char)c);
				 //System.out.println((char)c);
				// out.println 시 미출력 이유 (System.out.println 시 출력됨) : (out.println은 '문자열 출력'이 아닌 output 코드 위의 write메소드와 동일하게 '파일생성(출력)' 역할)
			}
			System.out.println("< FileOutputStream -> PrintStream >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
