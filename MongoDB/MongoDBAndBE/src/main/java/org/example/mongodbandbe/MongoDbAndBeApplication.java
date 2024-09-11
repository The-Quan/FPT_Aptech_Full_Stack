package org.example.mongodbandbe;

import com.github.javafaker.Faker;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@SpringBootApplication
public class MongoDbAndBeApplication {
    private static final Faker faker = new Faker();

    private static final Random random = new Random();

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ecommerce_db");
        MongoCollection<Document> transactionCollection = database.getCollection("transaction");

        int numberProduct = 100;
        int numberCustomer = 1000;
        int numberTransaction = 10000;

        List<Document> product = generatorProduct(numberProduct);
        List<Document> customer = generatorCustomer(numberCustomer);
        List<Document> transaction2021 = generatorTransactions(customer, product, numberTransaction, 2021);
        List<Document> transaction2022 = generatorTransactions(customer, product, numberTransaction, 2021);
        List<Document> transaction2023 = generatorTransactions(customer, product, numberTransaction, 2021);

        transactionCollection.insertMany(transaction2021);
        transactionCollection.insertMany(transaction2022);
        transactionCollection.insertMany(transaction2023);

        System.out.println("đã chèn thành công");
        mongoClient.close();
    }

    public static List<Document> generatorProduct(int count) {
        List<Document> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String productId = "PROD " + (i + 1);
            String productName = faker.commerce().productName();
            String priceStr = faker.commerce().price(10.0, 500);
            double price = Double.parseDouble(priceStr.replace(",", "."));
            products.add(new Document("product_id", productId)
                    .append("productName", productName)
                    .append("price", price));
        }
        return products;
    }

    public static List<Document> generatorCustomer(int count){
        List<Document> Customer = new ArrayList<>();
        for (int i = 0; i < count; i++){
            String customerId = "CUST" + (i+1);
            String customerName = faker.name().fullName();
            Customer.add(new Document("customer_id", customerId)
                    .append("customerName", customerName));
        }
        return Customer;
    }

    public static List<Document> generatorTransactions(List<Document> customer, List<Document> products, int count, int year){
        List<Document> transaction = new ArrayList<>();
        for(int j = 0; j < count; j++){
            String transactionID = UUID.randomUUID().toString();
            Document customerID = customer.get(random.nextInt(customer.size()));
            Date transactionDate = generatorData(year);

            List<Document> items = new ArrayList<>();
            double totalAmount = 0;

            int numItems = random.nextInt(5) + 1;
            for (int i = 0; i < numItems; i++){
                Document product = products.get(random.nextInt(products.size()));
                int quantity = random.nextInt(10) + 1;
                double price = product.getDouble("price");
                double itemTotal = quantity * price;
                totalAmount += itemTotal;

                items.add(new Document("productId", product.getString("product_id"))
                        .append("productName", product.getString("product_name"))
                        .append("quantity", quantity)
                        .append("price", price)
                        .append("total", itemTotal));
            }
            transaction.add(new Document("TransactionId", transactionID)
                    .append("customerId", customerID.getString("customerId"))
                    .append("customerName", customerID.getString("customerName"))
                    .append("date", transactionDate)
                    .append("items", items)
                    .append("totalAmount", totalAmount));
        }
        return transaction;
    }

    public static Date generatorData(int year){
        int dayOfYear = random.nextInt(365) + 1;
        LocalDate random = LocalDate.ofYearDay(year , dayOfYear) ;
        return  Date.from(random.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
