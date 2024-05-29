package json.jsonMockApi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MockApi implements IMockApi {
    @Override
    public void delete(EntityMockApi entityMockApi) {
        final String Url_delete = "https://656ae3dcdac3630cf7276592.mockapi.io/json/" + entityMockApi.getId();
        try {
            URL url = new URL(Url_delete);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            boolean success = responseCode == HttpURLConnection.HTTP_OK;

            if (success) {
                System.out.println("User deleted successfully on MockAPI.");
            } else {
                System.out.println("Failed to delete user on MockAPI. Response code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void add(EntityMockApi entityMockApi) {
        try {
            URL url = new URL("https://656ae3dcdac3630cf7276592.mockapi.io/json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Chuyển đổi  User thành chuỗi JSON
            Gson gson = new Gson();
            String jsonData = gson.toJson(entityMockApi);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Data created successfully on MockAPI.");
            } else {
                System.out.println("Failed to create data on MockAPI. Response code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(EntityMockApi entityMockApi) {
        try {
            URL url = new URL("https://656ae3dcdac3630cf7276592.mockapi.io/json/" + entityMockApi.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String jsonData = gson.toJson(entityMockApi);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input,0,input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("User updated successfully on MockAPI.");
            } else {
                System.out.println("Failed to update user on MockAPI. Response code: " + responseCode);
            }
            connection.disconnect();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<EntityMockApi> getAll() {
        try {
            URL url = new URL("https://656ae3dcdac3630cf7276592.mockapi.io/json" );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();
            Gson gson = new Gson();
            List<EntityMockApi> entityMockApis = gson.fromJson(response.toString(), new TypeToken<List<EntityMockApi>>(){}.getType());
            connection.disconnect();
            return entityMockApis;
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch users from MockAPI.", e);
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
        EntityMockApi entityMockApi = new EntityMockApi(1,"quan","hanoi","quan@gmail.com");
        MockApi mockApi = new MockApi();
        mockApi.add(entityMockApi);
    }
}
