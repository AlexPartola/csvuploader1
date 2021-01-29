package com.partola.csvuploader.repository;

import com.partola.csvuploader.domain.AttributeDO;
import org.springframework.stereotype.Repository;

@Repository
public class AttributeSuperRepository implements SuperRepository<AttributeDO> {
	
	@Override
	public AttributeDO get(String id) {
		System.out.println("getting from repository");
		return null;
	}
	
	@Override
	public AttributeDO put(AttributeDO attributeDO) {
		System.out.println("putting into repository");
		return attributeDO;
	}
}
