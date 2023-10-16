package es.upm.miw.apaw_practice.domain.models.library;

public class BookWriter {
    private String name;
    private String nickname;
    private Integer numberOfBook;

    public BookWriter() {
        //empty for framework
    }

    public BookWriter(String name, String nickname, Integer numberOfBook) {
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
        return "BookWriter{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", numberOfBook=" + numberOfBook +
                '}';
    }
}
