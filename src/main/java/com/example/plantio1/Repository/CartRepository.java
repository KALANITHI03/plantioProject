package com.example.plantio1.Repository;

import java.util.List;
import java.util.Optional;

import javax.smartcardio.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plantio1.Entity.card;

@Repository
public interface CartRepository extends JpaRepository<card, Long>{
	
	 Optional<card> findByUserIdAndProductId(
	            Long userId,
	            Long productId
	    );

	    List<card> findByUserId(Long userId);
	    

}
