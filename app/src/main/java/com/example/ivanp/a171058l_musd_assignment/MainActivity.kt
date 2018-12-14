package com.example.ivanp.a171058l_musd_assignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var checkViolence = ""
    var checkLanguage = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val checkboxViolence = findViewById<CheckBox>(R.id.cbViolence)
        checkboxViolence.visibility = View.GONE
        val checkboxLanguage = findViewById<CheckBox>(R.id.cbLanguage)
        checkboxLanguage.visibility = View.GONE
        val checkboxSuitable = findViewById<CheckBox>(R.id.cbSuitable)
        checkboxSuitable.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkboxViolence.visibility = View.VISIBLE
                checkboxLanguage.visibility = View.VISIBLE
            }
            else {
                checkboxViolence.visibility = View.GONE
                checkboxViolence.isChecked = false
                checkboxLanguage.visibility = View.GONE
                checkboxLanguage.isChecked = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
        menuInflater.inflate(R.menu.movieaddmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.Addbtn )
        {
            val name = findViewById<EditText>(R.id.MovieName)
            var desc = findViewById<EditText>(R.id.Description)
            var date = findViewById<EditText>(R.id.ReleaseDate)
            val checkboxViolence = findViewById<CheckBox>(R.id.cbViolence)
            checkboxViolence.visibility = View.GONE
            val checkboxLanguage = findViewById<CheckBox>(R.id.cbLanguage)
            checkboxLanguage.visibility = View.GONE
            val checkboxSuitable = findViewById<CheckBox>(R.id.cbSuitable)
            if(name.text.isNullOrEmpty())
            {
                name.setError("Field Empty!Enter a valid movie name!")
            }
            if(desc.text.isNullOrEmpty())
            {
                desc.setError("Field Empty! Enter a Description!")
            }
            if(date.text.isNullOrEmpty())
            {
                date.setError("Field Empty! Enter a Date!")
            }
            var RadioGroup = findViewById<RadioGroup>(R.id.RGLanguage)
            var Radioid:Int = RadioGroup.checkedRadioButtonId
            if(Radioid != -1) {
                val Radio1: RadioButton = findViewById(Radioid)
                if(checkboxSuitable.isChecked) {
                    if(checkboxViolence.isChecked && checkboxLanguage.isChecked == false) {
                        checkViolence ="Violence"
                        checkLanguage = ""
                    }
                    else if(checkboxLanguage.isChecked && checkboxLanguage.isChecked == false) {
                        checkLanguage= "Language Used"
                        checkViolence = ""
                    }
                    else if (checkboxViolence.isChecked && checkboxLanguage.isChecked)
                    {
                        checkViolence ="Violence"
                        checkLanguage= "Language Used"
                    }
                    val movie = applicationContext as MovieGetSet
                    val intent = Intent(applicationContext, ViewMovieDetails::class.java)
                    val movieDeets = movieItem(name.text.toString(),
                        desc.text.toString(),
                        Radio1.text.toString(),
                        date.text.toString(),
                        "No",
                        checkLanguage,
                        checkViolence)

                    movie.addMovie(movieDeets)
                    startActivity(intent)
                }

                else if(checkboxSuitable.isChecked == false)
                {
                    val movie = applicationContext as MovieGetSet
                    val intent = Intent(applicationContext, ViewMovieDetails::class.java)
                    val movieDeets = movieItem(name.text.toString(),
                        desc.text.toString(),
                        Radio1.text.toString(),
                        date.text.toString(),
                        "Yes",
                        checkLanguage,
                        checkViolence)
                    movie.addMovie(movieDeets)
                    startActivity(intent)
                }
            }

        }
        else if(item?.itemId == R.id.ClearAddEntry)
        {
            val name = findViewById<EditText>(R.id.MovieName)
            var desc = findViewById<EditText>(R.id.Description)
            var date = findViewById<EditText>(R.id.ReleaseDate)
            val checkboxViolence = findViewById<CheckBox>(R.id.cbViolence)
            val checkboxLanguage = findViewById<CheckBox>(R.id.cbLanguage)
            val checkboxSuitable = findViewById<CheckBox>(R.id.cbSuitable)
            var engbutton = findViewById<RadioButton>(R.id.LangEnglish)
            name.text.clear()
            desc.text.clear()
            date.text.clear()
            checkboxViolence.isChecked = false
            checkboxLanguage.isChecked = false
            checkboxSuitable.isChecked = false
            engbutton.isChecked = true
        }
        return super.onOptionsItemSelected(item)
    }
}
