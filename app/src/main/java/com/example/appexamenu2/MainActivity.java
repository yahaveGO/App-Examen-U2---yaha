package com.example.appexamenu2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    public int variable = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

    }

    //Intercambiar
    public void intercambiar(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        FragmentB fragmentB= (FragmentB) manager.findFragmentByTag("B");

        if (variable == 0) {
            FragmentA fb = new FragmentA();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contenedorB, fb, "A");
            transaction.commit();

            FragmentB fb2 = new FragmentB();
            FragmentTransaction transaction2 = manager.beginTransaction();
            transaction2.replace(R.id.contenedorA, fb2, "B");
            transaction2.commit();
            variable = 1;
        }
        else{
            FragmentB fb2 = new FragmentB();
            FragmentTransaction transaction2 = manager.beginTransaction();
            transaction2.replace(R.id.contenedorB, fb2, "B");
            transaction2.commit();

            FragmentA fb = new FragmentA();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contenedorA, fb, "A");
            transaction.commit();
            variable = 0;
        }
    }





    //Visualizar A
    /*
    public void addA(View view){
        FragmentA fragmentA= (FragmentA) manager.findFragmentByTag("A");
        if(fragmentA==null){
            fragmentA=new FragmentA();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.contenedorA,fragmentA,"A");
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento A ya existe ",Toast.LENGTH_LONG).show();
        }
    }
    //Visualizar B
    public void addB(View view){
        FragmentB fragmentB= (FragmentB) manager.findFragmentByTag("B");
        if(fragmentB==null){
            fragmentB=new FragmentB();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.contenedorB,fragmentB,"B");
            transaction.commit();
        }else{
            Toast.makeText(getApplicationContext(),"El fragmento B ya existe ",Toast.LENGTH_LONG).show();
        }
    }
    */

}