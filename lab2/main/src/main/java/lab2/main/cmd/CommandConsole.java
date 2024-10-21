package lab2.main.cmd;

import lab2.main.brand.Brand;
import lab2.main.service.BrandService;
import lab2.main.service.SmartPhoneService;
import lab2.main.smartPhone.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CommandConsole implements CommandLineRunner {
    private final BrandService brandService;
    private  final SmartPhoneService phoneServ;

    @Autowired
    public CommandConsole(BrandService brandService, SmartPhoneService phoneServ) {
        this.brandService = brandService;
        this.phoneServ = phoneServ;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        boolean running = true;

        while(running){
            printLegend();
            command = scanner.nextLine();

            switch (command){
                case "quit":
                    running  = false;
                    break;
                case "list_all_brands":
                    brandService.findAll().forEach(System.out::println);
                    break;
                case "list_all_phones":
                    phoneServ.findAll().forEach(System.out::println);
                    break;
                case "add_new":
                    addPhone(scanner);
                    break;
                case "delete":
                    delete(scanner);
                    break;
                case "list_brand_phones":
                    listBrandPhones(scanner);
                    break;
                default:
                    break;
            }
        }
    }

    public String getNotEmpty(Scanner scanner, String label){
        String input = "";
        while(input.isEmpty()){
            System.out.println(label);
            input = scanner.nextLine();
        }
        return input;
    }

    public void delete(Scanner scanner){
        System.out.println("available phones:");
        phoneServ.findAll().forEach(System.out::println);
        System.out.println("provide id of the phone to delete:");
        try{
            UUID id = UUID.fromString(scanner.nextLine());
            phoneServ.delete(id);
            System.out.println("Deletion was successful!!!!");
        }catch (Exception e){
            System.out.println("There is no phone with that id.");
        }
    }

    public void listBrandPhones(Scanner scanner){
        while (true){
            String tmp = getNotEmpty(scanner,"Provide name of the brand:");
            Optional<Brand> brand = brandService.findByName(tmp);
            if(brand.isPresent()){
                phoneServ.findAllByBrand(brand.get()).forEach(System.out::println);
                break;
            }
            System.out.println("No such brand present");
        }
    }

    public void addPhone(Scanner input){
        int mem = 0;
        String model = getNotEmpty(input,"Provide model name:");
        String modelId = getNotEmpty(input, "Provide model id:");

        while(mem <= 0) {
            System.out.println("Provide memory size:");
            try{
                mem = Integer.parseInt(input.nextLine());
            }catch (Exception e){
                System.out.println("value must be a positive integer");
            }
        }

        while(true) {
            System.out.println("Available brands:");
            brandService.findAll().forEach(System.out::println);
            System.out.println("Choose brand:");

            String brandName = input.nextLine();
            Optional<Brand> tmp = brandService.findByName(brandName);

            if(tmp.isPresent()) {
                phoneServ.create(new SmartPhone.Builder().setModel(model)
                        .setModelId(modelId).setMemory(mem).setBrand(tmp.get()).build());
                return;
            }
            System.out.println("not found");
        }
    }

    public void printLegend(){
        System.out.println("---------------------------------------");
        System.out.println("----------Available commands:----------");
        System.out.println("---------------------------------------");
        System.out.println("list_all_brands - lists all brands");
        System.out.println("list_all_phones - lists all phones");
        System.out.println("list_brand_phones - lists all phones belonging to later given brand");
        System.out.println("add_new - begins adding new phone");
        System.out.println("delete - begins process of deleting an existing phone");
        System.out.println("quit - quits the app");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
    }
}
