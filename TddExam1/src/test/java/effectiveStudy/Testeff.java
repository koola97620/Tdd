package effectiveStudy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Testeff {

    @Test
    public void order_test() {
        Customer customer = new Customer();
        Coffee coffee = new Coffee("latte");
        Order order = new Order();
        CoffeeSeller coffeeSeller = new CoffeeSeller();

        customer.order(order, coffeeSeller);
    }

    @Test
    public void exam_stub() {
        Customer customer = new Customer();
        Order order = new Order();
        CoffeeSellerStub coffeeSellerStub = new CoffeeSellerStub();
        Coffee order1 = customer.order(order, coffeeSellerStub);
        assertThat(order1.getName()).isEqualTo("Ice Americano");
    }

    @Test
    public void menu_list() {
        CoffeeSeller coffeeSeller = new CoffeeSeller();
        Recipe recipe = new Recipe();
        coffeeSeller.saveRecipe(recipe);
        // 레포지토리 미구현~
    }

    @Test
    public void menu_list_fake() {
        CoffeeSellerFake coffeeSeller = new CoffeeSellerFake();
        Recipe recipe = new Recipe();
        //coffeeSeller.saveRecipe(recipe);
        coffeeSeller.getRecipes();
        System.out.println(coffeeSeller.getRecipes().size());


    }







    private interface Seller<T> {
        T acceptOrder(Order order);
    }

    private static class CoffeeSeller implements Seller{
        private CoffeeMachine coffeeMachine;
        private CoffeeRecipeRepository coffeeRecipeRepository;

        @Override
        public Coffee acceptOrder(Order order)  {
            Coffee coffee = coffeeMachine.makeCoffee(order);
            return coffee;
        }

        public void saveRecipe(Recipe recipe) {
            coffeeRecipeRepository.saveRecipe(recipe);
        }

        public List<Recipe> getRecipes() {
            return coffeeRecipeRepository.getRecipes();
        }


    }
    private interface CoffeeRecipeRepository {

        void saveRecipe(Recipe recipe);

        List<Recipe> getRecipes();

    }

    private static class CoffeeSellerStub extends CoffeeSeller{

        @Override
        public Coffee acceptOrder(Order order) {
            return new Coffee("Ice Americano");
        }
    }


    @NoArgsConstructor
    private static class Coffee {
        private String name;

        public Coffee(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }


    private static class Customer {
        public Coffee order(Order order, CoffeeSeller coffeeSeller) {
            Coffee coffee = coffeeSeller.acceptOrder(order);
            return coffee;
        }

    }
    private static class Order {
    }

    private static class CoffeeMachine {
        public Coffee makeCoffee(Order order) {
            return new Coffee();
        }
    }

    @NoArgsConstructor
    private static class Recipe {
        private String name;

        public Recipe(String name) {
            this.name = name;
        }
    }

    private class CoffeeSellerFake extends CoffeeSeller {
        @Override
        public List<Recipe> getRecipes() {
            return Arrays.asList(new Recipe("1") , new Recipe("2"));
        }
    }
}
