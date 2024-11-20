package apc.appcradle.roomtraining

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import apc.appcradle.roomtraining.tables.AppDatabase
import apc.appcradle.roomtraining.tables.MovieEntity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = Room.databaseBuilder(this, AppDatabase::class.java, "database.db").build()

        // добавляем новый фильм в базу данных
        database.getMovieDao().insertNewMovie(
            MovieEntity(
                1,
                "Звездные войны",
                "В далекой -далекой галактике...",
                null
            )
        )

        // получаем список фильмов из базы данных
        val movies = database.getMovieDao().getMovies()
    }
}