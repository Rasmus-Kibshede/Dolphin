package system.member;

import java.time.LocalDate;

//Michala
public class Member implements Comparable<Member>{
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private boolean active;
    private boolean inDebt;
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
        this.inDebt = false;
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

    public void setInDebt(boolean inDebt) {
        this.inDebt = inDebt;
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

    public int compareTo(Member member){
        return this.memberNumber - member.getMemberNumber();
    }

    @Override
    public String toString() {
        return "Member number: "
                + memberNumber
                + ". Name: "
                + name
                + ". Date of Birth: "
                + dateOfBirth
                + ". Email: "
                + email
                + " Phone Number: "
                + phoneNumber
                + ". Membership "
                + active
                + ". Not in debt: "
                + inDebt
                + ". Memberprice: "
                + membershipPrice
                + "\n"
        ;
    }
}