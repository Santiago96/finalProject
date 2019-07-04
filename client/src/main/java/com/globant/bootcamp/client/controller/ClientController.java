package com.globant.bootcamp.client.controller;

import com.globant.bootcamp.client.domain.FlightPerson;
import com.globant.bootcamp.client.domain.Person;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController()
@RequestMapping("/clients/")
public class ClientController {

    private final RestTemplate restTemplate;

    public ClientController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping()
    public String  getAllPersons(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:9000/clients/", HttpMethod.GET, entity, String.class).getBody();

    }
    @GetMapping("{numDocument}")
    public Person getPersonByNumDocument(@PathVariable (value="numDocument") String numDocument){
        String uri = "http://localhost:9000/clients/"+numDocument;
        return restTemplate.getForObject(uri,Person.class);
    }

    @PostMapping("addFlight/")
    public String addFlight(@RequestBody FlightPerson flightPerson){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<FlightPerson> entity = new HttpEntity<FlightPerson>(flightPerson,headers);

        return restTemplate.exchange(
                "http://localhost:9000/airlines/flights/add", HttpMethod.POST, entity, String.class).getBody();
    }
}
