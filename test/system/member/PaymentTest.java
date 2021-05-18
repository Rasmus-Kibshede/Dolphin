package system.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
  Payment payment;

  @BeforeEach
  void setUp(){
    payment = new Payment();
  }

  @Test
  void getPriceSenior() {
    //Arrange
    LocalDate date = LocalDate.parse("1995-12-12");
    boolean active = true;
    double expected = 1600.00;

    //Act
    double actual = payment.getPrice(date, active);

    //Access
    assertEquals(expected, actual);
  }

  @Test
  void getPriceJunior(){
    //Arrange
    LocalDate date = LocalDate.parse("2012-12-12");
    boolean active = true;
    double expected = 1000.00;

    //Act
    double actual = payment.getPrice(date, active);

    //Access
    assertEquals(expected, actual);
  }

  @Test
  void getPriceSeniorDiscount(){
    //Arrange
    LocalDate date = LocalDate.parse("1929-12-12");
    boolean active = true;
    double expected = 1200.00;

    //Act
    double actual = payment.getPrice(date, active);

    //Access
    assertEquals(expected, actual);
  }

  @Test
  void getPricePassive(){
    //Arrange
    LocalDate date = LocalDate.parse("1967-12-12");
    boolean active = false;
    double expected = 500.00;

    //Act
    double actual = payment.getPrice(date, active);

    //Access
    assertEquals(expected, actual);
  }
}