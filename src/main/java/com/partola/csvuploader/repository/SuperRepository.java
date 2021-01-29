package com.partola.csvuploader.repository;

public interface SuperRepository<T> {
	
	T get(String id);
	
	T put(T attributeDO);
}
