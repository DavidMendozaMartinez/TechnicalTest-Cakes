package com.davidmendozamartinez.technicaltest.cakes.data.remote.mapper

import com.davidmendozamartinez.technicaltest.cakes.data.remote.model.CakeRemote
import com.davidmendozamartinez.technicaltest.cakes.domain.model.Cake

object CakeMapper {
    fun CakeRemote.toDomain(): Cake = Cake(title, description, image)
}
