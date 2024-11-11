package lab2.main.smartPhone.event.impl;

import lab2.main.smartPhone.event.api.BrandEventRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BrandEventRestRepo implements BrandEventRepo {
    private  final RestTemplate restTemplate;


    public BrandEventRestRepo(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void create(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, UUID> requestBody = new HashMap<>();
        requestBody.put("id", id);

        HttpEntity<Map<String, UUID>> request = new HttpEntity<>(requestBody, headers);
        restTemplate.postForEntity("/api/brands", request, Void.class);
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/brands/{id}", id);
    }
}
