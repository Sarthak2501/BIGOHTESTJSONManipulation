package com.company;



import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    static JSONObject jsonObject = new JSONObject();
    static Map<String, String> strStrMap = new HashMap<String, String>();

    public static void main(String[] args) {
        // write your code here

        String json = " {\n" +
                "    \"ProjectName\":\"Bigoh tech\",\n" +
                "    \"Language\":\"Eng\",\n" +
                "    \"Pages\":{\n" +
                "        \"Home\":{\n" +
                "            \"title\":\"We build software product\",\n" +
                "            \"content\":\"Big Oh creates enterprise great cutting edge software products and help companies achieve their business goals by providing high quality IT talent\",\n" +
                "            \"description\":\"We are a leading software company that helps Enterprises and Startups build scalable and cutting edge software products \"\n" +
                "        },\n" +
                "        \"About\":{\n" +
                "            \"title\":\"About Us\",\n" +
                "            \"content\":\"We have been successfully delivering value to our clients across the globe.\",\n" +
                "            \"description\":\"Big Oh Notation is ISO 27001 & CMMI Level 3 certified company We Deliver you a result that marks the difference between service & professionalism\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String json2 = "{\n" +
                "  \"projectList\": [\n" +
                "    {\n" +
                "      \"ProjectName\": \"Bigoh tech2\",\n" +
                "      \"Language\": \"Eng\",\n" +
                "      \"Pages\": {\n" +
                "        \"Home\": {\n" +
                "          \"title\": \"We build software product\",\n" +
                "          \"content\": \"Big Oh creates enterprise great cutting edge software products and help companies achieve their business goals by providing high quality IT talent\",\n" +
                "          \"description\": \"We are a leading software company that helps Enterprises and Startups build scalable and cutting edge software products \"\n" +
                "        },\n" +
                "        \"About\": {\n" +
                "          \"title\": \"About Us\",\n" +
                "          \"content\": \"We have been successfully delivering value to our clients across the globe.\",\n" +
                "          \"description\": \"Big Oh Notation is ISO 27001 & CMMI Level 3 certified company We Deliver you a result that marks the difference between service & professionalism\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"ProjectName\": \"Resuit\",\n" +
                "      \"Language\": \"Fr\",\n" +
                "      \"Pages\": {\n" +
                "        \"Home\": {\n" +
                "          \"title\": \"Shoping App\",\n" +
                "          \"content\": \"here You can purchase product\",\n" +
                "          \"description\": \"this's app for purchase T-shirt , jeens ,\"\n" +
                "        },\n" +
                "        \"About\": {\n" +
                "          \"title\": \"ghjk\",\n" +
                "          \"content\": \"here You can purchase product\",\n" +
                "          \"description\": \"yvhjbkn\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"ProjectName\": \"Bigoh tech3\",\n" +
                "      \"Language\": \"Eng\",\n" +
                "      \"Pages\": {\n" +
                "        \"Home\": {\n" +
                "          \"title\": \"We build software product\",\n" +
                "          \"content\": \"Big Oh creates enterprise great cutting edge software products and help companies achieve their business goals by providing high quality IT talent\",\n" +
                "          \"description\": \"We are a leading software company that helps Enterprises and Startups build scalable and cutting edge software products \"\n" +
                "        },\n" +
                "        \"About\": {\n" +
                "          \"title\": \"About Us\",\n" +
                "          \"content\": \"We have been successfully delivering value to our clients across the globe.\",\n" +
                "          \"description\": \"Big Oh Notation is ISO 27001 & CMMI Level 3 certified company We Deliver you a result that marks the difference between service & professionalism\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"ProjectName\": \"Resuit2\",\n" +
                "      \"Language\": \"Fr\",\n" +
                "      \"Pages\": {\n" +
                "        \"Home\": {\n" +
                "          \"title\": \"Shoping App\",\n" +
                "          \"content\": \"here You can purchase product\",\n" +
                "          \"description\": \"this's app for purchase T-shirt , jeens ,\"\n" +
                "        },\n" +
                "        \"About\": {\n" +
                "          \"title\": \"ghjk\",\n" +
                "          \"content\": \"here You can purchase product\",\n" +
                "          \"description\": \"yvhjbkn\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JSONObject js = new JSONObject(json2);

        try {
            parser(js,"");
            jsonObject.put("Bigoh", strStrMap);
            System.out.println(jsonObject.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }

    public static void parser(JSONObject json,String parentTittle) {
        Iterator<String> keys = json.keys();;
        String currentKey;
        while (keys.hasNext()) {

                currentKey = keys.next();

                if (json.get(currentKey) instanceof JSONObject) {
                    parser(json.getJSONObject(currentKey),parentTittle+"."+currentKey);
                }
                else if(json.get(currentKey) instanceof JSONArray){
                    for(Object jsonObject : ((JSONArray)json.get(currentKey))){
                        parser((JSONObject) jsonObject,((JSONObject) jsonObject).get("ProjectName")+parentTittle+"."+currentKey);
                    }
                }
                else {
                    String key = parentTittle + "." + currentKey;
                    String value = json.get(currentKey).toString();
                    System.out.println(parentTittle + "." + currentKey + " = " + json.get(currentKey).toString());
                    strStrMap.put(parentTittle+"."+ currentKey, json.get(currentKey).toString());

                }
        }
    }
}
//json.has(key);

