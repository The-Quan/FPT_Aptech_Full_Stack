package session11_gennerics.model;

public interface ServiceFuntion<T> {
    void create (T object);
    void update (T object);
    void delete (T object);
    void getAll (T object);

}
