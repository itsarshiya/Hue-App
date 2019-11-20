package com.example.hueappla;

import android.content.Context;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HueLampApi {

    Context context;
    RequestQueue queue;
    final String ip = "http://145.48.205.33/api/iYrmsQq1wu5FxF9CPqpJCnm1GpPVylKBWDUsNDhB/lights";
    HueLampApiListener listener;

    HueLampApi(Context context, HueLampApiListener listener) {
        this.listener = listener;
        this.context = context;
    }

    public void searchForHueLamps() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                this.ip,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        for(int index = 0; index < 10; index++) {
                            try {
                                JSONObject hueLamp = response.getJSONObject(index + "");
                                JSONObject state = hueLamp.getJSONObject("state");
                                JSONObject capabilities = hueLamp.getJSONObject("capabilities");
                                boolean on = state.getBoolean("on");
                                int bri = state.optInt("bri");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.OnHueAdapterError();
                    }
                }
        );
    }

}
