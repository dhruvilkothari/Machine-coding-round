package Entity;

import java.util.HashMap;

public class MenuItem {
    private HashMap<Long, Item> items ;

    public MenuItem(){
        items = new HashMap<>();
    }
    public void addItem(Item item){
        items.putIfAbsent(item.getItemId(), item);
    }
    public Item getItem(Long id){
        return items.getOrDefault(id,null);
    }

}
