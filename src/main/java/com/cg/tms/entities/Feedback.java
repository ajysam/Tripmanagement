package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Feedback {
	@GeneratedValue
	@Id
	private int feedbackId;

	@OneToOne
	@Column(nullable = false)
	private Customer customer;
	private String feedback;
	private int rating;

	@Column(nullable = false)
	private LocalDate submitDate;

	public Feedback( String feedback, int rating) {

		this.feedback = feedback;
		this.rating = rating;
	
	}

	public Feedback() {
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

}
