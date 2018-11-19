package com.seanshubin.condorcet.model.data

data class Voter(val email:String,
                 val name:String,
                 val password:String,
                 val groups:List<String>)
