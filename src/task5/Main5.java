package task5;

import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) {


        Student student1 = new Student("Олежик", 20);
        Student student2 = new Student("Олежик", 20);
        Student student3 = new Student("Семен", 19);
        Student student4 = student1;

        System.out.println(student1 == student1);      //t
        System.out.println(student1.equals(student1)); //t
        System.out.println(student1 == student2);      //f
        System.out.println(student1.equals(student2)); //t
        System.out.println(student1 == student3);      //f
        System.out.println(student1.equals(student3)); //f
        System.out.println(student1 == student4);      //t
        System.out.println(student1.equals(student4)); //t

        System.out.println();
        System.out.println();

        Passport passport1 = new Passport(1234);
        Passport passport2 = new Passport(1234);
        Passport passport3 = new Passport(5678);
        Passport passport4 = passport1;

        System.out.println(passport1 == passport1);      //t
        System.out.println(passport1.equals(passport1)); //t
        System.out.println(passport1 == passport2);      //f
        System.out.println(passport1.equals(passport2)); //t
        System.out.println(passport1 == passport3);      //f
        System.out.println(passport1.equals(passport3)); //f
        System.out.println(passport1 == passport4);      //t
        System.out.println(passport1.equals(passport4)); //t
        System.out.println();
        System.out.println();

        StudentWithPasport studentps1 = new StudentWithPasport(passport1);
        StudentWithPasport studentps2 = new StudentWithPasport(passport1);
        StudentWithPasport studentps3 = new StudentWithPasport(passport3);
        StudentWithPasport studentps4 = studentps1;

        System.out.println(studentps1 == studentps1);      //t
        System.out.println(studentps1.equals(studentps1)); //t
        System.out.println(studentps1 == studentps2);      //f
        System.out.println(studentps1.equals(studentps2)); //t
        System.out.println(studentps1 == studentps3);      //f
        System.out.println(studentps1.equals(studentps3)); //f
        System.out.println(studentps1 == studentps4);      //t
        System.out.println(studentps1.equals(studentps4)); //t
        System.out.println();
        System.out.println();
        System.out.println();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        StudentWithChangingField studentCh1 = new StudentWithChangingField("Иван",123,list);
        StudentWithChangingField studentCh2 = new StudentWithChangingField("Иван",123,list);
        StudentWithChangingField studentCh3 = new StudentWithChangingField("Иван",123,list2);
        StudentWithChangingField studentCh4 = studentCh1;

        System.out.println(studentCh1 == studentCh1);      //t
        System.out.println(studentCh1.equals(studentCh1)); //t
        System.out.println(studentCh1 == studentCh2);      //f
        System.out.println(studentCh1.equals(studentCh2)); //t
        System.out.println(studentCh1 == studentCh3);      //f
        System.out.println(studentCh1.equals(studentCh3)); //f
        System.out.println(studentCh1 == studentCh4);      //t
        System.out.println(studentCh1.equals(studentCh4)); //t
        System.out.println();
        System.out.println();

        list.clear();
        list.add(4);
        list.add(5);
        list.add(5);
        StudentWithChangingField studentCh5 = new StudentWithChangingField("Иван",123,list);
        System.out.println(studentCh5 == studentCh1);
        System.out.println(studentCh5.equals(studentCh1));
    }

}
