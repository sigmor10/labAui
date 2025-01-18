package lab4.elementsapp.smartPhone.controllers.impl;

import lab4.elementsapp.smartPhone.controllers.api.SmartPhoneController;
import lab4.elementsapp.smartPhone.dto.GetSmartPhoneResponse;
import lab4.elementsapp.smartPhone.dto.GetSmartphonesResponse;
import lab4.elementsapp.smartPhone.dto.PostPutSmartPhoneRequest;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import lab4.elementsapp.smartPhone.functions.RequestToSmartPhone;
import lab4.elementsapp.smartPhone.functions.SmartPhoneToResponse;
import lab4.elementsapp.smartPhone.functions.SmartPhonesToResponse;
import lab4.elementsapp.smartPhone.functions.UpdateSmartPhoneWithRequest;
import lab4.elementsapp.smartPhone.services.BrandService;
import lab4.elementsapp.smartPhone.services.SmartPhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class SmartPhoneDefaultController implements SmartPhoneController {
    @Value("${eureka.instance.instance-id}") String instanceId;
    private static final Logger log = LoggerFactory.getLogger(SmartPhoneDefaultController.class);
    private final SmartPhoneService service;
    private final BrandService brandService;
    private final SmartPhonesToResponse smartPhonesToResponse;
    private final SmartPhoneToResponse smartPhoneToResponse;
    private final RequestToSmartPhone requestToSmartPhone;
    private final UpdateSmartPhoneWithRequest updateSmartPhoneWithRequest;

    @Autowired
    public SmartPhoneDefaultController(
            SmartPhoneService service,
            BrandService brandService,
            SmartPhonesToResponse smartPhonesToResponse,
            SmartPhoneToResponse smartPhoneToResponse,
            RequestToSmartPhone requestToSmartPhone,
            UpdateSmartPhoneWithRequest updateSmartPhoneWithRequest) {
        this.service = service;
        this.brandService = brandService;
        this.smartPhonesToResponse = smartPhonesToResponse;
        this.smartPhoneToResponse = smartPhoneToResponse;
        this.requestToSmartPhone = requestToSmartPhone;
        this.updateSmartPhoneWithRequest = updateSmartPhoneWithRequest;
    }

    @Override
    public GetSmartPhoneResponse getSmartPhone(UUID id) {
        log.info("Get full list handled by instance: " + instanceId);
        return service.findById(id)
                .map(smartPhoneToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetSmartphonesResponse getSmartPhones() {
        log.info("Get singular handled by instance: " + instanceId);
        return smartPhonesToResponse.apply(service.findAll());
    }

    @Override
    public GetSmartphonesResponse getBrandSmartPhones(UUID id) {
        log.info("Get limited list handled by instance: " + instanceId);
        return service.findAllByBrand(id).map(smartPhonesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void postSmartPhone(UUID brandId,PostPutSmartPhoneRequest request) {
        log.info("Post handled by instance: " + instanceId);
        brandService.findById(brandId).ifPresentOrElse(
                brand ->{
                  SmartPhone tmp = requestToSmartPhone.apply(request);
                  tmp.setBrand(brand);
                  service.create(tmp);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void putSmartPhone(UUID id, PostPutSmartPhoneRequest request) {
        log.info("Put handled by instance: " + instanceId);
        service.findById(id).ifPresentOrElse(
                phone -> service.update(updateSmartPhoneWithRequest.apply(phone, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void deleteSmartPhone(UUID id) {
        log.info("Delete handled by instance: " + instanceId);
        service.findById(id)
                .ifPresentOrElse(
                        phone -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
