package com.manitou.dispatch.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manitou.dispatch.constants.ManitouConstants;
import com.manitou.dispatch.controller.InvoiceController;
import com.manitou.dispatch.entity.Invoice;
import com.manitou.dispatch.entity.InvoiceParametersForMatching;
import com.manitou.dispatch.entity.MatchInvoiceItem;
import com.manitou.dispatch.entity.ReflexItemsDetails;
import com.manitou.dispatch.entity.ReflexParameterForMatching;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.repository.InvoiceItemsRepository;
import com.manitou.dispatch.repository.InvoiceRepository;
import com.manitou.dispatch.repository.ReflexItemDetailsRepository;
import com.manitou.dispatch.repository.ReflexRepository;
import com.manitou.dispatch.service.MatchItemDetailsService;

@Service
public class MatchItemDetailsServiceImpl implements MatchItemDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(MatchItemDetailsServiceImpl.class);

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private InvoiceItemsRepository invoiceItemsRepo;

	@Autowired
	private ReflexRepository reflexRepo;

	@Autowired
	private ReflexItemDetailsRepository reflexItemsRepo;

	@Override
	public void matchItemDetails() {
		logger.info("getInvoiceParameters()::::::::method");

		try {
			List<String> listOfinvoiceNum = invoiceItemsRepo.getInvoiceNum();
			logger.info("fetched all the invoice no.");

			if (listOfinvoiceNum.size() != 0) {
				for (String invoiceNum : listOfinvoiceNum) {
					List<InvoiceParametersForMatching> findInviceDetailsForMatch = new ArrayList<>();
					List<MatchInvoiceItem> invoiceItem = new ArrayList<>();
					List<MatchInvoiceItem> reflexItem = new ArrayList<>();

					String packingListNo = null;
					String itemCode = null;
					String quantity = null;

					ArrayList<MatchInvoiceItem> notMatchedItems = null;
					StringBuilder exceptionMsg = new StringBuilder();

					findInviceDetailsForMatch = invoiceRepo.findInviceDetailsForMatch(invoiceNum);
					logger.info("Invoice details are fetched on the basis of invoice number");

					for (InvoiceParametersForMatching invoiceParameters : findInviceDetailsForMatch) {
						packingListNo = invoiceParameters.getPackingListNo();
						itemCode = invoiceParameters.getItemCode();
						quantity = invoiceParameters.getQuantity();

						invoiceItem.add(new MatchInvoiceItem(itemCode, quantity));
					}
					Integer invoiceItemCount = invoiceItemsRepo.getInvoiceItemCount(invoiceNum);
					Integer relfexItemCount = reflexRepo.getReflexItemCount(packingListNo);

					if (invoiceItemCount == relfexItemCount) {

						logger.info("Items count is equal for invoice and reflex");
						List<ReflexParameterForMatching> reflexParameters = getReflexParameters(packingListNo);

						for (ReflexParameterForMatching reflexData : reflexParameters) {
							reflexItem.add(new MatchInvoiceItem(reflexData.getItemCode(), reflexData.getItemQty()));
						}

						Collections.sort(invoiceItem, new MatchInvoiceItem());
						System.out.println("Invoice items details ::::::: " + invoiceItem);

						Collections.sort(reflexItem, new MatchInvoiceItem());
						System.out.println("Reflex items details ::::::: " + reflexItem);

						notMatchedItems = new ArrayList<>(invoiceItem);

						if (invoiceItem.equals(reflexItem)) {
							invoiceRepo.updateMsgAndFlag("Y", "", invoiceNum);
						} else {

							notMatchedItems.removeAll(reflexItem);

							for (MatchInvoiceItem items : notMatchedItems) {
//								exceptionMsg.append(items.getItemCode() + " item code data mismatch ");
								if (exceptionMsg.length() != 0) {
									exceptionMsg.append("~");
								}
								exceptionMsg.append(items.getItemCode());

							}

							if (exceptionMsg.length() != 0) {

								exceptionMsg.append(" item code data mismatch ");
							}
							invoiceRepo.updateMsgAndFlag("N", exceptionMsg.toString(), invoiceNum);
						}

					} else {
						logger.error("Number of items does not match for invoice no." + invoiceNum);
						if (exceptionMsg.length() != 0) {
							exceptionMsg.append("~");
						}

						exceptionMsg
								.append(" Mismatch in no. of items ");
						invoiceRepo.updateMsgAndFlag("N", exceptionMsg.toString(), invoiceNum);
				
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getInvoiceParameters()::::::::" + e.getMessage());

		}
	}

	public List<ReflexParameterForMatching> getReflexParameters(String dipatchList) {
		try {
			logger.info("getReflexParameters()::::::::method");
			List<ReflexParameterForMatching> findReflexDetailsForMatch = new ArrayList<>();
			List<Object[]> list = reflexRepo.findReflexDetailsForMatch(dipatchList);
			String dispatchNo = null;
			String parcelNo = null;
			String itemCode = null;
			String itemQty = null;

			for (Object[] obj : list) {

				dispatchNo = (String) obj[0];
				parcelNo = (String) obj[1];
				itemCode = (String) obj[2];
				itemQty = (String) obj[3];
				findReflexDetailsForMatch.add(new ReflexParameterForMatching(dispatchNo, parcelNo, itemCode, itemQty));
			}
			System.out.println(findReflexDetailsForMatch.toString());
			return findReflexDetailsForMatch;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in getReflexParameters()::::::::" + e.getMessage());
			return null;
		}
	}

}
