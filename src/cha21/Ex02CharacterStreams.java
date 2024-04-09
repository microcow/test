package cha21;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Ex02CharacterStreams {
	public static void main(String[] args) {
		
		// 캐릭터스트림은 Reader 혹은 Writer가 붙어있다 (문자열 처리에 유리하다)
		
		try (
				InputStreamReader in = new InputStreamReader(new FileInputStream("src/cha21/test.txt"));
				OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("src/cha21/outtest2.txt"));				
				// 바이트 단위로 처리하는 것이 아닌 캐릭터 단위로 처리한다
				// 아규먼트에 파일인풋(아웃풋)스트림 입력 시 파일인풋스트림에 기능이 추가된 인스턴스가 생성된다 (아웃풋도 마찬가지)
			) {
				int c;
				while ((c = in.read()) != -1) {
					out.write(c);
				}
				System.out.println("< ByteStream -> CharacterStream >");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		
			
			
		try (
			FileReader in = new FileReader("src/cha21/test.txt");
			FileWriter out = new FileWriter("src/cha21/test.txt");
				// FileReader나 FileWriter를 사용하게 되면 위쪽처럼 File인풋,아웃풋을 변환하지 않고 캐릭터스트림을 사용할 수 있다
		) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("< FileReader / FileWriter >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		try (
			BufferedReader in = new BufferedReader(new FileReader("src/cha21/test2.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("src/cha21/outtest2.txt"));
				// Buffer의 아규먼트에 File의 Reader,Writer 스트림 입력 시 Buffer기능이 추가된 인스턴스가 생성된다 (아웃풋도 마찬가지)
		) {
			String line;
			while ((line = in.readLine()) != null) {
				// readLine 메서드는 줄단위로 읽어오는 메서드이다
				// 더이상 읽어올 줄이 없다면 null을 return한다.
				out.write(line);
				out.newLine();
				// 줄단위로 읽어왔을땐 readLine메서드로 newLine메서드로 줄바꿈을 수동으로 해주어야한다. 
			}
			System.out.println("< File Reader/Writer -> Buffered Reader/Writer >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		try (
			BufferedReader in = new BufferedReader(new FileReader("src/cha21/test2.txt"));
			PrintWriter out = new PrintWriter(new FileWriter("src/cha21/outtest2.txt"));
				// 캐릭터스트림에는 PrintWriter 클래스가 존재하며, println 이나 printf 등과 같은 메서드들이 있는 클래스이며 출력 시 해당 클래스의 메서드들의 사용이 필요할 때 사용을 고려한다
				) {
			String line;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			System.out.println("< FileWriter -> PrintWriter >");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		System.out.println("< FileReader -> Scanner >");
		try (
			Scanner s = new Scanner(new FileReader("src/cha21/test2.txt"));
				// FileReader 아규먼트로 Scanner타입으로 변환할 수 있으며, hasNext나 next 등과 같은 메서드들이 있는 클래스이며 출력 시 해당 클래스의 메서드들의 사용이 필요할 때 사용을 고려한다
		) {
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		
		System.out.println("< BufferedReader -> Scanner >");
		try (
			Scanner s = new Scanner(new BufferedReader(new FileReader("src/cha21/test2.txt")));
				//FileReader에 Buffer기능을 추가한 후 Scanner타입으로 변환
				// = new Scanner(System.in); 이 아니기에 직접 입력받는게 아닌 아규먼트에 있는 내용을 s에 저장
		) {
			while (s.hasNext()) {
				System.out.println(s.next());//혹은 s.nextLine
				// next는 띄어쓰기(공백)을 만날때까지 를 return
				// nextLine은 한 줄을 읽음
				// hasNext와 next 모두 Iterator의 hasNext와 next의 기능과 유사하다(*cha17 Ex01)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
