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
        return Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
