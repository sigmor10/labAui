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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class SmartPhoneDefaultController implements SmartPhoneController {
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
        return service.findById(id)
                .map(smartPhoneToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetSmartphonesResponse getSmartPhones() {
        return smartPhonesToResponse.apply(service.findAll());
    }

    @Override
    public GetSmartphonesResponse getBrandSmartPhones(UUID id) {
        return service.findAllByBrand(id).map(smartPhonesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void postSmartPhone(UUID brandId,PostPutSmartPhoneRequest request) {
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
        service.findById(id).ifPresentOrElse(
                phone -> service.update(updateSmartPhoneWithRequest.apply(phone, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void deleteSmartPhone(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        phone -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
