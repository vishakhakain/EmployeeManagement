//Paul & Robert
package employeemanagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Management {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private int choose;
    private String chooseString;
    private String name;
    private String email;
    private String dateOfBirth;
    private String gender;
    private int salary;
    private int id;
    private String idString;

    public Management() {
        createDumData();
        MainMenu();
    }

    public void createDumData() {
        Administration newadmin = new Administration("Paul", "x@x.com", "male", "02-12-1200", 500, "a");
        Administration newadmin2 = new Administration("Paulz", "z@x.com", "male", "02-12-1200", 500, "b");
        Administration newadmin3 = new Administration("Paulz", "y@x.com", "male", "02-12-1200", 500, "c");
        Administration newadmin4 = new Administration("Paulzz", "w@x.com", "male", "02-12-1200", 500, "d");
        Administration newadmin5 = new Administration("Paulzz", "l@x.com", "male", "02-12-1200", 500, "e");
        addToArray(newadmin);
        addToArray(newadmin2);
        addToArray(newadmin3);
        addToArray(newadmin4);
        addToArray(newadmin5);
    }

    public boolean isDateValid(String date) {
        try {
            DateFormat dates = new SimpleDateFormat("dd-MM-yyyy");
            dates.setLenient(false);
            dates.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    static int numberOrNot(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return -1;

        }
    }

    public void changeName() {
        System.out.println("Enter the new name");

        searchArraybyId().setName(sc.nextLine());
    }

    public void changeEmail() {
        System.out.println("Enter the new Email");

        searchArraybyId().setEmail(sc.nextLine());
    }

    public void changeGender() {
        System.out.println("Enter the new Gender");

        searchArraybyId().setGender(sc.nextLine());
    }

    public void changeSalary() {
        do {
            System.out.println("Enter the new salary");
            chooseString = sc.nextLine();
        } while (numberOrNot(chooseString) == -1);
        searchArraybyId().setSalary(numberOrNot(chooseString));
    }

    public void averageSalary() {
        int averageSalary = 0;
        for (Employee employee : employeeList) {
            averageSalary += employee.getSalary();
        }
        System.out.println("The average of salary is " + averageSalary / employeeList.size());
    }

    public void totalBonus() {
        int totalBonus = 0;
        for (Employee employee : employeeList) {
            totalBonus += employee.calcBonus();
        }
        System.out.println("The total bonus is " + totalBonus);
    }

    public void minimumSalary() {
        int minimumSalary = employeeList.get(0).getSalary();
        for (Employee employee : employeeList) {
            if (employee.getSalary() < minimumSalary) {
                minimumSalary = employee.getSalary();
            }
        }
        System.out.println("The minimum salary is " + minimumSalary);
    }

    public void maximumSalary() {
        int maximumSalary = employeeList.get(0).getSalary();
        for (Employee employee : employeeList) {
            if (employee.getSalary() > maximumSalary) {
                maximumSalary = employee.getSalary();
            }
        }
        System.out.println("The maximum salary is " + maximumSalary);
    }

    public void percWomen() {
        int count = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender().toLowerCase().equals("female")) {
                count++;
            }
        }
        System.out.println("The percentage of women is " + count * 100 / employeeList.size() + "%");
    }

    public void percmen() {
        int count = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender().toLowerCase().equals("male")) {
                count++;
            }
        }
        System.out.println("The percentage of men is " + count * 100 / employeeList.size() + "%");
    }

    public void deleteEmployee() {
        employeeList.remove(searchArraybyId());
    }

    public Employee searchArraybyId() {
        for (Employee employee : employeeList) {
            if (id == employee.getId()) {
                return employee;
            }

        }
        return null;
    }

    private void addToArray(Employee emp) {
        employeeList.add(emp);
    }

    private void printAllEmployee() {
        String format = "%1$-10s|%2$-10s|%3$-20s|%4$-20s|%5$-20s|%6$-20s\n";
        System.out.format(format, "ID", "Name", "Email", "Birthdate", "Gender", "Salary");
        //System.out.println("ID\tName\tEmail\tBirthdate\tGender\tSalary");
        for (Employee employee : employeeList) {
            System.out.format(format, employee.getId(), employee.getName(), employee.getEmail(), employee.getDateOfBirth(), employee.getGender(), employee.getSalary());
            //System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getEmail() + "\t" + employee.getDateOfBirth() + "\t" + employee.getGender() + "\t" + employee.getSalary());
        }
    }

    private void printEmployee() {
        Employee employee = searchArraybyId();
        if (employee instanceof Administration) {
            String format = "%1$-10s|%2$-10s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|%7$-20s\n";
            System.out.format(format, "ID", "Name", "Email", "Birthdate", "Gender", "Salary", "Department");
            System.out.format(format, employee.getId(), employee.getName(), employee.getEmail(), employee.getDateOfBirth(), employee.getGender(), employee.getSalary(), ((Administration) employee).getDepartment());
            //System.out.println("ID\tName\tEmail\tBirthdate\tGender\tSalary\tDepartment");
            //System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getEmail() + "\t" + employee.getDateOfBirth() + "\t" + employee.getGender() + "\t" + employee.getSalary() + "\t" + ((Administration) employee).getDepartment());
        } else if (employee instanceof Technicians) {
            String format = "%1$-10s|%2$-10s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|%7$-20s\n";
            System.out.format(format, "ID", "Name", "Email", "Birthdate", "Gender", "Salary", "Floor");
            System.out.format(format, employee.getId(), employee.getName(), employee.getEmail(), employee.getDateOfBirth(), employee.getGender(), employee.getSalary(), ((Technicians) employee).getFloor());
            //System.out.println("ID\tName\tEmail\tBirthdate\tGender\tSalary\tFloor");
            //System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getEmail() + "\t" + employee.getDateOfBirth() + "\t" + employee.getGender() + "\t" + employee.getSalary() + "\t" + ((Technicians) employee).getFloor());
        } else if (employee instanceof Programmers) {
            String format = "%1$-10s|%2$-10s|%3$-20s|%4$-20s|%5$-20s|%6$-20s|%7$-20s\n";
            System.out.format(format, "ID", "Name", "Email", "Birthdate", "Gender", "Salary", "Programming Language");
            System.out.format(format, employee.getId(), employee.getName(), employee.getEmail(), employee.getDateOfBirth(), employee.getGender(), employee.getSalary(), ((Programmers) employee).getProgramLang());
            //System.out.println("ID\tName\tEmail\tBirthdate\tGender\tSalary\tProgramming Language");
            //System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getEmail() + "\t" + employee.getDateOfBirth() + "\t" + employee.getGender() + "\t" + employee.getSalary() + "\t" + ((Programmers) employee).getProgramLang());
        }
    }

    private void MainMenu() {
        do {
            System.out.println("Choose from the options below:");
            System.out.println("1.Employee Management");
            System.out.println("2.Employee Statistics");
            System.out.println("3.Exit");
            System.out.print("Choose:");
            chooseString = sc.nextLine();
            choose = numberOrNot(chooseString);
            if (choose < 1 || choose > 3) {
                System.out.println("Wrong Input!");
            }
        } while (choose < 1 || choose > 3);
        if (choose < 3) {
            chooseMainMenu();
        } else {
            System.out.println("Exit!");
        }
    }

    private void chooseMainMenu() {
        switch (choose) {
            case 1:
                EmployeeManagementMenu();
                break;
            case 2:
                EmployeeStatisticsMenu();

                break;
            case 3:
                break;

        }
    }

    private void EmployeeManagementMenu() {
        //print all the employee
        do {
            System.out.println("Choose from the options below:");
            System.out.println("1.Add Employee");
            System.out.println("2.Update Employee");
            System.out.println("3.Delete Employee");
            System.out.println("4.Search Employee");
            System.out.println("5.Display All Employee");
            System.out.println("0.Main Menu");
            System.out.print("Choose:");
            chooseString = sc.nextLine();
            choose = numberOrNot(chooseString);
            if (choose < 0 || choose > 5) {
                System.out.println("Wrong Input!");
            }
        } while (choose < 0 || choose > 5);
        if (choose == 0) {
            MainMenu();
        } else {
            chooseEmployeeMenu();
        }
    }

    private void EmployeeStatisticsMenu() {
        do {
            System.out.println("Choose from the options below:");
            System.out.println("1.Average Salary");
            System.out.println("2.Minimum Salary");
            System.out.println("3.Maximum Salary");
            System.out.println("4.Total Bonus");
            System.out.println("5.Percentage of Women");
            System.out.println("6.Percentage of Men");
            System.out.println("0.Main Menu");
            System.out.print("Choose:");
            chooseString = sc.nextLine();
            choose = numberOrNot(chooseString);
            if (choose < 0 || choose > 6) {
                System.out.println("Wrong Input!");
            }
        } while (choose < 0 || choose > 6);
        if (choose == 0) {
            MainMenu();
        } else {
            chooseEmployeeStatit();
        }
    }

    private void chooseEmployeeStatit() {
        switch (choose) {
            case 1:
                averageSalary();
                break;
            case 2:
                minimumSalary();
                break;
            case 3:
                maximumSalary();
                break;
            case 4:
                totalBonus();
                break;
            case 5:
                percWomen();
                break;
            case 6:
                percmen();
                break;
        }
        EmployeeStatisticsMenu();
    }

    private void chooseEmployeeMenu() {
        switch (choose) {
            case 1:
                System.out.println("What is the department:");
                do {
                    System.out.println("1.Administration");
                    System.out.println("2.Technicians");
                    System.out.println("3.Programmers");
                    System.out.print("Choose:");
                    chooseString = sc.nextLine();
                    choose = numberOrNot(chooseString);
                    if (choose < 1 || choose > 3) {
                        System.out.println("Wrong Input!");
                    }
                } while (choose < 1 || choose > 3);

                System.out.print("Full name:");
                name = sc.nextLine();

                System.out.print("Email:");
                email = sc.nextLine();

                do {
                    System.out.print("Date of birth:(dd-MM-yyyy)");
                    dateOfBirth = sc.nextLine();
                } while ((!dateOfBirth.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d")) || (!isDateValid(dateOfBirth)));

                do {
                    System.out.print("Gender:(Male/Female)");
                    gender = sc.nextLine();
                } while ((!gender.toLowerCase().equals("male")) && (!gender.toLowerCase().equals("female")));

                System.out.print("Salary:");
                salary = numberOrNot(sc.nextLine());

                switch (choose) {
                    case 1:
                        System.out.print("Department:");

                        Administration newadmin = new Administration(name, email, gender, dateOfBirth, salary, sc.nextLine());
                        addToArray(newadmin);
                        break;
                    case 2:
                        System.out.print("Floor:");
                        Technicians technician = new Technicians(name, email, gender, dateOfBirth, salary, sc.nextLine());
                        addToArray(technician);
                        break;

                    case 3:
                        System.out.print("Programming Language:");
                        Programmers program = new Programmers(name, email, gender, dateOfBirth, salary, sc.nextLine());
                        addToArray(program);
                        break;

                }
                break;
            case 2:
                System.out.println("Please enter the ID of the employee you want to update");
                System.out.print("ID:");
                idString = sc.nextLine();
                id = numberOrNot(idString);
                do {
                    System.out.println("What do you want to update?");
                    System.out.println("1.Name");
                    System.out.println("2.Email");
                    System.out.println("3.Gender");
                    System.out.println("4.Salary");
                    System.out.print("Choose:");
                    chooseString = sc.nextLine();
            choose = numberOrNot(chooseString);
                    if (choose < 1 || choose > 4) {
                        System.out.println("Invalid!");
                    }

                } while (choose < 1 || choose > 4);

                switch (choose) {
                    case 1:
                        changeName();
                        break;
                    case 2:
                        changeEmail();
                        break;
                    case 3:
                        changeGender();
                        break;
                    case 4:
                        changeSalary();
                        break;
                }
                break;
            case 3:
                System.out.println("Enter the id of the employee you want to delete");
                System.out.print("ID:");
                idString = sc.nextLine();
                id = numberOrNot(idString);
                deleteEmployee();
                break;
            case 4:
                System.out.println("Enter the id of the employee you want to search");
                System.out.print("ID:");
                idString = sc.nextLine();
                id = numberOrNot(idString);
                printEmployee();
                break;
            case 5:
                printAllEmployee();
                break;
            case 6:
                break;

        }
        EmployeeManagementMenu();
    }
}
