package com.tekheroes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "byCarrier", query = "from Flight where carrier=:car"),
	@NamedQuery(name = "byRoute", query = "from Flight where source=:src and destiny=:dest")
})
public class Flight {
	@Id
	private int code;
	@Column(length = 20)
	private String carrier;
	@Column(name = "kaha_se", length = 20)
	private String source;
	@Column(name = "kaha_tak", length = 20)
	private String destiny;
	
	public Flight() {
	}
	public Flight(int code, String carrier, String source, String destiny) {
		this.code = code;
		this.carrier = carrier;
		this.source = source;
		this.destiny = destiny;
	}
	
	// Getters and Setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	@Override
	public String toString() {
		return "Flight [code=" + code + ", carrier=" + carrier + ", source=" + source + ", destiny=" + destiny + "]";
	}
	
	
}
