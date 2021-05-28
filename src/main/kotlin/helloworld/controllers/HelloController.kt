package helloworld.controllers
import helloworld.*
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue

@Controller("/hello")
class HelloController(private val musicrepository: MusicRepository, private val albumrepository: AlbumRepository, private val artistrepository: ArtistRepository, private val songrepository: SongRepository) {

    @Get("/Welcome")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {
        return "Hello World"
    }

    @Get("/Query")
    @Produces(MediaType.TEXT_PLAIN)
    fun searchAccount(): String {
        val account = musicrepository.findById(50).orElse(null)
        return account.username
    }

    @Get("/Albums")
    @Produces(MediaType.TEXT_JSON)
    fun searchAlbum(): List<Albums> {
        val albums = albumrepository.findAll()
        return albums.toList()
    }

    @Get("/Artists")
    @Produces(MediaType.TEXT_JSON)
    fun searchArtist(): List<Artists> {
        val artists = artistrepository.findAll()
        return artists.toList()
    }

    @Get("/Songs")
    @Produces(MediaType.TEXT_JSON)
    fun searchSongs(@QueryValue release_year : String?): List<Songs> {
        return if (release_year == null || release_year.toInt()<0) {
            val songs = songrepository.findAll()
            songs.toList()
        } else {
            val songs = songrepository.find(release_year.toInt())
            songs.toList()
        }
    }

}