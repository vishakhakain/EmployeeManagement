//Paul & Robert
package employeemanagement;

public class Programmers extends Employee{
    
    private String ProgramLang;
    int bonusper = 20;

    public Programmers(String name, String email, String gender, String dateOfBirth, int salary,String ProgramLang) {
        super(name,email,gender,dateOfBirth,salary);
        this.ProgramLang = ProgramLang;
    }

    
    public String getProgramLang() {
        return ProgramLang;
    }

    
    public void setProgramLang(String ProgramLang) {
        this.ProgramLang = ProgramLang;
    }
    
    @Override
    public int calcBonus() {
        return this.salary*bonusper/100;
    }

    
    
}
