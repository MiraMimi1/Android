package com.w12.thslm.historica;


import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PreviewActivity extends AppCompatActivity {

        TextView n2;
        Button go,back,changer;
        ConstraintLayout backgrounded;
        int index=0; String a[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_books);
        hideNav();

        n2=(TextView)findViewById(R.id.show);
        go=(Button)findViewById(R.id.go);
        back=(Button)findViewById(R.id.back);
        changer=(Button)findViewById(R.id.changer);
        backgrounded=(ConstraintLayout)findViewById(R.id.backgrounded);



        int resId=this.getResources().getIdentifier(this.getIntent().getStringExtra("bg"),null,this.getPackageName());
        backgrounded.setBackgroundResource(resId);

        a=getIntent().getExtras().getStringArray("pageContent");
        update();

        n2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                n2.setVisibility(View.INVISIBLE);
                changer.setVisibility(View.VISIBLE);
                return true;
            }
        });

    }

                                        /*  ONCLICK   */
    public void goFun(View view){

        if(index < a.length-1){
            if(index==0) if (back.getVisibility()==View.INVISIBLE) back.setVisibility(View.VISIBLE);
            index++;
            update();
        }
        if(index==a.length-1) if (go.getVisibility()==View.VISIBLE) go.setVisibility(View.INVISIBLE);


              //Toast.makeText(this,"You've reached the last page ", Toast.LENGTH_SHORT).show(); //put translation
    }


    public void backFun(View view) {
        if(index > 0){
            if(index==a.length-1) if (go.getVisibility()==View.INVISIBLE) go.setVisibility(View.VISIBLE);
            index--;
            update();
        }
        if(index==0) if (back.getVisibility()==View.VISIBLE) back.setVisibility(View.INVISIBLE);



    }
    public void update(){
        n2.setText(a[index]);
    }

    public void changeVisibility(View view) {
        n2.setVisibility(View.VISIBLE);
        changer.setVisibility(View.INVISIBLE);
    }

    /* Hide Navigation Bare */



    /*je sais pas commment mettre TRY CATCH pour cet truc*/

    private void hideNav(){
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNav();
    }
}
