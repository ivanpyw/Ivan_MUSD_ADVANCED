package com.example.ivanp.a171058l_musd_assignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.ContextMenu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.TextView
import android.view.View
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)

        val rate = findViewById<RatingBar>(R.id.RatingBar)
        rate.visibility = View.GONE


        val movie = applicationContext as MovieGetSet
        var position = intent.getIntExtra("position", 0)
        val movieDetails : movieItem
        if(position > 0 || position == 0)
        {
            movieDetails = movie.getMovie().elementAt(position)
        }
        else
        {
            movieDetails = movie.getMovie().last()
        }

        val moviet = findViewById<TextView>(R.id.titleinfo)
        val overview = findViewById<TextView>(R.id.descript)
        val date = findViewById<TextView>(R.id.releasedate)
        val language = findViewById<TextView>(R.id.lang)
        val age = findViewById<TextView>(R.id.SuitChild)


        moviet.text = movieDetails.movieTitle
        overview.text = movieDetails.movieDesc
        date.text = movieDetails.releaseDate
        language.text = movieDetails.lang
        if(movieDetails.suitable == "No")
        {
            age.text = movieDetails.suitable

            if(movieDetails.langused == "Language Used" && movieDetails.violent =="") {
                age.text = movieDetails.suitable +"(" + movieDetails.langused+ ")"
            }
            else if(movieDetails.violent == "Violence" && movieDetails.langused == "")
            {
                age.text = movieDetails.suitable +"(" + movieDetails.violent+ ")"
            }
            else if (movieDetails.langused == "Language Used" && movieDetails.violent =="Violence" )
            {
                age.text = movieDetails.suitable +"(" + movieDetails.langused+", "+movieDetails.violent+ ")"
            }

        }
        else if(movieDetails.suitable == "Yes")
        {
            age.text = movieDetails.suitable
        }

        if(movieDetails.rateStars>0F)
        {
            RatingBar.layoutParams.height=ActionBar.LayoutParams.WRAP_CONTENT
            RatingBar.rating = movieDetails.rateStars
            RatingBar.visibility = View.VISIBLE
            review.text = movieDetails.review
        }

        registerForContextMenu(review)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id == R.id.review)
        {
            menu?.add(1,1001,1,"Add Review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(applicationContext, RatingSystem::class.java)
        if(item?.itemId== 1001)
        {
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }

}
