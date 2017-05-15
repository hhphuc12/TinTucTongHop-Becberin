package com.phuc.tintuctonghop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentNoInternet extends Fragment {

    public FragmentNoInternet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_no_internet, container, false);
		
        TextView tvError = (TextView) view.findViewById(R.id.tv_error);
        Button btRetry= (Button) view.findViewById(R.id.bt_retry);
		
		/**show warning dialog when devices has no internet*/
        tvError.setText("No Internet connection. Make sure that Wi-Fi or cellular data is turned on, then try again.");
        btRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = new MainActivity();
                activity.initGUI();
            }
        });
        return view;
    }

}
