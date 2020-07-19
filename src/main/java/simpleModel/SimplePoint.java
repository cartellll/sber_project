package simpleModel;

import com.example.sberbank_project.model.User;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.List;
import java.io.IOException;
import java.util.*;
import java.io.Serializable;


public class SimplePoint implements Serializable {

    private long ID;

    private List<SimpleCar> carsSimple;

    private List<User> users;

    public SimplePoint() {
    }

    public SimplePoint(long ID) {
        setID(ID);
    }


    public int getLengthArray() {
        return carsSimple.size();
    }

    public void addElement(int i, SimpleCar car) {
        carsSimple.add(i, car);
        car.setPoint(this);
    }

    public void removeElment(int i) {
        carsSimple.get(i).setPoint(null);
        carsSimple.remove(i);
    }

    public void sort() {
        try {
            Set<SimpleCar> set = new LinkedHashSet<SimpleCar>(carsSimple);
            carsSimple.clear();
            carsSimple.addAll(set);

            Collections.sort(carsSimple);
        } catch (IndexOutOfBoundsException q) {
            System.out.println("пустой или некорректный");
        }
    }

    public SimpleCar getElement(int i) {
        try {
            return carsSimple.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Выход за предел массив");
            return null;
        }
    }


    public void outputList(String Name) {
        PrintWriter Pw = null;
        try {
            Pw = new PrintWriter(Name);
            Pw.println(this.carsSimple.size());
            for (int i = 0; i < carsSimple.size(); i++) {
                SimpleCar.outputObject(carsSimple.get(i), Pw);
            }
        } catch (FileNotFoundException exp) {
            System.out.print("При выводе не найден файл");
        } finally {
            Pw.flush();
            Pw.close();
        }
    }

    public void inputList(String Name) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Name));
            int size = Integer.parseInt(br.readLine());

            for (int i = 0; i < size; i++) {
                this.addElement(i, SimpleCar.inputObject(br));
            }
        } catch (FileNotFoundException exp) {
            System.out.print("При чтении не найден файл");
        } catch (IOException exp) {
            System.out.print("Ошибка при чтении ");
        } catch (NumberFormatException excp) {
            System.out.print("Нарушен формат файла");
        }

    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return this.ID;
    }

    public void setCarsSimple(List<SimpleCar> cars) {
        this.carsSimple = cars;
    }

    public List<SimpleCar> getCarsSimple() {
        return carsSimple;
    }

    public List<User> getUsersList() {
        return users;
    }

    public void setUsersList(List<User> users) {
        this.users = users;
    }

}
