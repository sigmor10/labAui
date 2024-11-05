package lab2.main.smartPhone.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GetSmartPhoneResponse {

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
    }

    private UUID id;
    private String model;
    private String modelId;
    private int memory;
    private Brand brand;
}
