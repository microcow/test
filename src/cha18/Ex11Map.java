package cha18;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class Ex11Map {
	public static void main(String[] args) {
		Employee e1 = new Employee("A");
		e1.addSkill(new Skill("자바", 3));
		e1.addSkill(new Skill("DB", 2));
		
		Employee e2 = new Employee("B");
		e2.addSkill(new Skill("파이썬", 2));
		e2.addSkill(new Skill("DB", 3));
		
		Employee e3 = new Employee("C");
		e3.addSkill(new Skill("JS", 2));
		e3.addSkill(new Skill("AWS", 1));
		
		List<Employee> team1 = new ArrayList<>();
		team1.add(e1);
		team1.add(e2);
		team1.add(e3);
		
		Employee e4 = new Employee("D");
		e4.addSkill(new Skill("자바", 2));
		e4.addSkill(new Skill("Linux", 3));
		
		Employee e5 = new Employee("E");
		e5.addSkill(new Skill("Vue", 3));
		
		Employee e6 = new Employee("F");
		e6.addSkill(new Skill("안드로이드", 2));
		e6.addSkill(new Skill("IOS", 3));
		e6.addSkill(new Skill("React", 1));
		
		List<Employee> team2 = new ArrayList<>();
		team2.add(e4);
		team2.add(e5);
		team2.add(e6);
		
		Company company = new Company();
		company.addTeam("A", team1);
		company.addTeam("B", team2);
		
		company.printTeamAll();
	}

}

class Company {
	Map<String, List<Employee>> teamMap;
	public Company() {
		teamMap = new HashMap<>(); 
	}
	public void addTeam(String teamName, List<Employee> team) {
		teamMap.put(teamName, team);
	}
	public void printTeamAll() {
		for (Entry<String, List<Employee>> entry : teamMap.entrySet()) {
			// Ex10에는 Map.Entry로 사용하였지만 Map.은 생략 후 Entry만 사용해도 된다
			for (Employee emp : entry.getValue()) {
				System.out.println(emp.getName());
				for (Skill s : emp.getSkills()) {
					System.out.println(s.getName() + ", " + s.getLevel());
				}
				System.out.println("---");
			}
			
		}
	}
}

class Employee {
	private String name;
	private List<Skill> skills;
	public Employee(String name) {
		this.name = name;
		skills = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void addSkill(Skill skill) {
		skills.add(skill);
	}
}

class Skill {
	private String name;
	private int level;
	public Skill(String name, int level) {
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
