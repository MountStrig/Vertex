package com.project.Vertex.repository;

import javax.security.auth.callback.Callback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.CallBack;

@Repository
public interface CallBackRepository extends JpaRepository<CallBack, Long>{

	void save(Callback callback);
	 boolean existsByAuctionEntity_IdAndRegister_Id(Long auctionId, Long userId);
	
}
