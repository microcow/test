package cha17;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Ex03SubType {
	
	public static void main(String[] args) {
		// List<Content> musicList = new ArrayList<Music>();	// error
		List<Music> musicList = new ArrayList<Music>(); // 업캐스팅 (ArrayList<Music> musicList = new ArrayList<Music>(); 로 적어도 되지만 List로 적는데 범용성이 좋다)
		// ArrayList는 List인터페이스를 구현하고 있기에 ArrayList는 sub타입이다.
		// 그러나, 제네릭스 타입(<Music>)은 sub타입이 적용되지 않는다 (일치해야함)
		// Music 타입 인스턴스를 배열로 저장할 수 있는 musicList란 인스턴스 생성
		musicList.add(new Music("노래1"));
		musicList.add(new Music("노래2"));
		/// add 메소드에 아규먼트로 Music클래스의 인스턴스를 생성하며 문자열을 집어넣으니 musicList에 추가됐다??
		
		// PECS: Producer Extends, Consumer super (extends 와일드카드는 읽어서 제공만 하는 기능이고, super 와일드 카드는 소모(수정)하는 기능이다)
		Player.play(musicList);
				
		Player.addRecommendedContent(musicList);
		Player.play(musicList);
		
		List<Content> contents = new ArrayList<Content>();
		contents.add(new Music("노래3"));
		contents.add(new Music("노래4"));
		
		Player.play(contents);
		
		Player.addRecommendedContent(contents);
		Player.play(contents);
		
		List<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie("영화1"));
		movieList.add(new Movie("영화2"));
		
		Player.play(movieList);
		
		//Player.addRecommendedContent(movieList);	// error (1)
		//Player.play(movieList);
		
		Movie movie = new Movie("무비");
		
		
		Player.<Music>play(new Music("음악1"));
		// ★ 메서드를 호출할 때 제너릭 메소드를 넘겨줄 수 있다 /// (static 메소드에 한해?) 	
		Player.play(new Movie("무비1"));
		// ★★ 굳이 제너릭 메소드를 적지 않아도 아규먼트로 인스턴스를 생성(메모리만 있고 형체는 없는 인스턴스)하며 넘겨주고 있기에 메소드 내 T가 movie 클래스임을 특정할 수 있으므로 생략이 가능하다.
		/// <Movie>를 생략해도 괜찮은 이유는 원래 적어야하지만 java에서 자동으로 처리해주기 때문?
		Player.play(movie);
		// ★★ 마찬가지로, 아규먼트로 new Movie()와 같이 인스턴스를 생성하며 넘겨줘도 되지만 인스턴스 자체를 넘겨주어도 T가 movie 클래스임을 특정할 수 있으므로 제너릭 메소드 부분 생략이 가능하다
		
		
		Player.play(movieList);
		/// ★ Player.play(new Movie("무비1")); 코드와 차이점? → movieList는 List인터페이스 소속 인스턴스임 new Movie();는 Movie클래스임
		
		Music.removeContent(contents);
	}

}


class Player {
	// 제너릭스 오버로딩 안됨
	/*
	public static void play(List<Content> playList) {
		for (Content c : playList) {
			System.out.println("재생: " + c.getTitle());
		}
	}
	
	public static void play(List<Music> playList) {
		for (Content c : playList) {
			System.out.println("재생: " + c.getTitle());
		}
	}*/

	// Producer Extends (read) 읽기 전용
	public static void play(List<? extends Content> playList) {
		// ★★ <? extends 클래스or인터페이스> : extends 와일드카드이다. 이는 Content인터페이스를 구현하고있는 클래스는 뭐든 입력이 가능하다.
		// ★★ 인터페이스나 클래스 상관없이 와일드카드에선 extends를 적어야한다.
		// ★★ 단, extends 키워드를 사용했을 땐 playList는 읽기 전용이 된다 (상한 와일드카드 이기에, 자식클래스의 특정 타입을 품을 수 없을수 있기에 수정 불가)
		/// Content 인터페이스의 자식 인터페이스를 구현하고 있는 클래스도 입력 가능? : yes (<K extends T> = T와 T자식클래스만 입력 가능)
		// extends 키워드를 사용한 와일드카드를 상한 와일드카드라 부른다.
		for (Content c : playList) { // ★★ 타입으론 와일드 카드<? extends Content>는 설정이 불가하므로 Content로 기입
			System.out.println("재생: " + c.getTitle());
		}
		System.out.println();
		
		// playList.add(new Music("노래")); 읽기 전용이므로 내용 수정 (추가삭제) 불가
		// 제네릭스는 컴파일 타임에 오류를 잡을 수 있도록 해줍니다.
		// Music 타입인지 Movie 타입인지는 런타임이 돼서야 알 수 있기 때문에 제네릭스는 이를 허용하지 않습니다.
	}
	
	// Consumer Super (write)
	public static void addRecommendedContent(List<? super Music> playList) {
		// ★★ super 와일드카드이다. 이는 Music클래스 혹은 Music의 부모(상위)클래스, Music클래스가 구현하고 있는 인터페이스 타입만 입력 가능하다.
		// ★★ 단, super 키워드를 사용했을 땐 playList는 쓰기 전용이 된다 (하한 와일드카드 이기에, 부모클래스의 모든 타입을 품을 수 있기에 수정 가능)
		// 물론 읽기도 가능함
		// super 키워드를 사용한 와일드카드를 하한 와일드카드라 부른다

		Music music = new Music("인공지능추천음악1");
		playList.add(music);
		
		// playList.add(new Movie("영화1"));		// 컴파일러가 에러를 잡아낼 수 있습니다.
		
	}
	
	// 제한된 타입 파라미터
	/*
	public static <T> void play(T content) { // 이처럼 T가 받을 타입을 한정짓지 않는다면 T는 Object클래스가 되며 모든 클래스를 다 받을 수 있다
		System.out.println(content.getTitle());	// 그렇게 될 경우 호출하고자 하는 getTitle이 어떤 getTitle인지 한정지을 수 없기에 에러 발생 
	}
	*/
	public static <T extends Content> void play(T content) {
		// ★ content 인터페이스를 구현하고있는 클래스나 인터페이스를 받고있다
		// T는 extends Content를 통해 받을 수 있는 타입을 한정짓고 있다(제한된 제네릭스 윗부분 설명 참고)
		/// 메소드 호출 시 제너릭 메소드를 적지 않아도 되는데 <T extends Content> 이 부분을 지우면 컴파일에러 발생하는 이유? 원래 호출 시 적어야하는데 java에서 자동으로 제너릭 메소드를 적어주기 때문?
		System.out.println(content.getTitle());
		System.out.println();
	}
}

interface Content {
	public abstract String getTitle();
}

class Movie implements Content {
	private String title;
	private String writer;
	private String director;
	
	public Movie(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}

class Music implements Content {
	private String songTitle;
	private String songWriter;
	private String lyricist;
	
	public Music(String songTitle) {
		this.songTitle = songTitle;
	}

	@Override
	public String getTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongWriter() {
		return songWriter;
	}
	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}

	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	/* public static <T extends Content> void removeWithIterator(T books) {
		for (Iterator<T> it = books.iterator(); it.hasNext(); ) {
			Music book = it.next(); 
			if 
				
				it.remove(); 
		}
	}*/
	
	// 문제 1
	public static void removeContent(List<? extends Content> playList) {
		playList.remove(playList.size()-1);
		 for (Content c : playList) { // ★★ 파라미터로 받을 때 빼곤 타입으론 와일드 카드<? extends Content>의 설정이 불가하므로 Content로 기입
			System.out.println(c.getTitle());
		}
		/* playList.getTitle(); = palyList는 List 소속이기에 getTitle(); 메소드를 호출하지 못함 이에 Music클래스가 구현하고 있는 Content 인터페이스의
		  인스턴스로 playList를 옮긴 후(for : 문을 통해 c로 옮김) Content 인터페이스를 구현하고 있는 Music클래스가 getTitle 메소드를 오버라이딩 하고 있기에 출력  */
	}
}
/*
문제 1.
마지막 컨텐츠를 삭제하는 기능을 플레이어에 추가하세요.

문제 2.
컨텐츠를 거꾸로 출력하세요.
힌트) Collections.reverse()
*/