package task6;

public class Programmer extends Employee{
    private Integer kolOfSittingHours;

    public Programmer(String name, Integer age, Integer experience,Integer kolOfSittingHours) {
        super(name, age, experience);
        this.kolOfSittingHours = kolOfSittingHours;
    }

    public Integer getKolOfSittingHours() {
        return kolOfSittingHours;
    }

    public void setKolOfSittingHours(Integer kolOfSittingHours) {
        this.kolOfSittingHours = kolOfSittingHours;
    }
}
