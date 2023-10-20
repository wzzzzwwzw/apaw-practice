package es.upm.miw.apaw_practice.domain.models.library;

import es.upm.miw.apaw_practice.domain.models.library.builders.BookWriterBuilders;

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

    public static class Builder implements BookWriterBuilders.Nickname, BookWriterBuilders.Optionals{
        private final BookWriter bookWriter;
        public Builder(){
            this.bookWriter = new BookWriter();
        }

        @Override
        public BookWriterBuilders.Optionals nickname(String nickname) {
            this.bookWriter.setNickname(nickname);
            return this;
        }

        @Override
        public BookWriterBuilders.Optionals name(String name) {
            this.bookWriter.setName(name);
            return this;
        }

        @Override
        public BookWriterBuilders.Optionals numberOfBook(Integer numberOfBook) {
            this.bookWriter.setNumberOfBook(numberOfBook);
            return this;
        }

        @Override
        public BookWriter build() {
            return this.bookWriter;
        }
    }


}
