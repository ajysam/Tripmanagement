package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
public interface IFeedbackRepository extends JpaRepository<Feedback,Integer> {

    Feedback findFeedbackByCustomer(Customer customer);
}
