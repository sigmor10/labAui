package lab2.main.service;

import lab2.main.brand.Brand;
import lab2.main.repositories.SmartPhoneRepository;
import lab2.main.smartPhone.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SmartPhoneService {
    private final SmartPhoneRepository repository;

    @Autowired
    public SmartPhoneService(SmartPhoneRepository repository) {
        this.repository = repository;
    }

    public List<SmartPhone> findAll(){
        return repository.findAll();
    }

    public Optional<SmartPhone> findById(UUID id){
        return repository.findById(id);
    }

    public List<SmartPhone> findAllByBrand(Brand brand){
        return repository.findAllByBrand(brand);
    }

    public void create(SmartPhone smartPhone){
        repository.save(smartPhone);
    }

    public void update(SmartPhone smartPhone){
        repository.save(smartPhone);
    }

    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }
}
