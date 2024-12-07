package lab2.main.smartPhone.controllers.api;

import lab2.main.smartPhone.dto.GetBrandResponse;
import lab2.main.smartPhone.dto.GetBrandsResponse;
import lab2.main.smartPhone.dto.PutPostBrandRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BrandController {

    @GetMapping("api/brands/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandResponse getBrand(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("api/brands")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBrandsResponse getBrands();

    @PostMapping("api/brands")
    @ResponseStatus(HttpStatus.CREATED)
    void postBrand(
            @RequestBody
            PutPostBrandRequest request
    );

    @PutMapping("api/brands/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putBrand(
            @PathVariable
            UUID id,
            @RequestBody
            PutPostBrandRequest request
    );

    @DeleteMapping("api/brands/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBrand(
      @PathVariable("id")
      UUID id
    );
}
