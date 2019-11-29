package com.example.hueappla;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class HueLampApi implements Serializable {

    Context context;
    RequestQueue queue;
    String ip1 = "http://145.48.205.33/api/iYrmsQq1wu5FxF9CPqpJCnm1GpPVylKBWDUsNDhB/lights";
    String ip = "http://192.168.1.179/api/SR9GSJKwoECrCeqiCTRoMCToNYfphHD6Yiu2u8me/lights";
    HueLampApiListener listener;

    public HueLampApi(Context context, HueLampApiListener listener) {
        this.listener = listener;
        this.context = context;
        this.queue = Volley.newRequestQueue(this.context);
    }

    public void searchForHueLamps() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                this.ip,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        for(int index = 0; index < 100; index++) {
                            try {
                                JSONObject hueLamp = response.getJSONObject(index + "");
                                JSONObject state = hueLamp.getJSONObject("state");
                                try {
                                    JSONObject capabilities = hueLamp.getJSONObject("capabilities");
                                } catch (Exception e) {

                                }
                                boolean on = state.getBoolean("on");
                                int bri = state.optInt("bri");
                                int hue = state.optInt("hue");
                                int sat = state.optInt("sat");

                                listener.OnHueLampAvailable(new HueLamp(index + "", on, bri, hue, sat));

                            } catch (JSONException e) {
                                Log.i("index", "index klopt niet: " + index);
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.OnHueAdapterError(error.toString());
                    }
                }
        );
        this.queue.add(request);
    }

    public void setHueLampStateOn(final HueLamp hueLamp, boolean on, final HueLampApiListener tListener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                this.ip + "/" + hueLamp.getIndex() + "/state",
                buildOnJsonObject(on),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        tListener.OnHueLampSetOn(response.toString(), hueLamp);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tListener.OnHueLampSetOnError(error.toString());
                    }
                }
        );

        this.queue.add(request);
    }

    public void setHueLampStateBri(final HueLamp hueLamp, int bri, final HueLampApiListener tListener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                this.ip + "/" + hueLamp.getIndex() + "/state",
                buildBriJsonObject(bri),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        tListener.OnHueLampSetBri(response.toString(), hueLamp);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tListener.OnHueLampSetBriError(error.toString());
                    }
                }
        );

        this.queue.add(request);
    }

    public void setHueLampStateHue(final HueLamp hueLamp, final int hue, final HueLampApiListener tListener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                this.ip + "/" + hueLamp.getIndex() + "/state",
                buildHueJsonObject(hue),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        tListener.OnHueLampSetHue(response.toString(), hueLamp);
                        listener.OnHueLampSetHue("gaat goed", hueLamp);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tListener.OnHueLampSetHueError(error.toString());
                        listener.OnHueLampSetHueError(error.toString());
                    }
                }
        );

        this.queue.add(request);
    }

    public void setHueLampStateSat(final HueLamp hueLamp, int sat, final HueLampApiListener tListener) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                this.ip + "/" + hueLamp.getIndex() + "/state",
                buildSatJsonObject(sat),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse (JSONObject response) {
                        tListener.OnHueLampSetSat(response.toString(), hueLamp);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tListener.OnHueLampSetSatError(error.toString());
                    }
                }
        );

        this.queue.add(request);
    }

    private JSONObject buildBriJsonObject(int bri) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("bri", bri);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    private JSONObject buildHueJsonObject(int hue) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("hue", hue);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject buildSatJsonObject(int sat) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("sat", sat);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JSONObject buildOnJsonObject(boolean on) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("on", on);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}
