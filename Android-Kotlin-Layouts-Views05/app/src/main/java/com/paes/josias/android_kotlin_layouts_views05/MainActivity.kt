package com.paes.josias.android_kotlin_layouts_views05

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: ArrayAdapter<CharSequence> =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.array,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBlock.adapter = adapter;

        spBlock.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity,
                        R.string.str05, Toast.LENGTH_LONG).show();
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,
                        R.string.str06, Toast.LENGTH_LONG).show();
            }
        }
    }

    fun changeText(v:View){
        if(spBlock.selectedItem.toString().equals("Block text exchange")){
            Toast.makeText(this, R.string.str07, Toast.LENGTH_LONG).show();
        }else{
            tvText.setText(etText.text.toString());
            etText.setText("");
        }
    }

    fun clearText(v:View){
        tvText.setText("");
        etText.setText("");
    }
}



