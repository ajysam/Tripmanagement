package com.cg.tms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.exceptions.InvalidFeedbackException;
import com.cg.tms.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private IFeedbackRepository repo;
    @Autowired
    private ICustomerService customerService;


    LocalDate currentDate() {
        return LocalDate.now();
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        validateFeedback(feedback);
        feedback.setSubmitDate(currentDate());
        Feedback save = repo.save(feedback);
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
        Customer customer = customerService.viewCustomer(customerId);
        if(customer==null){
            throw new CustomerNotFoundException("customer not found for id="+customerId);
        }
        Feedback feedback = repo.findFeedbackByCustomer(customer);
        return feedback;
    }

    @Override
    public List<Feedback> viewAllFeedbacks() {
        List<Feedback> feedbacks = repo.findAll();
        return feedbacks;
    }

    void validateFeedback(Feedback feedback) {
        if (feedback.getCustomer() == null) {
            throw new InvalidFeedbackException("customer can't be null");
        }
    }

}
