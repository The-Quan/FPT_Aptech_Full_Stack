package json.jsonMockApi;

public class CMockApi {
    MockApi mockApi = new MockApi();
    public void deleteMockApi(EntityMockApi entityMockApi){
        mockApi.delete(entityMockApi);
    }
    public void addMockApi(EntityMockApi entityMockApi){
        mockApi.add(entityMockApi);
    }
}
