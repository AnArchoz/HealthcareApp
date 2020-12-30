package Model;

public class AdminTable {
    private int adminId;
    private int adminPw;

    public AdminTable(int adminId, int adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(int adminPw) {
        this.adminPw = adminPw;
    }
}
