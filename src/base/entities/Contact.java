package base.entities;
// Generated Jan 10, 2018 3:32:46 PM by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contact generated by hbm2java
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "Contact", catalog = "HighTechStore")
public class Contact implements java.io.Serializable {

	private int id;
	private String name;
	private String email;
	private String subject;
	private String description;
	private boolean seen;

	public Contact() {
	}

	public Contact(int id, String name, String email, String subject, String description, boolean seen) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.description = description;
		this.seen = seen;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false, length = 250)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Subject", nullable = false, length = 250)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "Description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Seen", nullable = false)
	public boolean isSeen() {
		return this.seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

}