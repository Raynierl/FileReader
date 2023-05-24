package main;

public class FileValue {
	private String name;
	private int age;
	private String color;
	private String city;
	
	
	public FileValue(String name, String age, String color, String city) {
		this.name = name;
		this.age = Integer.parseInt(age);
		this.color = color;
		this.city = city;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	@Override
	public String toString() {
		return this.getName() + "|" + this.getAge() + "|" + this.getColor() + "|" + this.getCity();
	}
	
}
