package com.greenmile.routes.repositories
import com.greenmile.routes.models.Route
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RouteRepository:JpaRepository<Route, Int> {

}