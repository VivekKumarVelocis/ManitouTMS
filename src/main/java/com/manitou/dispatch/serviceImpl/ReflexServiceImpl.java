package com.manitou.dispatch.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manitou.dispatch.constants.ManitouConstants;
import com.manitou.dispatch.controller.ReflexController;
import com.manitou.dispatch.entity.Reflex;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.repository.ReflexRepository;
import com.manitou.dispatch.service.ReflexService;

/*
 * Added by Vivek Kumar
 * */

@Service
public class ReflexServiceImpl implements ReflexService {

	private static final Logger logger = LoggerFactory.getLogger(ReflexServiceImpl.class);

	@Autowired
	private ReflexRepository reflexRepo;

	@Override
	public Reflex saveReflexData(Reflex reflex) {
		try {
			logger.info("saveReflexData()::::: method");
			logger.info("saving data of Invoice");
			if (reflex != null) {
				if (reflex.getCreatedBy() == null) {
					reflex.setCreatedBy("ADMIN");
				}
				Reflex savedReflex = reflexRepo.save(reflex);
				logger.info("reflex data saved successfully !!!!!!!");

				return savedReflex;
			} else {
				logger.error("Error:::::: No data present to save");
				return null;
			}
		} catch (Exception e) {
			logger.error("Error in saveReflexData() method ::::::::::: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	  
	}

	@Override
	public Response getReflexData() {
		try {
			logger.info("getReflexData()::::: method");
			logger.info("getting all the data of Reflex");

			List<Reflex> reflexData = reflexRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));

			if(reflexData.size()==0) {
				logger.error("No record found ");
				return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE, ManitouConstants.NO_RECORD_FOUND);
			}else {
				logger.info("Reflex data is fetched successfully !!!!!!!!");
				return new Response(ManitouConstants.SUCCESS, ManitouConstants.SUCCESS_CODE, reflexData);
			}
			
		} catch (Exception e) {
			logger.error("Error  in getReflexData() method ::: " + e.getMessage());
			e.printStackTrace();
			return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE, e.getMessage());
		}

	}

}
