package data;

public enum ContentMenu {
    COMPANY("Компания"),
    PARTNERS("Партнерам"),
    INVESTORS("Инвесторам"),
    PRESS("Пресс");

    private final String title;

    ContentMenu(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
