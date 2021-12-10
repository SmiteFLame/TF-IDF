package com.example.textrecommendation.service

import com.example.textrecommendation.wrapper.TextCount

interface MainService {
    fun getTf(list: List<String>): HashMap<String, TextCount>
}
