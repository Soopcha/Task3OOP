package task6;
//мне 2   варик
/*
организация: классы сотрудник, программист, аналитик, тестировщик; интерфейсы
продовнер, тимлид, техлид, скрам-мастер.
 */

import java.util.ArrayList;

public class MainSix {
    public static void main(String[] args) {
        ArrayList<String> taskOfAnal = new ArrayList<>();
        ProductOwner analyst = new Analyst("Егорка",123,56,taskOfAnal);
        analyst.evaluateQuality(10);

        ScrumMaster analyst2 = new Analyst("Егорка",123,56,taskOfAnal);
        analyst2.assessmentOfTheLevelOfTeaching(56);
    }

}
