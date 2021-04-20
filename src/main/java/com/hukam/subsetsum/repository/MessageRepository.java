package com.hukam.subsetsum.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hukam.subsetsum.bean.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String>{
	
	List<Message> findAll();

}
