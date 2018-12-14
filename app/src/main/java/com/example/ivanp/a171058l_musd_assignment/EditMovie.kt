package com.example.ivanp.a171058l_musd_assignment

import android.content.Intent
import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.movieedit.*

class EditMovie : AppCompatActivity() {

    var checkViolence = ""
    var checkLanguage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movieedit)
        val movie = applicationContext as MovieGetSet
        val position = intent.getIntExtra("position",0)
        val movieDetails = movie.getMovie().elementAt(position.toInt())
        val name = findViewById<EditText>(R.id.MovieNameEdit)
        var desc = findViewById<EditText>(R.id.DescriptionEdit)
        var date = findViewById<EditText>(R.id.ReleaseDateEdit)
        name.setText(movieDetails.movieTitle)
        desc.setText(movieDetails.movieDesc)
        date.setText(movieDetails.releaseDate)
        if(movieDetails.lang=="English")
        {
            LangEnglishEdit.isChecked == true
        }
        else if(movieDetails.lang=="Chinese")
        {
            LangChineseEdit.isChecked == true
        }
        else if(movieDetails.lang=="Malay")
        {
            LangMalayEdit.isChecked == true
        }
        else if(movieDetails.lang=="Tamil")
        {
            LangTamilEdit.isChecked == true
        }
        val checkboxViolence = findViewById<CheckBox>(R.id.cbViolenceEdit)
        checkboxViolence.visibility = View.GONE
        val checkboxLanguage = findViewById<CheckBox>(R.id.cbLanguageEdit)
        checkboxLanguage.visibility = View.GONE
        if(movieDetails.langused== "Language Used")
        {
            checkboxLanguage.visibility = View.VISIBLE
            checkboxLanguage.isChecked
        }
        else if (movieDetails.violent=="Violence")
        {
            checkboxViolence.visibility = View.VISIBLE
            checkboxViolence.isChecked
        }
        else if (movieDetails.langused== "Language Used" && movieDetails.violent=="Violence") {
            checkboxLanguage.visibility = View.VISIBLE
            checkboxViolence.visibility = View.VISIBLE
            checkboxLanguage.isChecked
            checkboxViolence.isChecked
        }
        val check = findViewById<CheckBox>(R.id.cbSuitableEdit)
        check.setOnCheckedChangeListener { buttonView, isChecked ->
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
        menuInflater.inflate(R.menu.movieeditmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.SaveBtn )
        {
            val movie = applicationContext as MovieGetSet
            val position = intent.getIntExtra("position",0)
            val movieDetails = movie.getMovie().elementAt(position.toInt())
            val name = findViewById<EditText>(R.id.MovieNameEdit)
            var desc = findViewById<EditText>(R.id.DescriptionEdit)
            var date = findViewById<EditText>(R.id.ReleaseDateEdit)
            val checkboxViolence = findViewById<CheckBox>(R.id.cbViolenceEdit)
            checkboxViolence.visibility = View.GONE
            val checkboxLanguage = findViewById<CheckBox>(R.id.cbLanguageEdit)
            checkboxLanguage.visibility = View.GONE
            val checkboxSuitable = findViewById<CheckBox>(R.id.cbSuitableEdit)
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
            var radiocheck = findViewById<RadioGroup>(R.id.RGEdit)
            var radioid:Int = radiocheck.checkedRadioButtonId
            if(radioid != -1) {
                val radio1: RadioButton = findViewById(radioid)
                if(checkboxLanguage.isChecked) {
                    if(checkboxViolence.isChecked && checkboxLanguage.isChecked == false) {
                        checkViolence ="Violence"
                        checkLanguage = ""
                    }
                    else if(checkboxLanguage.isChecked && checkboxViolence.isChecked == false) {
                        checkLanguage= "Language Used"
                        checkViolence = ""
                    }
                    else if (checkboxViolence.isChecked && checkboxLanguage.isChecked)
                    {
                        checkViolence ="Violence"
                        checkLanguage= "Language Used"
                    }


                    val intent = Intent(applicationContext, ViewMovieDetails::class.java)
                    intent.putExtra("position", position)
                    movieDetails.movieTitle = MovieNameEdit.text.toString()
                    movieDetails.movieDesc = desc.text.toString()
                    movieDetails.releaseDate = date.text.toString()
                    movieDetails.lang = radio1.text.toString()
                    movieDetails.suitable = "No"
                    movieDetails.langused = checkLanguage
                    movieDetails.violent = checkViolence

                    startActivity(intent)
                }

                else if(checkboxSuitable.isChecked == false)
                {

                    val intent = Intent(applicationContext, ViewMovieDetails::class.java)
                    intent.putExtra("position", position)
                    movieDetails.movieTitle = MovieNameEdit.text.toString()
                    movieDetails.movieDesc = desc.text.toString()
                    movieDetails.releaseDate = date.text.toString()
                    movieDetails.lang = radio1.text.toString()
                    movieDetails.suitable = "Yes"
                    movieDetails.langused = checkLanguage
                    movieDetails.violent = checkViolence


                    startActivity(intent)
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
