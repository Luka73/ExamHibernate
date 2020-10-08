package model;
import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
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
	private String program;
	@ManyToOne
	@JoinColumn(name="college_id", nullable=false)
	private College college;


	public Student() {
		
	}
	
	
	public Student(String firstName, String lastName, String city, String program) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.program = program;
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
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
    public String toString() {
        return "Student: " + this.id + ", " + this.firstName + ", " + this.city;
    }
}
