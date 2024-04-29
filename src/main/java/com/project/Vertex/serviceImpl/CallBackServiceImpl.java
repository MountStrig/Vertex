package com.project.Vertex.serviceImpl;

import java.util.List;

import javax.security.auth.callback.Callback;

import org.hibernate.jpa.event.spi.CallbackRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.CallBack;
import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.AuctionEntityRepository;
import com.project.Vertex.repository.CallBackRepository;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.service.CallBackService;

import jakarta.transaction.Transactional;

@Service
public class CallBackServiceImpl implements CallBackService{
		
		@Autowired
		private CallBackRepository callBackRepository;
		
		@Autowired
		RegisterRepository registerRepository;
		
		@Autowired
		AuctionEntityRepository auctionEntityRepository;
	
		@Override
		public List<CallBack> getAllCallbacks() {

			return callBackRepository.findAll();
		}

		 @Override
		    public CallBack findById(Long id) {
		        return callBackRepository.findById(id).orElse(null);
		    }

		 
		
		 
		

		  


		
}
