package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;
    public List<BaseProduct> lproduse = new ArrayList<>();
    public List<MenuItem> lproduse1 = new ArrayList<>();


    public CompositeProduct(List<BaseProduct> lproduse, String title) {
        super();
        this.lproduse = lproduse;
        this.title = title;
        for (BaseProduct bp : lproduse) {
            this.rating = this.rating + bp.getRating();
            this.calories = this.calories + bp.getCalories();
            this.proteins = this.proteins + bp.getProteins();
            this.fats = this.fats + bp.getFats();
            this.sodium = this.sodium + bp.getSodium();
            this.price = this.price + bp.getPrice();
        }
        this.rating = this.rating / lproduse.size();
    }

    public CompositeProduct(List<MenuItem> lproduse1, String title, int a) {
        super();
        this.lproduse1 = lproduse1;
        this.title = title;
        for (MenuItem bp : lproduse1) {
            this.rating = this.rating + bp.getRating();
            this.calories = this.calories + bp.getCalories();
            this.proteins = this.proteins + bp.getProteins();
            this.fats = this.fats + bp.getFats();
            this.sodium = this.sodium + bp.getSodium();
            this.price = this.price + bp.getPrice();
        }
        this.rating = this.rating / lproduse1.size();
    }

    @Override
    public int computePrice() {
        /*int suma = 0;
        for (int i = 0; i < lproduse.size(); i++) {
            suma = suma + lproduse.get(i).getPret();
        }
        this.price = suma;
        return suma;*/
        int suma = 0;
        for (int i = 0; i < lproduse1.size(); i++) {
            suma = suma + lproduse1.get(i).getPret();
        }
        this.price = suma;
        return suma;
    }


    @Override
    public String getNumeProdus() {
        return this.title;
    }

    @Override
    public void setNumeProdus(String nume) {
        this.title = nume;
    }

    @Override
    public int getPret() {
        return this.price;
    }

    @Override
    public void setPret(int pret) {

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public List<BaseProduct> getProduse() {
        return lproduse;
    }

    @Override
    public void setProduse(List<BaseProduct> lista) {
        this.lproduse = lista;
    }

    public void adaugareProdus(BaseProduct bp) {
        this.lproduse.add(bp);
    }

    public void stergereProdus(BaseProduct bp) {
        this.lproduse.remove(bp);
    }

}
