package Entity;

public class User extends Id<Long> {
    private final String name;
    public String getName() {
        return name;
    }

    public User(Long id, String name){

        super(id);
        this.name = name;
    }


}
