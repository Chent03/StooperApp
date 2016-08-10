package com.cs6392016.gbergy.stooperapp;

/**
 * Created by Tony on 7/6/16.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://chent03.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String first, String last, String username, String password, String email, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("first", first);
        params.put("last", last);
        params.put("username", username);
        params.put("password", password);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
