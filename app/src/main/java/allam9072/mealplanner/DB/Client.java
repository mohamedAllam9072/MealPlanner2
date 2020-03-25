package allam9072.mealplanner.DB;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "https://5bcce576cf2e850013874767.mockapi.io/task/";
    private static Client INSTANCE;
    private JsonAPI jsonAPI;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        jsonAPI = retrofit.create(JsonAPI.class);

    }

    public static Client getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new Client();
        }
        return INSTANCE;
    }

    public Call<List<Category>> getCategories() {
        return jsonAPI.getAllCategories();
    }

}
