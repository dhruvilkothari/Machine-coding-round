package Utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong restId = new AtomicLong(1000);
    private static AtomicLong itemId = new AtomicLong(2000);


    public static Long getRestId(){
        return restId.incrementAndGet();
    }
    public static Long getItemId(){
        return itemId.incrementAndGet();
    }
}
