package lab2.main.smartPhone.functions;

import lab2.main.smartPhone.dto.PutPostBrandRequest;
import lab2.main.smartPhone.entities.Brand;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestToBrand implements Function<PutPostBrandRequest, Brand> {
    @Override
    public Brand apply(PutPostBrandRequest request) {
        return Brand.builder()
                .name(request.getName())
                .foundingYear(request.getFoundingYear())
                .rating(request.getRating())
                .build();
    }
}
