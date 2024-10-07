package main;

import brand.Brand;
import smartPhone.SmartPhone;
import smartPhone.SmartPhoneDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n task 1 & 2 \n");
        ArrayList<Brand> brands = createBrands();
        printBrands(brands);

        // task 3
        System.out.println("\n task 3 \n");
        Set<SmartPhone> allPhones = brands.stream().map(brand -> brand.getPhones()).flatMap(List::stream)
                .collect(Collectors.toSet());
        allPhones.stream().forEach(phone -> System.out.println(phone));

        //task 4
        System.out.println("\n task 4 \n");
        allPhones.stream().filter(phone -> phone.getMemory() > 32).sorted(new CustomComparator())
                .forEach(System.out::println);

        //task 5
        System.out.println("\n task 5 \n");
        List<SmartPhoneDTO> sortedPhones = allPhones.stream().map(phone -> new SmartPhoneDTO.Builder().setModelId(phone.getModelId())
                .setModel(phone.getModel()).setMemory(phone.getMemory()).setBrand(phone.getBrand().getName()).build())
                .sorted().collect(Collectors.toList());
        sortedPhones.stream().forEach(phone -> System.out.println(phone));

        //task 6
        System.out.println("\n task 6 \n");
        try {
            FileOutputStream file = new FileOutputStream("serialized.bin");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(brands);
            out.flush();
            out.close();

            FileInputStream read = new FileInputStream("serialized.bin");
            ObjectInputStream input = new ObjectInputStream(read);
            List<Brand> readBrands = (List<Brand>) input.readObject();
            printBrands(readBrands);
            input.close();
        } catch(Exception e){
            System.out.println("\nfailed\n");
        }

        //task 7
        System.out.println("\n task 7 \n");
        for(int i=1; i <= 4; i++){
            System.out.println("\n thread count: " + i + "\n");
            ForkJoinPool pool = new ForkJoinPool(i);
            brands.stream().parallel().forEach(brand -> pool.invoke(new WorkTask(brand)));
            pool.shutdown();
        }
    }

    public static void printBrands(List<Brand> brands){
        brands.forEach(brand -> {
                    System.out.println(brand);
                    brand.getPhones().forEach(phone -> System.out.println(phone));
                }
        );
    }

    static class WorkTask extends RecursiveTask {
        private final Brand brand;

        public WorkTask(Brand brand){
            this.brand = brand;
        }

        @Override
        protected Object compute() {
            for(int i = 0; i < 5; i++){
                brand.getPhones().forEach(phone-> System.out.println(phone));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        }
    }

    static class CustomComparator implements Comparator<SmartPhone> {
        @Override
        public int compare(SmartPhone o1, SmartPhone o2) {
            return o1.getModel().compareTo(o2.getModel());
        }
    }

    public static ArrayList<Brand> createBrands(){
        ArrayList<Brand> brands = new ArrayList<>();
        ArrayList<SmartPhone> phones1 = new ArrayList<>();
        ArrayList<SmartPhone> phones2 = new ArrayList<>();
        ArrayList<SmartPhone> phones3 = new ArrayList<>();
        ArrayList<SmartPhone> phones4 = new ArrayList<>();

        phones1.add(new SmartPhone.Builder().setModel("Galaxy 10").setMemory(64).setModelId(1454).build());
        phones1.add(new SmartPhone.Builder().setModel("Note 5").setMemory(128).setModelId(2518).build());
        phones1.add(new SmartPhone.Builder().setModel("M4").setMemory(64).setModelId(6771).build());
        phones1.add(new SmartPhone.Builder().setModel("Galaxy 23+").setMemory(256).setModelId(1840).build());

        phones2.add(new SmartPhone.Builder().setModel("Iphone 7").setMemory(32).setModelId(3325).build());
        phones2.add(new SmartPhone.Builder().setModel("Iphone 11").setMemory(128).setModelId(8711).build());
        phones2.add(new SmartPhone.Builder().setModel("Iphone 10").setMemory(64).setModelId(6549).build());
        phones2.add(new SmartPhone.Builder().setModel("Iphone 13").setMemory(256).setModelId(7444).build());

        phones3.add(new SmartPhone.Builder().setModel("V2").setMemory(64).setModelId(4771).build());
        phones3.add(new SmartPhone.Builder().setModel("Q6+").setMemory(128).setModelId(157916).build());
        phones3.add(new SmartPhone.Builder().setModel("G4").setMemory(128).setModelId(541579).build());
        phones3.add(new SmartPhone.Builder().setModel("V30+").setMemory(512).setModelId(741283).build());

        phones4.add(new SmartPhone.Builder().setModel("Redmi 3").setMemory(64).setModelId(189478).build());
        phones4.add(new SmartPhone.Builder().setModel("Redmi 3").setMemory(128).setModelId(214484).build());
        phones4.add(new SmartPhone.Builder().setModel("Mi 2+").setMemory(32).setModelId(2517867).build());
        phones4.add(new SmartPhone.Builder().setModel("Redmi 6").setMemory(256).setModelId(179917).build());

        brands.add(new Brand.Builder().setName("Samsung").setYear(1999).setRating(8.7).setPhones(phones1).build());
        brands.add(new Brand.Builder().setName("Apple").setYear(1997).setRating(2.7).setPhones(phones2).build());
        brands.add(new Brand.Builder().setName("LG").setYear(1988).setRating(6.2).setPhones(phones3).build());
        brands.add(new Brand.Builder().setName("Xiaomi").setYear(2012).setRating(5.3).setPhones(phones4).build());

        return brands;
    }
}
