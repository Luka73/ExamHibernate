package model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="college")
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String collegeName;
	
	@OneToMany(mappedBy = "college", fetch = FetchType.EAGER)
	Set<Student> students;
	
	@OneToMany(mappedBy = "college", fetch = FetchType.EAGER)
	Set<Teacher> teachers;

	public College() {
		
	}

	public College(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	@Override
    public String toString() {
        return "College: " + this.collegeName;
    }
}
