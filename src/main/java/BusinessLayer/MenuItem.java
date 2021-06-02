package BusinessLayer;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.io.Serializable;
import java.util.List;

public abstract class MenuItem implements Serializable {
    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;


    public MenuItem(
    ) {
    }


    public String getTitle() {
        return title;
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
        return this.calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return this.proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return this.fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSodium() {
        return this.sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //////////////////////////////
    public abstract int computePrice();

    public abstract String getNumeProdus();

    public abstract void setNumeProdus(String nume);

    public abstract int getPret();

    public abstract void setPret(int pret);

    public abstract List<BaseProduct> getProduse();

    public abstract void setProduse(List<BaseProduct> lista);

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
