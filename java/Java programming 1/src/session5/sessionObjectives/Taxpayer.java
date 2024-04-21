package session5.sessionObjectives;

public abstract class Taxpayer {
    private String id;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract double pay();
}
