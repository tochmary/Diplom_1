package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static praktikum.IngredientType.FILLING;

class IngredientTest {

    Ingredient ingredient;
    private static final IngredientType INGREDIENT_TYPE = FILLING;
    private static final String INGREDIENT_NAME = "cutlet";
    private static final float INGREDIENT_PRICE = 100;

    @ParameterizedTest
    @ValueSource(strings = {"SAUCE", "FILLING"})
    @DisplayName("Получение типа ингредиента")
    void getType(String type) {
        IngredientType ingredientType = IngredientType.valueOf(type);
        ingredient = new Ingredient(ingredientType, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(ingredientType, ingredient.getType());
    }

    @Test
    @DisplayName("Получение имени ингредиента")
    void getName() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    @DisplayName("Получение цены ингредиента")
    void getPrice() {
        ingredient = new Ingredient(INGREDIENT_TYPE, INGREDIENT_NAME, INGREDIENT_PRICE);
        assertEquals(INGREDIENT_PRICE, ingredient.getPrice());
    }
}