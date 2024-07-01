#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>

class Book {
private:
    std::string title;
    std::string author;
    std::string edition;
    int year;

public:
    Book() : title(""), author(""), edition(""), year(0) {}
    Book(const std::string &t, const std::string &a, const std::string &e, int y) : title(t), author(a), edition(e), year(y) {}
    
    std::string getTitle() const { return title; }
    std::string getAuthor() const { return author; }
    std::string getEdition() const { return edition; }
    int getYear() const { return year; }

    void setTitle(const std::string &t) { title = t; }
    void setAuthor(const std::string &a) { author = a; }
    void setEdition(const std::string &e) { edition = e; }
    void setYear(int y) { year = y; }

    void display() const {
        std::cout << "Название: " << title << ", Автор: " << author << ", Издание: " << edition << ", Год: " << year << std::endl;
    }
};

void inputBooks(std::vector<Book> &books) {
    int n;
    std::cout << "Введите количество книг: ";
    std::cin >> n;
    for (int i = 0; i < n; ++i) {
        std::string title, author, edition;
        int year;
        std::cout << "Введите название: ";
        std::cin.ignore();
        std::getline(std::cin, title);
        std::cout << "Введите автора: ";
        std::getline(std::cin, author);
        std::cout << "Введите издание: ";
        std::getline(std::cin, edition);
        std::cout << "Введите год: ";
        std::cin >> year;
        books.emplace_back(title, author, edition, year);
    }
}

void displayBooks(const std::vector<Book> &books) {
    for (const auto &book : books) {
        book.display();
    }
}

void sortBooksByYear(std::vector<Book> &books) {
    std::sort(books.begin(), books.end(), [](const Book &a, const Book &b) {
        return b.getYear() < a.getYear();
    });
}

void displayBooksByTitle(const std::vector<Book> &books, const std::string &title) {
    for (const auto &book : books) {
        if (book.getTitle() == title) {
            book.display();
        }
    }
}

void addBookAtFirstPosition(std::vector<Book> &books) {
    std::string title, author, edition;
    int year;
    std::cout << "Введите название: ";
    std::cin.ignore();
    std::getline(std::cin, title);
    std::cout << "Введите автора: ";
    std::getline(std::cin, author);
    std::cout << "Введите издание: ";
    std::getline(std::cin, edition);
    std::cout << "Введите год: ";
    std::cin >> year;
    books.insert(books.begin(), Book(title, author, edition, year));
}

void deleteBooksByAuthor(std::vector<Book> &books, const std::string &author) {
    books.erase(std::remove_if(books.begin(), books.end(), [&author](const Book &book) {
        return book.getAuthor() == author;
    }), books.end());
}

void writeBooksToFile(const std::vector<Book> &books, const std::string &filename) {
    std::ofstream file(filename);
    for (const auto &book : books) {
        file << book.getTitle() << " " << book.getAuthor() << " " << book.getEdition() << " " << book.getYear() << "\n";
    }
}

void readFirstBookFromFile(const std::string &filename) {
    std::ifstream file(filename);
    std::string title, author, edition;
    int year;
    if (file >> title >> author >> edition >> year) {
        Book book(title, author, edition, year);
        book.display();
    } else {
        std::cout << "Данные о книге не найдены в файле." << std::endl;
    }
}

void menu() {
    std::vector<Book> books;
    int choice;
    std::string input;
    do {
        std::cout << "меню:\n";
        std::cout << "1) ввод книг\n";
        std::cout << "2) показать книги\n";
        std::cout << "3) сортировать книги по году\n";
        std::cout << "4) показать книги по названию\n";
        std::cout << "5) добавить книгу на первое место\n";
        std::cout << "6) удалить книги по автору\n";
        std::cout << "7) записать книги в файл\n";
        std::cout << "8) прочитать первую книгу из файла\n";
        std::cout << "9) выйти\n";
        std::cout << "выберите действие: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                inputBooks(books);
                break;
            case 2:
                displayBooks(books);
                break;
            case 3:
                sortBooksByYear(books);
                break;
            case 4:
                std::cout << "введите название для поиска: ";
                std::cin.ignore();
                std::getline(std::cin, input);
                displayBooksByTitle(books, input);
                break;
            case 5:
                addBookAtFirstPosition(books);
                break;
            case 6:
                std::cout << "введите автора для удаления: ";
                std::cin.ignore();
                std::getline(std::cin, input);
                deleteBooksByAuthor(books, input);
                break;
            case 7:
                writeBooksToFile(books, "books.txt");
                break;
            case 8:
                readFirstBookFromFile("books.txt");
                break;
            case 9:
                std::cout << "выход\n";
                break;
            default:
                std::cout << "неверный выбор, попробуйте снова\n";
                break;
        }
    } while (choice != 9);
}

int main() {
    menu();
    return 0;
}