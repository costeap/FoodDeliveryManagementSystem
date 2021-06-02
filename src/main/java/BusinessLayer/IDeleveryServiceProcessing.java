package BusinessLayer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * @author Costea Paula-Maria, grupa 302210
 * @since Iunie, 2021
 *
 */

public interface IDeleveryServiceProcessing extends Serializable {
    /**
     * @param mi meniu
     * @pre mi!=null
     * @post meniu!=null
     * @invariant meniu!=null
     */
    public void addProduct(MenuItem mi);

    /**
     * @param mi
     * @pre mi!=null
     * @post mi!=null
     * @invariant meniu!=null
     */
    public void deleteProduct(MenuItem mi);


    /**
     * @param nameu
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @pre nameu!=null
     * @pre title!=null
     * @pre price!=0
     * @post
     * @invariant meniu!=null
     */
    public void editProduct(String nameu, String title, Float rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price);

    /**
     * @param nr numele produsului
     * @return MenuItems
     * @pre nr!=null
     * @invariant meniu!=null
     */
    public HashSet<MenuItem> searchTitle(String nr);

    /**
     * @param nr rating
     * @return produsele cu rating-ul specificat
     * @pre nr>=0
     * @invariant meniu!=0
     */
    public HashSet<MenuItem> searchRating(Float nr);

    /**
     * @param nr numarul de calorii
     * @return produsele care contin nr. specificat de calorii
     * @pre nr>=0
     * @invariant meniu!=0
     */
    public HashSet<MenuItem> searchCalories(int nr);

    /**
     * @param nr proteine
     * @return produsele care contin nr. specificat de proteine
     * @pre nr>=0
     * @invariant meniu!=0
     */
    public HashSet<MenuItem> searchProtein(int nr);

    /**
     * @param nr grasimi
     * @return produsele care contin nr. specificat de grasimi
     * @pre nr>=0
     * @invariant meniu!=null
     */
    public HashSet<MenuItem> searchFat(int nr);

    /**
     * @param nr
     * @return produsele care indeplinesc conditia impusa
     * @pre nr>=0
     * @invariant meniu!=0
     */
    public HashSet<MenuItem> searchSodium(int nr);

    /**
     * @param nr
     * @return produsele cu pretul cautat
     * @pre nr!=0
     * @invariant meniu!=0
     */
    public HashSet<MenuItem> searchPrice(int nr);


    /**
     * @param order
     * @param produse
     * @pre order!=null
     * @post produse!=null
     * @invariant meniu!=0
     */
    public void createNewOrder(Order order, List<MenuItem> produse);

    /**
     * @param order
     * @return pretul total al comenzii
     * @pre order!=null
     * @post pret>0
     * @invariant meniu!=null
     */
    public int computePrice(Order order);

    /**
     * @param order
     * @pre order!=null
     * @invariant meniu!=null
     */
    public void generateBill(Order order);

    /**
     * Metoda importa produsele din fisierul products.csv
     *
     * @throws IOException
     */
    public void importProducts() throws IOException;

    /**
     * @return produsele din meniu
     * @post JTable!=null
     * @pre meniu!=null
     */
    public JTable showProducts();

    /**
     * @param ora1 start hour
     * @param ora2 end hour
     * @throws IOException
     * @pre ora <24
     * @pre ora2<24
     * @post fisier inchis
     * @invariant meniu!=null
     */

    public void raportUnu(int ora1, int ora2) throws IOException;

    /**
     * @param nrComenzi
     * @pre nrComenzi>0
     * @post fisier inchis
     * @invariant meniu!=null
     */
    public void raportDoi(int nrComenzi);

    /**
     * @param nrComenzi
     * @param valoare
     * @pre valoare >0
     * @pre nrComenzi>0
     * @post fisier inchis
     * @invariant meniu!=null
     */
    public void raportTrei(int nrComenzi, int valoare);

    /**
     * @param z
     * @pre z>=1
     * @invariant meniu!=null
     */


    public void raportPatru(int z);

}
