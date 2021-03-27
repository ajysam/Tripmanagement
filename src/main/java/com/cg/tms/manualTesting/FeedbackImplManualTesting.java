
 package com.cg.tms.manualTesting;
 

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.exceptions.InvalidFeedbackException;
import com.cg.tms.service.ICustomerService;
import com.cg.tms.service.IFeedbackService;

@Component
public class FeedbackImplManualTesting {

	@Autowired
	private IFeedbackService service;
	@Autowired
	private ICustomerService service1;

	public void start() {
		try {
			Feedback feed = new Feedback();
			LocalDate currentDate = LocalDate.now();
			feed.setRating(5);
			feed.setFeedback("Healthy and Hygenic");

			Feedback feeded = service.addFeedback(feed);
			System.out.println("Feedback has been created");
			display(feeded);

			Feedback feed1 = new Feedback();
			feed1.setSubmitDate(currentDate);
			feed1.setRating(3);
			feed1.setFeedback("Average,Needs Improvement");
			
			Feedback feeded1 = service.addFeedback(feed1);
			display(feeded1);
			
			Feedback feed2=new Feedback();
			feed2.setFeedback("FeedbackID");
			
			Feedback feeded2=service.findByFeedbackId(5);
			display(feeded2);
			System.out.println("Feedbackid is 5");
			
	/*		Customer customer=new Customer();
			feed1.setCustomer(customer);
			
			Customer cust=service1.findByCustomerId(feed1.getCustomer().getCustomerId());
			display(cust);
			System.out.println("Customer is 2");
			*/
			
			System.out.println("Display all Feedbacks");
			List<Feedback> feedbacks = service.viewAllFeedbacks();
			displayAll(feedbacks);

		} catch (FeedbackNotFoundException e) {
			System.out.println("Feedback not found");
		} catch (InvalidFeedbackException e) {
			System.out.print("InvalidFeedback exception");

		}

	}

	void display(Feedback feeded) {
		System.out.println(feeded.getFeedbackId() + " " + feeded.getRating() + " "
				+ feeded.getFeedback() + " " + feeded.getSubmitDate());

	}
	void display(Customer cust) {
		System.out.println( " "+ cust.getCustomerId());

	}

	void displayAll(Collection<Feedback> feedbacks) {
		for (Feedback feed : feedbacks) {
			display(feed);
		}
	}
}

