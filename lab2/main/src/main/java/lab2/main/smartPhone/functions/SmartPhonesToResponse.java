package lab2.main.smartPhone.functions;

import lab2.main.smartPhone.dto.GetSmartphonesResponse;
import lab2.main.smartPhone.entities.SmartPhone;
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
                                .memory(phone.getMemory())
                                .modelId(phone.getModelId())
                                .brand(phone.getBrand().getName())
                                .build())
                        .toList())
                .build();
    }
}
