package com.example.animationhw;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isFront = true;
    private Button flipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipButton = findViewById(R.id.button_flip);
        TextView card_front = findViewById(R.id.card_front);
        TextView card_back = findViewById(R.id.card_back);
        AnimatorSet front_anim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.front_animator);
        AnimatorSet back_anim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.back_animator);

        float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        card_front.setCameraDistance(8000 * scale);
        card_back.setCameraDistance(8000 * scale);

        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFront) {
                    front_anim.setTarget(card_front);
                    back_anim.setTarget(card_back);
                    front_anim.start();
                    back_anim.start();
                    isFront = false;
                }
                else {
                    front_anim.setTarget(card_back);
                    back_anim.setTarget(card_front);
                    front_anim.start();
                    back_anim.start();
                    isFront = true;
                }
            }
        });
    }
}