package task6;

import java.util.Date;

public class Tester extends Employee implements ScrumMaster, TeamLeader{
    private Integer kolOfProgFinish;

    public Integer getKolOfProgFinish() {
        return kolOfProgFinish;
    }

    public void setKolOfProgFinish(Integer kolOfProgFinish) {
        this.kolOfProgFinish = kolOfProgFinish;
    }

    public Tester(String name, Integer age, Integer experience, Integer kolOfProgFinish) {
        super(name, age, experience);
        this.kolOfProgFinish=kolOfProgFinish;
    }


    @Override
    public void assessmentOfTheLevelOfTeaching(Integer assessment) {
        if (assessment < theLowerThresholdOfTheTeaching){
            System.out.println("Тестер постарается лучше");
        } else {
            System.out.println("Тестер рад вашей оценке");
        }
    }
    @Override
    public void assignTask(Employee employee, String task) {
        System.out.println(employee.getName() + " тестер получил таск "+ task);
    }

    @Override
    public void setDeadline(String task, Date deadline) {
        System.out.println(task+"время проверки для тестера  " + deadline);
    }
}
