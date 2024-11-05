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
public class GetSmartphonesResponse {

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SmartPhone {
        private UUID id;
        private String model;
        private String modelId;
        private int memory;
        private String brand;
    }

    @Singular
    List<SmartPhone> phones;
}
