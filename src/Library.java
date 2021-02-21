import java.util.LinkedList;
import java.util.Scanner;

public class Library {

    static class Book {
        String name, author, genre, location;

        public Book() {
            System.out.print("Введите данные книги: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String author = scanner.nextLine();
            String genre = scanner.nextLine();
            String location = scanner.nextLine();
            this.name = name;
            this.author = author;
            this.genre = genre;
            this.location = location;
        }

        public Book(String name, String author, String genre, String location) {
            this.name = name;
            this.author = author;
            this.genre = genre;
            this.location = location;
        }

        String getName() {
            return name.toLowerCase();
        }

        String getAuthor() {
            return author.toLowerCase();
        }

        String getGenre() {
            return genre.toLowerCase();
        }

        String getLocation() {
            return location.toLowerCase();
        }

        public void setLocation(String pos) {
            this.location = pos;
        }
    }


    static public LinkedList<Book> library;

    public Library() {
        library = new LinkedList<>();
    }

    ////////////////////
    public void add() {
        Book book = new Book();
        library.add(book);
    }

    public void add(Book book) {
        library.add(book);
    }

    ////////////////////
    public void delete(String name) {
        Book book = searchByName(name);
        library.remove(book);
    }

    public void delete(Book book) {
        library.remove(book);
    }

    //////Изменение книги
    public void change(String name) {
        for (int i = 0; i < library.size(); i++) if (library.get(i).getName().contains(name.toLowerCase()))
            library.set(i ,new Book());
    }

    //////Реализация поиска
    Book searchByName(String name) {
        for (Book it : library) {
            if (it.getName() != null && it.getName().contains(name.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByAuthor(String author) {
        for (Book it : library) {
            if (it.getAuthor() != null && it.getAuthor().contains(author.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByGenre(String genre) {
        for (Book it : library) {
            if (it.getGenre() != null && it.getGenre().contains(genre.toLowerCase())) {
                return it;
            }
        }
        return null;
    }

    Book searchByLoc(String location) {
        for (Book it : library) {
            if (it.getLocation() != null && it.getLocation().equalsIgnoreCase(location)) {
                return it;
            }
        }
        return null;
    }

    /////Experimental - множественный поиск/////
    LinkedList<Book> multipleGenreSearch(String genre) {
        LinkedList<Book> found = new LinkedList<>();
        for (Book book : library) if (book.getGenre().contains(genre.toLowerCase())) found.add(book);
        if (!found.isEmpty()) return found;
            return null;
    }
}