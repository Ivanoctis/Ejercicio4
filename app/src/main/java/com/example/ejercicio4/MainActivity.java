package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray> {


    ListView lv1;

    ArrayList<Imagen> Elementos;

    String url;
    RequestQueue queue;
    JsonArrayRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.listview1);
        Elementos = new ArrayList<>();
        queue = Volley.newRequestQueue(this);
        url = getResources().getString(R.string.url_base)+"cm/2020-1/products.php";
        request = new JsonArrayRequest(Request.Method.GET, url, null, this,this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("RESPUESTA",error.toString());
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.d("RESPUESTA",response.toString());

        JSONObject jsonObject;

        try {
            for (int i = 0; i < response.length(); i++) {

                jsonObject = response.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String thumbnail_url = jsonObject.getString("thumbnail_url");
                float price = BigDecimal.valueOf(jsonObject.getDouble("price")).floatValue();
                String provider = jsonObject.getString("provider");
                float delivery = BigDecimal.valueOf(jsonObject.getDouble("delivery")).floatValue();

                Imagen Elemento = new Imagen(id,name,thumbnail_url,price,provider,delivery);

                Elementos.add(Elemento);
            }
            MyAdapter myAdapter = new MyAdapter(this,Elementos);
            lv1.setAdapter(myAdapter);

            lv1.setOnItemClickListener((parent, view, position, id) -> {

                Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,ejercicio4_2.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
