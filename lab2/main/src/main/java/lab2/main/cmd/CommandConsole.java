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
        System.out.println("Available phones:");
        phoneServ.findAll().forEach(System.out::println);
        System.out.println("Provide id of the phone to delete:");

        try{
            UUID id = UUID.fromString(scanner.nextLine());
            phoneServ.delete(id);
            System.out.println("Deletion was successful!!!!");
        }catch (NoSuchElementException e){
            System.out.println("There is no phone with that id.");
        }catch (IllegalArgumentException e){
            System.out.println("Id is in a wrong format.");
        }
    }

    public void listBrandPhones(Scanner scanner){
        String tmp = getNotEmpty(scanner,"Provide name of the brand:");
        Optional<Brand> brand = brandService.findByName(tmp);

        if(brand.isPresent())
            phoneServ.findAllByBrand(brand.get()).forEach(System.out::println);
        else
            System.out.println("No such brand present");
    }

    public void addPhone(Scanner scanner){
        int mem = 0;
        String model = getNotEmpty(scanner,"Provide model name (or type quit to exit the process):");
        if(model.equals("quit")) return;

        String modelId = getNotEmpty(scanner, "Provide model id (or type quit to exit the process):");
        if(modelId.equals("quit")) return;

        while(mem <= 0) {
            System.out.println("Provide memory size in GB (or type quit to exit the process):");
            try{
                String tmp = scanner.nextLine();
                if(tmp.equals("quit")) return;

                mem = Integer.parseInt(tmp);
                if(mem <= 0) System.out.println("Number must be a positive integer.");
            }catch (NumberFormatException e){
                System.out.println("Value must be a positive integer.");
            }
        }

        while(true) {
            System.out.println("Available brands:");
            brandService.findAll().forEach(System.out::println);
            System.out.println("Choose brand (or type quit to exit the process):");
            String brandName = scanner.nextLine();
            if(brandName.equals("quit")) return;

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
