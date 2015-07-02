package dao;

import java.util.List;

/**
 *
 * @author 
 */
public interface GenericDAO<T> {

    public void save(T object);
    
    public Integer savereturn(T object);

    public void saveOrUpdate(T object);

    public void update(T object);

    public void delete(T object);

    public void deleteAll();

    public void deleteAllWhere(String value, Object object);

    public T searchById(int id);

    public T searchBy(String value, Object object);

    public List<T> listAll();

    public List<T> listAllWhere(String value, Object object);

    public List<T> listAllWhereOrderBy(String value, Object object, String order);

    public List<T> listAllOrderBy(String value);

    public List<T> listAllOrderDescBy(String value);

    public int countRows();
}
