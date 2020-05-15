package allam9072.mealplanner.DB;

public class Food {
    private String image;
    private String text1;
    private String id;
    private String name;
    private float energy;
    private float protein;
    private float fat;
    private float saturated_fat;
    private float carbohydrate;
    private float sugars;
    private float dietary_fibre;
    private float sodium;
    private String tag1;
    private String tag2;
    //2
    private float potassium;
    private float trans_fat;
    private float polyunsaturated_fat;
    private float monounsaturated_fat;
    private float vitamin_e;
    private float magnesium;
    private float vitamin_b1;
    private float vitamin_b2;
    private float vitamin_b3;
    private float vitamin_b5;
    private float vitamin_b6;
    private float vitamin_b9;
    private float vitamin_c;
    private float calcium;
    private float iron;
    private float phosphorus;
    private float zinc;
    private float manganese;
    private float vitamin_k;
    private float vitamin_a;
    private float omega_3_fatty_acid;

    public Food(String image, String text1, String id, String name, float energy, float protein,
                float fat, float saturated_fat, float carbohydrate, float sugars, float dietary_fibre,
                float sodium, String tag1, String tag2, float potassium, float trans_fat, float polyunsaturated_fat,
                float monounsaturated_fat, float vitamin_e, float magnesium, float vitamin_b1, float vitamin_b2,
                float vitamin_b3, float vitamin_b5, float vitamin_b6, float vitamin_b9, float vitamin_c,
                float calcium, float iron, float phosphorus, float zinc, float manganese, float vitamin_k,
                float vitamin_a, float omega_3_fatty_acid) {
        this.image = image;
        this.text1 = text1;
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.saturated_fat = saturated_fat;
        this.carbohydrate = carbohydrate;
        this.sugars = sugars;
        this.dietary_fibre = dietary_fibre;
        this.sodium = sodium;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.potassium = potassium;
        this.trans_fat = trans_fat;
        this.polyunsaturated_fat = polyunsaturated_fat;
        this.monounsaturated_fat = monounsaturated_fat;
        this.vitamin_e = vitamin_e;
        this.magnesium = magnesium;
        this.vitamin_b1 = vitamin_b1;
        this.vitamin_b2 = vitamin_b2;
        this.vitamin_b3 = vitamin_b3;
        this.vitamin_b5 = vitamin_b5;
        this.vitamin_b6 = vitamin_b6;
        this.vitamin_b9 = vitamin_b9;
        this.vitamin_c = vitamin_c;
        this.calcium = calcium;
        this.iron = iron;
        this.phosphorus = phosphorus;
        this.zinc = zinc;
        this.manganese = manganese;
        this.vitamin_k = vitamin_k;
        this.vitamin_a = vitamin_a;
        this.omega_3_fatty_acid = omega_3_fatty_acid;
    }

    public String getImage() {
        return image;
    }

    public String getText1() {
        return text1;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getEnergy() {
        return energy;
    }

    public float getProtein() {
        return protein;
    }

    public float getFat() {
        return fat;
    }

    public float getSaturated_fat() {
        return saturated_fat;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public float getSugars() {
        return sugars;
    }

    public float getDietary_fibre() {
        return dietary_fibre;
    }

    public float getSodium() {
        return sodium;
    }

    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public float getPotassium() {
        return potassium;
    }

    public float getTrans_fat() {
        return trans_fat;
    }

    public float getPolyunsaturated_fat() {
        return polyunsaturated_fat;
    }

    public float getMonounsaturated_fat() {
        return monounsaturated_fat;
    }

    public float getVitamin_e() {
        return vitamin_e;
    }

    public float getMagnesium() {
        return magnesium;
    }

    public float getVitamin_b1() {
        return vitamin_b1;
    }

    public float getVitamin_b2() {
        return vitamin_b2;
    }

    public float getVitamin_b3() {
        return vitamin_b3;
    }

    public float getVitamin_b5() {
        return vitamin_b5;
    }

    public float getVitamin_b6() {
        return vitamin_b6;
    }

    public float getVitamin_b9() {
        return vitamin_b9;
    }

    public float getVitamin_c() {
        return vitamin_c;
    }

    public float getCalcium() {
        return calcium;
    }

    public float getIron() {
        return iron;
    }

    public float getPhosphorus() {
        return phosphorus;
    }

    public float getZinc() {
        return zinc;
    }

    public float getManganese() {
        return manganese;
    }

    public float getVitamin_k() {
        return vitamin_k;
    }

    public float getVitamin_a() {
        return vitamin_a;
    }

    public float getOmega_3_fatty_acid() {
        return omega_3_fatty_acid;
    }
}
