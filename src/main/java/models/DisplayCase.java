package models;

import utils.GenLinkedList;

public class DisplayCase {

    public GenLinkedList<DisplayTray> trays = new GenLinkedList<>();
    public int id;
    public boolean freestd,lit;

    public DisplayCase(int id, boolean freestd, boolean lit) {
         setId(id);
         setFreestd(freestd);
         setLit(lit);
    }

    //setters

    public void setTrays(GenLinkedList<DisplayTray> trays) {
        this.trays = trays;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFreestd(boolean freestd) {
        this.freestd = freestd;
    }

    public void setLit(boolean lit) {
        this.lit = lit;
    }

    //getters

    public GenLinkedList<DisplayTray> getTrays() {
        return trays;
    }

    public int getId() {
        return id;
    }

    public boolean isFreestd() {
        return freestd;
    }

    public boolean isLit() {
        return lit;
    }

    @Override
    public String toString() {
        return "DisplayCase{ id=" + id +
                ", freestd=" + freestd +
                ", lit=" + lit +
                '}';
    }



}
