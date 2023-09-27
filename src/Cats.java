public class Cats {
    private String name;

    public Cats(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void Print(){
        System.out.println(this.name);
    }
}
