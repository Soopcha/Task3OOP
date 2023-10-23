package task6;

import java.util.ArrayList;
import java.util.Date;

public class Analyst extends Employee implements ProductOwner, ScrumMaster,TeamLeader{

    private ArrayList<String> tasks;
    public Analyst(String name, Integer age, Integer experience, ArrayList<String> tasks) {
        super(name, age, experience);
        this.tasks = tasks;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void evaluateQuality(Integer assessment) {
        if (assessment < qualityStandards){
            System.out.println("Мы будем стараться лучше для нашего продукта");
        } else {
            System.out.println("Спасибо за положительную оценку продукта");
        }
    }


    @Override
    public void assessmentOfTheLevelOfTeaching(Integer assessment) {
        if (assessment < theLowerThresholdOfTheTeaching){
            System.out.println("Скрам мастер постарается лучше");
        } else {
            System.out.println("Скрам мастер рад вашей оценке");
        }
    }

    @Override
    public void assignTask(Employee employee, String task) {

    }

    @Override
    public void setDeadline(String task, Date deadline) {

    }
}
