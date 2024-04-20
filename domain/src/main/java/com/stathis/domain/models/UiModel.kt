package com.stathis.domain.models

interface UiModel {
    fun equalsContent(obj: UiModel): Boolean
}