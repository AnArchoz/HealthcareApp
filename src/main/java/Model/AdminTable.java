package Model;

public class AdminTable {
    private int adminId;
    private String adminPw;

    public AdminTable(int adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }
}
