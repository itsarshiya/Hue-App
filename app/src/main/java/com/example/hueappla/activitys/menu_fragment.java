package com.example.hueappla.activitys;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hueappla.R;
import com.example.hueappla.menu_fragmentListener;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link menu_fragmentListener} interface
 * to handle interaction events.
 * Use the {@link menu_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menu_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private menu_fragmentListener listener;

    public menu_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menu_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static menu_fragment newInstance(String param1, String param2) {
        menu_fragment fragment = new menu_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_fragment, container, false);
        Button groups = view.findViewById(R.id.groups);
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnGroupsButtonClicked();
            }
        });
        Button lamps = view.findViewById(R.id.lamps);
        lamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnLampsButtonClicked();
            }
        });
        Button allLamps = view.findViewById(R.id.all_lamps);
        allLamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnAllLampsButtonClicked();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof menu_fragmentListener) {
            listener = (menu_fragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}
