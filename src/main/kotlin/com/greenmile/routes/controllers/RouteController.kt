package com.greenmile.routes.controllers

import com.greenmile.routes.models.Route
import com.greenmile.routes.repositories.RouteRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/routes")
class RouteController (
        private val routeRepository: RouteRepository
) {
    @PostMapping
    fun new(@RequestBody newRoute: Route): ResponseEntity<Route> {
        routeRepository.save(newRoute)
        return ResponseEntity.ok().body(newRoute)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Int): ResponseEntity<Optional<Route>> {
        val route = routeRepository.findById(id)
        return if(route.isPresent){
            ResponseEntity.ok().body(route)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun getAll(): ResponseEntity<MutableList<Route>> {
        return ResponseEntity.ok().body(routeRepository.findAll())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteOne(@PathVariable id:Int){
        routeRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id:Int, @RequestBody updatedRoute:Route): ResponseEntity<Route>? {
       return routeRepository.findById(id).map {
            route ->
            val newRoute =  updatedRoute.copy(id=route.id, stopRoute = route.stopRoute)
            routeRepository.save(newRoute)
            ResponseEntity.ok().body(newRoute)
        }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }
}