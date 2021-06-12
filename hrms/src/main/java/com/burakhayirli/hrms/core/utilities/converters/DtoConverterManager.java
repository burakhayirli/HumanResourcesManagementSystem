/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.converters;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConverterManager implements DtoConverterService{
	
	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass){
		return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
		
	}
	
	@Override
	public <T> Object dtoClassConverter(Object source,Class<T> baseClass) {
		return modelMapper.map(source,baseClass);
		
	}
}
	