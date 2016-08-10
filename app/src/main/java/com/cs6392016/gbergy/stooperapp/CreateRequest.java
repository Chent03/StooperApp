package com.cs6392016.gbergy.stooperapp;

/**
 * Created by Tony on 7/7/16.
 */
import android.support.v4.app.Fragment;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class CreateRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://chent03.com/Create.php";
    private Map<String, String> params;

    public CreateRequest(String title, String category, String condition, String address, String city, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("title", title);
        params.put("category", category);
        params.put("condition", condition);
        params.put("address", address);
        params.put("city", city);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
