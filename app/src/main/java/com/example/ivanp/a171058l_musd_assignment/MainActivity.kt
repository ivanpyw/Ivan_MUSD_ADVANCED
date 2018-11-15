package com.example.ivanp.a171058l_musd_assignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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

    fun BtnValidateOrSuccess(v: View) {
        var MovieN: String = MovieName.text.toString()
        var MovieD: String = Description.text.toString()
        var MovieReleaseDate: String = ReleaseDate.text.toString()
        var MovieSuitable :String = ""
        var SuitableReason :String= "Reason:\n"
        var LanguageGroup :String= ""



        if(cbSuitable.isChecked) {
            MovieSuitable += "False"
            if(cbViolence.isChecked and cbLanguage.isChecked) {
                SuitableReason+= "Violence\nLanguage Used"
            }else if (cbViolence.isChecked) {
                SuitableReason += "Violence\n"
            }else if (cbLanguage.isChecked){
                SuitableReason += "Language Used\n"
            }
        } else {
            MovieSuitable += "True"
        }

        if(LangChinese.isChecked){
            LanguageGroup += "Chinese"
        }
        else if(LangEnglish.isChecked){
            LanguageGroup += "English"
        }
        else if(LangMalay.isChecked){
            LanguageGroup += "Malay"
        }
        else if(LangTamil.isChecked){
            LanguageGroup += "Tamil"
        }


        if (MovieN.isEmpty() or MovieD.isEmpty() or MovieReleaseDate.isEmpty()) {
            if (MovieN.isEmpty()) {
                MovieName.setError("Field Empty")
            }

            if (MovieD.isEmpty()) {
                Description.setError("Field Empty")
            }

            if (MovieReleaseDate.isEmpty()) {
                ReleaseDate.setError("Field Empty")
            }

        } else {
            Toast.makeText(this, "Title = " + MovieN + "\n" + "Overview = " + MovieD + "\n" + "Release date = " + MovieReleaseDate + "\n" + "Language = " + LanguageGroup + "\n" + "Suitable for all ages = " + MovieSuitable + "\n" + SuitableReason , Toast.LENGTH_LONG).show()
        }






    }



}