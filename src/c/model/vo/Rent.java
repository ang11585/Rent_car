package c.model.vo;

import java.sql.Date;

public class Rent {
    private int rentNo;
    private int carNo;
    private int memberNo;
    private Date rentStart;
    private Date rentEnd;
    private int rentCost;
    private String insuranceVariety;
    private int insuranceCost;

    public Rent() {}

    public int getRentNo() {
        return rentNo;
    }

    public void setRentNo(int rentNo) {
        this.rentNo = rentNo;
    }

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Date getRentStart() {
        return rentStart;
    }

    public void setRentStart(Date rentStart) {
        this.rentStart = rentStart;
    }

    public Date getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public String getInsuranceVariety() {
        return insuranceVariety;
    }

    public void setInsuranceVariety(String insuranceVariety) {
        this.insuranceVariety = insuranceVariety;
    }

    public int getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(int insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    @Override
    public String toString() {
        return
                this.rentNo + ", " +
                this.carNo + ", " +
                this.memberNo + ", " +
                this.rentStart + ", " +
                this.rentEnd + ", " +
                this.rentCost + ", " +
                this.insuranceVariety + ", " +
                this.insuranceCost + "원";
    }
}
