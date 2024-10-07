package smartPhone;

import brand.Brand;

import java.io.Serializable;
import java.util.Objects;

public class SmartPhone implements Comparable<SmartPhone>, Serializable {
    private String model;
    private int modelId;
    private int memory;
    private Brand brand;

    public SmartPhone(Builder builder){
        this.model = builder.model;
        this.modelId = builder.modelId;
        this.memory = builder.memory;
        this.brand = builder.brand;
    }

    public String getModel() {
        return model;
    }

    public int getModelId() {
        return modelId;
    }

    public int getMemory() {
        return memory;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public static class Builder{
        private String model;
        private int modelId;
        private int memory;
        private Brand brand;

        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public Builder setModelId(int modelId){
            this.modelId = modelId;
            return this;
        }

        public Builder setMemory(int memory){
            this.memory = memory;
            return this;
        }

        public Builder setBrand(Brand brand){
            this.brand = brand;
            return this;
        }

        public SmartPhone build(){
            return new SmartPhone(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartPhone that = (SmartPhone) o;
        return modelId == that.modelId && memory == that.memory && Objects.equals(model, that.model) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, modelId, memory);
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "model='" + model + '\'' +
                ", modelId=" + modelId +
                ", memory=" + memory +
                ", brand=" + brand.getName() +
                '}';
    }

    @Override
    public int compareTo(SmartPhone o) {
        return Integer.compare(modelId, o.modelId);
    }
}
