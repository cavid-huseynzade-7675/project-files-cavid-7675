+package az.developia.studentregisteraprel11;

public class Student {
private String name;
private String surname;


public Student(String name, String surname) {
	super();
	this.name = name;
	this.surname = surname;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}

}