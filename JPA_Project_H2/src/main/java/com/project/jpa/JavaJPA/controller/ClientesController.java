package com.project.jpa.JavaJPA.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jpa.JavaJPA.model.Cliente;
import com.project.jpa.JavaJPA.repository.Clientes;


@RestController
@RequestMapping("api/JPA/clientes")
public class ClientesController {
	
	@Autowired
	private Clientes clientes;
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente)
	{
		Object atualizar = clientes.findById(id);
		if (atualizar == null) {
			return ResponseEntity.notFound().build();
		}		
		BeanUtils.copyProperties(cliente, atualizar, "id");		
		atualizar = clientes.save(cliente);	
		return ResponseEntity.ok(atualizar);
	}
	
	
}
