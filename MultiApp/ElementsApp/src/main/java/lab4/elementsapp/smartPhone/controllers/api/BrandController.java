package lab4.elementsapp.smartPhone.controllers.api;

import lab4.elementsapp.smartPhone.dto.PostBrandRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface BrandController {
    @PostMapping("api/brands")
    @ResponseStatus(HttpStatus.CREATED)
    void createBrand(
            @RequestBody
            PostBrandRequest request
    );

    @DeleteMapping("api/brands/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBrand(
      @PathVariable("id")
      UUID id
    );
}
