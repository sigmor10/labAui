package lab2.main.smartPhone.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand implements Comparable<Brand>, Serializable {
    @Id
    @Column(name = "id")
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "founding_year")
    private int foundingYear;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private List<SmartPhone> phones = new ArrayList<>();

    @Override
    public int compareTo(Brand o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "----- " +
                "id = " + id +
                ", name = " + name +
                ", founding year = " + foundingYear +
                ", rating = " + rating;
    }
}
