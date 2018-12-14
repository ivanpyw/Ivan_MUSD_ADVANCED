package com.example.ivanp.a171058l_musd_assignment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.movielist.*

class ListMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movielist)
        registerForContextMenu(MovieListing)
        val movie = applicationContext as MovieGetSet
        if(movie.getMovie().isNotEmpty()) {
            val adapter = movieAdapter(applicationContext, movie.getMovie())
            MovieListing.adapter = adapter
        }


    }
    class movieAdapter( private val context: Context,
                        private val dataSource: ArrayList<movieItem>) : BaseAdapter() {

        private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val row = inflater.inflate(R.layout.listmovielayout, parent, false)
            val movieitem = getItem(position) as movieItem
            val moviename = row.findViewById<TextView>(R.id.titleName)
            val thumbnail = row.findViewById<ImageView>(R.id.thumbnail)
            moviename.text = movieitem.movieTitle
            thumbnail.setImageResource(R.drawable.circlepicture)

            return row
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addingmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intention = Intent(applicationContext,MainActivity::class.java )
        startActivity(intention)
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v:
    View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.MovieListing) {
            menu?.add(1, 1001, 1, "Edit")
        }

    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if(item.itemId == 1001)
        {
            val intent = Intent(this@ListMovie, EditMovie::class.java)
            intent.putExtra("position",info.id.toInt())
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }


}
