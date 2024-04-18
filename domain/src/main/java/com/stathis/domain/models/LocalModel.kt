package com.stathis.domain.models

interface LocalModel {
    fun equalsContent(obj: LocalModel): Boolean
}