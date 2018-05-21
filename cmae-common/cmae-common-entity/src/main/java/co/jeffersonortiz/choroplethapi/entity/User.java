package co.jeffersonortiz.choroplethapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import co.jeffersonortiz.choroplethapi.entity.util.AbstractEntity;

/**
 * 
 * @author <a href="mailto:me@jeffersonortiz.com">Jefferson Ortiz Quiroga</a>
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User implements AbstractEntity {
	
	/**
	 *  Serialize Data
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Type(type = "objectid")
    private String id;
	@Column(name="idenfitification")
	private String identification;
	@Column(name="name")
	private String name;
	@Column(name="nationality")
	private String nationality;
	@Column(name="sex")
	private String gender;
	@Column(name="date_of_birth")
	private Date birthday;
	
	/**
	 * Default constructor
	 */
	public User() {}
	
	public void setLazyHibernateSetup() {}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
