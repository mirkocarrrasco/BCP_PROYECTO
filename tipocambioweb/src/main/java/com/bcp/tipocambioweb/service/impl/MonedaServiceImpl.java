package com.bcp.tipocambioweb.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tipocambioweb.dto.MonedaDTO;
import com.bcp.tipocambioweb.service.MonedaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class MonedaServiceImpl implements MonedaService {

	@Value("${backend.restURL}")
    String backendURL;
	
	HttpEntity<String> request;
    HttpHeaders headers;

    public MonedaServiceImpl() {
        /*
    	String username = "usrServer";
        String password = "usrClave";
        headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        request = new HttpEntity<String>(headers);*/
    	request = null;
    }
	
	@Override
	public List<MonedaDTO> listarTodos() {
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<MonedaDTO[]> resultado = plantilla.exchange(backendURL + "/monedas", HttpMethod.GET, request, MonedaDTO[].class);
        MonedaDTO[] lista = resultado.getBody();
        List<MonedaDTO> retorno = Arrays.asList(lista);
        return retorno;
	}

	@Override
	public MonedaDTO obtenerUno(int codigo) {
		RestTemplate plantilla = new RestTemplate();
        ResponseEntity<MonedaDTO> resultado = plantilla.exchange(backendURL + "/monedas/" + codigo, HttpMethod.GET, request, MonedaDTO.class);
        MonedaDTO moneda = resultado.getBody();
        return moneda;
	}

	@Override
	public void insertar(MonedaDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<MonedaDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/monedas", HttpMethod.POST, entidad, MonedaDTO.class);
	}

	@Override
	public void modificar(MonedaDTO ce) {
		RestTemplate llamada = new RestTemplate();
        HttpEntity<MonedaDTO> entidad = new HttpEntity<>(ce, headers);
        llamada.exchange(backendURL + "/monedas", HttpMethod.PUT, entidad, MonedaDTO.class);
	}

	@Override
	public void eliminar(int codigo) {
		RestTemplate llamada = new RestTemplate();
        llamada.exchange(backendURL + "/monedas/" + codigo, HttpMethod.DELETE, request, MonedaDTO.class);
	}

	

}
