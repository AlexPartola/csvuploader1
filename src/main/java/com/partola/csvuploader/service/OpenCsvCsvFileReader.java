package com.partola.csvuploader.service;

import io.reactivex.rxjava3.core.Observable;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class OpenCsvCsvFileReader<T> implements CsvFileReader<T> {
	
	@Override
	public boolean checkIsCsv(File file) {
		System.out.println("checking csv");
		return true;
	}
	
	@Override
	public boolean checkHeaders(File file, Class<T> type) {
		
		return true;
	}
	
	@Override
	public Observable<T> read(File file) {
		System.out.println("reading a file");
		return Observable.empty();
	}
}
