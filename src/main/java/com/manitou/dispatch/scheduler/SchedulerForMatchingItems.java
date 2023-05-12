package com.manitou.dispatch.scheduler;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manitou.dispatch.entity.InvoiceParametersForMatching;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.repository.InvoiceItemsRepository;
import com.manitou.dispatch.service.MatchItemDetailsService;

@RestController
public class SchedulerForMatchingItems {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerForMatchingItems.class);

	@Value("${MATCH_ITEMS_DETAILS_STATUS}")
	private boolean matchItemsDetailsStatus;

	@Autowired
	private MatchItemDetailsService matchItemDetailsSerice;

	@Autowired
	private InvoiceItemsRepository invoiceRepo;
	/*
	 * 
	 * this method is invoke to match the items details present in invoice (received
	 * from M3) and the reflex (received from reflex)
	 * 
	 * 
	 */

//	@Scheduled(cron = "${MATCH_ITEMS_DETAILS}")
	@PostMapping("/matchItems")
	public void matchItemsDetails() {
		try {
			if (matchItemsDetailsStatus) {
				logger.info("Scheduler started to match items");
				matchItemDetailsSerice.matchItemDetails();

				System.out.println("Scheduler run successfully !!!!!!!!!");
			} else {
				logger.error("Scheduler is disabled ");

			}
		} catch (Exception e) {
			logger.error("Error while running matchItemsDetails scheduler " + e.getMessage());

		}

	}

//	@PostMapping("/getInvoiceNumber")
//	public ResponseEntity<?> getInvoiceNumber(){
//		
//	List<String> invoiceNum = invoiceRepo.getInvoiceNum();
//	return ResponseEntity.ok(Response.ok(invoiceNum));
//	}
}
