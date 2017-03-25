package com.example.dhana.eventadda;

/**
 * Created by dhana on 3/25/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class tab1 extends Fragment {
    EventListAdapter adapter;


    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();
    ArrayList<String> hostBy = new ArrayList<>();
    ArrayList<String> teamSize = new ArrayList<>();
    ArrayList<String> details = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new EventListAdapter(titles, dates,location,teamSize,details,times);
        View view = inflater.inflate(R.layout.tab1, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.eventRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        getAllEvents();

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        return  view;
    }
    public void getAllEvents() {
        //volley
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest mStringRequest = new StringRequest(Request.Method.GET,AppConfig.listURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String event_id = jsonObject.getString("event_id");
                                titles.add(jsonObject.getString("event_name"));
                                dates.add(jsonObject.getString("event_date"));
                                location.add(jsonObject.getString("venue"));
                                details.add(jsonObject.getString("details"));
                                teamSize.add(jsonObject.getString("max_team"));
                                times.add(jsonObject.getString("tym"));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(mStringRequest);
}
}

