package cha18;
import java.util.LinkedList;
import java.util.Queue;
public class Ex04Queuetest {
	public static void main(String[] args) {
		Notice notice = new Notice();
		notice.noticeList();
		notice.takeNotice("공지","첫 번째");
		notice.takeNotice("공지","두 번째");
		notice.takeNotice("공지","세 번째");
		notice.noticeList();
		notice.deleteNotice();
		notice.noticeList();
		
	}

}
class Notice {
	public static Queue<NoticeDispenser> notice = new LinkedList<>();	
	
	public void takeNotice(String title, String content) {
		Notice.notice.offer(new NoticeDispenser(title, content));
		
	}
	public void noticeList() {
		if (this.notice.isEmpty()) { // isEmpty 메소드는 호출자에 저장된 데이터가 없을 경우 false를 return한다.
            System.out.println("등록된 공지가 없습니다.");
            return;
        }
		else System.out.println("공지 목록입니다\n");
		for (NoticeDispenser notice : notice) {        	
        	System.out.println(notice);
            System.out.println();
        }
	}
	public void deleteNotice() {
        if (notice.isEmpty()) {
            System.out.println("삭제할 공지가 없습니다.");
            return;
        }

        notice.poll();
        System.out.println("가장 오래된 공지가 삭제되었습니다.\n");
    }
	
}
class NoticeDispenser {
	   private String title;
	   private String content;
	   
	   public NoticeDispenser(String title, String content) {
		   this.title = title;
		   this.content = content;
	   }
	   @Override
	    public String toString() {
	        return title + "\n" + content;
	    }
}
/*
문제 1.
공지사항 등록, 목록, 삭제 기능을 코딩하세요.
삭제 시 제일 오래된 공지사항을 삭제하세요.
공지사항의 등록, 목록, 삭제 상수는 enum을 사용하세요.
*/