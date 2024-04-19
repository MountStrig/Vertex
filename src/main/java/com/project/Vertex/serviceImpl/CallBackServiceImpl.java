package com.project.Vertex.serviceImpl;

import java.util.List;

import org.hibernate.jpa.event.spi.CallbackRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.CallBack;
import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.CallBackRepository;
import com.project.Vertex.service.CallBackService;

@Service
public class CallBackServiceImpl implements CallBackService{
		
		@Autowired
		private CallBackRepository callBackRepository;
	
		@Override
		public List<CallBack> getAllCallbacks() {
			// TODO Auto-generated method stub
			return callBackRepository.findAll();
		}

		 @Override
		    public CallBack saveCallBack(Register register, AuctionEntity auctionEntity) {
		        // Create a new CallBack instance
		        CallBack callBack = new CallBack(null, auctionEntity, register);
		        callBack.setRegister(register);
		        callBack.setAuctionEntity(auctionEntity);

		        // Save the CallBack entity
		        return callBackRepository.save(callBack);
		    }
	
		
}
