package task6;
//мне 2   варик
/*
организация: классы сотрудник, программист, аналитик, тестировщик; интерфейсы
продовнер, тимлид, техлид, скрам-мастер.
 */

import java.util.ArrayList;
import java.util.Date;

public class MainSix {
    public static void main(String[] args) {
        ArrayList<String> taskOfAnal = new ArrayList<>();
        ProductOwner analyst = new Analyst("Егорка",123,56,taskOfAnal);
        analyst.evaluateQuality(10);

        ScrumMaster analyst2 = new Analyst("Егорка",123,56,taskOfAnal);
        analyst2.assessmentOfTheLevelOfTeaching(56);

        Date date = new Date();
        TeamLeader analyst3 = new Analyst("Егорка",123,56,taskOfAnal);
        analyst3.setDeadline("Сделать сайт",date);


        System.out.println();
        System.out.println();


        ScrumMaster programmer1 = new Programmer("Василий",123,3,34);
        programmer1.assessmentOfTheLevelOfTeaching(23);

        TeamLeader programmer2 = new Programmer("Василий",123,3,34);
        programmer2.setDeadline("купить кукурузу", date);

        TechLead programmer3 = new Programmer("Василий",123,3,34);
        programmer3.printHard();


        System.out.println();
        System.out.println();



        TeamLeader tester = new Tester("Альбина",2345,4,56);
        tester.setDeadline("Сделать игру",date);

        ScrumMaster tester2 = new Tester("Альбина",2345,4,56);
        tester2.assessmentOfTheLevelOfTeaching(0);
    }

}
