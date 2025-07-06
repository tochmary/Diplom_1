package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 20);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 200);
    Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
    Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    @DisplayName("Добавление ингредиента для бургера")
    void addIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient1));
        assertAll("Проверка полей Ingredient",
                () -> assertEquals(ingredient1.type, burger.ingredients.get(0).type),
                () -> assertEquals(ingredient1.name, burger.ingredients.get(0).name),
                () -> assertEquals(ingredient1.price, burger.ingredients.get(0).price));
    }

    @Test
    @DisplayName("Удаление ингредиента из бургера")
    void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(ingredient1));
        assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    @DisplayName("Перемещение ингредиента у бургера")
    void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        burger.moveIngredient(1, 2);
        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }
}