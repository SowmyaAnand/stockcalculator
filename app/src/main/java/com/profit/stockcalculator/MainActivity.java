package com.profit.stockcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;


public class MainActivity extends AppCompatActivity {
    String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};
    Button addition;
    LinearLayout l1,l2,l3,l4,l5;
    int flag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition=findViewById(R.id.add);
        l1=findViewById(R.id.lin1);
        l2=findViewById(R.id.lin2);
        l3=findViewById(R.id.lin3);
        l4=findViewById(R.id.lin4);
        l5=findViewById(R.id.lin5);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=flag+1;
               if(flag==2)
               {
                   l2.setVisibility(View.VISIBLE);
               }
                if(flag==3)
                {
                    l3.setVisibility(View.VISIBLE);
                }
                if(flag==4)
                {
                    l4.setVisibility(View.VISIBLE);
                }
                if(flag==5)
                {
                    l5.setVisibility(View.VISIBLE);
                }
            }
        });
        MaterialSpinner spinner = findViewById(R.id.spinner1);
        spinner.setItems("Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
