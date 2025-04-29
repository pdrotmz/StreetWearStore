package model.category;

public enum Category {
    BONE("boné"),
    BLUSA("blusa"),
    SHORT("short"),
    CALCA("calça"),
    TENIS("tenis");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
