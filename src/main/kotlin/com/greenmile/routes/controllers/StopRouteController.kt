package com.greenmile.routes.controllers

import com.greenmile.routes.repositories.StopRouteRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stops")
class StopRouteController(
        private val stopRouteRepository:StopRouteRepository
) {

}