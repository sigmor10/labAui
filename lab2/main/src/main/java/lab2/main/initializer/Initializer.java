package lab2.main.initializer;

import lab2.main.smartPhone.entities.*;
import lab2.main.smartPhone.services.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

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
        Brand sam = Brand.builder().name("Samsung").rating(8.7).foundingYear(1999).build();
        Brand apple = Brand.builder().name("Apple").rating(2.7).foundingYear(1997).build();
        Brand xiaomi = Brand.builder().name("Xiaomi").rating(6.2).foundingYear(2012).build();
        Brand lg = Brand.builder().name("LG").rating(5.3).foundingYear(1988).build();
        Brand mot = Brand.builder().name("Motorola").rating(4.3).foundingYear(1992).build();

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
