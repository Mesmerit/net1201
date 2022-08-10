import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

public class ProductManagerTest {

    Product book1 = new Book(1, "Загадки", 600, "Чарли Чух-Чух");
    Product smartphone1 = new Smartphone(2, "RunMan", 5000, "Nokla");
    Product book2 = new Book(3, "История Nokla", 800, "Сатер Кейн");
    Product smartphone2 = new Smartphone(4, "iТелефон", 999999, "Груша");
    Product book3 = new Book(5, "Биография С.Кейна", 600, "Роберт Ли");
    Product smartphone3 = new Smartphone(6, "iMan", 999999, "Груша");

    @Test
    void shouldAddFourProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book1);
        manager.addProduct(book3);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone1);

        Product[] actual = repository.getAllProducts();
        Product[] expected = {book1, book3, smartphone3, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);


        Product[] actual = manager.searchBy("RunMan");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNoFind() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);


        Product[] actual = manager.searchBy("Api");
        Product[] expected = null;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTwoBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);


        Product[] actual = manager.searchBy("Кейн");
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTwoSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone1);


        Product[] actual = manager.searchBy("Man");
        Product[] expected = {smartphone3, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookAndSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone3);


        Product[] actual = manager.searchBy("Nokla");
        Product[] expected = {book2, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book1);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        repository.removeById(1);

        Product[] actual = repository.getAllProducts();
        Product[] expected = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book3);
        manager.addProduct(book1);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone2);

        repository.removeById(6);

        Product[] actual = repository.getAllProducts();
        Product[] expected = {book3, book1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemove() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.addProduct(book2);
        manager.addProduct(book1);
        manager.addProduct(smartphone3);
        manager.addProduct(smartphone1);

        repository.removeById(4);

        Product[] actual = repository.getAllProducts();
        Product[] expected = {book2, book1, smartphone3, smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }
}
