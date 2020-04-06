package jp.ac.seiko.yamazaki.myapplicationtodo.Fragments;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import jp.ac.seiko.yamazaki.myapplicationtodo.R;

import static android.view.View.*;

public class NewFragment extends Fragment {
    private final static String KEY_TEXT = "text";
    private final static String KEY_TEXT2 = "text2";
    private final static String KEY_TEXT3 = "text3";

    private String mText = "";
    private String mText2 = "";
    private String mText3 = "";

    public static NewFragment newInstance (String text,String text2,String text3) {
        NewFragment fragment = new NewFragment();
        Bundle args = new Bundle(); // は？// は？
        args.putString(KEY_TEXT, text);
        args.putString(KEY_TEXT2, text2);
        args.putString(KEY_TEXT3, text3);// は？
        fragment.setArguments(args); // は？は？
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

            mText = args.getString(KEY_TEXT); // getIntExtraみたいなもん
            mText2 = args.getString(KEY_TEXT2);
            mText3 = args.getString(KEY_TEXT3);

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_new, container, false);
        init(rootView); // 授業ではやらなかったけどこうするといい。

        Button hozonbutton = rootView.findViewById(R.id.button2);
        final EditText titleedit = rootView.findViewById(R.id.titleedit);
        final EditText todoedit = rootView.findViewById(R.id.todoedit);
        hozonbutton.setText(""+mText3);
        hozonbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleedit.getText().toString();
                String todo = todoedit.getText().toString();
                MainFragment fragment = MainFragment.newInstance(""+title,""+todo);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    private void init(View rootView) {
        // ...
    }}