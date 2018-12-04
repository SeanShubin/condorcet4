package com.seanshubin.condorcet.model.data

data class Condorcet(val voters:List<Voter>,
                     val elections:List<Election>,
                     val groups:List<String>)
