package es.upm.miw.apaw_practice.domain.models.library;

public class Author {
    private String name;
    private String nickname;
    private Integer numberOfBook;

    public Author() {
        //empty for framework
    }

    public Author(String name, String nickname, Integer numberOfBook) {
        this.name= name;
        this.nickname = nickname;
        this.numberOfBook = numberOfBook;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getNickname() { return nickname;}

    public void setNickname(String nickname) { this.nickname = nickname;}

    public Integer getNumberOfBook() { return numberOfBook;}

    public void setNumberOfBook(Integer numberOfBook) { this.numberOfBook = numberOfBook;}

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", numberOfBook=" + numberOfBook +
                '}';
    }
}
