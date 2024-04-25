package Ch1;

public class test2 { // 동적계획법
	public static void main(String[] args) {
        Solution22 sol = new Solution22();
        int[] money = {5, 4, 12, 67, 2, 242, 14, 66, 45};
        int a = sol.solution22(money); // 예시로 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} 배열에 대한 결과 출력
        System.out.println("=========");
        System.out.println(a);
	}
}

class Solution22 {
    public int solution22(int[] money) {
        int[] dp1 = new int[money.length - 1];
        int[] dp2 = new int[money.length - 1];

        // dp1: 0 ~ money.length-2
        for (int i = 0; i < money.length - 1; i++) {
            dp1[i] = money[i]; // 1,2,3,4,5,6,7,8,9 저장됨
        }

        // dp2: 1 ~ money.length-1
        for (int i = 1; i < money.length; i++) {
            dp2[i-1] = money[i]; // 2,3,4,5,6,7,8,9,10 저장됨
        }

        for (int i = 2; i < money.length - 1; i++) { // 문제의 핵심알고리즘
            dp1[i] += Math.max(dp1[i - 2], (i >= 3 ? dp1[i - 3] : 0));
            System.out.println(dp1[i]);
            dp2[i] += Math.max(dp2[i - 2], (i >= 3 ? dp2[i - 3] : 0));
            System.out.println("dp2         " + dp2[i]);
        }
        //return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]); // 오류
        return Math.max(Math.max(dp1[dp1.length - 1], dp1[dp1.length - 2]), Math.max(dp2[dp2.length - 1], dp2[dp2.length - 2]));
    }

    
}