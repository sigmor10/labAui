package lab4.elementsapp.smartPhone.repositories;

import lab4.elementsapp.smartPhone.entities.Brand;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone, UUID> {
    List<SmartPhone> findAllByBrand(Brand brand);
}
