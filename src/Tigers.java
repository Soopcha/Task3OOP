public class Tigers extends Cats{
    private Integer numOfSrips;
    public Tigers(String name, Integer numOfSrips) {
        super(name);
        this.numOfSrips = numOfSrips;
    }

    public Integer getNumOfSrips() {
        return numOfSrips;
    }

    public void setNumOfSrips(Integer numOfSrips) {
        this.numOfSrips = numOfSrips;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(this.numOfSrips);
    }
}
