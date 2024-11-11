package lab2.main.smartPhone.services;

import lab2.main.smartPhone.entities.Brand;
import lab2.main.smartPhone.event.impl.BrandEventRestRepo;
import lab2.main.smartPhone.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService {
    private final BrandRepository repository;
    private final BrandEventRestRepo eventRepo;

    @Autowired
    public BrandService(BrandRepository repository, BrandEventRestRepo eventRepo) {
        this.repository = repository;
        this.eventRepo = eventRepo;
    }

    public Optional<Brand> findByName(String name){
        return repository.findByName(name);
    }

    public List<Brand> findAll(){
        return repository.findAll();
    }

    public Optional<Brand> findById(UUID id){
        return repository.findById(id);
    }

    public void create(Brand brand){
        repository.save(brand);
        eventRepo.create(brand.getId());
    }

    public void delete(UUID id){
        repository.deleteById(id);
        eventRepo.delete(id);
    }
}
