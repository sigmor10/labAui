package lab2.main.smartPhone.functions;

import lab2.main.smartPhone.dto.GetBrandsResponse;
import lab2.main.smartPhone.entities.Brand;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class BrandsToResponse implements Function<List<Brand>, GetBrandsResponse> {

    @Override
    public GetBrandsResponse apply(List<Brand> brands) {
        return GetBrandsResponse.builder()
                .brands(brands.stream().map( brand -> GetBrandsResponse.Brand.builder()
                                .id(brand.getId())
                                .name(brand.getName())
                                .build())
                        .toList())
                .build();
    }
}
