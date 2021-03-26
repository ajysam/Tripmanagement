package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;

public interface IFeedbackService {
	
	
		public Feedback  addFeedback(Feedback feedback);
		public Feedback   findByFeedbackId(int feedbackId) throws FeedbackNotFoundException;
		public Feedback   findByCustomerId(int customerId) throws CustomerNotFoundException;
		public List<Feedback> viewAllFeedbacks();
	
	

}
