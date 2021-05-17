package system.member;

import java.time.LocalDate;

//Michala
public class Member {
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private boolean active;
    private boolean notFlagged;
    private double membershipPrice;
    private Payment payment = new Payment();

    public Member(String name,
                  LocalDate dateOfBirth,
                  String email,
                  String phoneNumber,
                  boolean active
    ) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setActive(active);
        this.notFlagged = true;
        setMembershipPrice();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setNotFlagged(boolean notFlagged) {
        this.notFlagged = notFlagged;
    }

    public void setMembershipPrice() {
        this.membershipPrice = payment.getPrice(this.dateOfBirth, this.active);
    }

    public double getMembershipPrice() {
        return membershipPrice;
    }
}