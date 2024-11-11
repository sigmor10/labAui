package lab2.main.smartPhone.controllers.impl;

import lab2.main.smartPhone.controllers.api.BrandController;
import lab2.main.smartPhone.dto.GetBrandResponse;
import lab2.main.smartPhone.dto.GetBrandsResponse;
import lab2.main.smartPhone.dto.PutPostBrandRequest;
import lab2.main.smartPhone.entities.Brand;
import lab2.main.smartPhone.functions.BrandToResponse;
import lab2.main.smartPhone.functions.BrandsToResponse;
import lab2.main.smartPhone.functions.RequestToBrand;
import lab2.main.smartPhone.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class BrandDefaultController implements BrandController {

    private final BrandService service;
    private final BrandToResponse brandToResponse;
    private final BrandsToResponse brandsToResponse;
    private final RequestToBrand requestToBrand;

    @Autowired
    public BrandDefaultController(
            BrandService brandService,
            BrandToResponse brandToResponse,
            BrandsToResponse brandsToResponse,
            RequestToBrand requestToBrand) {
        this.service = brandService;
        this.brandToResponse = brandToResponse;
        this.brandsToResponse = brandsToResponse;
        this.requestToBrand = requestToBrand;
    }

    @Override
    public GetBrandResponse getBrand(UUID id) {
        return service.findById(id).map(brandToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetBrandsResponse getBrands() {
        return brandsToResponse.apply(service.findAll());
    }

    @Override
    public void postBrand(PutPostBrandRequest request) {
        service.create(requestToBrand.apply(request));
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
