package controller;

import model.user.User;
import service.UserService;

import java.util.Scanner;

public class UserController {

    private final UserService userService;
    private final Scanner scanner;

    public UserController() {
        this.userService = new UserService();
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
        User user = new User();
        System.out.print("Digite o seu username: ");
        user.setUsername(scanner.nextLine());
        System.out.print("Digite o seu email: ");
        user.setEmail(scanner.nextLine());
        System.out.print("Digite sua senha: ");
        user.setPassword(scanner.nextLine());

        userService.registerUser(user);
    }

    private void login() {
        User user = new User();
        System.out.print("Digite o seu username: ");
        user.setUsername(scanner.nextLine());
        System.out.print("Digite o seu password: ");
        user.setPassword(scanner.nextLine());

        userService.loginUser(user.getUsername(), user.getPassword());
    }
}
