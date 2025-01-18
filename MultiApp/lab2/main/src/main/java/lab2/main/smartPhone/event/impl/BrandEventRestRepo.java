package lab2.main.smartPhone.event.impl;

import lab2.main.smartPhone.event.api.BrandEventRepo;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BrandEventRestRepo implements BrandEventRepo {
    private  final RestTemplate restTemplate;
    private final LoadBalancerClient lb;


    public BrandEventRestRepo(RestTemplate template, LoadBalancerClient lb) {
        this.restTemplate = template;
        this.lb = lb;
    }

    @Override
    public void create(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, UUID> requestBody = new HashMap<>();
        requestBody.put("id", id);

        HttpEntity<Map<String, UUID>> request = new HttpEntity<>(requestBody, headers);
        try {
            String uri = lb.choose("ELEMENTS-APP").getUri().toString();
            restTemplate.postForEntity(uri + "/api/brands", request, Void.class);
        } catch (RestClientException e) {
            System.out.println("Couldn't connect to elements app.");
        }
    }

    @Override
    public void delete(UUID id) {
        String uri = lb.choose("ELEMENTS-APP").getUri().toString();
        restTemplate.delete(uri + "/api/brands/{id}", id);
    }
}
