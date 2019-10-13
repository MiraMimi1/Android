package com.w12.thslm.historica;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    long time;
    private MediaPlayer mp;
    private ActionBarDrawerToggle t;
    private DrawerLayout d;
    Dialog dialog;
    Vibrator vib;
    RelativeLayout rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mp.start();
        mp.setLooping(true);
      //  mp.start(); //sound


        d = (DrawerLayout) findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, d, R.string.open, R.string.close);
        d.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        lv = (ListView) findViewById(R.id.lv);


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final ArrayList<Livres> lvl = databaseAccess.getDBdata();

        databaseAccess.close();


        LivresListeAdapter adapter = new LivresListeAdapter(this, R.layout.livre_layout, lvl);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mp.pause();
                Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);
                intent.putExtra("pageContent", lvl.get(i).getContenu());
                intent.putExtra("bg", lvl.get(i).getBgImage());
                startActivity(intent);

            }
        });

    }
    @Override

        public boolean onOptionsItemSelected(MenuItem item) {
            if (t.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }







    @Override
    public void onBackPressed() {


        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCancelable(true);
        TextView m = (TextView) dialog.findViewById(R.id.message);
        TextView t = (TextView) dialog.findViewById(R.id.title);
        Button n = (Button) dialog.findViewById(R.id.exit);
        Button p = (Button) dialog.findViewById(R.id.cancel);
        Button e = (Button) dialog.findViewById(R.id.exitbtn);
        rl = (RelativeLayout) dialog.findViewById(R.id.rl1);

        vib = (Vibrator) this.getSystemService(this.VIBRATOR_SERVICE);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vib.vibrate(15);
                finish();
                mp.stop();
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vib.vibrate(20);
                dialog.cancel();

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vib.vibrate(20);
                dialog.cancel();

            }
        });
        dialog.show();

    }




    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menuopt,menu);
        return true;
    }



    public boolean more(MenuItem item){

        if(item.getItemId()==R.id.mor){

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast,
                    (ViewGroup)findViewById(R.id.toastx));
            Toast t= new Toast(getApplicationContext());
            t.setDuration(Toast.LENGTH_SHORT);
            t.setView(layout);
            t.show();
            return true;

        }
        return true;
    }



    
}



























