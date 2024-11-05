package lab2.main.smartPhone.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GetBrandsResponse {

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Brand {
        private UUID id;
        private String name;
        private int foundingYear;
        private double rating;
    }

    private List<Brand> brands;
}
