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
    private int memberNumber;
    private Payment payment = new Payment();

    public Member(String name,
                  LocalDate dateOfBirth,
                  String email,
                  String phoneNumber,
                  boolean active,
                  int memberNumber) {

        setName(name);
        setDateOfBirth(dateOfBirth);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setActive(active);
        this.notFlagged = true;
        setMembershipPrice();
        setMemberNumber(memberNumber);
    }

    //SETTER
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

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    //GETTER
    public double getMembershipPrice() {
        return membershipPrice;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getActive() {
        return active;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    @Override
    public String toString() {
        return "Member number: "
                + memberNumber
                + " " // Er der en tanke bag at den er blank?
                + name
                + " " // Er der en tanke bag at den er blank?
                + dateOfBirth
                + ". Email: "
                + email
                + " Phone Number: "
                + phoneNumber
                + ". Membership "
                + active
                + ". Not in debt: "
                + notFlagged
                + ". Memberprice: "
                + membershipPrice
                + "\n"
        ;
    }
}