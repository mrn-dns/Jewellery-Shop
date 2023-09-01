package models;

import utils.GenLinkedList;

public class JewelleryItem {

    public GenLinkedList<Material> materials = new GenLinkedList<>();
    public String description,type,gender,image;
    public int price;

    public JewelleryItem(String description, String type, String gender, int price, String image) {
        setDescription(description);
        setType(type);
        setGender(gender);
        setPrice(price);
        setImage(image);
    }

    //getters

    public GenLinkedList<Material> getMaterials() {
        return materials;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    //setters

    public void setMaterials(GenLinkedList<Material> materials) {
        this.materials = materials;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return  "JewelleryItem{" +
                "price= " + price + '\'' +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' + '\'' + ", URL=" + image +
                '}';
    }
}
