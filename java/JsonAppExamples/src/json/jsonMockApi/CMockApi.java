package json.jsonMockApi;

import java.util.List;

public class CMockApi {
    MockApi mockApi = new MockApi();
    public void deleteMockApi(EntityMockApi entityMockApi){
        mockApi.delete(entityMockApi);
    }
    public void addMockApi(EntityMockApi entityMockApi){
        mockApi.add(entityMockApi);
    }
    public void update(EntityMockApi entityMockApi){

    }
    public List<EntityMockApi> getAll(){
        List<EntityMockApi> getALl = mockApi.getAll();
        return getALl;
    }
}
