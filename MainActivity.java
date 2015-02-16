package com.example.bhavik.pizzaorder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.HashMap;


public class MainActivity extends Activity
{

    RadioButton handToast,thinCrust1,brookylnStyle;
    RadioGroup handGroup,thinCrust ,bk;
    HashMap<String,String> addItems  = new HashMap<>();
    double total = 0.0;
    double perpproniCost =1.5 ,italianCost=1.5,beefCost=2.0,meatsCost=2.0,cheddarCheeseCost=2.0,
            fCheesCost=2.0,bananaPerpperCost=2.0,thinCost=20,handTostCost=25,brookylnStyleCost=30;
    CheckBox perpproni ,italianSausage,beef,cheddarcheese,fetacheese,bananaperppers;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perpproni = (CheckBox)findViewById(R.id.perpperoni);
        italianSausage = (CheckBox)findViewById(R.id.italianSausage);
        beef = (CheckBox)findViewById(R.id.beef);
        cheddarcheese = (CheckBox)findViewById(R.id.cheddarcheese);
        fetacheese = (CheckBox)findViewById(R.id.fetacheese);
        bananaperppers = (CheckBox)findViewById(R.id.bananaperppers);

        perpproni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(perpproni.isChecked())
                {
                    total = total + perpproniCost;
                    addItems.put("perpproni", "1.5");
                }
                else
                {
                    total = total - perpproniCost;
                    addItems.remove("perpproni");
                }
            }
        });
        italianSausage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(italianSausage.isChecked())
                {
                    total = total + italianCost;
                    addItems.put("ItalianSausage", "1.5");
                }
                else
                {
                    total = total - italianCost;
                    addItems.remove("ItalianSausage");
                }
            }
        });
        beef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(beef.isChecked())
                {
                    total = total + beefCost;
                    addItems.put("Beef", "2.0");
                }
                else
                {
                    total = total - beefCost;
                    addItems.remove("Beef");

                }
            }
        });
        cheddarcheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                    if(cheddarcheese.isChecked())
                    {
                        total = total + cheddarCheeseCost;
                        addItems.put("Cheddar Cheese", "2.0");
                    }
                    else
                    {
                        total = total - cheddarCheeseCost;
                        addItems.remove("Cheddar Cheese");

                    }
            }
        });
        fetacheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(fetacheese.isChecked())
                {
                    total = total + fCheesCost;
                    addItems.put("Feta Cheese", "2.0");
                }
                else
                {
                    total = total - fCheesCost;
                    addItems.remove("Feta Cheese");

                }
            }
        });
        bananaperppers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(bananaperppers.isChecked())
                {
                    total = total + bananaPerpperCost;
                    addItems.put("Banana Perppers", "2.0");
                }
                else
                {
                    total = total - bananaPerpperCost;
                    addItems.remove("Banana Perppers");

                }
            }
        });

    }
    public void submitOrder(View v)
    {
        System.out.println("this is inside in submitt order method");


            handGroup = (RadioGroup) findViewById(R.id.handTossed);
            int selectedId = handGroup.getCheckedRadioButtonId();
            handToast = (RadioButton) findViewById(selectedId);

            if (handToast.isChecked()) {
                total = total + handTostCost;
                addItems.put(handToast.getText().toString().concat(" (Hand Tossed)"), "$25");
            }
        
        thinCrust = (RadioGroup) findViewById(R.id.thinCrust);
        int selectedId1 = thinCrust.getCheckedRadioButtonId();
        thinCrust1 = (RadioButton) findViewById(selectedId1);

        if(thinCrust1.isChecked())
        {
            total = total + thinCost;
            addItems.put(thinCrust1.getText().toString().concat(" (Thin Crust)"),"$20");
        }

        bk = (RadioGroup) findViewById(R.id.bk);
        int selectedId2 = thinCrust.getCheckedRadioButtonId();
        brookylnStyle = (RadioButton) findViewById(selectedId2);

        if(brookylnStyle.isChecked())
        {
            total = total + brookylnStyleCost;
            addItems.put(brookylnStyle.getText().toString().concat(" (Brookyln Style)"),"$30");
        }

        addItems.put("pizza_total",String.valueOf(total));

        System.out.println("this is hash map "+addItems);
        Intent act = new Intent(this,Order.class);
        Bundle newact = new Bundle();
        newact.putSerializable("subtotal",addItems);
        act.putExtras(newact);
        startActivity(act);

    }


}
