package lab2.main.smartPhone.controllers.api;

import lab2.main.smartPhone.dto.GetSmartPhoneResponse;
import lab2.main.smartPhone.dto.GetSmartphonesResponse;
import lab2.main.smartPhone.dto.PostSmartPhoneRequest;
import lab2.main.smartPhone.dto.PutSmartPhoneRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface SmartPhoneController {

    @GetMapping("api/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSmartPhoneResponse getSmartPhone(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("api/smartphones")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSmartphonesResponse getSmartPhones();

    @GetMapping("api/brands/{brandId}/smartphones")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSmartphonesResponse getBrandSmartPhones(
            @PathVariable("brandId")
            UUID brandId
    );

    @PostMapping("api/brands/{brandId}/smartphones")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void postSmartPhone(
            @PathVariable("brandId")
            UUID brandId,
            @RequestBody
            PostSmartPhoneRequest request
    );

    @PutMapping("api/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void putSmartPhone(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutSmartPhoneRequest request
    );

    @DeleteMapping("api/smartphones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSmartPhone(
            @PathVariable("id")
            UUID id
    );
}
