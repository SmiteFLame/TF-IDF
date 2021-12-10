package com.example.textrecommendation.service

import com.example.textrecommendation.wrapper.TextCount
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.ln

@Service
class MainServiceImpl : MainService {

    override fun getTf(list: List<String>): HashMap<String, Array<Int>> {
        val map = HashMap<String, Array<Int>>()
        for (i in list.indices) {
            val st = StringTokenizer(list[i])
            while (st.hasMoreTokens()) {
                val now = st.nextToken()
                map.putIfAbsent(now, Array(list.size) { 0 })
                map[now]!![i] = map[now]!![i] + 1
            }
        }
        return map
    }

    override fun getIdf(list: List<String>): HashMap<String, Double> {
        val map = HashMap<String, HashSet<Int>>()
        for (i in list.indices) {
            val st = StringTokenizer(list[i])
            while (st.hasMoreTokens()) {
                val now = st.nextToken()
                map.putIfAbsent(now, HashSet())
                map[now]!!.add(i)
            }
        }

        val idf = HashMap<String, Double>()
        map.forEach { (key, value) ->
            idf[key] = ln((list.size).toDouble() / (value.size + 1))
        }

        return idf
    }

    override fun getTfIdf(list: List<String>): HashMap<String, Array<Double>> {
        val tf = getTf(list)
        val idf = getIdf(list)
        val map = HashMap<String, Array<Double>>()
        tf.forEach { (key, value) ->
            val array = Array(list.size) { 0.0 }
            for(i in list.indices){
                array[i] = value[i] * idf[key]!!
            }
            map[key] = array
        }
        return map
    }
}
