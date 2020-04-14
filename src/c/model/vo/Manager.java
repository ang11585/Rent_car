package c.model.vo;

public class Manager {
    private int managerNo;
    private String managerId;
    private String managerPwd;

    public Manager() {}

    public int getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(int managerNo) {
        this.managerNo = managerNo;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd;
    }

    @Override
    public String toString() {
        return
                this.managerNo + ", " +
                this.managerId + ", " +
                this.managerPwd;
    }
}
