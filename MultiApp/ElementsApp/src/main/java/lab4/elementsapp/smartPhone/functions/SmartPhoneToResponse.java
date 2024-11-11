package lab4.elementsapp.smartPhone.functions;

import lab4.elementsapp.smartPhone.dto.GetSmartPhoneResponse;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SmartPhoneToResponse implements Function<SmartPhone, GetSmartPhoneResponse> {

    @Override
    public GetSmartPhoneResponse apply(SmartPhone phone) {
        return GetSmartPhoneResponse.builder()
                .id(phone.getId())
                .model(phone.getModel())
                .modelId(phone.getModelId())
                .memory(phone.getMemory())
                .brand(GetSmartPhoneResponse.Brand.builder()
                        .name(String.valueOf(phone.getBrand().getId()))
                        .id(phone.getBrand().getId())
                        .build()).build();
    }
}
