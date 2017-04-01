package com.filipe.task.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date registered;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date edited;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date concluded;

	private Boolean conclude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Date getEdited() {
		return edited;
	}

	public void setEdited(Date edited) {
		this.edited = edited;
	}

	public Date getConcluded() {
		return concluded;
	}

	public void setConcluded(Date concluded) {
		this.concluded = concluded;
	}

	public Boolean getConclude() {
		return conclude;
	}

	public void setConclude(Boolean conclude) {
		this.conclude = conclude;
	}

	public String getConcludeString() {
		if (conclude)
			return "Sim";
		return "Não";
	}
}
