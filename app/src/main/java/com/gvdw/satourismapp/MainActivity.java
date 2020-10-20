package com.gvdw.satourismapp;

/*
 Pearson Pretoria BSC IT Level 3
 2020 ITJA321 - Take Home Assessment Question 6
 Gullian Van Der Walt - H5G8YT7X3
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 String place = "";
 String selectedItem;
 Spinner spinner;
 TextView txtView;
 DatabaseHelper db;

  public MainActivity() {

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = (Spinner) findViewById(R.id.spinnerSelectProv);
    txtView = (TextView) findViewById(R.id.txtViewPlace);

    db = new DatabaseHelper(this);

    List<String> prov = new ArrayList<>();
    prov.add("Gauteng");
    prov.add("Western Cape");
    prov.add("KwaZulu Natal");
    prov.add("Eastern Cape");
    prov.add("Northern Cape");
    prov.add("Mpumalanga");
    prov.add("Limpopo");
    prov.add("North West");
    prov.add("Free State");

    // Spinner Adapter
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,prov);

    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    //add to spinner
    spinner.setAdapter(dataAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedItem = spinner.getSelectedItem().toString();
        PlaceDetails placeDetails = new PlaceDetails();
        placeDetails = db.getPlaceDetails(selectedItem);
        place = placeDetails.getPlace();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }

}
