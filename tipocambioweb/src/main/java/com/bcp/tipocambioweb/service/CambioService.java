package com.bcp.tipocambioweb.service;

public interface CambioService {

	public Double calcularMonto(int idMonedaOrig, int idMonedaDest, double montoOrig);
}
