package lab2.main.initializer;

import lab2.main.brand.Brand;
import lab2.main.service.BrandService;
import lab2.main.service.SmartPhoneService;
import lab2.main.smartPhone.SmartPhone;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
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
        Brand sam = new Brand.Builder().setName("Samsung").setRating(8.7).setYear(1999).build();
        Brand apple = new Brand.Builder().setName("Apple").setRating(2.7).setYear(1997).build();
        Brand xiaomi = new Brand.Builder().setName("Xiaomi").setRating(6.2).setYear(2012).build();
        Brand lg = new Brand.Builder().setName("LG").setRating(5.3).setYear(1988).build();

        brandService.create(sam);
        brandService.create(apple);
        brandService.create(lg);
        brandService.create(xiaomi);

        phoneServ.create(new SmartPhone.Builder().setModel("Galaxy 10").setMemory(64).setModelId("1454").setBrand(sam).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Note 5").setMemory(128).setModelId("2518").setBrand(sam).build());
        phoneServ.create(new SmartPhone.Builder().setModel("M4").setMemory(64).setModelId("6771").setBrand(sam).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Galaxy 23+").setMemory(256).setModelId("1840").setBrand(sam).build());

        phoneServ.create(new SmartPhone.Builder().setModel("Iphone 7").setMemory(32).setModelId("3325").setBrand(apple).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Iphone 11").setMemory(128).setModelId("8711").setBrand(apple).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Iphone 10").setMemory(64).setModelId("6549").setBrand(apple).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Iphone 13").setMemory(256).setModelId("7444").setBrand(apple).build());

        phoneServ.create(new SmartPhone.Builder().setModel("V2").setMemory(64).setModelId("4771").setBrand(lg).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Q6+").setMemory(128).setModelId("157916").setBrand(lg).build());
        phoneServ.create(new SmartPhone.Builder().setModel("G4").setMemory(128).setModelId("541579").setBrand(lg).build());
        phoneServ.create(new SmartPhone.Builder().setModel("V30+").setMemory(512).setModelId("741283").setBrand(lg).build());

        phoneServ.create(new SmartPhone.Builder().setModel("Redmi 3").setMemory(64).setModelId("189478").setBrand(xiaomi).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Redmi 3").setMemory(128).setModelId("214484").setBrand(xiaomi).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Mi 2+").setMemory(32).setModelId("2517867").setBrand(xiaomi).build());
        phoneServ.create(new SmartPhone.Builder().setModel("Redmi 6").setMemory(256).setModelId("179917").setBrand(xiaomi).build());
    }
}
