package com.cg.tms.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.tms.entities.Feedback;
import com.cg.tms.entities.Package;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.repository.IFeedbackRepository;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceUnitTesting {

	@Mock
	IFeedbackRepository feedbackrepository;

	@Spy
	@InjectMocks
	IFeedbackImpl feedbackService;

	/**
	 * Test Scenario 1 : Add package successfully
	 */
	@Test
	public void testAdd_feedback() {

		String feedback = "Very good";
		int rating = 5;

		Feedback feeds = new Feedback(feedback, rating);
		Mockito.when(feedbackrepository.save(feeds)).thenReturn(feeds);
		Feedback result = feedbackService.addFeedback(feeds);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(feedback, result.getFeedback());
		Assertions.assertEquals(rating, result.getRating());

	}

	/**
	 * Test scenario 2:Feedback not foundById
	 */
	@Test
	public void testSearch_feedbackByIdnotfound() {

		int feedbackId = 50;
		Optional<Feedback> optional = Optional.empty();
		when(feedbackrepository.findById(feedbackId)).thenReturn(optional);
		Executable executable = () -> feedbackService.findByFeedbackId(feedbackId);
		Assertions.assertThrows(FeedbackNotFoundException.class, executable);
	}
	
	/** 
	 * Test scenario 3:Feedback Customer Found
	 */
	@Test
	public void testSearch_feedbackByIdfound () {
		int feedbackId=1;
		Feedback feedback=mock(Feedback.class);
		Optional<Feedback> optional= Optional.of(feedback);
		when(feedbackrepository.findById(feedbackId)).thenReturn(optional);
		Feedback result= feedbackService.findByFeedbackId(feedbackId);
		Assertions.assertEquals(result,feedback);
		
		}
	 

	/**
	 * Test scenario 4:view all feedback
	 */

	@Test
	public void ViewAllfeedback() {
		List<Feedback> allfeedbacks = mock(List.class);
		when(feedbackrepository.findAll()).thenReturn(allfeedbacks);
		List<Feedback> result = feedbackService.viewAllFeedbacks();
		Assertions.assertSame(allfeedbacks, result);
		verify(feedbackrepository).findAll();

	}

}