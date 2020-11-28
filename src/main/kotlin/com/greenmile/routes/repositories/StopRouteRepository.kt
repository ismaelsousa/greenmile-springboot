package com.greenmile.routes.repositories

import com.greenmile.routes.models.StopRoute
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StopRouteRepository:JpaRepository<StopRoute,Int> {

}