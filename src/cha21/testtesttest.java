package cha21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class testtesttest {
		static class node implements Comparable<node>
		{
			int thick;
			
			public node(int thick)
			{
				this.thick = thick;
			}
			
			public int compareTo(node n)
			{
				return Math.abs(n.thick) - Math.abs(thick);
			}
		}
		
		
		
		static int a , b , n;
		static int max = Integer.MAX_VALUE;
		static ArrayList<node> list = new ArrayList<>();
		
		public static void main (String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < n ; i++)
			{
				list.add(new node(Integer.parseInt(st.nextToken())));
			}
			
			Collections.sort(list);
			
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
// https://blog.naver.com/kjih1104/223015782620
// https://blog.naver.com/kjih1104 프로그레머스 3레벨 이것도 풀어보기
