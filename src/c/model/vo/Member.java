package c.model.vo;

import java.sql.Date;

public class Member {
    private int memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private Date memberBirth;
    private String memberPhone;
    private String memberEmail;
    private String memberLicenseType;
    private String memberLicenseNo;
    private Date memberTestExp;
    private String memberAddress;

    public Member() {}

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(Date memberBirth) {
        this.memberBirth = memberBirth;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberLicenseType() {
        return memberLicenseType;
    }

    public void setMemberLicenseType(String memberLicenseType) {
        this.memberLicenseType = memberLicenseType;
    }

    public String getMemberLicenseNo() {
        return memberLicenseNo;
    }

    public void setMemberLicenseNo(String memberLicenseNo) {
        this.memberLicenseNo = memberLicenseNo;
    }

    public Date getMemberTestExp() {
        return memberTestExp;
    }

    public void setMemberTestExp(Date memberTestExp) {
        this.memberTestExp = memberTestExp;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    @Override
    public String toString() {
        return
                this.memberNo + ", " +
                this.memberId + ", " +
                this.memberPwd + ", " +
                this.memberName + ", " +
                this.memberBirth + ", " +
                this.memberPhone + ", " +
                this.memberEmail + ", " +
                this.memberLicenseType + ", " +
                this.memberLicenseNo + ", " +
                this.memberTestExp + ", " +
                this.memberAddress;
    }
}
