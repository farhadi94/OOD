package main.java.controller;

import java.sql.Date;

import javax.persistence.*;

import org.apache.poi.util.Beta;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	@Column(unique = true)
	private String username;
    private String password;
    private String name;
    private String email;
    private Date birthDate;
    private boolean isAdmin;
    
    public User() {
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, username='%s', password='%s']",
                id, username, password);
    }
}