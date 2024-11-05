package lab2.main.smartPhone.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class GetBrandResponse {
    private UUID id;
    private String name;
    private int foundingYear;
    private double rating;
}
