package com.poojan.jsonparsingtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String stringJson = "{\n" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadJSon();
    }

    public void loadJSon(){
        try {
            JSONObject jObject = new JSONObject(stringJson);
            JSONObject glossaryObject = jObject.getJSONObject("glossary");


            String titleGlossary = glossaryObject.getString("title");
            Log.d("tag","Title :"+titleGlossary);

            JSONObject glossDivObject = glossaryObject.getJSONObject("GlossDiv");
            String titleDiv = glossDivObject.getString("title");
            Log.d("tag","Title:"+titleDiv);

            JSONObject glossListObject = glossDivObject.getJSONObject("GlossList");
            JSONObject glossEntryObject = glossListObject.getJSONObject("GlossEntry");

            String id =glossEntryObject.getString("ID");
            Log.d("tag", "Id: "+id);
             String sort=glossEntryObject.getString("SortAs");
            Log.d("tag", "SortAs: "+sort);
            String glossTerm = glossEntryObject.getString("GlossTerm");
            Log.d("tag", "GlossTerm: "+glossTerm);
            String acr = glossEntryObject.getString("Acronym");
            Log.d("tag", "Acronym: "+acr);
            String abr = glossEntryObject.getString("Abbrev");
            Log.d("tag", "Abbrev: "+abr);

            JSONObject glossDefObject = glossEntryObject.getJSONObject("GlossDef");

            String para = glossDefObject.getString("para");
            Log.d("tag", "Para: "+para);

            JSONArray glossSeeAlsoArray = glossDefObject.getJSONArray("GlossSeeAlso");

            for (int i = 0; i <glossSeeAlsoArray.length() ; i++) {
               String strParsedValue="\n"+glossSeeAlsoArray.getString(i);
                Log.d("tag", "GlossSeeAlso: "+strParsedValue);
            }



            String glossSee = glossEntryObject.getString("GlossSee");
            Log.d("tag","Gloss See:"+glossSee);


            glossaryObject.get("Glossary");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
