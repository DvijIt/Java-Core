package lesson9.task1.check;

public class Company {
    private String name;
    private String coutryFounded;

    protected String code;

    public int someField;

    public Company(String name, String coutryFounded) {
        this.name = name;
        this.coutryFounded = coutryFounded;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String coutryFounded() {
        return coutryFounded;
    }

    public void setСoutryFounded(String coutryFounded) {
        this.coutryFounded = coutryFounded;
    }
}
