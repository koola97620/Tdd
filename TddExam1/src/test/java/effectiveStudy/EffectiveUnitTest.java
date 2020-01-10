package effectiveStudy;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EffectiveUnitTest {

    @Test
    public void order_test() {
        Customer customer = new Customer();
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
        CoffeeSellerFake coffeeSeller = new CoffeeSellerFake();
        Recipe recipe = new Recipe();
        // 레포지토리 미구현~

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> coffeeSeller.saveRecipe(coffeeSeller, recipe));
    }

    @Test
    public void exam_menu_list_fake() {
        CoffeeSellerFake coffeeSeller = new CoffeeSellerFake();
        Recipe recipe1 = new Recipe("americano");
        Recipe recipe2 = new Recipe("latte");
        Recipe recipe3 = new Recipe("green tea");

        coffeeSeller.saveRecipe(coffeeSeller, recipe1);
        coffeeSeller.saveRecipe(coffeeSeller, recipe2);
        coffeeSeller.saveRecipe(coffeeSeller, recipe3);
        //coffeeSeller.saveRecipe(recipe);

        assertThat(coffeeSeller.getRecipes().size()).isEqualTo(3);
    }




    private interface Seller<T> {
        T acceptOrder(Order order);
        void saveRecipe(CoffeeSellerFake coffeeSeller, Recipe recipe);
    }

    private static class CoffeeSeller implements Seller{
        private String sellerName;
        private CoffeeMachine coffeeMachine = new CoffeeMachine();
        private CoffeeRecipeRepository coffeeRecipeRepository;

        @Override
        public Coffee acceptOrder(Order order)  {
            return coffeeMachine.makeCoffee(order);
        }

        @Override
        public void saveRecipe(CoffeeSellerFake coffeeSeller, Recipe recipe) {
            coffeeRecipeRepository.saveRecipe(recipe);
        }

        public List<Recipe> getRecipes() {
            return coffeeRecipeRepository.getRecipes();
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerName() {
            return this.sellerName;
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
        private String creatorName;

        public Recipe(String name) {
            this.name = name;
        }

    }

    private static class CoffeeSellerFake extends CoffeeSeller {
        private List<Recipe> recipes = new ArrayList<>();

//        @Override
//        public List<Recipe> getRecipes() {
//            return Arrays.asList(new Recipe("1") , new Recipe("2"));
//        }
        @Override
        public List<Recipe> getRecipes() {
            return this.recipes;
        }

        public void saveRecipe(CoffeeSellerFake coffeeSeller, Recipe recipe) {
            this.recipes.add(recipe);
        }
    }

    private static class SpyRecipe extends  Recipe {
        
    }

}
