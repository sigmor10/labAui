package lab4.elementsapp.smartPhone.dto;

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

    private UUID id;
    private String model;
    private String modelId;
    private int memory;
}
