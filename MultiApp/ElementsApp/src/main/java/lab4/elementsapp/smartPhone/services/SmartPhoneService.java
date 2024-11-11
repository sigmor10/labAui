package lab4.elementsapp.smartPhone.services;

import lab4.elementsapp.smartPhone.repositories.BrandRepository;
import lab4.elementsapp.smartPhone.repositories.SmartPhoneRepository;
import lab4.elementsapp.smartPhone.entities.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SmartPhoneService {
    private final SmartPhoneRepository repository;
    private final BrandRepository brandRepository;

    @Autowired
    public SmartPhoneService(SmartPhoneRepository repository, BrandRepository brandRepository) {
        this.repository = repository;
        this.brandRepository = brandRepository;
    }

    public List<SmartPhone> findAll(){
        return repository.findAll();
    }

    public Optional<SmartPhone> findById(UUID id){
        return repository.findById(id);
    }

    public Optional<List<SmartPhone>> findAllByBrand(UUID id){
        return brandRepository.findById(id).map(repository::findAllByBrand);
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
