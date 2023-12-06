package com.example.tugas5_1402021023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import coil.load
import com.example.tugas5_1402021023.databinding.ActivityDetailMovieBinding
import com.example.tugas5_1402021023.databinding.ActivityMainBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imgUrl = intent.getStringExtra("imgUrl").toString()

        var position : Int = 0
        when(imgUrl) {
            "https://image.tmdb.org/t/p/w342/kjFDIlUCJkcpFxYKtE6OsGcAfQQ.jpg" -> position = 0
            "https://image.tmdb.org/t/p/w342/aGBuiirBIQ7o64FmJxO53eYDuro.jpg" -> position = 1
            "https://image.tmdb.org/t/p/w342/pTxw4GFE3ZfzJfvuUsPyD5njAuI.jpg" -> position = 2
            "https://image.tmdb.org/t/p/w342/spCAxD99U1A6jsiePFoqdEcY0dG.jpg" -> position = 3
            "https://image.tmdb.org/t/p/w342/7ze7YNmUaX81ufctGqt0AgHxRtL.jpg" -> position = 4
            "https://image.tmdb.org/t/p/w342/gb6rq2nD0jRrN0dCzigg2MxXNsB.jpg" -> position = 5
            "https://image.tmdb.org/t/p/w342/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg" -> position = 6
            "https://image.tmdb.org/t/p/w342/rFljUdOozFEv6HDHIFpFvcYW0ec.jpg" -> position = 7
        }

        val linkFilm = listOf(
            "xWN2iVRlqek", "eNH2bRZ6gJw", "RbJ3xS47UHY", "ZkmxSwX1cWs", "idc0EOmKr30",
            "fN5j1MtGO2Q", "_uX6of3vBu0", "_415zVD7R6E"
        )

        val judul = listOf(
            "BLADE OF THE 47 RONIN", "JEEPERS CREEPERS REBORN", "MEXZOMBIES", "FALL", "HOCUS FOCUS 2",
            "TERRIFIER", "ORPHAN FIRST KILL", "PROJECT GEMINI"
        )

        val genre = listOf(
            "Genre: Action, Fantasy", "Genre: Horror", "Genre: Action", "Genre Thriller", "Genre: Horror Komedi",
            "Genre: Horror", "Genre: Horor Thriller", "Genre: Action"
        )

        val durasi = listOf(
            "Durasi: 1 Jam 48 Menit", "Durasi: 1 Jam 28 Menit", "Durasi 1 Jam 28 Menit", "Durasi 1 Jam 45 Menit",
            "Durasi: 1 Jam 43 Menit", "Durasi: 1 Jam 26 Menit", "Durasi 1 Jam 39 Menit", "Durasi: 1 Jam 38 Menit"
        )

        val sutradara = listOf(
            "Sutradara: Ron Yuan", "Timo Vuorensola", "Chava Cartas", "Scott Mann", "Anne Fletcher",
            "Sutradara: Damien Leone", "Sutradara William Brent Bell", "Serik Beiseuov"
        )

        val rentangUsia = listOf(
            "Rating usia: D 17+",  "Rating usia: R 13+",  "Rating usia: D 21+",  "Rating usia: D 17+",
            "Rating usia: D 20+",  "Rating usia: D 22+",  "Rating usia: D 18+",  "Rating usia: R 13+"
        )

        val description = listOf(
            "Secara garis besar, film Blade of the 47 Ronin menceritakan tentang pertarungan pendekar yang mengambil latar masa modern. Film Blade of the 47 Ronin yang bergenre laga dan fantasi ini memiliki rating 4,7 dari total 10 bintang di IMDb",
            "Film ini mengangkat alur cerita tentang mitos The Creeper, yang ternyata bukan hanya sekedar cerita di masyarakat belaka. Sinopsis film Jeepers Creepers: Reborn ini mengisahkan tentang seorang perempuan bernama Laine yang mendapatkan penglihatan mengerikan dan berhubungan dengan masa lalu tempa tinggalnya.",
            "Film ini dengan cekatan menjalin masalah remaja yang khas ke dalam aksi pembunuhan zombie. MexZombies menyanyikan lagu remaja frustrasi orang tua tidak mengerti sambil menyulap tema cinta tak berbalas dan perbedaan kelas.",
            "Sinopsis Fall, Bertahan Hidup kala Terjebak di Puncak Menara TV. Fall merupakan film terbaru yang mengisahkan upaya bertahan hidup sepasang sahabat penggemar kegiatan adrenalin kala mereka terjebak di puncak sebuah menara di ketinggian ratusan meter di atas tanah.",
            "Menceritakan tentang Becca, Cassie, dan Izzy, tiga siswi SMA yang secara tidak sengaja membawa penyihir Sanderson Bersaudari kembali ke Salem di era modern.",
            "Film ini menceritakan Art the Clown yang kembali beraksi untuk melakukan pembunuhan biadab yang mengerikan. Art the Clown muncul sebagai badut dengan muka yang aneh lengkap dengan riasan badut hitam putih.",
            "Film Orphan: First Kill mengisahkan tentang seorang anak bernama Leena Klammer. Leena memiliki kondisi kesehatan yang membuatnya harus dirawat di fasilitas psikiatri Estonia.",
            "Film Project Gemini mengisahkan tentang krisis ekologi yang bertahun-tahun sehingga memicu terjadinya penyebaran virus yang akan meracuni sumber daya alam. "
        )

        binding.txtTitle.setText(judul[position])
        binding.txtGenre.setText(genre[position])
        binding.txtDurasi.setText(durasi[position])
        binding.txtSutradara.setText(sutradara[position])
        binding.txtRatingUsia.setText(rentangUsia[position])
        binding.txtDescription.setText(description[position])
        binding.imgMoviePoster.load(imgUrl)


        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoIdBaru = linkFilm[position]
                youTubePlayer.cueVideo(videoIdBaru, 0f)
            }
          })
      }
}
