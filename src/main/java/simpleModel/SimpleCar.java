/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleModel;

import com.sun.istack.internal.NotNull;

import java.io.*;
import javax.validation.constraints.Max;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class SimpleCar implements Serializable, Comparable<SimpleCar> {

    private long ID;


    @Size(max = 30)
    @NotEmpty
    @NotNull
    private String model;

    @Size(max = 30)
    @NotEmpty
    private String manufacturer;

    @Positive
    @NotNull
    private int quantity;

    @Positive
    @NotNull
    private int cost;

    private SimplePoint point;

    public SimpleCar() {
    }

    public SimpleCar(long ID, String model, String manufacturer, int quantity, int cost) {
        setID(ID);
        setModel(model);
        setManufacturer(manufacturer);
        setQuantity(quantity);
        setCost(cost);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.cost;
        //result = prime * result + this.;
        return result;
    }

    public int compareTo(SimpleCar car) {

        if (this.cost > car.cost)
            return 1;
        else
            return -1;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException excp) {
                System.out.print("Неверно заданы значения");
            }
        }
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException excp) {
                System.out.print("Неверно заданы значения");
            }
        }
        this.cost = cost;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public SimplePoint getPoint() {
        return this.point;
    }

    public void setPoint(SimplePoint point) {
        this.point = point;
    }

    public static void outputObject(SimpleCar car, PrintWriter pW) {
        pW.println(car.ID);
        pW.println(car.model);
        pW.println(car.manufacturer);
        pW.println(car.quantity);
        pW.println(car.cost);
        pW.println(car.point);
    }

    public static SimpleCar inputObject(BufferedReader br) {
        String model = null;
        String manufacturer = null;
        int quantity = 0;
        int ID = 0;
        int cost = 0;
        int point = 0;
        try {
            ID = Integer.parseInt(br.readLine());
            model = br.readLine();
            manufacturer = br.readLine();
            quantity = Integer.parseInt(br.readLine());
            cost = Integer.parseInt(br.readLine());
            point = Integer.parseInt(br.readLine());
        } catch (IOException ioe) {
            System.out.print("Ошибка при чтении из файла");
        }

        return new SimpleCar(ID, model, manufacturer, quantity, cost);

    }

}


