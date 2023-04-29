package in.bushansirgur.springbootthymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pin;
	private String state;
	private String city;
	private String area;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public Address(String pin, String state, String city, String area) {
		super();
		this.pin = pin;
		this.state = state;
		this.city = city;
		this.area = area;
	}

	public Address() {
		super();
	}

	public Address(Long id, String pin, String state, String city, String area, Employee employee) {
		super();
		this.id = id;
		this.pin = pin;
		this.state = state;
		this.city = city;
		this.area = area;
		this.employee = employee;
	}

	public Address(Long id, String pin, String state, String city, String area) {
		super();
		this.id = id;
		this.pin = pin;
		this.state = state;
		this.city = city;
		this.area = area;
	}

	public Address(String pin, String state, String city, String area, Employee employee) {
		super();
		this.pin = pin;
		this.state = state;
		this.city = city;
		this.area = area;
		this.employee = employee;
	}
	

}
