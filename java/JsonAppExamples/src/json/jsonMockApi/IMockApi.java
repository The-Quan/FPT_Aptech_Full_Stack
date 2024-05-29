package json.jsonMockApi;

import java.util.List;

public interface IMockApi {
    public void delete(EntityMockApi entityMockApi);
    public void add(EntityMockApi entityMockApi);
    public void update(EntityMockApi entityMockApi);
    public List<EntityMockApi> getAll();

}
