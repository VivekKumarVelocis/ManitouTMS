package com.manitou.userauth.service;

import org.springframework.stereotype.Service;

import com.manitou.userauth.entity.Branch;
import com.manitou.userauth.entity.Response;

@Service
public interface BranchService {
	
	public Response findAllBranch() throws Exception;
	public Response getBranchById(String branchId) throws Exception;
}
