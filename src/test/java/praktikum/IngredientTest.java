package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    Ingredient ingredient;

    @BeforeEach
    void setUp() {
         ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    }

    @Test
    @DisplayName("Получение цены ингредиента")
    void getPrice() {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    @DisplayName("Получение имени ингредиента")
    void getName() {
        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    @DisplayName("Получение типа ингредиента")
    void getType() {
        assertEquals(100, ingredient.getPrice());
    }
}