package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.LaunchModeActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.Q4Activity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.Quiz2Activity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button q1;
    private Button q2;
    private Button q4;
    private Intent intent;

    public WorkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkFragment newInstance(String param1, String param2) {
        WorkFragment fragment = new WorkFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        q1 = (Button) view.findViewById(R.id.quiz_1_btn);
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Quiz 1", Toast.LENGTH_SHORT).show();
            }
        });

        q2 = (Button) view.findViewById(R.id.quiz_2_btn);
        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start new activity
                intent = new Intent(getActivity(), Quiz2Activity.class);
                startActivity(intent);
            }
        });

        q4 = (Button) view.findViewById(R.id.quiz_4_btn);
        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start new activity
                intent = new Intent(getActivity(), Q4Activity.class);
                startActivityForResult(intent, 200);
            }
        });

        return  view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = data.getStringExtra("Data");
        if (s.equals("Exit")) {
            Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        }
    }

}
