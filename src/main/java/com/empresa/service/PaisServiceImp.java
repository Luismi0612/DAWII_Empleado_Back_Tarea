package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Pais;
import com.empresa.repository.PaisRepository;

@Service
public class PaisServiceImp implements  PaisService {

	@Autowired
	private PaisRepository repoPais;
	
	@Override
	public List<Pais> listaPais() {
		// TODO Auto-generated method stub
		return repoPais.findAll();
	}

}
