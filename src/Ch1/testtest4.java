package Ch1;

import java.util.HashMap;
import java.util.Map;

public class testtest4 {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("문자열 ").append("연결");
//        String str = stringBuilder;   // String에 StringBuilder를 그대로 넣을 순 없다. toString()을 붙여야 한다
        String str = stringBuilder.toString();
        // 두 println()은 같은 값을 출력한다
        System.out.println(stringBuilder);
        System.out.println(str);
        
	}
}