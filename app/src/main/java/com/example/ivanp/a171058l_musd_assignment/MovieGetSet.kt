package com.example.ivanp.a171058l_musd_assignment

import android.app.Application
import java.util.*

class MovieGetSet : Application(){
    var name:String=""
    var desc:String=""
    var lang:String=""
    var date:String=""
    var suitable:Boolean=true
    var violence:Boolean=false
    var strongLang:Boolean=false
    var ratings:String?=null
    var star:Float= 0.0f

    fun getMovieName():String{
        return name
    }

    fun setMovieName(MovieName:String){
        this.name = MovieName
    }

    fun getMovieDesc():String{
        return desc
    }

    fun setMovieDesc(MovieDesc:String){
        this.desc = MovieDesc
    }

    fun getMovieLang():String{
        return lang
    }

    fun setMovieLang(MovieLanguage:String){
        this.lang = MovieLanguage
    }

    fun getMovieDate():String{
        return date
    }

    fun setMovieDate(MovieDate:String){
        this.date = MovieDate

    }

    fun getMovieSuitable():Boolean{
        return suitable
    }

    fun setMovieSuitable(MovieSuitable:Boolean){

        this.suitable = MovieSuitable
    }

    fun getMovieViolence():Boolean{
        return violence
    }

    fun setMovieViolence(MovieViolence:Boolean){
        this.violence = MovieViolence
    }

    fun getMovieStrongLang():Boolean{
        return strongLang
    }

    fun setMovieStrongLang(sLang:Boolean){
        this.strongLang = sLang
    }

    fun getMovieRatings():String?{
        return ratings
    }

    fun setMovieRatings(MovieRatings:String?){
        this.ratings = MovieRatings
    }

    fun getMovieStar():Float{
        return star
    }

    fun setMovieStar(MovieRateStar:Float){
        this.star = MovieRateStar
    }
}