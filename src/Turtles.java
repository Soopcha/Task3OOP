public class Turtles extends Animal{
    private String gender;
    private Integer age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public Turtles(String gender, Integer age, String name, String breed) {
        super(name, breed);
        this.gender = gender;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void print() {
        System.out.println("Turtles is " + super.getName() + " "+ super.getBreed() + " " + age + " "+  gender );
    }
}
