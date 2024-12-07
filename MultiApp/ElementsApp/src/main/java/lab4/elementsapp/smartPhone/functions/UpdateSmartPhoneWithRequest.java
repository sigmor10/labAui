package lab4.elementsapp.smartPhone.functions;

import lab4.elementsapp.smartPhone.dto.PostPutSmartPhoneRequest;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.stereotype.Component;
import java.util.function.BiFunction;

@Component
public class UpdateSmartPhoneWithRequest implements BiFunction<SmartPhone, PostPutSmartPhoneRequest, SmartPhone> {
    @Override
    public SmartPhone apply(SmartPhone entity, PostPutSmartPhoneRequest request) {
        return SmartPhone.builder()
                .id(entity.getId())
                .modelId(request.getModelId() != null ? request.getModelId() : entity.getModelId())
                .model(request.getModel() != null ? request.getModel() : entity.getModel())
                .memory(request.getMemory() != null ? request.getMemory() : entity.getMemory())
                .brand(entity.getBrand())
                .build();
    }
}
