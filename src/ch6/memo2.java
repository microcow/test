package ch6;
import java.util.Arrays;
public class memo2 {
	public static void main(String[] args) {
        // 1부터 45까지의 숫자를 저장할 배열
        int[] numbers = new int[45];				// numbers에 45개 배열 선언 // number[0] number[1] number[2] number[3]... 쭉 있는 형태지만 저장된 데이터는 없음
        for (int i = 0; i < numbers.length; i++) {	// i 선언 및 조건
        	numbers[i] = i+1;						// 45개의 배열에 숫자 저장
        }

        // 선택된 숫자를 저장할 배열
        int[] selectedNumbers = new int[6];

        // 현재 선택된 숫자의 개수
        int selectedCount = 0;
        //System.out.println(selectedCount); == 0
        while (selectedCount < 6) {
            // 0부터 44까지의 랜덤 인덱스 생성
            int index = (int) (Math.random() * 45);

            // 이미 선택된 숫자인지 확인
            boolean isDuplicate = false;
            
            for (int j = 0; j < selectedCount; j++) {
                if (selectedNumbers[j] == numbers[index]) {
                    isDuplicate = true;
                    break;
                }
            }
          
            // 중복되지 않은 숫자라면 선택
            if (!isDuplicate) {
                selectedNumbers[selectedCount++] = numbers[index];
                //selectedCount는 인덱스 변수 역할을 하는 동시에 "선증가 연산자"로 사용됩니다.
                //즉, 배열 인덱스로 사용하기 전에 먼저 selectedCount 값을 1 증가시킵니다.
            }
        }

        // 선택된 숫자 출력
        System.out.println(Arrays.toString(selectedNumbers));
        //System.out.println(selectedCount); == 6
    }
}
