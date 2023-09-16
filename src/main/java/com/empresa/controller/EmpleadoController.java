package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;
import com.empresa.util.AppSettings;
import com.empresa.util.FunctionUtil;

@RestController
@RequestMapping("/url/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Empleado>> listaModalidad(){
		List<Empleado> lista = service.listaEmpleado();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<?> insertaModalidad( @RequestBody Empleado obj, Errors errors){
		Map<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<>();
		salida.put("errores", lstMensajes);
		String fecharegistro = FunctionUtil.getFechaActualStringDateTime();
		obj.setFechaRegistro(fecharegistro);
		Empleado objSalida = service.insertaEmpleado(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		}else {
			lstMensajes.add("Se registró la modalidad de ID ==> " + objSalida.getIdEmpleado());
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
