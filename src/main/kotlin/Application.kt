package io.github.sam_schu

import io.ktor.server.application.*
import org.ktorm.database.Database

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.mainModule() {
    val db: Database = Database.connect(
        driver = environment.config.property("db.driver").getString(),
        url = environment.config.property("db.url").getString(),
        user = environment.config.property("db.user").getString(),
        password = environment.config.property("db.password").getString()
    )

    configureRouting()
}
