package lab2.main.repositories;

import lab2.main.brand.Brand;
import lab2.main.smartPhone.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SmartPhoneRepository extends JpaRepository<SmartPhone, UUID> {
    List<SmartPhone> findAllByBrand(Brand brand);
}
