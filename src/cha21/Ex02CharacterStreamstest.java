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
public class Ex02CharacterStreamstest {
	public static void main(String[] args) {
		try (
				BufferedReader in = new BufferedReader(new FileReader("src/cha21/Ex02test.txt"));
				BufferedWriter out = new BufferedWriter(new FileWriter("src/cha21/outEx02test.txt"));
					// Buffer의 아규먼트에 File의 Reader,Writer 스트림 입력 시 Buffer기능이 추가된 인스턴스가 생성된다 (아웃풋도 마찬가지)
			) {
				String line;
				while ((line = in.readLine()) != null) {
					out.write(line);
					out.newLine();
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
	}
}
/*
문제 1.
문장들이 적힌 텍스트 파일을 생성하세요.
버퍼를 사용해 텍스트 파일을 읽어 들인 후 줄 번호와 함께 내용들을 출력하세요.
예) 
1. 안녕하세요.
2. Hello.
*/