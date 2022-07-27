package net.javaguides.user_management.model;

public class Users {
    protected int id;
    protected String name;
    protected String email ;
    protected String country;
//CONTRUCTOR KHONG TUONG MINH / KHONG THAM SO/ DEFAULT
    public Users() {
    }
//CONSTRUCTOR TƯỜNG MINH
    public Users(int id, String name, String email, String country) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public Users(String name, String email, String country) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
// email on the left is the field name, email on the right is the parameter
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
