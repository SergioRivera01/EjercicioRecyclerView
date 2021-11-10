package com.sergiorivera.ejerciciorecyclerview

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("results")
    val repositories: List<RepositoryResponse>
)

data class RepositoryResponse(
    val id : String,
    val name : String,
    val owner : OwnerResponse
)

data class OwnerResponse(
    val login : String
)