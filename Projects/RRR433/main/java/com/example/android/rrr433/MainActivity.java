package com.example.android.rrr433;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    /**
     * play pause button define
     **/
    private ImageView playpause_image;
    private int playpause_imageCurrent;
    int[] playpause_imageLength = {R.drawable.pause, R.drawable.play};

    /**
     * heart button define
     **/
    private ImageView heart_image;
    private int heart_imageCurrent;
    int[] heart_imageLength = {R.drawable.heart, R.drawable.heart_save};

    /**
     * menu button define
     **/
    private Button menu_image;

    /**
     * menu header define
     **/
    public Text menuheader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playpause_click();
        heart_click();
        menu_click();
    }

    /************
     *
     * play pause button
     **/

    public void playpause_click() {
        playpause_image = findViewById(R.id.playpause);
        playpause_image.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playpause_imageCurrent++;
                        playpause_imageCurrent = playpause_imageCurrent % playpause_imageLength.length;
                        playpause_image.setImageResource(playpause_imageLength[playpause_imageCurrent]);
                    }
                }
        );
    }

    /**
     * heart button
     **/
    public void heart_click() {
        heart_image = findViewById(R.id.heart);
        heart_image.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        heart_imageCurrent++;
                        heart_imageCurrent = heart_imageCurrent % heart_imageLength.length;
                        heart_image.setImageResource(heart_imageLength[heart_imageCurrent]);
                    }
                }
        );
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);*/

    public void menu_click() {
        menu_image = findViewById(R.id.menu_popup);
        menu_image.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //Creating the instance of PopupMenu
                        PopupMenu popup = new PopupMenu(MainActivity.this, menu_image);
                        //Inflating the Popup using xml file
                        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                        MenuItem item = popup.getMenu().findItem(R.id.menu_header);
                        MenuItemCompat.setActionView(item, R.layout.custom_layout);
                        //Here, you get access to the view of your item, in this case, the layout of the item has a RelativeLayout as root view but you can change it to whatever you use
                        LinearLayout rootView = (LinearLayout)MenuItemCompat.getActionView(item);
                        //Then you access to your control by finding it in the rootView
                        ImageView imageview1 = (ImageView) rootView.findViewById(R.id.record_thumbnail);

                        //show popup menu
                        popup.show();

                        //** Adding header to popup menu #1 **//
                        // https://stackoverflow.com/questions/38495851/how-to-add-a-relativelayout-as-menu-item-android //
                        // menuheader = findViewById(R.id.menu_header); //
                        //**//

                        //** Adding header to popup menu #2 **//
                        // MenuItem menuheader = popup.getMenu().findItem(R.id.menu_header);
                        // MenuItemCompat.setActionView(menuheader, R.layout.custom_layout);
                        // LinearLayout rootView = (LinearLayout) MenuItemCompat.getActionView(menuheader);
                        //**//


                    }
                }

        );
    }


} //* end main compat activity *//*

