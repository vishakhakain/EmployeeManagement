//Paul & Robert
package employeemanagement;

public class Employee {

    static int idCounter = 1;
    int id;
    private String name;
    private String email;
    private String gender;
    private String dateOfBirth;
    public int salary;
    public int bonusper;

    public Employee(String name, String email, String gender, String dateOfBirth, int salary) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        //this.bonus = salary * bonus / 100;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int calcBonus() {
        return this.salary*bonusper/100;
    }


}
