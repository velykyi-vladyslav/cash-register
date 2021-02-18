package ua.lviv.velykyi.vladyslav.db.entity;

public class Locale extends Entity{
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Locale{" +
                "language='" + language + '\'' +
                '}';
    }
}
