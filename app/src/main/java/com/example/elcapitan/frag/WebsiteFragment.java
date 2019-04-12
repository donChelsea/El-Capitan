package com.example.elcapitan.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.elcapitan.OnFragmentInteractionListener;
import com.example.elcapitan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.elcapitan.DetailActivity.WEBSITE_URL;

public class WebsiteFragment extends Fragment {
    String websiteUrl;
    private OnFragmentInteractionListener listener;
    @BindView(R.id.webview) WebView webView;

    public WebsiteFragment() {
    }

    public static WebsiteFragment newInstance() {
        return new WebsiteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            websiteUrl = getArguments().getString(WEBSITE_URL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_website, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        webView.setWebViewClient(new WebViewClient());

        if (websiteUrl == null) {
        } else {
            webView.loadUrl(websiteUrl);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener= (OnFragmentInteractionListener) context;
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
