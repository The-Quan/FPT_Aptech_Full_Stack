package session14_gennerrics.model;

import session14_gennerrics.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Model <T extends Entity<?>> {
    private List<T> entity1 = new ArrayList<>();
    public void addEntity(T entity){
        entity1.add(entity);
    }
    public List<T> getEntity1(){
        return entity1;
    }
}
