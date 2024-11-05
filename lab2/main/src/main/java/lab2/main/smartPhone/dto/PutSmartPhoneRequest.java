package lab2.main.smartPhone.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PutSmartPhoneRequest {
    private String model;
    private String modelId;
    private Integer memory;
}
