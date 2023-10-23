package task6;

import java.util.Date;

public interface TeamLeader {
void assignTask(Employee employee, String task); // назначить задачу определенному сотруднику;
void setDeadline(String task, Date deadline); // установить крайний срок выполнения задачи;

}
