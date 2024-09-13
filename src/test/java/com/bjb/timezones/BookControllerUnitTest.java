package com.bjb.timezones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bjb.timezones.controller.TimezoneController;
import com.bjb.timezones.services.TimezoneService;

@SpringBootTest
public class BookControllerUnitTest {

	// moking the service
	@Mock
	private TimezoneService timeZoneService;

	// this annotation means mocks objects will be injected during his execution
	@InjectMocks
	private TimezoneController timeZoneController;

	@Test
	public void testTimeZones() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		ResponseEntity<List<String>> responseEntity = timeZoneController.getTimezones();
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

}