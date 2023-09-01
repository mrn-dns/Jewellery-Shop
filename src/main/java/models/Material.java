package models;

public class Material {

    public String description;
    public int weight,quality;

    public Material(String description, int weight, int quality) {
        setDescription(description);
        setWeight(weight);
        setQuality(quality);
    }

    //getters

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getQuality() {
        return quality;
    }

    //setters

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return  description +
                ", weight=" + weight +
                ", quality=" + quality;
    }

}
