package com.bcp.tipocambio.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.tipocambio.dao.entity.TipoCambioEntity;
import com.bcp.tipocambio.service.TipoCambioService;

@RestController
public class TipoCambioRestController {

	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping(path = "/tiposcambio")
	public List<TipoCambioEntity> listarTodos() {
		return tipoCambioService.listarTodos();
	}
	
	@GetMapping(path = "/tiposcambio/{id}")
	public TipoCambioEntity obtenerUno(@PathVariable(value = "id") int codigo) {
		return tipoCambioService.obtenerUno(codigo);
	}
	
	@PostMapping("/tiposcambio")
	public void insertar(@RequestBody TipoCambioEntity ce) {
		tipoCambioService.insertar(ce);
	}
	
	@PutMapping("/tiposcambio/{id}")
	public void modificar(@RequestBody TipoCambioEntity ce, @PathVariable(value = "id") int codigo) {
		ce.setIdtipocambio(codigo);
		tipoCambioService.modificar(ce);
	}
	
	@DeleteMapping("/tiposcambio/{id}")
	public void eliminar(@PathVariable(value = "id") int codigo) {
		tipoCambioService.eliminar(codigo);
	}
}
