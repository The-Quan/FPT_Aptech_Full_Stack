package json.jsonMockApi;

import java.util.ArrayList;
import java.util.List;
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
    public void add(){
        System.out.println("----- Add -----");
        System.out.println("enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter name: ");
        String name = sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        System.out.println("enter email: ");
        String email = sc.nextLine();

        EntityMockApi entityMockApi = new EntityMockApi(id,name,address,email);
        cMockApi.addMockApi(entityMockApi);
    }
    public void getAll(){
        List<EntityMockApi> entityMockApis = cMockApi.getAll();
        System.out.println("----- Get All -----");
        for (EntityMockApi entityMockApi: entityMockApis){
            System.out.println("ID: " + entityMockApi.getId());
            System.out.println("Name: " + entityMockApi.getName());
            System.out.println("Address: " + entityMockApi.getAddress());
            System.out.println("Email: " + entityMockApi.getEmail());
            System.out.println("------------------");
        }
    }
    public void start(){
        while (true){
            System.out.println("----- menu ------");
            System.out.println("1. add");
            System.out.println("2. update");
            System.out.println("3. delete");
            System.out.println("4. getAll");
            System.out.println("Enter: ");
            int i = sc.nextInt();
            switch (i){
                case 1:
                    add();
                    break;
                case 2:
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    getAll();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long thu lai");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Aplication aplication = new Aplication();
        aplication.start();
    }
}
