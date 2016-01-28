package org.nailedtothex.sqlbeautifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSONBeautifier implements Beautifier {

    /**
     * taken from http://stackoverflow.com/a/7310424/3591946
     */
    @Override
    public String beautify(final String text) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(text);
        return gson.toJson(je);
    }
}
