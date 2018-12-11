package com.example.ivanp.a171058l_musd_assignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movielist.*

class ListMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movielist)

        registerForContextMenu(MovieListing)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.MovieListing){
            menu?.add(1, 1003, 3, "Add")
        }

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1003) {
            var myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
        return super.onContextItemSelected(item)

    }
}