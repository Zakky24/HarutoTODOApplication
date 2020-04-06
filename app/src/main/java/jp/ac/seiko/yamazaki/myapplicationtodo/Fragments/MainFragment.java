package jp.ac.seiko.yamazaki.myapplicationtodo.Fragments;


import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import jp.ac.seiko.yamazaki.myapplicationtodo.R;

public class MainFragment extends Fragment {
    RecyclerView mRecyclerViewList;
    private final static String KEY_TEXT4 = "text4";
    private final static String KEY_TEXT5= "text5";

    private String mText4 = "";
    private String mText5 = "";

    public static MainFragment newInstance(String text4,String text5) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle(); // は？
        args.putString(KEY_TEXT4, text4); // は？
        args.putString(KEY_TEXT5, text5);
        fragment.setArguments(args); // は？は？// は？
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerViewList.setHasFixedSize(false);
        mRecyclerViewList.setLayoutManager(manager);
        mRecyclerViewList.setAdapter(new Adapter(createData()));
        Bundle args = getArguments();
        mText4 = args.getString(KEY_TEXT4);     // getStringExtraみたいなもん
        mText5 = args.getString(KEY_TEXT5);     // getStringExtraみたいなもん
    }
    private List<DataModel> createData() {
        List<DataModel> list = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            // 一行分のデータ
            DataModel rowData = new DataModel();
            rowData.setBitmap(/*なんかの画像*/);
            rowData.setmString("この行は" + (index + 1) + "回目の繰り返しです。");
            list.add(rowData);
        }
        return list;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        init(rootView);// 授業ではや// らなかったけどこうするといい。
        mRecyclerViewList = rootView.findViewById(R.id.todoview);
        Button shinkibutton = rootView.findViewById(R.id.button);
        shinkibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewFragment newfragment = NewFragment.newInstance("","","次へ");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, newfragment);
                fragmentTransaction.addToBackStack(newfragment.getClass().getSimpleName());
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    private void init(View rootView) {
        // ...
    }
}
