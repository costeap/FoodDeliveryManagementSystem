package BusinessLayer;

import DataLayer.FileWriterr;
import DataLayer.Serializator;
import PresentationLayer.AdministratorGraphicalUserInterface;
import PresentationLayer.All;
import PresentationLayer.EmployeeGraphicalUserInterface;
import PresentationLayer.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author Costea Paula-Maria
 * @since Iunie, 2021
 *
 */

public class DeliveryService extends Observable implements IDeleveryServiceProcessing {

    public Map<Order, List<MenuItem>> listaComenzi;
    public HashSet<MenuItem> meniu;
    public ArrayList<BaseProduct> valIn;   /////////////////////////////
    public List<Order> comenzi = new ArrayList<>();
    public Serializator s = new Serializator();
    public ArrayList<User> listau = new ArrayList<User>();
    //EmployeeGraphicalUserInterface ei = new EmployeeGraphicalUserInterface();

    public boolean isWellFormed() {
        return this.meniu != null;
    }

    public DeliveryService() {
        listaComenzi = new HashMap<Order, List<MenuItem>>();
        meniu = new HashSet<MenuItem>();
        meniu = (HashSet<MenuItem>) s.Deserializare(("Se.txt"));
        //comenzi = (List<Order>) s.Deserializare(("SerComenzi.txt"));
        listaComenzi = (Map<Order, List<MenuItem>>) s.Deserializare(("SeOrder6.txt"));


    }

    /**
     * @param mi meniu
     * @pre mi!=null
     * @post meniu!=null
     * @invariant meniu!=null
     */
    @Override
    public void addProduct(MenuItem mi) {
        assert (mi != null);
        meniu.add(mi);
        assert (meniu != null);
        assert (isWellFormed());
        Serializator s = new Serializator();
        Serializator.Serializare(meniu, "Se.txt");

    }

    public MenuItem isInMenu(String item) {
        MenuItem it = null;
        for (MenuItem i : meniu) {
            if (i.getTitle().equals(item)) {
                it = i;
            }
        }
        return it;
    }

    public List<MenuItem> getMenuItems(String str) {

        List<MenuItem> result = new ArrayList<MenuItem>();
        String[] sir = str.split(",");

        for (int i = 0; i < sir.length; i++) {

            for (MenuItem mi : meniu) {
                if (mi.getTitle().equals(sir[i])) {
                    result.add(mi);
                }
            }
        }
        return result;
    }

    public void addComp1(AdministratorGraphicalUserInterface ai) {
        try {
            List<MenuItem> productsList = null;

            String productName = ai.getNameComp();
            if (ai.getCompComp().length() > 1) {
                productsList = getMenuItems(ai.getCompComp());
                if (productsList.size() != 0) {

                    MenuItem newProduct = new CompositeProduct(productsList, productName, 1);

                    if (isInMenu(newProduct.getTitle()) == null) {
                        addProduct(newProduct);
                    } else {
                        JOptionPane.showMessageDialog(null, newProduct.getTitle() + " already in the menu!");
                    }
                }

            }

        } catch (Exception except) {

            JOptionPane.showMessageDialog(null, "X");
        }
    }

    /**
     * @param mi
     * @pre mi!=null
     * @post meniu!=null
     * @invariant meniu!=null
     */
    @Override
    public void deleteProduct(MenuItem mi) {
        assert (mi != null);
        //meniu.remove(t);
        assert (meniu != null);
        assert (isWellFormed());
        Serializator s = new Serializator();
        Serializator.Serializare(meniu, "Se.txt");


    }


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
     * @invariant meniu!=null
     */
    @Override
    public void editProduct(String nameu, String title, Float rating, Integer calories, Integer protein, Integer
            fat, Integer sodium, Integer price) {

        assert (title != null);
        assert (nameu != null);
        assert (price != null);
        for (MenuItem men : meniu) {


            if (men.getTitle().equals(nameu)) {
                men.setTitle(title);
                men.setRating(rating);
                men.setCalories(calories);
                men.setProteins(protein);
                men.setFats(fat);
                men.setSodium(sodium);
                men.setPrice(price);
            }


        }
        assert (isWellFormed());
        Serializator s = new Serializator();
        Serializator.Serializare(meniu, "Se.txt");

    }

    /**
     * @param nr numele produsului
     * @return MenuItems
     * @pre nr!=null
     * @invariant meniu!=null
     */
    @Override
    public HashSet<MenuItem> searchTitle(String nr) {
        assert (nr != null);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getTitle().equals(nr)).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }


    /**
     * @param nr rating
     * @return produsele cu rating-ul specificat
     * @pre nr>=0
     * @invariant meniu!=0
     */
    @Override
    public HashSet<MenuItem> searchRating(Float nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getRating() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    /**
     * @param nr numarul de calorii
     * @return produsele care contin nr. specificat de calorii
     * @pre nr>=0
     * @invariant meniu!=0
     */
    @Override
    public HashSet<MenuItem> searchCalories(int nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getCalories() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    /**
     * @param nr proteine
     * @return produsele care contin nr. specificat de proteine
     * @pre nr>=0
     * @invariant meniu!=0
     */
    @Override
    public HashSet<MenuItem> searchProtein(int nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getProteins() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    /**
     * @param nr grasimi
     * @return produsele care contin nr. specificat de grasimi
     * @pre nr>=0
     * @invariant meniu!=null
     */
    @Override
    public HashSet<MenuItem> searchFat(int nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getFats() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    /**
     * @param nr
     * @return produsele care indeplinesc conditia impusa
     * @pre nr>=0
     * @invariant meniu!=0
     */
    @Override
    public HashSet<MenuItem> searchSodium(int nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getSodium() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    /**
     * @param nr
     * @return produsele cu pretul cautat
     * @pre nr!=0
     * @invariant meniu!=0
     */
    @Override
    public HashSet<MenuItem> searchPrice(int nr) {
        assert (nr >= 0);
        HashSet<MenuItem> inf = new HashSet<>();
        inf = (HashSet<MenuItem>) meniu.stream().filter(t -> t.getPrice() == nr).collect(Collectors.toSet());
        assert (isWellFormed());
        return inf;
    }

    public Order findOrder(int id) {
        for (Order order : this.comenzi) {
            if (order.getClientID() == id)
                return order;
        }
        return null;
    }

    /**
     * @param order
     * @param produse
     * @pre order!=null
     * @post produse!=null
     * @invariant meniu!=0
     */
    @Override
    public void createNewOrder(Order order, List<MenuItem> produse) {
        assert (order != null);
        if (gol() == true) {
            comenzi.add(order);


            listaComenzi.put(order, produse);
            Serializator.Serializare(listaComenzi, "SeOrder6.txt");

            String s = "";
            int k1 = 0;
            for (MenuItem m : produse) {
                if (k1 == 0) {
                    s = m.getTitle();
                    k1++;
                } else {
                    s = s + "," + m.getTitle();
                }
            }
            setChanged();
            notifyObservers(order.getClientID() + " ordered:" + s);
        }
        assert (produse != null);
        assert (isWellFormed());


    }

    public boolean gol() {
        for (Order order : comenzi) {
            List<MenuItem> items = this.listaComenzi.get(order);
            if (items.size() == 0) {
                return false;
            }
        }
        return true;
    }


    public void createNewOrder1(Order order, List<MenuItem> productsList) {
        if (findOrder(order.getClientID()) == null) {
            if (gol() == true) {
                comenzi.add(order);
                int pret = computePrice(order);
                order.setPretTotal(pret);
                listaComenzi.put(order, productsList);
                Serializator.Serializare(listaComenzi, "SeOrder6.txt");

                String s = "";
                int k1 = 0;
                for (MenuItem m : productsList) {
                    if (k1 == 0) {
                        s = m.getTitle();
                        k1++;
                    } else {
                        s = s + "," + m.getTitle();
                    }
                }
                setChanged();
                notifyObservers(order.getClientID() + " ordered:" + s);

            }

        }


    }


    /**
     * @param order
     * @return pretul total al comenzii
     * @pre order!=null
     * @post pret>0
     * @invariant meniu!=null
     */
    @Override
    public int computePrice(Order order) {
        assert (order != null);
        List<MenuItem> itemsList = listaComenzi.get(order);
        int pret = 0;
        for (MenuItem menuitem : itemsList) {
            pret = pret + menuitem.getPret();
        }
        assert (isWellFormed());
        assert (pret > 0);
        return pret;
    }

    /**
     * @param o
     * @pre order!=null
     * @invariant meniu!=null
     */
    @Override
    public void generateBill(Order o) {
        assert (o != null);
        List<MenuItem> items = listaComenzi.get(o);
        comenzi.remove(o);
        String s = (o.getDate()).toString() + "\n";
        for (MenuItem mi : items) {
            s = s + mi.getTitle() + ".........." + mi.computePrice() + "ron\n";
        }
        s = s + "\n\nTotal:" + computePrice(o) + " ron";
        assert (isWellFormed());
        FileWriterr fw = new FileWriterr(s, o.getClientID());

    }

    public static <T> Predicate<T> distinct(Function<? super T, ?> NameExtractor) {
        Set<Object> s = ConcurrentHashMap.newKeySet();
        return p -> s.add(NameExtractor.apply(p));
    }

    /**
     * Metoda importa produsele din fisierul products.csv
     *
     * @throws IOException
     */
    @Override
    public void importProducts() {
        Function<String, BaseProduct> mi = (line) ->
        {
            String[] p = line.split(",");
            BaseProduct bp = new BaseProduct();
            bp.setTitle(p[0].toString());
            assert (p[0] != null);
            bp.setRating(Float.parseFloat(p[1].toString()));
            assert (p[1] != null);
            bp.setCalories(Integer.parseInt(p[2].toString()));
            assert (p[2] != null);
            bp.setProteins(Integer.parseInt(p[3].toString()));
            assert (p[3] != null);
            bp.setFats(Integer.parseInt(p[4].toString()));
            assert (p[4] != null);
            bp.setSodium(Integer.parseInt(p[5].toString()));
            assert (p[5] != null);
            bp.setPrice(Integer.parseInt(p[6].toString()));
            assert (p[6] != null);
            return bp;

        };
        ArrayList<BaseProduct> valIn;
        String fileName = "products.csv";
        File f = new File(fileName);
        InputStream fs = null;
        try {
            fs = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        valIn = (ArrayList<BaseProduct>) br.lines().skip(1).map(mi).filter(distinct(m -> m.getTitle())).collect(Collectors.toList());
        try {
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (BaseProduct i : valIn) {
            meniu.add(i);
        }
        for (MenuItem m : meniu) {
            System.out.println(m.toString());
            System.out.println("\n");
        }
        Serializator s = new Serializator();
        Serializator.Serializare(meniu, "Se.txt");
        System.out.println(meniu.size());

    }

    public void showP() {
        for (MenuItem m : meniu) {
            System.out.println("aa");
            System.out.println(m.toString());
        }
    }

    /**
     * @return produsele din meniu
     * @post JTable!=null
     * @pre meniu!=null
     */
    @Override
    public JTable showProducts() {

        assert (meniu != null);
        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();


        String[] header = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        Object[][] inf = new Object[meniu.size()][header.length];
        int k = 0;

        for (MenuItem i : meniu) {

            Vector<Object> dataTable = new Vector<Object>();
            inf[k][0] = i.getTitle();
            inf[k][1] = i.getRating();
            inf[k][2] = i.getCalories();
            inf[k][3] = i.getProteins();
            inf[k][4] = i.getFats();
            inf[k][5] = i.getSodium();
            inf[k][6] = i.getPrice();
            k++;
        }
        table = new JTable(inf, header);

        System.out.println(meniu.size());
        Set<MenuItem> aux = meniu.stream().filter(a -> a.getTitle().equals("meniu5")).collect(Collectors.toSet());

        for (MenuItem m : aux
        ) {
            System.out.println("heihirgo" + m.getTitle());

        }
        assert (table != null);
        return table;
    }

    public JTable showProducts2() {

        JTable table = new JTable();

        DefaultTableModel model = new DefaultTableModel();


        String[] header = {"Order ID", "Date", "Client ID", "Command"};
        Object[][] inf = new Object[meniu.size()][header.length];
        int k = 0;

        for (Order i : listaComenzi.keySet()) {
            System.out.println(listaComenzi.toString());

            for (MenuItem m : listaComenzi.get(i)) {
                inf[k][0] = i.getOrderID();
                inf[k][1] = i.getDate();
                inf[k][2] = i.getClientID();
                List<MenuItem> menu = listaComenzi.get(i);
                String sir = "";
                for (MenuItem men : menu) {
                    if (k == 0) {
                        sir = men.getTitle();
                    } else {
                        sir = sir + " " + men.getTitle();
                    }
                }
                inf[k][3] = sir;

            }
            k++;

        }
        table = new JTable(inf, header);

        return table;
    }

    private void memoriseLastIndex(int index) {
        String path = "";
        try (FileWriter file = new FileWriter(path)) {
            file.write(index);
        } catch (IOException e) {
            System.out.println("There is a problem with the IndexFile" + e.getMessage());
        }
    }

    private int getLastIndex() {
        String path = "";
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            int index = Integer.parseInt(file.readLine());
            return index;
        } catch (IOException e) {
            System.out.println("There is a problem with the IndexFile" + e.getMessage());
        }
        return 0;
    }


    public JTable list(HashSet<MenuItem> bp) {
        JTable table = new JTable();


        String[] header = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        Object[][] inf = new Object[bp.size()][header.length];
        int k = 0;

        for (MenuItem i : bp) {

            Vector<Object> dataTable = new Vector<Object>();
            inf[k][0] = i.getTitle();
            inf[k][1] = i.getRating();
            inf[k][2] = i.getCalories();
            inf[k][3] = i.getProteins();
            inf[k][4] = i.getFats();
            inf[k][5] = i.getSodium();
            inf[k][6] = i.getPrice();
            k++;
        }
        table = new JTable(inf, header);


        return table;
    }


    /**
     * @param ora1 start hour
     * @param ora2 end hour
     * @throws IOException
     * @pre ora1 <24
     * @pre ora2 <24
     * @post fisier inchis
     * @invariant meniu!=null
     */
    @Override
    public void raportUnu(int ora1, int ora2) {
        assert (ora1 < 24);
        assert (ora2 <24);
        Set<Order> so = listaComenzi.keySet().stream().filter(p -> p.getDate().getHours() >= ora1).filter(p -> p.getDate().getHours() <= ora2)
                .collect(Collectors.toSet());

        FileWriterr fw = new FileWriterr(so);

    }

    /**
     * @param nrComenzi
     * @pre nrComenzi>0
     * @post fisier inchis
     * @invariant meniu!=null
     */
    @Override
    public void raportDoi(int nrComenzi) {
        assert (nrComenzi > 0);
        List<MenuItem> prod = new ArrayList<>();
        StringBuilder sir = new StringBuilder();
        listaComenzi.keySet().stream().forEach(order -> prod.addAll(listaComenzi.get(order)));
        HashMap<MenuItem, Long> frecv = prod.stream().collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        Set<MenuItem> rezultat = frecv.keySet().stream().filter(menuItem -> frecv.get(menuItem) >= nrComenzi).collect(Collectors.toSet());
        rezultat.stream().forEach(menuItem -> sir.append(menuItem.toString()).append("->").append(frecv.get(menuItem)).append("\n"));
        FileWriterr fw = new FileWriterr(sir);
        assert (isWellFormed());
    }

    /**
     * @param nrComenzi
     * @param valoare
     * @pre valoare >0
     * @pre nrComenzi >0
     * @post fisier inchis
     * @invariant meniu!=null
     */
    @Override
    public void raportTrei(int nrComenzi, int valoare) {
        assert (valoare > 0);
        assert(nrComenzi>0);
        List<User> util = All.getUtilizatori().stream().
                filter(client -> listaComenzi.keySet().stream()
                        .filter(order -> order.getClientID() == client.getNri()
                                && listaComenzi.get(order).stream().map(MenuItem::computePrice)
                                .reduce(0, Integer::sum) >= valoare).count() > nrComenzi)
                .collect(Collectors.toList());
        StringBuilder s = new StringBuilder(util.toString());
        FileWriterr fw = new FileWriterr(s, 3);
        assert (isWellFormed());
    }


    /**
     *
     * @param z
     * @pre {z <=30}
     * @post {fisier inchis}
     * @invariant {meniu!=null}
     */
    @Override
    public void raportPatru(int z) {
        assert (z<=30);
        //filtru dupa zi
        Set<Order> ok = listaComenzi.keySet().stream().filter(order -> order.getDate().getDay()-1 == z).collect(Collectors.toSet());
        List<MenuItem> prod = new LinkedList<>();
        StringBuilder s = new StringBuilder("");
        ok.stream().forEach(order -> prod.addAll(listaComenzi.get(order)));
        HashMap<MenuItem, Long> frecv = prod.stream().collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
        frecv.keySet().stream().forEach(menuItem -> s.append("\n").append(menuItem.toString()).append("\n"));
        FileWriterr fw = new FileWriterr(s, 'a');
        assert (isWellFormed());
    }

}
