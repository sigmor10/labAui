package lab2.main.smartPhone.dto;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PutPostBrandRequest {
    private String name;

    private int foundingYear;

    private double rating;
}
