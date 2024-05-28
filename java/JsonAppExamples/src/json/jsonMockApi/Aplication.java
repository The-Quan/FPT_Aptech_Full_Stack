package json.jsonMockApi;

import java.util.Scanner;

public class Aplication {
    CMockApi cMockApi = new CMockApi();
    EntityMockApi entity = new EntityMockApi();
    Scanner sc = new Scanner(System.in);
    public void delete(){
        System.out.println("----- delete -----");
        System.out.println("enter id: ");
        int id = sc.nextInt();
        entity.setId(id);
        cMockApi.deleteMockApi(entity);
    }

    public static void main(String[] args) {
        Aplication aplication = new Aplication();
        aplication.delete();
    }
}
