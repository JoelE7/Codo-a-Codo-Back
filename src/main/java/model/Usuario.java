package model;

import java.util.Date;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String name;
    private String last_name;
    private String email;

    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public Usuario(String username, String password, String name, String last_name, String email){
        this.username = username;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public Usuario(int id,String username, String password, String name, String last_name, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
