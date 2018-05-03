//Paul & Robert
package employeemanagement;

public class Technicians extends Employee {
    
    private String Floor;
    int bonusper = 15;

    public Technicians(String name, String email, String gender, String dateOfBirth, int salary,String Floor) {
        super(name, email, gender, dateOfBirth, salary);
        this.Floor = Floor;
    }

    
    public String getFloor() {
        return Floor;
    }

    
    public void setFloor(String Floor) {
        this.Floor = Floor;
    }
    
    @Override
    public int calcBonus() {
        return this.salary*bonusper/100;
    }

}
