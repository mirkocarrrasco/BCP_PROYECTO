package com.bcp.tipocambioweb.service;

import java.util.List;

import com.bcp.tipocambioweb.dto.TipoCambioDTO;

public interface TipoCambioService {

	public List<TipoCambioDTO> listarTodos();

	public TipoCambioDTO obtenerUno(int codigo);

	public void insertar(TipoCambioDTO ce);

	public void modificar(TipoCambioDTO ce);

	public void eliminar(int codigo);	
	
}
