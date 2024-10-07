package brand;

import smartPhone.SmartPhone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Brand implements Comparable<Brand>, Serializable {
    private String name;
    private int foundingYear;
    private double rating;
    private List<SmartPhone> phones;

    public Brand(Builder builder){
        this.name = builder.name;
        this.foundingYear = builder.foundingYear;
        this.rating = builder.rating;
        this.phones = builder.phones;

        if(this.phones == null)
            this.phones = new ArrayList<SmartPhone>();
        else{
            for(SmartPhone s : phones)
                s.setBrand(this);
        }
    }

    public static class Builder{
        private String name;
        private int foundingYear;
        private double rating;
        private List<SmartPhone> phones;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setYear(int foundingYear) {
            this.foundingYear = foundingYear;
            return this;
        }

        public Builder setPhones(List<SmartPhone> phones) {
            this.phones = phones;
            return this;
        }

        public Builder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public Brand build(){
            return new Brand(this);
        }
    }

    public String getName() {
        return name;
    }

    public List<SmartPhone> getPhones() {
        return phones;
    }

    public double getRating() {
        return rating;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return foundingYear == brand.foundingYear && Double.compare(rating, brand.rating) == 0 && Objects.equals(name, brand.name) && Objects.equals(phones, brand.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foundingYear, rating);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", foundingYear=" + foundingYear +
                ", rating=" + rating +
                ", phones=" + phones +
                '}';
    }

    @Override
    public int compareTo(Brand o) {
        return name.compareTo(o.getName());
    }
}
