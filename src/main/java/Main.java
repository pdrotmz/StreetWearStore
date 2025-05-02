import controller.AdminController;
import controller.UserController;
import model.admin.Admin;
import model.product.Product;
import model.user.User;
import service.AdminService;
import service.ProductService;
import service.UserService;

import java.util.Scanner;

public class Main {
    private static final ProductService productService = new ProductService();
    private static final UserController userController = new UserController();
    private static final AdminController adminController = new AdminController();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean execution = true;
        int optionRole;

        System.out.println("------------- BEM-VINDOS A STREET WEAR STORE -------------");
        System.out.println("Qual o seu papel: ");
        System.out.println("1 - CLIENTE");
        System.out.println("2 - ADMIN");
        optionRole = scanner.nextInt();
        scanner.nextLine();

        switch (optionRole) {
            case 1 -> {
                userController.menu();
            }

            case 2 -> {
                adminController.menu();
                adminController.painelAdmin();
            }
        }
    }
}
