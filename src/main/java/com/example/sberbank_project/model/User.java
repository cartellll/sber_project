/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sberbank_project.model;


import java.io.Serializable;
import java.lang.IndexOutOfBoundsException;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "users")
@XmlRootElement(name = "User")


public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "usersSequence", sequenceName = "users_SEQUENCE", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSequence")
    @Column(name = "id", nullable = false, updatable = false)
    private int ID;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
    @JoinTable(name = "userpoint", joinColumns = {
            @JoinColumn(name = "id_user", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "id_point", referencedColumnName = "id")})
    @ManyToMany
    private List<Point> points;

    public User() {
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

    public Point getPoint(int i) {
        try {
            return points.get(i);
        } catch (IndexOutOfBoundsException exp) {
            System.out.print("Выход за пределы массива пользователей");
        }
        return null;
    }

    public void addPoint(int i, Point cars) {
        points.add(i, cars);
    }

    public void removePoint(int i) {
        points.remove(i);
    }

    public int getPointSize() {
        return points.size();
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
