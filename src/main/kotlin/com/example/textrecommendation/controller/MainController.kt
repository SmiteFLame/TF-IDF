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

    @PostMapping
    fun get(@RequestBody stringInput: StringInput): ResponseEntity<HashMap<String, TextCount>>{
        return ResponseEntity<HashMap<String, TextCount>>(mainService.getTf(stringInput.list), HttpStatus.OK)
    }
}
