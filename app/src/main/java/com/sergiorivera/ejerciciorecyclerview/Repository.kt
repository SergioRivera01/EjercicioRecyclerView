package com.sergiorivera.ejerciciorecyclerview

data class repository(
    val id : String,
    val name : String,
    val owner : String,
    val image : String? = null
)

fun RepositoryResponse.toRepository():repository{
    return repository(
    this.id,
    this.name,
    this.owner.login)
}

fun List<RepositoryResponse>.toRespository(): List<repository>{
    return this.map { it.toRepository() }
}