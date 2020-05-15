package allam9072.mealplanner.DB;

public class Recipes {
    private String id;
    private String image1;
    private String name;
    private String source;
    private String comments;
    private String instructions;
    private String ingredients;
    private String tag1;
    private String tag2;
    private String tag3;
    private String tag4;
    private String tag5;
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

    public Recipes(String id, String image1, String name, String source, String comments,
                   String instructions, String ingredients, String tag1, String tag2, String tag3,
                   String tag4, String tag5, int preptime, int waittime, int cooktime, int servings, int calories,
                   int fat, int carbs, int fiber, int protein, int satfat, int sugar) {
        this.id = id;
        this.image1 = image1;
        this.name = name;
        this.source = source;
        this.comments = comments;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.tag4 = tag4;
        this.tag5 = tag5;
        this.preptime = preptime;
        this.waittime = waittime;
        this.cooktime = cooktime;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
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

    public int getProtein() {
        return protein;
    }

    public int getSatfat() {
        return satfat;
    }

    public int getSugar() {
        return sugar;
    }

    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public String getTag4() {
        return tag4;
    }

    public String getTag5() {
        return tag5;
    }
}
