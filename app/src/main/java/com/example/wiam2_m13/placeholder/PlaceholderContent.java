package com.example.wiam2_m13.placeholder;

import com.example.wiam2_m13.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Integer> imagenesId = Arrays.asList(R.drawable.hamburguesa, R.drawable.pizza, R.drawable.chuleta, R.drawable.tortilla, R.drawable.paella, R.drawable.alcachofas, R.drawable.bravas, R.drawable.callos, R.drawable.croquetas,R.drawable.migas);
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= imagenesId.size(); i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {

        return new PlaceholderItem(String.valueOf(position),R.drawable.hamburguesa ,"Item_" + position,1.5F,"2.25", makeDetails(position),"opinion for Item "+String.valueOf(position),getDateTime());
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\nMore details information here.");
        builder.append("\nA placeholder item representing a piece of content..");

        return builder.toString();
    }
    private static String getDateTime() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        return formattedDate;
    }

    public static class PlaceholderItem {
        public final String id;
        public int imageUrl;
        public String nombre;
        public Float rating;
        public String price;
        public String description;
        public String opiniones;
        public String date;

        public PlaceholderItem(String id, int imageUrl, String nombre, Float rating, String price, String description, String opiniones, String date) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.nombre = nombre;
            this.rating = rating;
            this.price = price;
            this.description = description;
            this.opiniones = opiniones;
            this.date = date;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
}