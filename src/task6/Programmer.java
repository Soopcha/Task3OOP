package task6;

import java.util.Date;

public class Programmer extends Employee implements ScrumMaster,TeamLeader,TechLead{
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

    @Override
    public void assessmentOfTheLevelOfTeaching(Integer assessment) {
        if (assessment < theLowerThresholdOfTheTeaching){
            System.out.println("Программист постарается лучше");
        } else {
            System.out.println("Программист рад вашей оценке");
        }
    }

    @Override
    public void assignTask(Employee employee, String task) {
        System.out.println(employee.getName() + " программист получил таск "+ task);
    }

    @Override
    public void setDeadline(String task, Date deadline) {
        System.out.println(task+"время сдачи для программиста  " + deadline);
    }

    @Override
    public void printHard() {
        System.out.println("Проект сложный");
    }
}
