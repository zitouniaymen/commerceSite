package com.mcommandes;

import java.net.URI;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.mcommandes.model.Commande;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class McommandesApplicationTests {
	
	
	  @LocalServerPort
	    int randomServerPort;

	   public void testAddCommandeSuccess() throws URISyntaxException, ParseException 
	    {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:"+randomServerPort+"/commandes/";
	        URI uri = new URI(baseUrl);
	        Commande  commande =new Commande(21,df.parse("12-01-1981"),5,true);
	        
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-PERSIST", "true");      
	 
	        HttpEntity<Commande> request = new HttpEntity<>(commande, headers);
	         
	        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	         
	        //Verify request succeed
	   
	        Assertions.assertEquals(201, result.getStatusCodeValue());
	    }
}
