package cha21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class testtesttest {
		static class node implements Comparable<node>
		{
			int thick;
			
			public node(int thick)
			{
				this.thick = thick;
			}
			@Override
			public int compareTo(node n)
			{
				return Math.abs(n.thick) - Math.abs(thick); // Math.abs는 아규먼트를 절대값으로 return
			}
			
			String [] alphabet = { "A", "B", "C" ,"A"};
			
			
	        	// 결과 : {A=2, B=1, C=1
		}
		
		/* 5
		-99 -2 -1 4 98
		위 예제 입력해봄
		*/
		
		static int a , b , n;
		static int max = Integer.MAX_VALUE; //MAX_VALUE : int값이 가질 수 있는 최대값
		static ArrayList<node> list = new ArrayList<>();
		
		public static void main (String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 숫자 입력받은 후 BufferedReader br에 저장		
			StringTokenizer st = new StringTokenizer(br.readLine()); // br을 한줄씩 토큰으로 저장 // 이 코드 때문에 입력이 가능한거네
			// BufferedReader를 생성할 때 System.in을 사용하면 프로그램은 사용자로부터 키보드 입력을 받을 수 있습니다. 그러나 readLine() 메서드를 호출하기 전까지는 사용자의 입력을 받지 않습니다.
			// StringTokenizer클래스는 문자열을 '토큰'으로 저장할 수 있다 (배열은 아님) (Itorator와 좀 비슷하게 동작하고 메서드들도 비슷함)
			
			n = Integer.parseInt(st.nextToken()); // 현재 가리키고있는 토큰을 return하고 다음토큰으로 커서를 옮김(Iterator 클래스의 next와 동일한 구조로 동작) (팁 : StringTokenizer클래스 hasMoreTokens()은 Itorator클래스의 hasNext() 메서드와 동일)
			// n은 5
			st = new StringTokenizer(br.readLine()); // 한줄 더 입력
			// st는 -99 -2 -1 4 98가 저장되어있음
			// StringTokenizer는 공백을 기준으로 토큰으로 저장하기에 st에는  -99 / -2 / -1 / 4 / 98 라는 5개의 토큰이 저장
			
			for(int i = 0 ; i < n ; i++)
			{
				list.add(new node(Integer.parseInt(st.nextToken()))); // 요소 5개 추가
			}
			
			Collections.sort(list); // -99 98 4 -2 -1로 정렬
			
			 for (node node1 : list) {
		            System.out.println(node1.thick);
		        } /// 왜 내림차순으로 정렬되지
			
			for(int i = 0 ; i < list.size() -1 ; i++)
			{
				int first = list.get(i).thick;
				int second = list.get(i+1).thick;
				
				if(Math.abs(max) > Math.abs(first + second))
				{
					max = Math.abs(first+second);
					a = Math.min(first , second);
					b = Math.max(first , second);
				}
			}
			
			System.out.println(a+" "+b);
		}
		
		

}
/* 어떤 구조이기에 readLine을 호출하기전까지 입력하지 못하는거지?
ChatGPT
이것은 Java의 표준 입력 스트림(System.in)의 동작 방식 때문입니다.
Java에서 표준 입력 스트림(System.in)은 버퍼링되지 않은 바이트 스트림으로, 사용자가 입력한 데이터가 바로 사용 가능한 상태가 아닙니다. 따라서 BufferedReader를 사용하여 이를 문자 스트림으로 변환하고, 이후에 readLine() 메서드를 호출하여야 사용자의 입력을 받을 수 있습니다.
즉, BufferedReader를 생성하고 readLine()을 호출하기 전까지는 사용자의 입력이 프로그램에게 전달되지 않습니다. 사용자가 입력한 데이터는 버퍼에 저장되어 있으며, 이를 읽어들이기 위해서는 readLine() 또는 다른 읽기 메서드를 호출해야 합니다.
따라서 BufferedReader를 생성하고 readLine()을 호출하기 전까지는 사용자가 입력을 할 수 없습니다.
*/
// 자바에서 BufferedReader는 입력 스트림으로부터 데이터를 읽을 때 데이터를 버퍼에 임시로 저장(버퍼링)합니다. 이는 한 번에 많은 양의 데이터를 읽거나 쓸 때 효율성을 높입니다.
// 버퍼링(Buffering)은 데이터를 임시로 저장하는 메모리 영역

/*StringTokenizer는 자체적으로 토큰을 관리하며, 이들을 배열에 저장하지는 않습니다. 대신, 토큰을 필요할 때마다 하나씩 가져올 수 있습니다.
예를 들어, StringTokenizer 객체를 사용하여 토큰을 가져오려면 nextToken() 메서드를 사용합니다. 이 메서드는 String으로 토큰을 반환합니다. 
토큰을 모두 가져올 때까지 반복문을 사용하여 각 토큰을 처리할 수 있습니다. 따라서 StringTokenizer에 저장된 토큰들은 배열에 저장되지 않고, 필요할 때마다 하나씩 가져와서 사용됩니다*/

// https://blog.naver.com/kjih1104/223015782620
// https://blog.naver.com/kjih1104 프로그레머스 3레벨 이것도 풀어보기
