package com.manitou.dispatch.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manitou.dispatch.constants.ManitouConstants;
import com.manitou.dispatch.entity.Reflex;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.service.ReflexService;

@RestController
public class ReflexController {

	private static final Logger logger = LoggerFactory.getLogger(ReflexController.class);

	@Autowired
	private ReflexService reflexService;

	@PostMapping("/getReflexData")
	public ResponseEntity<Response> getReflexData() {
		try {
			logger.info("getReflexData():::::: method called to get the reflex data");

			Response response = reflexService.getReflexData();

			if(response.getStatus()==ManitouConstants.FAILURE) {
				return ResponseEntity.ok(Response.error("No Record Found"));
			}else {
				return ResponseEntity.ok(Response.ok(response));
			}
			
		} catch (Exception e) {
			logger.error("Error in getReflexData() method :::: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));

		}
	}

	@PostMapping(value = "/saveReflexData")
	public ResponseEntity<Response> saveReflexData(@Valid @RequestBody Reflex reflex) {
		try {
			logger.info("saveReflexData()::::::::: method called to save the Reflex data");

			Reflex saveReflexData = reflexService.saveReflexData(reflex);

			return ResponseEntity.ok(Response.ok(saveReflexData));
		} catch (Exception e) {
			logger.error("Exception in saveReflexData() method :::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}

	}
}
