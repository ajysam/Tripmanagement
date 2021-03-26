package com.cg.tms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;

@Service
public class IFeedbackImpl implements IFeedbackService {

	@Autowired
	private IFeedbackRepository repo;

	@Override
	public Feedback addFeedback(Feedback feedback) {

		Feedback save=repo.save(feedback);

		return save;
	}

	@Override
	public Feedback findByFeedbackId(int feedbackId) throws FeedbackNotFoundException {
		Optional<Feedback> optional = repo.findById(feedbackId);
		if (!optional.isPresent()) {
			throw new FeedbackNotFoundException("Feedback is not found");
		}
		return optional.get();

	}

	@Override
	public Feedback findByCustomerId(int customerId) throws CustomerNotFoundException {
		Optional<Feedback> optional = repo.findById(customerId);
		if (!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer is not found");
		}
		return optional.get();
	}

	@Override
	public List<Feedback> viewAllFeedbacks() {
		List<Feedback> feedbacks=repo.findAll();
		return feedbacks;
	}
}
