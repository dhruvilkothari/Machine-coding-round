package Entity;

import java.util.List;

public class Restaurant {
    private final long restId;
    private String name;
    private String location;
    private List<MenuItem>menuItems;

    public Restaurant(long restId, String name, String location, List<MenuItem> menuItems) {
        this.restId = restId;
        this.name = name;
        this.location = location;
        this.menuItems = menuItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
