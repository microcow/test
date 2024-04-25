package Ch1;

import java.util.HashMap;
import java.util.Map;

public class testtest4 {
	public static void main(String[] args) {
		int[] array = {1, 1, 2, 2, 3, 3, 3};
		Solution1111 T = new Solution1111();
		System.out.println(T.solution(array));
		
		
		
				
	}
}
class Solution1111 {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
 	              maxCount = count;
 	              answer = number;           
            }
            else if(count == maxCount){
            	answer = -1;
            }         
            map.put(number, count);
            System.out.println(map);
        }
        return answer;
    }
}