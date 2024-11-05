package lab2.main.smartPhone.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "smartphones")
public class SmartPhone implements Comparable<SmartPhone>, Serializable {
    @Id
    @Column(name = "id")
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "model")
    private String model;

    @Column(name = "model_id")
    private String modelId;

    @Column(name = "memory")
    private int memory;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @EqualsAndHashCode.Exclude
    private Brand brand;

    @Override
    public int compareTo(SmartPhone o) {
        return modelId.compareTo(o.modelId);
    }

    @Override
    public String toString() {
        return "----- " +
                "id = " + id +
                ", model = " + model +
                ", model id = " + modelId +
                ", memory = " + memory +
                " GB, brand = " + brand.getName();
    }
}
