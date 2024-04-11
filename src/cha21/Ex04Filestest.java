package cha21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex04Filestest {
	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		String path = "src/cha21";
		System.out.println(dir);
		
		Path p = Paths.get(dir).resolve(path).resolve("testfile.txt");
		try {
			Files.createFile(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String str = "안녕하세요 엘컴퓨터 학원입니다, 자바, java";
		Path p2 = Paths.get(dir).resolve(path).resolve("testfile.txt");
		try (BufferedWriter out = Files.newBufferedWriter(p2, Charset.forName("UTF-8"))) {
		    out.write(str, 0, str.length());
		   
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		try (BufferedReader in = Files.newBufferedReader(p2, Charset.forName("UTF-8"))) {
		    String line = null;
		    while ((line = in.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

}
/*
문제 1.
현재 패키지에 빈파일을 생성 후 임의의 내용을 출력하세요.
Path, createFile, newBufferedWriter를 사용하세요.

문제 2.
상대경로와 절대경로에 대해 알아보고 차이점을 작성하세요.
절대경로는 운영체제 및 파일 위치 등 환경이 변경되어도 고정된 경로의 파일(디렉토리)을 가르키고 있고
상대경로는 운영체제 및 파일 위치 등 환경이 변경됨에 따라 유동적으로 파일(디렉토리)의 위치를 가르키고 있다 
*/