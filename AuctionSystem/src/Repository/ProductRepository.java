package Repository;

import Entity.Product;

public class ProductRepository extends Repository<Product> {
    @Override
    public Product save(Product data) {
        dataMap.putIfAbsent(data.getId(), data);
        return data;
    }
}
