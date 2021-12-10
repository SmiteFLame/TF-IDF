package com.example.textrecommendation.controller

import com.example.textrecommendation.dto.StringInput
import com.example.textrecommendation.main
import com.example.textrecommendation.service.MainService
import com.example.textrecommendation.wrapper.TextCount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.collections.HashMap

@RestController
@RequestMapping("/api")
class MainController {

    @Autowired
    lateinit var mainService: MainService

    @PostMapping("/tf")
    fun getTf(@RequestBody stringInput: StringInput): ResponseEntity<HashMap<String, Array<Int>>>{
        return ResponseEntity<HashMap<String, Array<Int>>>(mainService.getTf(stringInput.list), HttpStatus.OK)
    }

    @PostMapping("/idf")
    fun getIdf(@RequestBody stringInput: StringInput): ResponseEntity<HashMap<String, Double>>{
        return ResponseEntity<HashMap<String, Double>>(mainService.getIdf(stringInput.list), HttpStatus.OK)
    }

    @PostMapping("/tf-idf")
    fun getTfIdf(@RequestBody stringInput: StringInput): ResponseEntity<HashMap<String, Array<Double>>>{
        return ResponseEntity<HashMap<String, Array<Double>>>(mainService.getTfIdf(stringInput.list), HttpStatus.OK)
    }
}
