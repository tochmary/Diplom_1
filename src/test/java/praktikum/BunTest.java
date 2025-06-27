package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {

    Bun bun;

    @BeforeEach
    void setUp() {
        bun = new Bun("white", 100);
    }

    @Test
    @DisplayName("Получение имени бургера")
    void getName() {
        assertEquals("white", bun.getName());
    }

    @Test
    @DisplayName("Получение цены бургера")
    void getPrice() {
        assertEquals(100, bun.getPrice());
    }
}