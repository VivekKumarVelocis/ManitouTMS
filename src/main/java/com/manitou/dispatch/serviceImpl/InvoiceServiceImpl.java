package com.manitou.dispatch.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manitou.dispatch.constants.ManitouConstants;
import com.manitou.dispatch.entity.Invoice;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.repository.InvoiceRepository;
import com.manitou.dispatch.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	@Autowired
	private InvoiceRepository invoiceRepo;

	@Override
	public Invoice saveInvoiceData(Invoice invoice) {
		try {
			logger.info("saveInvoiceData()::::: method");
			logger.info("saving data of Invoice");
			if (invoice != null) {
				if (invoice.getCreatedBy() == null) {
					invoice.setCreatedBy("ADMIN");
				}
				Invoice savedInvoice = invoiceRepo.save(invoice);
				logger.info("invoice data saved successfully !!!!!!!");

				return savedInvoice;
			} else {
				logger.error("Error:::::: No data present to save");
				return null;
			}
		} catch (Exception e) {
			logger.error("Error in saveInvoiceData() method ::::::::::: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Response getInvoiceData() {
		try {
			logger.info("getInvoiceData() :::::: method");

			List<Invoice> allinvoices = invoiceRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));

			if (allinvoices.size() == 0) {
				return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE,
						ManitouConstants.NO_RECORD_FOUND);
			} else {
				logger.info("Invoice data is fetched successfully !!!!!!!!");
				return new Response(ManitouConstants.SUCCESS, ManitouConstants.SUCCESS_CODE, allinvoices);
			}

		} catch (Exception e) {

			logger.error("Error in getInvoiceData() method ::::::: " + e.getMessage());
			e.printStackTrace();
			return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public Response getInvoicebyInvoiceNo(String invoiceNum) {
		try {
			logger.info("getInvoicebyInvoiceNo() :::::: method");

			Optional<Invoice> invoice = Optional.ofNullable(invoiceRepo.findByInvoiceNum(invoiceNum));

			if (!invoice.isPresent()) {
				logger.error("No record found for invoice number " + invoiceNum);
				return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE,
						ManitouConstants.NO_RECORD_FOUND);
			} else {
				logger.info("Invoice data is fetched successfully for invoice number "+invoiceNum+ " !!!!!!!!");
				return new Response(ManitouConstants.SUCCESS, ManitouConstants.SUCCESS_CODE, invoice);
			}

		} catch (Exception e) {

			logger.error("Error in getInvoicebyInvoiceNo() method ::::::: " + e.getMessage());
			e.printStackTrace();
			return new Response(ManitouConstants.FAILURE, ManitouConstants.ERROR_CODE, e.getMessage());
		}
	}

}
