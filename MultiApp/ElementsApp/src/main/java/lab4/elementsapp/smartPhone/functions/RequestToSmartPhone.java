package lab4.elementsapp.smartPhone.functions;

import lab4.elementsapp.smartPhone.dto.PostPutSmartPhoneRequest;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToSmartPhone implements Function<PostPutSmartPhoneRequest, SmartPhone> {

    @Override
    public SmartPhone apply(PostPutSmartPhoneRequest request) {
        return SmartPhone.builder()
                .model(request.getModel())
                .modelId(request.getModelId())
                .memory(request.getMemory())
                .build();
    }
}
