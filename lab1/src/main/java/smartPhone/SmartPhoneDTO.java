package smartPhone;

import brand.Brand;

import java.util.Objects;

public class SmartPhoneDTO implements Comparable<SmartPhoneDTO>{
    private String model;
    private int modelId;
    private int memory;
    private String brand;

    public  SmartPhoneDTO(Builder builder){
        this.modelId = builder.modelId;
        this.model = builder.model;
        this.memory = builder.memory;
        this.brand = builder.brand;
    }

    public static class Builder{
        private String model;
        private int modelId;
        private int memory;
        private String brand;

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

        public Builder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public SmartPhoneDTO build(){
            return new SmartPhoneDTO(this);
        }
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

    public String getBrand() {
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

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(SmartPhoneDTO o) {
        return Integer.compare(this.modelId,o.getModelId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartPhoneDTO that = (SmartPhoneDTO) o;
        return modelId == that.modelId && memory == that.memory && Objects.equals(model, that.model) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, modelId, memory, brand);
    }

    @Override
    public String toString() {
        return "SmartPhoneDTO{" +
                "model='" + model + '\'' +
                ", modelId=" + modelId +
                ", memory=" + memory +
                ", brand='" + brand + '\'' +
                '}';
    }
}
