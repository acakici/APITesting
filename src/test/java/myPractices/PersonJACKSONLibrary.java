package myPractices;

public class PersonJACKSONLibrary {

	String name;
	int age;
	
	
	
	public PersonJACKSONLibrary() {
		
	}
	
	
	public PersonJACKSONLibrary(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonJACKSONLibrary [name=" + name + ", age=" + age + "]";
	}
	
	
	
}