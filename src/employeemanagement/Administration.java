//Paul & Robert
package employeemanagement;

public class Administration extends Employee{
    
   private String Department;
   int bonusper = 10;

    public Administration(String name, String email, String gender, String dateOfBirth, int salary,String Department) {
        super(name,email,gender,dateOfBirth,salary);
        this.Department = Department;
    }

    
    public String getDepartment() {
        return Department;
    }

    
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    @Override
    public int calcBonus() {
        return this.salary*bonusper/100;
    }
    
    
}