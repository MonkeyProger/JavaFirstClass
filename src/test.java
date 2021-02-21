import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Library testLibrary = new Library();

/////Добавление книг в библиотеку
        testLibrary.add(new Library.Book("Sadness of Biba and Boba", "Anatoliy Vaserman",
                "Dramatic literature", "A1"));
        testLibrary.add(new Library.Book("Legends of the victories of Pericles",
                "Apolon Povedov", "Lyro-Epic", "A3"));
        testLibrary.add(new Library.Book("How Kek left the circus", "Boris Borisov",
                "Сomedy", "Z1"));
        testLibrary.add(new Library.Book("Dead Zombie Creepy Man", "Alexey Cennoy",
                "Horror", "C3"));
        testLibrary.add(new Library.Book("10 tips to earn EASY MONEY", "Grigory Bingo",
                "Business literature", "B2"));
/////Ввод вручную
        testLibrary.add();

        testLibrary.add(new Library.Book("10 tips to earn EASY MONEY", "Grigory Bingo",
                "Business literature", "B2"));

/////Experimental/////
        testLibrary.add(new Library.Book("It", "Steven King",
                "Horror", "K1"));
        testLibrary.add(new Library.Book("30 Days of Night", "Steve Niles",
                "Horror comics", "N1"));


/////Вывод книг типа: Library$Book@2dda6444
        for (Library.Book it : testLibrary.library) {
            System.out.println(it);
        }
        System.out.println();

/////Удаление книги из библиотеки
        testLibrary.delete("10 tips to earn EASY MONEY");
/////Изменение книги
        System.out.println("Измените книгу <Sadness of Biba and Boba>:");
        testLibrary.change("Sadness of Biba and Boba");
        System.out.println("Книга <Sadness of Biba and Boba> успешно изменена");

/////Поиск первой попавшейся книги определенного типа
        Library.Book search = null;
        String genreSearch = "Horror";
        for (Library.Book it : testLibrary.library) {
            if (it.getGenre() != null && it.getGenre().equalsIgnoreCase(genreSearch)) {
                // or it.getGenre().contains(genre.toLowerCase()) в случае поиска подстроки в строке
                search = it;
                break;
            }
        }
        if (search != null){
            System.out.println("Найдена книга жанра <Horror>: " + search.name + ", " + search.author + ", "
                    + search.genre + ", " + search.location);
            System.out.println();}


/////Experimental - множественный поиск
        System.out.print("Введите интересуемый жанр: ");
        Scanner scanner = new Scanner(System.in);
        String genre = scanner.nextLine();
        LinkedList<Library.Book> searcher = testLibrary.multipleGenreSearch(genre);
        if (searcher != null) {
            System.out.println("По запросу <" + genre + "> найдено " + searcher.size() + " книги:");
            /////Можно добавить проверку на searcher.size() -> корректное отображение книга/книги/книг////
            for (Library.Book it : searcher)
                System.out.println(it.name + ", " + it.author + ", " + it.genre + ", " + it.location);
        }
        else System.out.println("По данному запросу ничего не найдено.");
    }
}
