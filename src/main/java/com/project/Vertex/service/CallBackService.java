package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.CallBack;
import com.project.Vertex.entity.Register;

public interface CallBackService {
	
	 List<CallBack> getAllCallbacks();
	 
	 CallBack saveCallBack(Register register, AuctionEntity auctionEntity);
	 
}
