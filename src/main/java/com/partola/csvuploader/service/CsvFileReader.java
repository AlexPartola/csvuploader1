package com.partola.csvuploader.service;

import io.reactivex.rxjava3.core.Observable;

import java.io.File;


public interface CsvFileReader<T> {
	
	boolean checkIsCsv(File file);
	
	boolean checkHeaders(File file, Class<T> type);
	
	Observable<T> read(File file);
}
