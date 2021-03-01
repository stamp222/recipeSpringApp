package spring.phlodx.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"spring/phlodx/recipeapp/domain"})
public class RecipeappApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeappApplication.class, args);
    }

}
