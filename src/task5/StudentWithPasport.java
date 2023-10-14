package task5;

import java.util.Objects;

public class StudentWithPasport {
    Passport passport;

    public StudentWithPasport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentWithPasport that = (StudentWithPasport) o;
        //какая-то подобная проверка чтобы челики с налом паспортами умерли
        if (passport==null){
           return false;
        }
        //какая-то подобая проверка кончилась

        return Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
