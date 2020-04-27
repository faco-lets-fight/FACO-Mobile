package com.facomobile.ui;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.facomobile.R;
import com.facomobile.data.AppRepository;
import com.facomobile.utilities.CustomNavUtils;
import com.facomobile.utilities.PreferenceUtils;
import com.stargradegroup.vtuservices.cta.utilities.InjectorUtils;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tvTheme = findViewById(R.id.tv_theme);
        tvTheme.setText(Html.fromHtml("<span style=\"color: #FF6363\">FIGHT</span> <span style=\"color: #FDE546\">AGAINST</span> <span style=\"color: #53E265\">CORONA</span>"));

        setupStatusBar();
        initComponent();
    }

    private void initComponent() {
        final boolean isOnboarded = PreferenceUtils.INSTANCE.getOnboardingStatus(this);
        if (isOnboarded) {
            boolean isUserSignedIn = PreferenceUtils.INSTANCE.getPrefAuthStatus(this);
            if (isUserSignedIn) {
                AppRepository repository = InjectorUtils.INSTANCE.provideRepository(this);
                AUTH_STATUS authStatus = repository.getUserAuthStatus();
                switch (authStatus) {
                    case SIGNED_OUT:
                        new Handler().postDelayed(() ->
                                CustomNavUtils.launchInitScreen(this), 3000);
                        break;
                    case SIGNED_IN:
                        new Handler().postDelayed(() ->
                                CustomNavUtils.launchMainScreen(this), 3000);
                        break;
                }
            } else {
                new Handler().postDelayed(() ->
                        CustomNavUtils.launchInitScreen(this), 3000);
            }
        } else {
            new Handler().postDelayed(() ->
                    CustomNavUtils.launchOnboarding(this), 3000);
        }
    }


    private void setupStatusBar() {
        View mRoot = findViewById(R.id.root);
        mRoot.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        ViewCompat.setOnApplyWindowInsetsListener(mRoot, (v, insets) -> {
            mRoot.setPadding(mRoot.getPaddingLeft(),
                    mRoot.getPaddingTop() + insets.getSystemWindowInsetTop(),
                    mRoot.getPaddingRight(), mRoot.getPaddingBottom() + insets.getSystemWindowInsetBottom());
            return insets;
        });
    }

    public enum AUTH_STATUS {SIGNED_OUT, SIGNED_IN}
}