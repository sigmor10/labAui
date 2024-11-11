package lab4.elementsapp.smartPhone.functions;

import lab4.elementsapp.smartPhone.dto.PostSmartPhoneRequest;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToSmartPhone implements Function<PostSmartPhoneRequest, SmartPhone> {

    @Override
    public SmartPhone apply(PostSmartPhoneRequest request) {
        return SmartPhone.builder()
                .model(request.getModel())
                .modelId(request.getModelId())
                .memory(request.getMemory())
                .build();
    }
}
