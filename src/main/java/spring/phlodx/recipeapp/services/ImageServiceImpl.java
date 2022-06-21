package spring.phlodx.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import spring.phlodx.recipeapp.domain.Recipe;
import spring.phlodx.recipeapp.repositories.RecipeRepository;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile imageFile) {
        try {
            Recipe recipe = recipeRepository.findById(id).get();
            Byte[] byteObject = new Byte[imageFile.getBytes().length];
            int i =0;
            for (byte aByte : imageFile.getBytes()) {
                byteObject[i++] = aByte;
            }
            recipe.setImage(byteObject);
            recipeRepository.save(recipe);
        } catch (Exception e) {
            log.error("Error saving image file", e);
            e.printStackTrace();
        }
    }
}
