package ch04.com.dao;

public class Person {
	private int id;
	private String name;

	public Person() {
		id = 20181004;
		name = "홍길순";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}