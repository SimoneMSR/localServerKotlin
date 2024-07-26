package com.example.sodexolocalwebserver

import io.ktor.server.application.call
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import io.ktor.server.request.receiveParameters
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

class ServerHelper {


    var server : NettyApplicationEngine

    constructor(){
        this.server = embeddedServer(Netty, 8080) {
            routing {
                get("/") {
                    call.respondText("Hello, World!")
                }
                post("/submit") {
                    val text = call.receiveText()
                    call.respondText("You submitted: $text")
                }
                get("/echo"){
                    val text = call.parameters.toString()
                    call.respondText ("You submitted: $text")
                }
            }
        }
    }
}