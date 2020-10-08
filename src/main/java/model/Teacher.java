package model;
import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String city;
	@Column
	private int salary;
	@ManyToOne
	@JoinColumn(name="college_id", nullable=false)
	private College college;

	public Teacher() {
		
	}

	public Teacher(String firstName, String lastName, String city, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
    public String toString() {
        return "Teacher: " + this.id + ", " + this.firstName + ", " + this.city;
    }

}
