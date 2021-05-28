package helloworld
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.*
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.*
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


@JdbcRepository(dialect = Dialect.POSTGRES)
interface MusicRepository : CrudRepository<Accounts, Int> {
    @Executable
    fun find(username: String): Accounts
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface AlbumRepository : CrudRepository<Albums, Long> {
    @Executable
    fun find(artist: String): Albums
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface ArtistRepository : CrudRepository<Artists, Long> {
    @Executable
    fun find(name: String): Artists
}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface SongRepository : CrudRepository<Songs, Long> {
//    @Executable
//    fun find(song: String): Songs
    @Executable
    fun find(release_year: Int): List<Songs>

}