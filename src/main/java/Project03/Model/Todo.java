package Project03.Model;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String description;
    private Date target_date;
    private int username;
    private boolean is_done;

    public Todo() {
    }

    public Todo( String title, String description, Date target_date, int username, boolean is_done) {
        this.title = title;
        this.description = description;
        this.target_date = target_date;
        this.username = username;
        this.is_done = is_done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTarget_date() {
        return target_date;
    }

    public void setTarget_date(Date target_date) {
        this.target_date = target_date;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }
}
