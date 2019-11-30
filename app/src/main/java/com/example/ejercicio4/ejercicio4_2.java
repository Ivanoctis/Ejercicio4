package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class ejercicio4_2 extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    ImageView imageView;
    TextView name;
    TextView price;
    TextView delivery;
    TextView desc;
    String url;
    String _price;
    String _delivery;
    String id;
    RequestQueue queue;
    JsonObjectRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4_2);

        imageView = findViewById(R.id.imageespecific);
        name = findViewById(R.id.Nameespecific);
        price = findViewById(R.id.Priceespecific);
        delivery = findViewById(R.id.Deliveryespecific);
        desc = findViewById(R.id.desc);

        id = getIntent().getStringExtra("ID");

        queue = Volley.newRequestQueue(this);
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
        url = getResources().getString(R.string.url_base) + "cm/2020-1/product_detail.php?id=" + id;
        request = new JsonObjectRequest(Request.Method.GET,url,null,this,this);

        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("RESPUESTA",error.toString());
    }

    @Override
    public void onResponse(JSONObject response){
        Log.d("RESPUESTA",response.toString());

        try {

            String _name = response.getString("name");
            String _thumbnail_url = response.getString("imag_url");
            String _desc = response.getString("desc");
            name.setText(_name);
            desc.setText(_desc);
            Picasso.get().load(_thumbnail_url).into(imageView);
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(),"Algo ha salido mal",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}
