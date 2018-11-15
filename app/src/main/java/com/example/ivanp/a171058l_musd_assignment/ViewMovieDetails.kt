package com.example.ivanp.a171058l_musd_assignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)

        var MovieInformation = MovieRater("Venom", "A black marvel villain", "english", "09-03-1999", "Yes")

        titleinfo.text= MovieInformation.Title
        Desc.text= MovieInformation.Overview
        lang.text= MovieInformation.Language
        ReleasingDate.text = MovieInformation.RDate
        SuitChild.text = MovieInformation.Suitable

    }

    class MovieRater(Title: String, Overview: String, Language: String, RDate: String, Suitable: String){
        var Title : String
        var Overview: String
        var Language: String
        var RDate: String
        var Suitable: String

        init{
            this.Title = Title
            this.Overview = Overview
            this.Language =  Language
            this.RDate =  RDate
            this.Suitable =  Suitable
        }


    }
}
