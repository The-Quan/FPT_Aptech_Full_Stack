package session14_gennerrics.controller;

import session14_gennerrics.entity.Entity;
import session14_gennerrics.model.Model;

import java.util.List;

public class Controller <T extends Entity<?>> {
    private Model<T> model;
    public Controller(Model<T> model){
        this.model = model;
    }
    public void addEntityController(T entity){
        model.addEntity(entity);
    }
    public List<T> getAllEntity(){
        return model.getEntity1();
    }
}
