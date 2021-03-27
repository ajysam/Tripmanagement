package com.cg.tms.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.tms.entities.Customer;
import com.cg.tms.entities.Feedback;
import com.cg.tms.exceptions.CustomerNotFoundException;
import com.cg.tms.exceptions.FeedbackNotFoundException;
import com.cg.tms.exceptions.InvalidFeedbackException;
import com.cg.tms.repository.IFeedbackRepository;

/**
 * unit tests for FeedbackServiceImpl
 */
@ExtendWith(MockitoExtension.class)
public class FeedbackServiceUnitTest {

	@Mock
	IFeedbackRepository feedbackRepository;

	@Mock
	ICustomerService customerService;

	@Spy
	@InjectMocks
	FeedbackServiceImpl feedbackService;

	/**
	 * Test Scenario 1 : Add Feedback
	 */
	@Test
	public void testAddFeedback_1() {
		Feedback feedback = mock(Feedback.class);
		Feedback saved = mock(Feedback.class);
		when(feedbackRepository.save(feedback)).thenReturn(saved);
		doNothing().when(feedbackService).validateFeedback(feedback);
		Feedback result = feedbackService.addFeedback(feedback);
		Assertions.assertNotNull(result);
		Assertions.assertSame(saved, result);
		feedbackRepository.save(feedback);
	}

	/**
	 * Scenario: validateFeedback throws InvalidFeedbackException verifying
	 * InvalidFeedbackException is thrown
	 */
	@Test
	public void testAddFeedback_2() {
		Feedback feedback = mock(Feedback.class);
		doThrow(InvalidFeedbackException.class).when(feedbackService).validateFeedback(feedback);
		Executable executable = () -> feedbackService.addFeedback(feedback);
		Assertions.assertThrows(InvalidFeedbackException.class, executable);
		verify(feedbackRepository, never()).save(feedback);
	}

	/**
	 * Test scenario 2:Feedback not foundById
	 */
	@Test
	public void testFindByFeedbackId_1() {
		int feedbackId = 50;
		Optional<Feedback> optional = Optional.empty();
		when(feedbackRepository.findById(feedbackId)).thenReturn(optional);
		Executable executable = () -> feedbackService.findByFeedbackId(feedbackId);
		Assertions.assertThrows(FeedbackNotFoundException.class, executable);
	}

	/**
	 * scenario : feedback found by id
	 */
	@Test
	public void testFindByFeedbackId_2() {
		int feedbackId = 1;
		Feedback feedback = mock(Feedback.class);
		Optional<Feedback> optional = Optional.of(feedback);
		when(feedbackRepository.findById(feedbackId)).thenReturn(optional);
		Feedback result = feedbackService.findByFeedbackId(feedbackId);
		Assertions.assertEquals(result, feedback);

	}
	/**
	 * Test scenario 3:Feedback found by CustomerId
	 */
	@Test
	public void testFindByCustomerId_1() {
		int customerId=1;
		Customer customer=mock(Customer.class);
		Feedback feedback=mock(Feedback.class);
		when(customerService.viewCustomer(customerId)).thenReturn(customer);
		when(feedbackRepository.findFeedbackByCustomer(customer)).thenReturn(feedback);
		Feedback result = feedbackService.findByCustomerId(customerId);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(result, feedback);
	}
	/**
	 * scenario :Customer not foundById
	 */
	
	@Test
	public void testFindByCustomerId_2() {
		int customerId = 50;
		Optional<Feedback> optional = Optional.empty();
		when(feedbackRepository.findById(customerId)).thenReturn(optional);
		Executable executable = () -> feedbackService.findByCustomerId(customerId);
		Assertions.assertThrows(CustomerNotFoundException.class, executable);
	}
	
	

	/**
	 * Test scenario 4:view all feedback
	 */

	@Test
	public void testViewAllFeedback() {
		List<Feedback> allfeedbacks = mock(List.class);
		when(feedbackRepository.findAll()).thenReturn(allfeedbacks);
		List<Feedback> result = feedbackService.viewAllFeedbacks();
		Assertions.assertSame(allfeedbacks, result);
		verify(feedbackRepository).findAll();

	}

}