package Model;

public class AdminTable extends User {
    private int id;
    private String pw;

    public AdminTable() {

    }

    public AdminTable(int id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
