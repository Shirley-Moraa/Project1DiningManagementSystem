package com.springboot.springbootproject1dms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seniors")
public class Senior {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String foodConstraint;
    private int age;
    
    public Senior() {
    	
    }

    public Senior(long id, String firstName, String lastName, String emailId, String foodConstraint, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.foodConstraint = foodConstraint;
		this.age = age;
	}
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	 @Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "foodConstraint", nullable = false)
	public String getFoodConstraint() {
		return foodConstraint;
	}

	public void setFoodConstraint(String foodConstraint) {
		this.foodConstraint = foodConstraint;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
	@Override
    public String toString() {
        return "Senior [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", foodConstraint=" + foodConstraint + ", age="
 +  age    + "]";
    }
 
	
    

}
