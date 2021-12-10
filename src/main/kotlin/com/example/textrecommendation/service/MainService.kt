package com.example.textrecommendation.service

import com.example.textrecommendation.wrapper.TextCount

interface MainService {
    fun getTf(list: List<String>): HashMap<String, Array<Int>>
    fun getIdf(list: List<String>): HashMap<String, Double>
    fun getTfIdf(list: List<String>): HashMap<String, Array<Double>>
}
