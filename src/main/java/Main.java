import model.admin.Admin;
import model.product.Product;
import model.user.User;
import service.AdminService;
import service.ProductService;
import service.UserService;

import java.util.Scanner;

public class Main {
    private static final ProductService productService = new ProductService();
    private static final UserService userService = new UserService();
    private static final AdminService adminService = new AdminService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Admin admin = new Admin();

        boolean execution = true;
        int optionNotLogged, optionRole;

        System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
        System.out.println("Qual o seu papel: ");
        System.out.println("1 - CLIENTE");
        System.out.println("2 - ADMIN");
        optionRole = scanner.nextInt();
        scanner.nextLine();

        switch (optionRole) {
            case 1 -> {
                System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
                System.out.println("Primeiro, escolha uma das opções: ");
                System.out.println("1 - FAZER CADASTRO");
                System.out.println("2 - FAZER LOGIN");
                optionNotLogged = scanner.nextInt();
                scanner.nextLine();

                switch (optionNotLogged) {
                    case 1 -> {
                        System.out.println("----- FAÇA SEU CADASTRO -----");
                        System.out.print("\nDigite seu username: ");
                        user.setUsername(scanner.nextLine());
                        System.out.print("\nDigite seu email: ");
                        user.setEmail(scanner.nextLine());
                        System.out.print("\nDigite sua senha: ");
                        user.setPassword(scanner.nextLine());

                        userService.registerUser(user);
                    }

                    case 2 -> {
                        System.out.println("----- FAÇA SEU LOGIN -----");
                        System.out.print("Digite o seu username: ");
                        user.setUsername(scanner.nextLine());
                        System.out.print("Digite sua senha: ");
                        user.setPassword(scanner.nextLine());
                        userService.loginUser(user.getUsername(), user.getPassword());
                    }
                    default -> System.out.println("Opção inválida!");
                }

            }

            case 2 -> {

                System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
                System.out.println("Primeiro, escolha uma das opções: ");
                System.out.println("1 - FAZER CADASTRO");
                System.out.println("2 - FAZER LOGIN");
                optionNotLogged = scanner.nextInt();
                scanner.nextLine();


                if (optionNotLogged == 1) {
                    System.out.println("----- FAÇA SEU CADASTRO -----");
                    System.out.print("\nDigite seu username: ");
                    admin.setUsername(scanner.nextLine());
                    System.out.print("\nDigite seu email: ");
                    admin.setEmail(scanner.nextLine());
                    System.out.println("\nDigite seu domínio: ");
                    admin.setDomain(scanner.nextLine());
                    System.out.print("\nDigite sua senha: ");
                    admin.setPassword(scanner.nextLine());

                    adminService.registerAdmin(admin);
                }
            }
        }





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
