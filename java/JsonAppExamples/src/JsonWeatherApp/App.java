package JsonWeatherApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {
    private static final String API_KEY = "3788f82a251a02fb59b91dec288d6e7c";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static void main(String[] args) {
        String city = "london";
        try {
            String urlString = String.format(API_URL, city, API_KEY); // sử dụng phương thức String.format để tạo một chuỗi URL hoàn chỉnh từ một mẫu URL đã được định nghĩa trước.
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //  được sử dụng để mở kết nối HTTP tới một URL cụ thể
            conn.setRequestMethod("GET"); // lấy dữ liệu
            int responseCode = conn.getResponseCode(); // được sử dụng để gửi yêu cầu HTTP đến máy chủ và nhận mã phản hồi (response code) từ máy chủ

            if (responseCode == 200) { //được sử dụng để gửi yêu cầu HTTP đến máy chủ và nhận mã phản hồi (response code) từ máy chủ.
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                // connection.getInputStream(): Tạo một luồng đầu vào từ kết nối HTTP, cho phép bạn đọc dữ liệu từ phản hồi của máy chủ.
                // InputStreamReader: Chuyển đổi luồng đầu vào từ dạng byte sang dạng ký tự, giúp bạn đọc các ký tự từ luồng đầu vào

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
                //được sử dụng để chuyển đổi chuỗi JSON từ phản hồi của máy chủ thành một đối tượng JsonObject, để bạn có thể truy cập và xử lý dễ dàng hơn.

                JsonObject main = jsonResponse.getAsJsonObject("main");
                //được sử dụng để truy cập đối tượng JSON chứa thông tin về các thông số chính của thời tiết như nhiệt độ, áp suất không khí, độ ẩm và nhiều thông số khác.
                double temperature = main.get("temp").getAsDouble();
                int humidity = main.get("humidity").getAsInt();

                JsonObject weather = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject();
                //được sử dụng để lấy thông tin về điều kiện thời tiết đầu tiên từ mảng "weather" trong đối tượng JSON chính (jsonResponse).

                String description = weather.get("description").getAsString();

                System.out.println("City: " + city);
                System.out.println("Temperature: " + temperature + "°C");
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Weather: " + description);
            } else {
                System.out.println("Error: Unable to fetch weather data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
