package br.com.hisao.hf;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.hisao.hf.Model.Recipe;
import br.com.hisao.hf.Util.JsonUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gets();


    }

    private void gets() {
        AsyncTask<Void, Void, JSONArray> taskGetJson = new AsyncTask<Void, Void, JSONArray>() {
            @Override
            protected JSONArray doInBackground(Void... params) {
                return JsonUtil.getJson("https://raw.githubusercontent.com/hellofreshdevtests/viniciushisao-android-test/master/recipes.json?token=AJrTg9JL2K2RfeBJHoOKpLT5Wc4E_ZOTks5Yi-gRwA%3D%3D");
            }

            @Override
            protected void onPostExecute(JSONArray jsonArray) {
                super.onPostExecute(jsonArray);
                try {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject explrObject;
                        explrObject = jsonArray.getJSONObject(i);
                        new Recipe(explrObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        taskGetJson.execute(null, null, null);
    }

}
