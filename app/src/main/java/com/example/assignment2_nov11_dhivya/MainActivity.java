package com.example.assignment2_nov11_dhivya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG ="MainActivity";
    //Creation of object for each class,
    ProductModel prodmod;
    StoreManager storemgr = new StoreManager();

    Calculation calculator;
    String calc_string = "";
    //Creating references of the XML Views into my activity == Java Objects
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonbuy, buttonclear,btnmanager;
    TextView listprodname,total, Prod_Quantity;

    private ListView activity_productlist;
    private ProductListAdapter prodAdapter;

    Double ChosenPrice;
    int ChosenQty;
    String ChosenItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =  findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 =  findViewById(R.id.button3);
        button4 =  findViewById(R.id.button4);
        button5 =  findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 =  findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 =  findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonbuy =  findViewById(R.id.buttonbuy);
        buttonclear =  findViewById(R.id.buttonclear);
        btnmanager =findViewById(R.id.btnmanager);

        listprodname =(TextView) findViewById(R.id.listprodname);
        total =(TextView)findViewById(R.id.total);
        Prod_Quantity = (TextView)findViewById(R.id.Prod_Quantity);

               //Define the List view and get the data from the table using the List Adapter
        activity_productlist = (ListView) findViewById(R.id.activity_productlist);
        Log.d(TAG,"onCreate:Started.");

        String[] listofItems;
        calculator = new Calculation();
        listofItems = new String[]{"Pants","Shirts","Shoes","Hats"};
        //AarrayList<String> arraylist = new ArrayList<>();
        ArrayList<ProductModel> product = new ArrayList<>();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonbuy.setOnClickListener(this);
        buttonclear.setOnClickListener(this);
        btnmanager.setOnClickListener(this);

        listprodname.setOnClickListener(this);
        total.setOnClickListener(this);
        Prod_Quantity.setOnClickListener(this);

       //prodAdapter = new ProductListAdapter(this,product);
        prodAdapter = new ProductListAdapter(getApplicationContext(),storemgr.arrproductlist);
        activity_productlist.setAdapter(prodAdapter);
        activity_productlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(MainActivity.this, "You clicked " + listofItems[position], Toast.LENGTH_SHORT).show();
      ChosenItem = storemgr.arrproductlist.get(position).ProdName;
      ChosenPrice = storemgr.arrproductlist.get(position).ProdPrice;
      ChosenQty =  storemgr.arrproductlist.get(position).ProdQty;
      listprodname.setText(ChosenItem);

 }

 });

   }
    @Override
    public void onClick(View view) {
      if(view.getId()==R.id.buttonclear){
      Log.d("Calculate","Clicked the clear button");
        calculator.clear();
        Prod_Quantity.setText("");
        total.setText("");
        listprodname.setText("");
        calc_string ="";

      }
      else if(view.getId()==R.id.buttonbuy) {

          Log.d("Buy Button Clicked", "Product purchased");
          // Create the object of
          // AlertDialog Builder class
          AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
          // Set the message show for the Alert time
          builder.setTitle("Thank you for Shopping!");
          builder.setMessage("Your purchase is "+ ChosenItem + "of quantity "+ChosenQty+"at price"+ChosenPrice);
          // Set Alert Title
          builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                  //set what would happen when positive button is clicked
                  finish();
              }
          });
          //replaceall to trim the white spaces
          String topurchase = Prod_Quantity.getText().toString().replaceAll("\\s+", "");

          if (topurchase.isEmpty()) {
              Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
          } else {
              int Qty = Integer.parseInt(topurchase);
              if (Qty > ChosenQty) {
                  Toast.makeText(getApplicationContext(), "Out Of Stock", Toast.LENGTH_SHORT).show();
              } else {
              Double result = calculator.TotalAmount(Qty, ChosenPrice);
                 total.setText(result.toString());
                  Log.d("Assignment2-Nov11-Dhivya","Value of result"+ChosenQty);
                  int newQuantity = ChosenQty - Qty;
                  int position = 0;
                  storemgr.arrproductlist.get(position).setProdQty(newQuantity);
                  prodAdapter.notifyDataSetChanged();
                  //Display the alert dialog box
                  builder.show();

              }
          }
      }
      else if (view.getId()==R.id.btnmanager){
          Intent managerintent = new Intent(getApplicationContext(),ManagerActivity.class);
          startActivity(managerintent);
          Toast.makeText(getApplicationContext(),"Moved to Manager View Screen", Toast.LENGTH_LONG).show();
          managerintent.putExtra("Display Manager View","Moved to screen2");
          startActivity(managerintent);
      }
        else
     {
            String calc = ((Button) view).getText().toString();
            calc_string = calc_string + " " + calc;
            Prod_Quantity.setText(calc_string);
            calculator.push(calc);
         Log.d("Calculation", "The digit pressed");
        }
//
      }
    }
