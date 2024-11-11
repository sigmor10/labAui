package lab4.elementsapp.smartPhone.controllers.impl;

import lab4.elementsapp.smartPhone.controllers.api.BrandController;
import lab4.elementsapp.smartPhone.dto.PostBrandRequest;
import lab4.elementsapp.smartPhone.entities.Brand;
import lab4.elementsapp.smartPhone.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class BrandDefaultController implements BrandController {

    private final BrandService service;

    @Autowired
    public BrandDefaultController(BrandService brandService) {
        this.service = brandService;
    }

    @Override
    public void createBrand(PostBrandRequest request) {
        service.create(Brand.builder()
                        .id(UUID.fromString(request.getId()))
                .build()
        );
    }

    @Override
    public void deleteBrand(UUID id) {
        service.findById(id)
                .ifPresentOrElse(
                        brand -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                        );
    }
}
