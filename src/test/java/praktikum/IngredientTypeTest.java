package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @Test
    @DisplayName("Получение списка типов ингредиентов")
    void values() {
        List<String> actualList = new ArrayList<>();
        for (IngredientType i : IngredientType.values()) {
            actualList.add(i.toString());
        }
        List<String> expectedList = List.of("SAUCE", "FILLING");
        assertIterableEquals(expectedList, actualList);
    }

    public static Stream<Arguments> dataTest() {
        return Stream.of(
                Arguments.of("SAUCE", IngredientType.SAUCE),
                Arguments.of("FILLING", IngredientType.FILLING)
        );
    }

    @ParameterizedTest
    @DisplayName("Получение типа ингредиента")
    @MethodSource("dataTest")
    void valueOfSAUCE(String nameIngredientType, IngredientType expectedType) {
        assertEquals(expectedType, IngredientType.valueOf(nameIngredientType));
    }
}