package com.greenmile.routes.models

import javax.persistence.*

@Entity
data class Route (
    @Id
    @GeneratedValue
    val id:Int? = null,
    val name:String?=null,
    @OneToMany(mappedBy = "route")
    val stopRoute: List<StopRoute> = emptyList()
)