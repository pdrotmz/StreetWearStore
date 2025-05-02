package util;

import java.nio.file.*;
import java.util.*;

public class EnvLoader {
    private static final Map<String, String> env = new HashMap<>();

    static {
        try {
            for (String line : Files.readAllLines(Paths.get(".env"))) {
                if (line.contains("=") && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    env.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar .env");
        }
    }

    public static String get(String key) {
        return env.get(key);
    }
}
