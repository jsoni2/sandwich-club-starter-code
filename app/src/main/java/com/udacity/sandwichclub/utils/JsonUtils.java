package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject obj = null;
        Sandwich sandwich = new Sandwich();
        try {
            obj = new JSONObject(json);
            sandwich.setMainName(obj.getJSONObject("name").getString("mainName"));
            JSONArray arrAlsoKnownAs = obj.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<String>();
            for(int i = 0; i < arrAlsoKnownAs.length(); i++){
                alsoKnownAs.add((String) arrAlsoKnownAs.get(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(obj.getString("placeOfOrigin"));
            sandwich.setDescription(obj.getString("description"));
            sandwich.setImage(obj.getString("image"));
            JSONArray arrIngredients = obj.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            for(int i = 0; i < arrIngredients.length(); i++){
                ingredients.add((String) arrIngredients.get(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
