package ch6;

public class Ex08Branchingtest {
	public static void main(String[] args) {
		int sum = 0;
		boolean T = true;
		
		while(T)
			for (int i=0; i<=200; i++) {
				if (i%2==0 && sum<=50) {
					sum = sum+i;
					continue;
				}
				else if (i%2==1 && sum<=50) {
					continue;
				}
				else if (sum>50) {
					T = false;
					break;
				}
			}
		System.out.print(sum);
	
	}

}
/*
문제 1.
i=1, sum=0 일때
i는 1씩 증가되고 i가 짝수일 경우 sum에 누적됩니다.
sum의 값이 50을 초과할 때의 i값을 출력하세요.
while문, continue, break문을 사용해야 합니다.  
*/