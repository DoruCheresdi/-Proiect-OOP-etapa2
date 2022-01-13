package utils;

import enums.Category;
import enums.Cities;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public final class Utils {
    private Utils() {

    }
    /**
     * function to transform an array of Json strings to an array of Category
     * @param categoryJson
     * @return
     */
    public static ArrayList<Category> jsonToCategory(final JSONArray categoryJson) {
        ArrayList<Category> categories = new ArrayList<>();
        for (Object category : categoryJson) {
            categories.add(Category.categoryOfValue((String) category));
        }
        return categories;
    }

    /**
     * function to transform an array of Json strings to an array of Cities
     * @param citiesJson
     * @return
     */
    public static ArrayList<Cities> jsonToCities(final JSONArray citiesJson) {
        ArrayList<Cities> cities = new ArrayList<>();
        for (Object city : citiesJson) {
            cities.add(Cities.cityOfValue((String) city));
        }
        return cities;
    }
}
