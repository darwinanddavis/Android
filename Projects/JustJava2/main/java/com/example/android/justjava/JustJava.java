package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/** This app displays an order form to order coffee. */

/** Public class = name of this java file */
public class JustJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
    }

    /** execute minus quantity method */
    public void minusQuantity(View view) {
        int quantity = 1;
        displayQuantity(quantity); /* display quantity */
        /*System.out.println(R.id.quantity_number - 1);*/
    }

    /** execute plus quantity method */
    public void plusQuantity(View view) {
        int quantity = 3;
        displayQuantity(quantity);
        /* System.out.println(R.id.quantity_number + (R.id.quantity_number + 1));*/
    }

    /** This method is called when the order button is clicked */
    public void submitOrder(View view) {
        int quantitySelected = R.id.quantity_number;  /* Quantity variable */
        displayQuantity(quantitySelected); /* display quantity */
        displayPrice(quantitySelected * 5); /* display price */
    }

    /** This method is called when the reset button is clicked */
    public void submitReset(View view) {
        displayQuantity(0); /* display quantity */
        displayPrice(0); /* display price */
    }

    /** This method displays the quantity on the screen */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_number);
        quantityTextView.setText("" + number);
    }

    /** This method displays the given price on the screen */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_number);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}