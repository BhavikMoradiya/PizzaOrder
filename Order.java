package com.example.bhavik.pizzaorder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;


public class Order extends Activity {

    double total;
    Spinner spinner1;
    HashMap<String, String> hashMap1;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        System.out.println("this is " +bundle);
        if (bundle != null) {
            hashMap1 = (HashMap<String, String>) intent.getSerializableExtra("subtotal");
            System.out.println("this is hash map " +hashMap1);
            total = Double.parseDouble(hashMap1.get("pizza_total"));
        }

        spinner1 = (Spinner)findViewById(R.id.chesse1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3)
            {
                System.out.println("this is inside of spinner");
                if(spinner1.getSelectedItem().toString() == "Normal")
                {
                    total = total + 5;
                    hashMap1.put(spinner1.getSelectedItem().toString().concat(" (Cheese Type)"), "$5");
                }

                if(spinner1.getSelectedItem().toString() == "Extra")
                {
                    total = total + 10;
                    hashMap1.put(spinner1.getSelectedItem().toString().concat(" (Cheese Type)"), "$10");
                }

                if(spinner1.getSelectedItem().toString() == "Double")
                {
                    total = total + 15;
                    hashMap1.put(spinner1.getSelectedItem().toString().concat(" (Cheese Type)"), "$15");
                }

                if(spinner1.getSelectedItem().toString() == "Triple")
                {
                    total = total + 18;
                    hashMap1.put(spinner1.getSelectedItem().toString().concat(" (Cheese Type)"), "$18");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }
    public void submitOrder(View v)
    {
        System.out.println("inside of submitt order");
        hashMap1.remove("YOUR PIZZA TOTAL");

        hashMap1.put("Pizza Total" , String.valueOf(total));
        Double tax =(total*6)/100;

        hashMap1.put("TAX ",String.valueOf(tax));
        total = tax + total;

        hashMap1.put("YOUR  TOTAL ",String.valueOf(total));

        Intent act = new Intent(this,PizzaOrderView.class);
        Bundle newact = new Bundle();
        newact.putSerializable("total",hashMap1);
        act.putExtras(newact);
        startActivity(act);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
