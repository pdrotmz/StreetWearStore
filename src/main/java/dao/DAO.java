package dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    void saveProduct(T t);
    List<T> findAll();
    Optional<T> findProductById(long id);
    Optional<T> findProductByName(String name);
    void deleteProductById(long id);
}
