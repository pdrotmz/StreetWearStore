package controller;

import model.admin.Admin;
import model.product.Product;
import service.AdminService;
import service.ProductService;

import java.util.Scanner;

public class AdminController {

    private final AdminService adminService;
    private final ProductService productService;
    private final Scanner scanner;

    public AdminController() {
        this.adminService = new AdminService();
        this.productService = new ProductService();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
            System.out.println("1 - Registrar");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registrar();
                case 2-> login();
                case 0 -> {
                    System.out.println("Fechando programa!");
                    return;
                }
                default -> System.out.println("Opção invalida!");
            }
        }
    }

    private void registrar() {
        Admin admin = new Admin();

        System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
        System.out.print("Digite o seu username: ");
        admin.setUsername(scanner.nextLine());
        System.out.print("Digite o seu email: ");
        admin.setEmail(scanner.nextLine());
        System.out.print("Digite sua senha: ");
        admin.setPassword(scanner.nextLine());
        System.out.print("Digite seu domínio: ");
        admin.setDomain(scanner.nextLine());

        adminService.registerAdmin(admin);
    }

    private void login() {
        Admin admin = new Admin();

        System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
        System.out.print("Digite o seu email: ");
        admin.setEmail(scanner.nextLine());
        System.out.print("Digite o seu password: ");
        admin.setPassword(scanner.nextLine());

        adminService.loginAdmin(admin.getEmail(), admin.getPassword());
    }

    public void painelAdmin() {
        boolean execution = true;

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
                    products.forEach(product -> System.out.println(product.getName() + " - " + product.getPrice() + "\n"));
                }
                case 3 -> execution = false;
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
