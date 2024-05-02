package com.project.Vertex.service;

import java.util.List;

import javax.security.auth.callback.Callback;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.CallBack;
import com.project.Vertex.entity.Register;

public interface CallBackService {
	
	 List<CallBack> getAllCallbacks();

	CallBack findById(Long callbackId);

	List<CallBack> findCallbacksByUser(Register user);


	 
}
