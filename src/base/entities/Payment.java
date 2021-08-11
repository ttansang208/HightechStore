package base.entities;
// Generated Dec 23, 2017 8:53:57 AM by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Payment generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "Payment", catalog = "HighTechStore")
public class Payment implements java.io.Serializable {

	private int id;
	private String payment;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public Payment() {
	}

	public Payment(int id, String payment) {
		this.id = id;
		this.payment = payment;
	}

	public Payment(int id, String payment, Set<Orders> orderses) {
		this.id = id;
		this.payment = payment;
		this.orderses = orderses;
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

	@Column(name = "Payment", nullable = false, length = 250)
	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "payment")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}