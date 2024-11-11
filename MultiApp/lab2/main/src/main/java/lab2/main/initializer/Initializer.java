package lab2.main.initializer;

import lab2.main.smartPhone.entities.*;
import lab2.main.smartPhone.services.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Initializer implements InitializingBean {
    private final BrandService brandService;

    public Initializer(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Brand sam = Brand.builder()
                .id(UUID.fromString("b4daf574-6c5d-4976-a2e7-35653773fedb"))
                .name("Samsung").rating(8.7).foundingYear(1999).build();
        Brand apple = Brand.builder()
                .id(UUID.fromString("01f4cb39-1d27-4178-8512-f0273e935e5a"))
                .name("Apple").rating(2.7).foundingYear(1997).build();
        Brand xiaomi = Brand.builder()
                .id(UUID.fromString("4c3c8e15-9178-4f24-b10d-87868a625424"))
                .name("Xiaomi").rating(6.2).foundingYear(2012).build();
        Brand lg = Brand.builder()
                .id(UUID.fromString("ddd0cd72-78af-4d8a-a3a9-5d22f45cb86a"))
                .name("LG").rating(5.3).foundingYear(1988).build();
        Brand mot = Brand.builder()
                .id(UUID.fromString("c0c40930-480e-4068-9e5a-f5747de327e7"))
                .name("Motorola").rating(4.3).foundingYear(1992).build();

        brandService.create(sam);
        brandService.create(apple);
        brandService.create(lg);
        brandService.create(xiaomi);
        brandService.create(mot);
    }
}
