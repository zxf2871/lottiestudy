package com.b8a3.lottiestudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static String[] jsonFileNames = {"squares-AlBoardman.json",
            "City.json",
            "EmptyState.json",
            "HamburgerArrow.json",
            "Hello World.json",
            "lottiefiles.com - ATM.json",
            "lottiefiles.com - Beating Heart.json",
            "lottiefiles.com - Camera.json",
            "lottiefiles.com - Countdown.json",
            "lottiefiles.com - Curly Hair.json",
            "lottiefiles.com - Day Night.json",
            "lottiefiles.com - Emoji Shock.json",
            "lottiefiles.com - Emoji Tongue.json",
            "lottiefiles.com - Emoji Wink.json",
            "lottiefiles.com - Favorite Star.json",
            "lottiefiles.com - Gears.json",
            "lottiefiles.com - Im Thirsty.json",
            "lottiefiles.com - Loader 5.json",
            "lottiefiles.com - Loading 1.json",
            "lottiefiles.com - Loading 2.json",
            "lottiefiles.com - Loading 3.json",
            "lottiefiles.com - Loading 4.json",
            "lottiefiles.com - Mail Sent.json",
            "lottiefiles.com - Notifications.json",
            "lottiefiles.com - Nudge.json",
            "lottiefiles.com - Octopus.json",
            "lottiefiles.com - Permission.json",
            "lottiefiles.com - Play and Like It.json",
            "lottiefiles.com - Postcard.json",
            "lottiefiles.com - Preloader.json",
            "lottiefiles.com - Progress Success.json",
            "lottiefiles.com - React.json",
            "lottiefiles.com - Retweet.json",
            "lottiefiles.com - Star Wars Rey.json",
            "lottiefiles.com - Tadah Image.json",
            "lottiefiles.com - Tadah Video.json",
            "lottiefiles.com - Touch ID.json",
            "lottiefiles.com - Video Camera.json",
            "lottiefiles.com - VR Sickness.json",
            "lottiefiles.com - VR.json",
            "LottieLogo1.json",
            "LottieLogo2.json",
            "lottifiles.com - QR Scan.json",
            "MotionCorpse-Jrcanest.json",
            "Name.json",
            "PinJump.json",
            "Spider Loader.json",
            "TwitterHeart.json",
            "WeAccept.json"
    };

    private LottieAnimationView mLottieView;
    private Button mBt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLottieView = findViewById(R.id.lottie_v);
        mBt1 = findViewById(R.id.bt_1);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int l = jsonFileNames.length;
        int position = (int) (Math.random()*l);
        switch (id) {
            case R.id.bt_1:
                mLottieView.setAnimation(position);
                break;
        }
    }
}
