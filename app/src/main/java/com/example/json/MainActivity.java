package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //loadJSONFromAsset();
        processJSON();

    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("studentdetails.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void processJSON()
    {
        String js=loadJSONFromAsset();
        if(js !=null)
        {
            // Log.d("json",js);
            try {
                JSONArray mJSONArray=new JSONArray(js);
                for(int i=0;i<mJSONArray.length();i++) {

                    JSONObject mJSONObj=mJSONArray.getJSONObject(i);
                    //  Log.d("mjson", mJSONObj.toString());
                    if(mJSONObj.has("sid")) {


                        int id = mJSONObj.getInt("sid");
                        String name=mJSONObj.getString("sname");

                        Log.d("mjson_ID", String.valueOf(id));
                        Log.d("mjson_name", String.valueOf(name));
                    }



                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


}
