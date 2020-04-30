package allam9072.mealplanner.DB;

public class Recipes {
    private String id;
    private String image1;
    private String name;
    private String source;
    private String comments;
    private String instructions;
    private String ingredients;
    private String tags;
    private int preptime;
    private int waittime;
    private int cooktime;
    private int servings;
    private int calories;
    private int fat;
    private int carbs;
    private int fiber;
    private int protein;
    private int satfat;
    private int sugar;


    public Recipes() {
    }

    public Recipes(String id, String image1, String name, String source,
                   int preptime, int waittime, int cooktime, int servings, String comments, int calories,
                   int fat, int carbs, int fiber, String instructions,
                   String ingredients, String tags, int protein, int satfat, int sugar) {
        this.id = id;
        this.image1 = image1;
        this.name = name;
        this.source = source;
        this.preptime = preptime;
        this.waittime = waittime;
        this.cooktime = cooktime;
        this.servings = servings;
        this.comments = comments;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
        this.protein = protein;
        this.satfat = satfat;
        this.sugar = sugar;
    }

    public String getImage1() {
        return image1;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public int getPreptime() {
        return preptime;
    }

    public int getWaittime() {
        return waittime;
    }

    public int getCooktime() {
        return cooktime;
    }

    public int getServings() {
        return servings;
    }

    public String getComments() {
        return comments;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFiber() {
        return fiber;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getTags() {
        return tags;
    }

    public int getProtein() {
        return protein;
    }

    public int getSatfat() {
        return satfat;
    }

    public int getSugar() {
        return sugar;
    }
}
