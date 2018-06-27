package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.ActivityA;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.AdvanceListViewActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.AdvanceViewPagerActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.AnimationActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.CheckBoxActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.DialogActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.HandlerActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.IntentAndBundleActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.LaunchModeActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.NinePatchActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.NotificationActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.RadioGroupActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.ResultActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.RunnableHandlerActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.ScaleTypeActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.activity.ViewPagerActivity;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter.ListNormalAdapter;
import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.audio.BaseBean;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final ArrayList<String> contentList;
    private final Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private Intent intent;

    public DemoFragment() {

        context = getContext();
        intent = null;

        contentList = new ArrayList<String>();
        contentList.add("LaunchMode");
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9Patch");
        contentList.add("Intent & Bundle");
        contentList.add("Notification");
        contentList.add("AdvancedListView");
        contentList.add("AdvancedViewPager");
        contentList.add("ActivityCommunications");
        contentList.add("ResultActivity");
        contentList.add("RadioGroupActivity");
        contentList.add("CheckBoxActivity");
        contentList.add("Dialogs");
        contentList.add("Handler");
        contentList.add("RunnableHandler");
        contentList.add("Animations");
        contentList.add("Rho");
        contentList.add("Sigma");
        contentList.add("Tau");
        contentList.add("Upsilon");
        contentList.add("Phi");
        contentList.add("Chi");
        contentList.add("Psi");
        contentList.add("Omega");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DemoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DemoFragment newInstance(String param1, String param2) {
        DemoFragment fragment = new DemoFragment();
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
        View view = inflater.inflate(R.layout.fragment_demo, container,false);
        listView = (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
        //View headerView = new View(getActivity());
        //listView.addHeaderView(headerView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //go to LaunchModeActivity
                        intent = new Intent(getActivity(), LaunchModeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        //go to ViewPagerActivity
                        intent = new Intent(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        //go to ScaleTypeActivity (scale type pager)
                        intent = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //go to NinePatchActivity (display a 9Patch file and original)
                        intent = new Intent(getActivity(), NinePatchActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        //go to IntentAndBundleActivity
                        intent = new Intent(getActivity(), IntentAndBundleActivity.class);
                        intent.putExtra("Msg","Hello");
                        intent.putExtra("number",10);
                        Bundle bundle = new Bundle();
                        bundle.putInt("B_Msg",100);
                        bundle.putString("B_Msg","FromBundle");
                        intent.putExtra("B_Msg",bundle);
                        startActivity(intent);
                        break;
                    case 5:
                        //go to NotificationActivity
                        intent = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        //go to Advanced List View
                        intent = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        //go to AdvancedViewPager
                        intent = new Intent(getActivity(), AdvanceViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        //go to Communication Activity
                        intent = new Intent(getActivity(), ActivityA.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("StringBundle","FromDemoFragment");
                        bundle2.putInt("IntegerBundle",101);
                        BaseBean bean = new BaseBean();
                        bean.setName("Bean");
                        bundle2.putSerializable("Object",bean);
                        intent.putExtra("Bundle",bundle2);
                        startActivity(intent);
                        break;
                    case 9:
                        //go to ResultActivity
                        intent = new Intent(getActivity(), ResultActivity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        //go to RadioGroupActivity
                        intent = new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent);
                        break;
                    case 11:
                        //go to CheckBoxActivity
                        intent = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent);
                        break;
                    case 12:
                        //go to DialogActivity
                        intent = new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent);
                        break;
                    case 13:
                        //go to HandlerActivity
                        intent = new Intent(getActivity(), HandlerActivity.class);
                        startActivity(intent);
                        break;
                    case 14:
                        //go to RunnableHandlerActivity
                        intent = new Intent(getActivity(), RunnableHandlerActivity.class);
                        startActivity(intent);
                        break;
                    case 15:
                        //go to AnimationActivity
                        intent = new Intent(getActivity(), AnimationActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getContext(), "You clicked an unconnected list item",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

}
