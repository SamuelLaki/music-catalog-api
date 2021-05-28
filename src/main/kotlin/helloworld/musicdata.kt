package helloworld

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class Accounts(
    @field:Id
    val user_id: Int,
    val username: String,
    val password: String,
    val email: String,
    val created_on: String,
    val last_login: String
)

@MappedEntity
data class Albums(
    @field:Id
    val id: Int,
    val artist: String,
    val name: String
)

@MappedEntity("artists_v2")
data class Artists(
    @field:Id
    val id: Int,
    val name: String,
    val hits: String
)

@MappedEntity("songs_v2")
data class Songs(
    @field:Id
    val id: Int,
    val artist: String,
    val song: String,
    val album: String,
    val release_year: Int
)



