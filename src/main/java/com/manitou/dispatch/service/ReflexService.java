
package com.manitou.dispatch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manitou.dispatch.entity.Reflex;
import com.manitou.dispatch.entity.Response;
import com.manitou.dispatch.entity.ResponseModel;

@Service
public interface ReflexService {

	public Reflex saveReflexData(Reflex reflex);

	public Response getReflexData();
}
