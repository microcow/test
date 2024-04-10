package cha21;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Ex03ObjectStreamstest {
	public static void main(String[] args) {
		try (
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream("src/cha21/Ex03parktest.txt")));
				) {
			Car2 car1 = new Car2("A 자동차");
			Car2 car2 = new Car2("B 자동차");
			Parking park = new Parking();
			park.add(car1);
			park.add(car2);
			out.writeObject(park); 	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream("src/cha21/Ex03parktest.txt")));
				) {
			Parking parknow = (Parking)in.readObject();
			System.out.println(parknow.getCars());	        		        	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
class Car2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private String carname;
	
	public Car2(String carname) {
		this.carname = carname;
	}
	@Override
	public String toString() {
		return "주차 중인 차 = " + carname;
	}
	
}

class Parking implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Car2> cars = new ArrayList<>();
	public void add(Car2 car) {
		cars.add(car);
	}
	public void print() {
		System.out.println(cars);
	}
	public List<Car2> getCars() {
		return cars;
	}
	
}
/*
문제 1.
두 대의 차를 주차장에 주차하는 코드를 작성하세요.
주차장 인스턴스를 파일에 쓴 뒤 다시 읽어 와 주차장의 상태를 출력하세요.
*/