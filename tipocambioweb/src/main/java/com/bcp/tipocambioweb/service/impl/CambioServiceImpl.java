package com.bcp.tipocambioweb.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcp.tipocambioweb.dto.MonedaDTO;
import com.bcp.tipocambioweb.service.CambioService;

@Service
public class CambioServiceImpl implements CambioService {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;
	
    public CambioServiceImpl() {
        /*
    	String username = "usrServer";
        String password = "usrClave";
        headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        request = new HttpEntity<String>(headers);*/
    	request = null;
    }
    
    
	@Override
	public Double calcularMonto(int idMonedaOrig, int idMonedaDest, double montoOrig) {
		RestTemplate plantilla = new RestTemplate();
        //http://localhost:8013/cambio/1/2/1000
		ResponseEntity<Double> resultado = plantilla.exchange(backendURL + "/cambio/" + idMonedaOrig + "/" + idMonedaDest + "/" + montoOrig
				, HttpMethod.GET, request, Double.class);
        Double montonuevo = resultado.getBody();
        return montonuevo;
	}

}
