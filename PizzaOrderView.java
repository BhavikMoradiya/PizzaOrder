package com.example.bhavik.pizzaorder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;


public class PizzaOrderView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order_view);

        HashMap<String, String> hashMap1 ;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        StringBuilder yourOreder1 = new StringBuilder();
        String yourOreder = "";

        if (bundle != null)
        {
            hashMap1 = (HashMap<String, String>) intent.getSerializableExtra("total");

            TextView textView = (TextView) findViewById(R.id.hello);
            TextView textView1 = (TextView) findViewById(R.id.pizza);
            TextView textView2 = (TextView) findViewById(R.id.tax);
            TextView textView3 = (TextView) findViewById(R.id.total);


            for(String key: hashMap1.keySet()){
                System.out.println(key  +"<<<<>>>> :: "+ hashMap1.get(key));

                yourOreder1.append(key+":---------------->"+hashMap1.get(key));
                yourOreder1.append(System.getProperty("line.separator"));
                //if you uncomment below code, it will throw java.util.ConcurrentModificationException
                //studentGrades.remove("Alan");
            }

            textView.setText(yourOreder1);
            textView1.setText("YOUR PIZZA TOTAL:---------------->"+hashMap1.get("Pizza Total"));
            textView2.setText("TAX:---------------->"+hashMap1.get("TAX"));
            textView3.setText("YOUR  TOTAL:---------------->"+hashMap1.get("YOUR  TOTAL"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pizza_order_view, menu);
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
