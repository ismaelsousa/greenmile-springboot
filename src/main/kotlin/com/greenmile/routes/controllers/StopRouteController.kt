package com.greenmile.routes.controllers

import com.greenmile.routes.models.StopRoute
import com.greenmile.routes.models.Route
import com.greenmile.routes.repositories.RouteRepository
import com.greenmile.routes.repositories.StopRouteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stops")
class StopRouteController(
        private val stopRouteRepository:StopRouteRepository,
        private val routeRepository: RouteRepository
) {

    @PostMapping("/{routeId}")
    fun addStop(@PathVariable routeId:Int, @RequestBody stopRoute: StopRoute): ResponseEntity<StopRoute> {
       return if(routeRepository.existsById(routeId)){
            val newStopRoute = stopRoute.copy(route = Route(id = routeId))
            stopRouteRepository.save(newStopRoute)
            ResponseEntity.ok().body(newStopRoute)
        }else{
            ResponseEntity(HttpStatus.PRECONDITION_FAILED)
        }
    }

    @DeleteMapping("/{routeId}/{stopRouteId}")
    fun deleteStop(@PathVariable routeId: Int, @PathVariable stopRouteId: Int) : ResponseEntity<HttpStatus>{
        return if(routeRepository.existsById(routeId)){
             stopRouteRepository.deleteById(stopRouteId)
            ResponseEntity(HttpStatus.OK)
        }else{
           ResponseEntity(HttpStatus.NOT_FOUND)
       }
    }
}