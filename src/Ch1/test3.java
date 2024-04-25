package Ch1;

public class test3 {
	public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int[] money = {5, 4, 12, 67, 2, 242, 14, 66, 45, 113};
        int a = sol.solution11(money); // 예시로 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} 배열에 대한 결과 출력
        System.out.println("=========");
        System.out.println(a);
	}

}
class Solution11 {
    public int solution11(int[] money) {        
        int[][] pick = new int[2][money.length];

        pick[0][0] = money[0];
        pick[0][1] = money[0]; // 해당 코드 설정 이유
        pick[1][0] = 0;
        pick[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
            System.out.println(pick[0][i]);
            pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
        }

        return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
    }
}