package BusinessLayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseProduct extends MenuItem {
    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;

    public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }

    public BaseProduct() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public float getRating() {
        return this.rating;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getProteins() {
        return this.proteins;
    }

    public int getFats() {
        return this.fats;
    }

    public int getSodium() {
        return this.sodium;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int computePrice() {
        return this.price;
    }

    @Override
    public String getNumeProdus() {
        return null;
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
        this.price = pret;
    }

    @Override
    public List<BaseProduct> getProduse() {
        return null;
    }

    @Override
    public void setProduse(List<BaseProduct> lista) {

    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }


    public static void produseFisier1() throws IOException {
        String[] s = null;
        List<String[]> lista1 = Files.lines(Paths.get("products.csv")).skip(1)
                .map(line -> line.split(","))
                .collect(Collectors.toList());


        System.out.println(lista1.size());
        for (int i = 0; i < lista1.size(); i++) {
            s = lista1.get(i);
            System.out.println();

            for (String ss : s) {
                System.out.println(ss.toString());
            }
        }

    }
}
