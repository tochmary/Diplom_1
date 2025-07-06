package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static praktikum.IngredientType.SAUCE;

@ExtendWith(MockitoExtension.class)
class BurgerMockTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredient;
    Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    @DisplayName("Добавление булочки для бургера")
    void setBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    @DisplayName("Получение цены бургера")
    void getPrice() {
        burger.bun = bunMock;
        Mockito.when(bunMock.getPrice()).thenReturn(11f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(22f);

        assertEquals(44f, burger.getPrice());
    }

    @Test
    @DisplayName("Получение чека с информацией о бургере")
    void getReceipt() {
        burger.bun = bunMock;
        Mockito.when(bunMock.getName()).thenReturn("white bun");
        Mockito.when(bunMock.getPrice()).thenReturn(11f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(22f);

        String expectedReceipt = "(==== white bun ====)\n" +
                "= sauce sour cream =\n" +
                "(==== white bun ====)\n\n" +
                "Price: 44,000000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}