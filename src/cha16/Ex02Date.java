package cha16;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
public class Ex02Date {
	public static void main(String[] args) {
		
		// 날짜(Date)를 연산하려면 캘린더 클래스를 이용
		// 출력하는 방식을 바꾸려면 심플데이트포맷 클래스를 이용
		// 날짜를 출력하려면 데이트 클래스를 이용
		
		Date today = new Date();
		// Date클래스의 Date 빈 생성자는 현재 날짜와 시간을 Date 타입으로(예_Mon Mar 18 17:28:32 KST 2024)저장해주는 생성자이다. 
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ★★ SimpleDateFormat 클래스의 SimpleDateFormat 생성자는 아규먼트의 방식으로 포맷한다
		String strToday = sdf.format(today);
		// ★★ format메소드는 아규먼트에 저장된 Date클래스 타입의 날짜(예_Mon Mar 18 17:28:32 KST 2024)를 호출자의 방식대로 변환하여 String타입으로 return해준다.
		// SimpleDateFormat클래스가 DateFormat 메소드를 상속받고 있으므로 format메소드 사용 가능
		System.out.println(strToday);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년MM월dd일");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scan = new Scanner(System.in);
		Date inputDate = null;
		
		System.out.print("yyyy년MM월dd일 패턴으로 날짜를 입력해 주세요: ");
		String strDate = scan.nextLine();		
		try {
			inputDate = sdf2.parse(strDate);
			// ★★ parse메소드의 아규먼트가 하나 있을 경우 String 타입의 아규먼트를 Date타입(예_Mon Mar 18 17:28:32 KST 2024)으로 return해준다.
			/// parse메소드의 호출자(sdf2)의 형식("yyyy년MM월dd일")과는 관계없이 Date 타입(예_Mon Mar 18 17:28:32 KST 2024)으로 return해주는가 → 그런듯
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("----");
		System.out.println(inputDate);
		System.out.println(sdf2.format(inputDate));
		System.out.println(sdf3.format(inputDate));
		// ★★ format메소드는 아규먼트에 저장된 Date클래스 타입의 날짜(예_Mon Mar 18 17:28:32 KST 2024)를 호출자의 방식대로 변환하여 String타입으로 return해준다.
		System.out.println();
		
		Calendar cal1 = Calendar.getInstance();
		// Calendar.getInstance() 메소드는 현재 날짜(년,월,일,시,분,초)가 저장되어있는 '정돈되지 않은' 시간 정보를 return한다. (*cha16 Ex01)
		cal1.setTime(inputDate);
		// Calendar클래스의 setTime메소드는 Date클래스의 아규먼트에 저장된 날짜 정보를 Calendar클래스의 인스턴스에 저장해준다. (여전히 시간이 정돈되어있지 않음)
		/// inputDate 인스턴스는 현재 sdf2타입으로 시간이 저장되어있음 근데 sdf3타입으로 시간이 저장되어 있을 경우 해당 메소드 실행안됨. sdf2와3은 같은 클래스인데 왜? → sdf3 방식인 yyyy-MM-dd으로 입력해야함
		cal1.add(Calendar.YEAR, 1);
		Date inputDate2 = cal1.getTime();
		// ★★ Calendar클래스의 getTime 메소드는 호출자의 정돈되지 않은 시간 정보를 Date 클래스의 타입(예_Mon Mar 18 17:28:32 KST 2024)으로 시간을 정돈하여 return한다
		System.out.println(inputDate2);
		System.out.println(sdf3.format(inputDate2));
		System.out.println();
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("'input date - 'yyyy-MM-dd", Locale.ENGLISH);
		//SimpleDateFormat 생성자를 호출할 때 영어가 출력되어야 할 경우, 날짜 방식(패턴)의 큰 따음표 안에 작은 따옴표에 출력하고자 하는 영어를 입력하고 두번째 아규먼트로 Locale.ENGLISH을 입력하자
		System.out.println(sdf4.format(inputDate2));
		
		
	}
}
