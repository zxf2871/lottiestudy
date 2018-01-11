package com.b8a3.lottiestudy;

import android.animation.ValueAnimator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final static String TAG = "MainActivity";
    final static String[] jsonFileNames = {"9squares-AlBoardman.json",
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
    private LottieAnimationView mLottieView1;
    private LottieDrawable mLottieDrawable;
    private LottieDrawable mLottieDrawableBackground;
    private Button mBt1;
    private TextView mJsonNameTV;
    private TextView mProgressTv;
    private SeekBar mSeekBar;
    private String jsonFile = "Mobilo/A.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLottieView = findViewById(R.id.lottie_v);
        mLottieView1 = findViewById(R.id.lottie_v_1);
        mLottieDrawable = new LottieDrawable();
        mLottieDrawableBackground = new LottieDrawable();
        mJsonNameTV = findViewById(R.id.tv_json_name);
        mProgressTv = findViewById(R.id.progress_tv);
        mSeekBar = findViewById(R.id.sb_01);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mLottieView1.setProgress((float) progress/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mBt1 = findViewById(R.id.bt_1);
        mBt1.setOnClickListener(this);


        ((ImageView)findViewById(R.id.lottie_v1)).setImageDrawable(mLottieDrawable);
        findViewById(R.id.lottie_v2).setBackgroundDrawable(mLottieDrawableBackground);

//        Cancellable cancellable = LottieComposition.Factory.fromAssetFileName(this, "xyz.json", new OnCompositionLoadedListener() {
//            @Override
//            public void onCompositionLoaded(@Nullable LottieComposition composition) {
//                mLottieView.setComposition(composition);
//                mLottieView.playAnimation();
//            }
//        });
//
//        cancellable.cancel();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bt_1:

                /******************************************* LottieAnimationView ***********************************/

                int l = jsonFileNames.length;
                int position = (int) (Math.random() * l);
                jsonFile = jsonFileNames[position];
                Log.i(TAG, "change to : 第" + position + "个" + jsonFile);
                mJsonNameTV.setText(jsonFile);
                mLottieView.setAnimation(jsonFile);
                Cancellable cancellable0 = LottieComposition.Factory.fromAssetFileName(this, jsonFile, new OnCompositionLoadedListener() {
                    @Override
                    public void onCompositionLoaded(@Nullable LottieComposition composition) {
                        mLottieView.setComposition(composition);
                        mLottieView1.setComposition(composition);
                        mLottieView.playAnimation();
                    }
                });

                mLottieView.setRepeatCount(LottieDrawable.INFINITE);
                mLottieView.playAnimation();




                /******************************************* ImageView + Drawable ***********************************/

                mLottieDrawable.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        String percent = String.valueOf((int) ((float) animation.getAnimatedValue() * 100)) + "%";
                        mProgressTv.setText(percent);
                    }
                });

                Cancellable cancellable = LottieComposition.Factory.fromAssetFileName(this, jsonFile, new OnCompositionLoadedListener() {
                    @Override
                    public void onCompositionLoaded(@Nullable LottieComposition composition) {
                        mLottieDrawable.setComposition(composition);
                        mLottieDrawable.playAnimation();
                    }
                });

                ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mLottieDrawable.setProgress((Float) animation.getAnimatedValue());
                    }
                });
                mLottieDrawable.setMaxProgress(0.6f);
                mLottieDrawable.setRepeatCount(LottieDrawable.INFINITE);
                mLottieDrawable.setRepeatMode(LottieDrawable.REVERSE);
                mLottieDrawable.playAnimation();



                mLottieDrawableBackground.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        String percent = String.valueOf((int) ((float) animation.getAnimatedValue() * 100)) + "%";
                        mProgressTv.setText(percent);
                    }
                });

                final ValueAnimator animator1 = ValueAnimator.ofFloat(0f, 1f);
                animator1.setDuration(3000);
                animator1.setRepeatCount(-1);
                animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mLottieDrawableBackground.setProgress((Float) animation.getAnimatedValue());
                    }
                });

                Cancellable cancellable1 = LottieComposition.Factory.fromAssetFileName(this, jsonFile, new OnCompositionLoadedListener() {
                @Override
                public void onCompositionLoaded(@Nullable LottieComposition composition) {
                    mLottieDrawableBackground.setComposition(composition);
                    animator1.start();
                }
            });
                mLottieDrawableBackground.setMaxProgress(0.6f);
                mLottieDrawableBackground.setRepeatCount(LottieDrawable.INFINITE);
                mLottieDrawableBackground.setRepeatMode(LottieDrawable.REVERSE);
                mLottieDrawableBackground.playAnimation();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLottieView != null) {
            mLottieView.cancelAnimation();
        }
        if (mLottieDrawable != null) {
            mLottieDrawableBackground.cancelAnimation();
            mLottieDrawable.cancelAnimation();
            mLottieDrawable.recycleBitmaps();
            mLottieDrawableBackground.recycleBitmaps();
        }
    }
}
