package milkman_manage_system;

import java.time.LocalDate;

public class Customer {

  private String Name;
  private String Address;
  private LocalDate DateOfJoining;
  private double MonthlyLitres;
  private double ratePerLitre;
  private double TotalDue;

  public Customer(
    String Name,
    String Address,
    LocalDate DateOfJoining,
    double MonthlyLitres,
    double ratePerLitre
  ) {
    this.Name = Name;
    this.Address = Address;
    this.DateOfJoining = DateOfJoining;
    this.MonthlyLitres = MonthlyLitres;
    this.ratePerLitre = ratePerLitre;
    this.TotalDue = 0.0;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public void setAddress(String Address) {
    this.Address = Address;
  }

  public void setJoinDate(LocalDate joinDate) {
    this.DateOfJoining = joinDate;
  }

  public void setMonthlyLitres(double ltr) {
    MonthlyLitres = ltr;
  }

  public void setRatePerLitre(double rpl) {
    ratePerLitre = rpl;
  }

  public String getName() {
    return Name;
  }

  public String getAddress() {
    return Address;
  }

  public LocalDate getJoinDate() {
    return DateOfJoining;
  }

  public double getMonthlyLitres() {
    return MonthlyLitres;
  }

  public double getTotalDue() {
    return TotalDue;
  }

  public double getRatePerLitre() {
    return ratePerLitre;
  }

  public void calculate_monthly_due() {
    TotalDue += ratePerLitre * MonthlyLitres;
  }

  public String toString() {
    return (
      "Customer{" +
      "name='" +
      Name +
      '\'' +
      ", address='" +
      Address +
      '\'' +
      ", joinDate=" +
      DateOfJoining +
      ", monthlyLiters=" +
      MonthlyLitres +
      ", totalDue=" +
      TotalDue +
      '}'
    );
  }

  public static void main(String[] args) {
    Customer cust = new Customer(
      "Khushi Rana",
      "I-420 Delta 2",
      LocalDate.of(2024, 02, 14),
      3,
      65
    );

    System.out.println(cust.toString());
  }
}
