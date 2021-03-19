package com.applaudostudios.womenintech.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Women(

    @field:SerializedName("id")
    @PrimaryKey
    val womanId: Int,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("title")
    val title: String?,

    @field:SerializedName("birth")
    val birthDate: String?,

    @field:SerializedName("death")
    val deathDate: String?,

    @field:SerializedName("country")
    val country: String?,

    @field:SerializedName("contribution")
    val contribution: String?,

    @field:SerializedName("quote")
    val quote: String?,

    @field:SerializedName("bio")
    val biography: String?,

    @field:SerializedName("url")
    val url: String?
)
