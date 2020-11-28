package com.greenmile.routes.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class StopRoute(
        @Id
        @GeneratedValue
        val id:Int? = null,
        val nameClient:String?=null,
        val address:String?=null,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "route_id", nullable = false)
        @JsonBackReference
        val route:Route = Route()
)