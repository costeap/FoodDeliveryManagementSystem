package PresentationLayer;

import DataLayer.Serializator;

import java.util.ArrayList;

public class All {
    Serializator ser = new Serializator();
    private static ArrayList<User> utilizatori = new ArrayList<>();

    public All() {
        utilizatori = (ArrayList<User>) ser.Deserializare("Serializare2.txt");
        boolean sem = false;
        for (User u : utilizatori) {
            if (u.getRole() == Role.ADMIN) {
                sem = true;
            }
        }
        if (sem == false) {
            User user = new User("admin", "1234", Role.setRole("ADMIN"));
            utilizatori.add(user);
        }
    }

    public void adaugareUtilizator(String user, String pass, Role role) {
        User user1 = new User(user, pass, role);
        user1.setNri(utilizatori.size() + 1);
        if (user1.getRole() != Role.ADMIN) {
            utilizatori.add(user1);
            Serializator s = new Serializator();
            s.Serializare(utilizatori, "Serializare2.txt");
        }
    }


    public static ArrayList<User> getUtilizatori() {
        return utilizatori;
    }

}
