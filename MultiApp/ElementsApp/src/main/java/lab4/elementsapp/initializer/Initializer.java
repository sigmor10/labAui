package lab4.elementsapp.initializer;

import lab4.elementsapp.smartPhone.entities.*;
import lab4.elementsapp.smartPhone.services.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Initializer implements InitializingBean {
    private final BrandService brandService;
    private final SmartPhoneService phoneServ;

    public Initializer(BrandService brandService, SmartPhoneService smartPhoneService) {
        this.brandService = brandService;
        this.phoneServ = smartPhoneService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (phoneServ.findAll().isEmpty()) {
            Brand sam = Brand.builder().id(UUID.fromString("b4daf574-6c5d-4976-a2e7-35653773fedb")).build();
            Brand apple = Brand.builder().id(UUID.fromString("01f4cb39-1d27-4178-8512-f0273e935e5a")).build();
            Brand xiaomi = Brand.builder().id(UUID.fromString("4c3c8e15-9178-4f24-b10d-87868a625424")).build();
            Brand lg = Brand.builder().id(UUID.fromString("ddd0cd72-78af-4d8a-a3a9-5d22f45cb86a")).build();
            Brand mot = Brand.builder().id(UUID.fromString("c0c40930-480e-4068-9e5a-f5747de327e7")).build();

            brandService.create(sam);
            brandService.create(apple);
            brandService.create(lg);
            brandService.create(xiaomi);
            brandService.create(mot);

            phoneServ.create(SmartPhone.builder().model("Galaxy 10").memory(64).modelId("1454").brand(sam).build());
            phoneServ.create(SmartPhone.builder().model("Note 5").memory(128).modelId("2518").brand(sam).build());
            phoneServ.create(SmartPhone.builder().model("M4").memory(64).modelId("6771").brand(sam).build());
            phoneServ.create(SmartPhone.builder().model("Galaxy 23+").memory(256).modelId("1840").brand(sam).build());

            phoneServ.create(SmartPhone.builder().model("Iphone 7").memory(32).modelId("3325").brand(apple).build());
            phoneServ.create(SmartPhone.builder().model("Iphone 11").memory(128).modelId("8711").brand(apple).build());
            phoneServ.create(SmartPhone.builder().model("Iphone 10").memory(64).modelId("6549").brand(apple).build());
            phoneServ.create(SmartPhone.builder().model("Iphone 13").memory(256).modelId("7444").brand(apple).build());

            phoneServ.create(SmartPhone.builder().model("V2").memory(64).modelId("4771").brand(lg).build());
            phoneServ.create(SmartPhone.builder().model("Q6+").memory(128).modelId("157916").brand(lg).build());
            phoneServ.create(SmartPhone.builder().model("G4").memory(128).modelId("541579").brand(lg).build());
            phoneServ.create(SmartPhone.builder().model("V30+").memory(512).modelId("741283").brand(lg).build());

            phoneServ.create(SmartPhone.builder().model("Redmi 3").memory(64).modelId("189478").brand(xiaomi).build());
            phoneServ.create(SmartPhone.builder().model("Redmi 3").memory(128).modelId("214484").brand(xiaomi).build());
            phoneServ.create(SmartPhone.builder().model("Mi 2+").memory(32).modelId("2517867").brand(xiaomi).build());
            phoneServ.create(SmartPhone.builder().model("Redmi 6").memory(256).modelId("179917").brand(xiaomi).build());
        }
    }
}
