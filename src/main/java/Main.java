import dao.ProductDAO;
import model.product.Product;
import model.user.User;
import service.ProductService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductService productService = new ProductService();
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean execution = true;
        User user = new User();

        do {
            System.out.println("----- FAÇA SEU CADASTRO -----");
            System.out.print("\nDigite seu username: ");
            user.setUsername(scanner.nextLine());
            System.out.print("\nDigite seu email: ");
            user.setEmail(scanner.nextLine());
            System.out.print("\nDigite sua senha: ");
            user.setPassword(scanner.nextLine());
        }

        while(!user.getEmail().contains("@"));

        userService.registerUser(user);

        while(execution) {
            System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
            System.out.println("\n1- Cadastrar Produto");
            System.out.println("2 - Lista Produtos");
            System.out.println("3 - Sair");
            System.out.println();

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    Product product = new Product();
                    System.out.print("Digite um nome para o produto: ");
                    product.setName(scanner.nextLine());
                    System.out.print("Digite uma descrição para o produto: ");
                    product.setDescription(scanner.nextLine());
                    System.out.print("Digite um valor para o produto: ");
                    product.setPrice(scanner.nextBigDecimal());
                    System.out.print("Digite a quantidade recebida: ");
                    product.setQuantity(scanner.nextInt());
                    scanner.nextLine();


                    productService.registerProduct(product);
                    System.out.println();
                    System.out.println("Produto cadastrado com sucesso");
                }
                case 2 -> {
                    var products = productService.findAllProducts();
                    products.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice()));
                }
                case 3 -> execution = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
