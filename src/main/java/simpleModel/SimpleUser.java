package simpleModel;

import java.io.Serializable;
import java.lang.IndexOutOfBoundsException;
import java.util.List;

public class SimpleUser implements Serializable {

    private int ID;

    private String name;

    private String login;

    private String password;

    private List<SimplePoint> simplePoints;

    public SimpleUser() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SimplePoint getPoint(int i) {
        try {
            return simplePoints.get(i);
        } catch (IndexOutOfBoundsException exp) {
            System.out.print("Выход за пределы массива пользователей");
        }
        return null;
    }

    public void addPoint(int i, SimplePoint cars) {
        simplePoints.add(i, cars);
    }

    public void removePoint(int i) {
        simplePoints.remove(i);
    }

    public int getPointSize() {
        return simplePoints.size();
    }

    public void setSimplePoints(List<SimplePoint> points) {
        this.simplePoints = points;
    }

    public List<SimplePoint> getSimplePoints() {
        return simplePoints;
    }
}
