package com.bcp.tipocambioweb.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcp.tipocambioweb.dto.TipoCambioDTO;
import com.bcp.tipocambioweb.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;
	
    public TipoCambioServiceImpl() {
        /*
    	String username = "usrServer";
        String password = "usrClave";
        headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        request = new HttpEntity<String>(headers);*/
    	request = null;
    }
    
	@Override
	public List<TipoCambioDTO> listarTodos() {
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<TipoCambioDTO[]> resultado = plantilla.exchange(backendURL + "/tiposcambio", HttpMethod.GET, request, TipoCambioDTO[].class);
        TipoCambioDTO[] lista = resultado.getBody();
        List<TipoCambioDTO> retorno = Arrays.asList(lista);
        return retorno;
	}

	@Override
	public TipoCambioDTO obtenerUno(int codigo) {
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<TipoCambioDTO> resultado = plantilla.exchange(backendURL + "/tiposcambio/" + codigo, HttpMethod.GET, request, TipoCambioDTO.class);
        TipoCambioDTO tipoCambio = resultado.getBody();
        return tipoCambio;
	}

	@Override
	public void insertar(TipoCambioDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<TipoCambioDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/tiposcambio", HttpMethod.POST, entidad, TipoCambioDTO.class);
	}

	@Override
	public void modificar(TipoCambioDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<TipoCambioDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/tiposcambio", HttpMethod.PUT, entidad, TipoCambioDTO.class);
	}

	@Override
	public void eliminar(int codigo) {
		RestTemplate llamada = new RestTemplate();
        llamada.exchange(backendURL + "/tiposcambio/" + codigo, HttpMethod.DELETE, request, TipoCambioDTO.class);		
	}

}
