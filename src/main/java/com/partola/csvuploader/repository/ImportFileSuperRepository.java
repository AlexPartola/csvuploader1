package com.partola.csvuploader.repository;

import com.partola.csvuploader.domain.ImportFileDO;
import org.springframework.stereotype.Repository;

@Repository
public class ImportFileSuperRepository implements SuperRepository<ImportFileDO> {
	
	@Override
	public ImportFileDO get(String id) {
		System.out.println("putting into repository");
		return null;
	}
	
	@Override
	public ImportFileDO put(ImportFileDO attributeDO) {
		System.out.println("putting into repository");
		return attributeDO;
	}
}
