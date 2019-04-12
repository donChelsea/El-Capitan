package com.example.elcapitan.frag;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;
import com.example.elcapitan.controller.JobAdapter;
import com.example.elcapitan.model.Job;
import com.example.elcapitan.network.JobsService;
import com.example.elcapitan.network.RetrofitSingleton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.elcapitan.frag.MainFragment.SHOW_PART_TIME;
import static com.example.elcapitan.frag.MainFragment.USER_LANGUAGE;
import static com.example.elcapitan.frag.MainFragment.USER_LOCATION;

public class ResultsFragment extends Fragment {
    private static final String TAG = "ResultFragment";
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    Disposable retrofit;
    OnFragmentInteractionListener listener;


    public ResultsFragment() {
    }

    public ResultsFragment newInstance() {
        return new ResultsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args == null) return;
        String userLocation = args.getString(USER_LOCATION);
        String userLanguage = args.getString(USER_LANGUAGE);
        boolean showPartTime = args.getBoolean(SHOW_PART_TIME);

        retrofit = RetrofitSingleton.getInstance("https://jobs.github.com/")
        .create(JobsService.class)
        .getJobs(userLanguage, showPartTime, userLocation)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(jobList -> {
            assert jobList != null;
            recyclerView.setAdapter(new JobAdapter(jobList, listener));
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }, throwable -> Log.d(TAG, "onFailure: --- " + throwable.getMessage()));
    }
}
