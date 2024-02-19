package milkman_manage_system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Milkman {

  private List<Customer> customers;

  public Milkman() {
    this.customers = new ArrayList<>();
  }

  public void add_new_customer(Customer customer) {
    customers.add(customer);
  }

  public void remove_customer(Customer customer) {
    customers.remove(customer);
  }

  public void collectPayments() {
    for (Customer customer : customers) {
      customer.calculate_monthly_due();
      LocalDate joinDate = customer.getJoinDate();
      System.out.println(
        "Collecting payment from " +
        customer.getName() +
        " for the month of " +
        joinDate.getMonth()
      );
      System.out.println("Total due : " + customer.getTotalDue());
    }
  }

  public void remind_customers_payment(LocalDate currentDate) {
    for (Customer customer : customers) {
      LocalDate joinDate = customer.getJoinDate();
      LocalDate dueDate = joinDate.plusMonths(1); // Add 1 month to joinDate using plusMonths

      if (currentDate.isEqual(dueDate)) { // Check if dates are equal using isEqual
        System.out.println(
          String.format(
            "Reminder: Collect payment for the month of %s from %s",
            joinDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")), // Format month and year
            customer.getName()
          )
        );
      }
    }
  }

  public void remind_customers_due_payment(LocalDate currentDate) {
    for (Customer customer : customers) {
      LocalDate paymentDate = customer.getJoinDate(); // Assuming customer has a getPaymentDate method

      if (currentDate.isEqual(paymentDate)) { // Check if today is the payment date
        System.out.println(
          String.format(
            "Reminder: Today is your payment due date for %s, %s. Please make your payment as soon as possible.",
            customer.getName(),
            customer.getTotalDue() // Assume a getTotalDue method exists
          )
        );
      }
    }
  }

  //   public void remind_customers_payment(Calendar currentDate) {
  //     for (Customer customer : customers) {
  //       Calendar dueDate = (Calendar) customer.getJoinDate().clone();
  //       dueDate.add(Calendar.MONTH, 1);

  //       if (currentDate.compareTo(dueDate) == 0) {
  //         System.out.println(
  //           "Reminder: Collect payment for the month of " +
  //           customer.getJoinDate().getTime() +
  //           " from " +
  //           customer.getName()
  //         );
  //       }
  //     }
  //   }

  public void update_customer_details(String customerName) {
    Scanner scan = new Scanner(System.in);

    // Find customer by name
    Customer foundCustomer = null;
    for (Customer customer : customers) {
      if (customer.getName().equalsIgnoreCase(customerName)) {
        foundCustomer = customer;
        break;
      }
    }

    if (foundCustomer == null) {
      System.out.println("Customer not found ... ");
      return;
    }

    System.out.println(
      "Updating details for customer " + foundCustomer.getName()
    );

    boolean isUpdating = true;
    while (isUpdating) {
      // Allow milkman to update details
      System.out.println("1. Update address !!");
      System.out.println("2. Update Monthy Litres !!");
      System.out.println("3. Update Rate Per Litre !!");
      System.out.println("4. Updating done !!");

      int choice = scan.nextInt();
      scan.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter new Address: ");
          String newAddress = scan.nextLine();
          foundCustomer.setAddress(newAddress);
          System.out.println("Address updated successfully ...");
          break;
        case 2:
          System.out.println("Enter new monthly Litres: ");
          double newLitres = scan.nextDouble();
          foundCustomer.setMonthlyLitres(newLitres);
          System.out.println("Monthly Litres updated successfully ...");
          break;
        case 3:
          System.out.println("Enter new Rate per Litre: ");
          double rate = scan.nextDouble();
          foundCustomer.setRatePerLitre(rate);
          System.out.println("Rate per Litres updated successfully ...");
          break;
        case 4:
          isUpdating = false;
          break;
        default:
          System.out.println("Invalid choice ...");
      }
    }

    System.out.println("Details updated successfully ...");
    scan.close();
  }

  public void generate_monthly_report(LocalDate currentDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy"); // Format month and year

    System.out.println("Monthly report for " + currentDate.format(formatter)); // Use formatter

    for (Customer customer : customers) {
      System.out.println("Customer name: " + customer.getName());
      System.out.println("Customer Address: " + customer.getAddress());
      System.out.println(
        "Customer monthlyitres: " + customer.getMonthlyLitres()
      );
      System.out.println(
        "Customer Rate Per litre: " + customer.getRatePerLitre()
      );
      System.out.println("Total Due: " + customer.getTotalDue());
      System.out.println("--------");
    }
  }
}
