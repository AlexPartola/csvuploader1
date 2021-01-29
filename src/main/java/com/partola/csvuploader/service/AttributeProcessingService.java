package com.partola.csvuploader.service;

import com.partola.csvuploader.domain.AttributeDO;
import com.partola.csvuploader.domain.ImportFileDO;
import com.partola.csvuploader.factory.ObjectFactory;
import com.partola.csvuploader.repository.SuperRepository;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
class AttributeProcessingService implements ProcessingService {
	
	@Autowired
	private CsvFileReader<AttributeDO> csvFileReader;
	
	@Autowired
	private SuperRepository<AttributeDO> attributeRepository;
	
	@Autowired
	private SuperRepository<ImportFileDO> importFileRepository;
	
	@Autowired
	private ObjectFactory objectFactory;
	
	@Override
	public ImportFileDO process(File file) {
		
		ImportFileDO importFileDO = objectFactory.createImportFileDO();
		final ImportFileDO importFileDOCreated = importFileRepository.put(importFileDO);
		
		Observable.just(file)
				.observeOn(Schedulers.io())
				.filter(csvFileReader::checkIsCsv)
				.filter(file1 -> csvFileReader.checkHeaders(file1, AttributeDO.class))
				.flatMap(csvFileReader::read)
				.forEach(attributeDO -> attributeRepository.put(attributeDO));
		
		return importFileDOCreated;
	}
}
