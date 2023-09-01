package models;

import utils.GenLinkedList;

public class DisplayTray {

    public GenLinkedList<JewelleryItem> jewels = new GenLinkedList<>();
    public String id;

    public String color;
    public int width;

    public int depth;


    public DisplayTray(String id, int width, int depth, String color) {
        setId(id);
        setWidth(width);
        setDepth(depth);
        setColor(color);
    }

    //getters

    public String getId() {
        return id;
    }
    public GenLinkedList<JewelleryItem> getJewels() {
        return jewels;
    }
    public int getWidth() {return width;}
    public int getDepth() {return depth;}
    public String getColor() {return color;}

    //setters

    public void setId(String id) {this.id = id;}

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\t" +"DisplayTray{" +
                "id=" + id +
                ", width=" + width +
                ", depth=" + depth +
                ", color='" + color + '\'' +
                '}';
    }


}
