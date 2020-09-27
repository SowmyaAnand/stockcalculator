package com.profit.stockcalculator.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.profit.stockcalculator.MainActivity;
import com.profit.stockcalculator.R;
import com.profit.stockcalculator.SecondActivity;

public class HomeFragment extends Fragment {
    String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};
    Button addition,cal;
    LinearLayout l1,l2,l3,l4,l5;
    int flag=1;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        addition=root.findViewById(R.id.add);
        cal=root.findViewById(R.id.calculate);
        l1=root.findViewById(R.id.lin1);
        l2=root.findViewById(R.id.lin2);
        l3=root.findViewById(R.id.lin3);
        l4=root.findViewById(R.id.lin4);
        l5=root.findViewById(R.id.lin5);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getContext(), SecondActivity.class);
                startActivity(next);
            }
        });
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
        MaterialSpinner spinner = root.findViewById(R.id.spinner1);
        spinner.setItems("SELECT SECURITY","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow","Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        return root;
    }
}
