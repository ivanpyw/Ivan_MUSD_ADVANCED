package com.example.ivanp.a171058l_musd_assignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_rating_system.*

class RatingSystem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movieedit)
        val movie = applicationContext as MovieGetSet
        val movieDetails = movie.getMovie().last()
        Movie_name.text = movieDetails.movieTitle
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movieratingmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val movie = applicationContext as MovieGetSet
        val movieDetails = movie.getMovie().last()
        movieDetails.rateStars = RatingBar.rating
        movieDetails.review = ratingreview.text.toString()
        val intent = Intent(applicationContext,ViewMovieDetails::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}