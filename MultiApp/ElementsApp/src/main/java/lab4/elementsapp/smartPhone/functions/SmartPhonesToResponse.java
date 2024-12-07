package lab4.elementsapp.smartPhone.functions;

import lab4.elementsapp.smartPhone.dto.GetSmartphonesResponse;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SmartPhonesToResponse implements Function<List<SmartPhone>, GetSmartphonesResponse> {

    @Override
    public GetSmartphonesResponse apply(List<SmartPhone> smartPhones) {
        return GetSmartphonesResponse.builder()
                .phones(smartPhones.stream().map(phone -> GetSmartphonesResponse.SmartPhone.builder()
                                .model(phone.getModel())
                                .id(phone.getId())
                                .brand(String.valueOf(phone.getBrand().getId()))
                                .build())
                        .toList())
                .build();
    }
}
