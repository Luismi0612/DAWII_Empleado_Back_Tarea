package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empleado;
import com.empresa.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	@Autowired
	private EmpleadoRepository repoEmp;
	
	
	@Override
	public Empleado insertaEmpleado(Empleado obj) {
		// TODO Auto-generated method stub
		return repoEmp.save(obj);
	}

	@Override
	public List<Empleado> listaEmpleado() {
		// TODO Auto-generated method stub
		return repoEmp.findAll();
	}

}
