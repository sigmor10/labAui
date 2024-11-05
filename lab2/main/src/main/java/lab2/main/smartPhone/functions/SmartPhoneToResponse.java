package lab2.main.smartPhone.functions;

import lab2.main.smartPhone.dto.GetSmartPhoneResponse;
import lab2.main.smartPhone.entities.SmartPhone;
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
                        .name(phone.getBrand().getName())
                        .id(phone.getBrand().getId())
                        .build()).build();
    }
}
