package ch6;
import java.util.Arrays;
public class memo {
	public static void main(String[] args) {
        // 1부터 45까지의 숫자를 저장할 배열
        int[] arr = new int [10]; {
         for (int a=0; a<arr.length; a++) {      	
        	   arr[a] = a+1;
        	   }
         
       
        }
        			
        
        
        /*
        for (int i=0; i<arr.length; i++) {
        	int tmp = arr[i];
        	int n = (int)(Math.random()*arr.length);
        	tmp = arr[i];
        	arr[i] = arr[n];
        	arr[n]= tmp;
        }*/
        System.out.println(Arrays.toString(arr));
	}
}
