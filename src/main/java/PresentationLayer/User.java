package PresentationLayer;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    private Role role;

    private int nr = 1;
    private int nri;


    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        if (this.role == Role.ADMIN) {
            this.nri = nr;
        }
       /* } else {
            nr++;
            this.nri = nr;
        }*/
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public int getNr() {
        return this.nr;
    }

    public int getNri() {
        return this.nri;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setNri(int nri) {
        this.nri = nri;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", nr=" + nr +
                ", nri=" + nri +
                '}';
    }
}
