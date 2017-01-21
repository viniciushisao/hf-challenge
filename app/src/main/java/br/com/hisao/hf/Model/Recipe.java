package br.com.hisao.hf.Model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by viniciushisao.
 */


public class Recipe {

    private static final String CALORIES = "calories";
    private static final String CARBOS = "carbos";
    private static final String COUNTRY = "country";
    private static final String DESCRIPTION = "description";
    private static final String DIFICULTY = "difficulty";
    private static final String FATS = "fats";
    private static final String FAVORITES = "favorites";
    private static final String FIBERS = "fibers";
    private static final String HEADLINE = "headline";
    private static final String HIGHLIGHTED = "highlighted";
    private static final String ID = "id";
    private static final String IMAGE = "image";
    private static final String INCOMPATIBILITIES = "incompatibilities";
    private static final String NAME = "name";
    private static final String PROTEINS = "proteins";
    private static final String RATING = "rating";
    private static final String RATINGS = "ratings";
    private static final String THUMB = "thumb";
    private static final String TIME = "time";
    private static final String DELIVERABLE_INGREDIENTS = "deliverable_ingredients";
    private static final String INGREDIENTS = "ingredients";
    private static final String PRODUCTS = "products";
    private static final String WEEKS = "weeks";
    private static final String EMAIL = "email";
    private static final String LATLNG = "latlng";
    private static final String USER = "user";

    private String calories;
    private String carbos;
    private String country;
    private String description;
    private String difficulty;
    private String fats;
    private String favorites;
    private String fibers;
    private String headline;
    private String highlighted;
    private String id;
    private String image;
    private String incompatibilities;
    private String name;
    private String proteins;
    private String rating;
    private String ratings;
    private String thumb;
    private String time;
    private ArrayList<DeliverableIngredients> deliverableIngredientArrayList;
    private ArrayList<Ingredient> ingredientArrayList;
    private ArrayList<Product> productArrayList;
    private ArrayList<Week> weekArrayList;
    private User user;

    public Recipe(JSONObject jsonObject) throws JSONException {

        deliverableIngredientArrayList = new ArrayList<>();
        ingredientArrayList = new ArrayList<>();
        productArrayList = new ArrayList<>();
        weekArrayList = new ArrayList<>();

        this.calories = jsonObject.getString(CALORIES);
        this.carbos = jsonObject.getString(CARBOS);
        this.country = jsonObject.getString(COUNTRY);
        this.description = jsonObject.getString(DESCRIPTION);
        this.difficulty = jsonObject.getString(DIFICULTY);
        this.fats = jsonObject.getString(FATS);
        this.favorites = jsonObject.getString(FAVORITES);
        this.fibers = jsonObject.getString(FIBERS);
        this.headline = jsonObject.getString(HEADLINE);
        this.highlighted = jsonObject.getString(HIGHLIGHTED);
        this.id = jsonObject.getString(ID);
        this.image = jsonObject.getString(IMAGE);
        this.incompatibilities = jsonObject.getString(INCOMPATIBILITIES);
        this.name = jsonObject.getString(NAME);
        this.proteins = jsonObject.getString(PROTEINS);
        this.rating = jsonObject.getString(RATING);
        this.ratings = jsonObject.getString(RATINGS);
        this.thumb = jsonObject.getString(THUMB);
        this.time = jsonObject.getString(TIME);

        JSONArray arrJson = jsonObject.getJSONArray(DELIVERABLE_INGREDIENTS);
        for (int i = 0; i < arrJson.length(); i++) {
            deliverableIngredientArrayList.add(new DeliverableIngredients(arrJson.getString(i)));
        }

        arrJson = jsonObject.getJSONArray(INGREDIENTS);
        for (int i = 0; i < arrJson.length(); i++) {
            ingredientArrayList.add(new Ingredient(arrJson.getString(i)));
        }

        arrJson = jsonObject.getJSONArray(PRODUCTS);
        for (int i = 0; i < arrJson.length(); i++) {
            productArrayList.add(new Product(arrJson.getString(i)));
        }

        arrJson = jsonObject.getJSONArray(WEEKS);
        for (int i = 0; i < arrJson.length(); i++) {
            weekArrayList.add(new Week(arrJson.getString(i)));
        }

        String email = jsonObject.getJSONObject(USER).getString(EMAIL);
        String latlng = jsonObject.getJSONObject(USER).getString(LATLNG);
        String name = jsonObject.getJSONObject(USER).getString(NAME);
        user = new User(email, latlng, name);

        Log.d("daf","Recipe:Recipe:122 ");

    }
}
