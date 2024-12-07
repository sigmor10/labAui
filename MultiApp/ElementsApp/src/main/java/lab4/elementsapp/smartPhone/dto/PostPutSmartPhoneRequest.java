package lab4.elementsapp.smartPhone.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PostPutSmartPhoneRequest {
    private String model;
    private String modelId;
    private Integer memory;
}
