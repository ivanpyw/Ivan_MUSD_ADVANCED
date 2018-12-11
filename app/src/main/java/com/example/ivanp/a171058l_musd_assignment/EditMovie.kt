package com.example.ivanp.a171058l_musd_assignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class EditMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbSuitable.setOnClickListener(View.OnClickListener {

            if (cbSuitable.isChecked == true)
            {
                NotSuitable.visibility = View.VISIBLE
            } else {
                NotSuitable.visibility = View.INVISIBLE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movieeditmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.SaveBtn){
            Toast.makeText(this, "fuck", Toast.LENGTH_LONG).show()
        }

        if(item?.itemId == R.id.CancelButton){
            Toast.makeText(this, "Me", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}