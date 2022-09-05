package guru.springframework.sfgpetclinic.model;

public abstract class NamedEntity extends BaseEntity{

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
