package lab2.main.smartPhone.functions;

import lab2.main.smartPhone.dto.GetBrandResponse;
import lab2.main.smartPhone.entities.Brand;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BrandToResponse implements Function<Brand, GetBrandResponse> {
    @Override
    public GetBrandResponse apply(Brand brand) {
        return GetBrandResponse.builder()
                .id(brand.getId())
                .foundingYear(brand.getFoundingYear())
                .name(brand.getName())
                .rating(brand.getRating())
                .build();
    }
}
