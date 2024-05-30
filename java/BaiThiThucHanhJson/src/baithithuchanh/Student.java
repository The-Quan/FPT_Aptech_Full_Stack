package baithithuchanh;


import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Subject> subjects;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", Name: ").append(name).append("\n");
        sb.append("Subjects:\n");
        for (Subject subject : subjects) {
            sb.append(subject).append("\n");
        }
        return sb.toString();
    }

    public void addSubject(baithithuchanh.Subject subject) {
    }
}
