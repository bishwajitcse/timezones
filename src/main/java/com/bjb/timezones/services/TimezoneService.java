package com.bjb.timezones.services;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TimezoneService {

	private static final Logger log= LoggerFactory.getLogger(TimezoneService.class.getName());
	
	public List<String> getTimezones() {
		List<String> timeZones= ZoneId.getAvailableZoneIds().stream()
				.sorted() // Sort alphabetically by name
				.collect(Collectors.toList());
		
		log.info("Total {} timezones found.",timeZones.size());
		return timeZones;
	}
}
