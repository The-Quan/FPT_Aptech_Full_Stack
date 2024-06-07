using OOP;

class Program
{
    public static void Main(string[] args)
    {
        IProductRepository productRepository = new ProductService();
        Menu(productRepository);

    }
    static void Menu(IProductRepository productRepository)
    {
        while (true)
        {
            Console.WriteLine("product Management");
            Console.WriteLine("1. List all products");
            Console.WriteLine("2. create products");
            Console.WriteLine("3. delete produsts by id");
            Console.WriteLine("4. search product by id");
            Console.WriteLine("5. update product by id");
            Console.WriteLine("6. exit");
            Console.WriteLine("select an option: ");

            string choice = Console.ReadLine();
            switch (choice)
            {
                case "1":// goi ham list all
                    listAllProduct(productRepository);
                    break;
                case "2":// goi ham create
                    CreateProduct(productRepository);
                    break;
                case "3":
                    delete(productRepository);
                    break;
                case "4":
                    searchProductById(productRepository);
                    break;
                case "5":
                    update(productRepository);
                    break;
                case "6": // thoat
                    return;
                default:
                    Console.WriteLine("invalid choice. psl try aganin");
                    break;
            }

        }
    }
    static void CreateProduct(IProductRepository productRepository)
    {
        Console.WriteLine("Enter Product name: ");
        string name = Console.ReadLine();
        Console.WriteLine("Enter Product price: ");
        decimal price = decimal.Parse(Console.ReadLine());
        Console.WriteLine("Enter Product description: ");
        string description = Console.ReadLine();

        Product product = new Product
        {
            Name = name,
            Price = price,
            Description = description
        };
        productRepository.Create(product);
        Console.WriteLine("ok");
    }
    static void listAllProduct(IProductRepository productRepository)
    {
        List<Product> products = productRepository.GetAll();
        foreach (Product product in products)
        {
            Console.WriteLine($"Id: {product.Id}, Name: {product.Name}, Price: {product.Price}, Description: {product.Description}");
        }
    }
    static void delete(IProductRepository productRepository)
    {
        Console.WriteLine("Delete product by id");
        Console.WriteLine("enter id: ");
        int id = int.Parse(Console.ReadLine());
        productRepository.Delete(id);
        Console.WriteLine("ok");
    }
    static void searchProductById(IProductRepository productRepository)
    {
        Console.Write("search product by id");
        Console.WriteLine("enter id: ");
        int id = int.Parse(Console.ReadLine());
        Product product = productRepository.Read(id);
        Console.WriteLine($"id: {product.Id}");
        Console.WriteLine($"name: {product.Name}");
        Console.WriteLine($"price: {product.Price}");
        Console.WriteLine($"description: {product.Description}");
    }
    static void update(IProductRepository productRepository)
    {
        Console.Write("update product");
        Console.WriteLine("enter id: ");
        int id = int.Parse(Console.ReadLine());
        Console.WriteLine("enter name: ");
        string name = Console.ReadLine();
        Console.WriteLine("enter price: ");
        decimal price = decimal.Parse(Console.ReadLine());
        Console.WriteLine("enter description: ");
        string description = Console.ReadLine();
        Product product = new Product{
            Id = id,
            Name = name,
            Price = price,
            Description = description
        };
        productRepository.Update(product);
        Console.WriteLine("ok");
    }
}