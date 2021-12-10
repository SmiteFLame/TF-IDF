package com.example.textrecommendation.service

import com.example.textrecommendation.wrapper.TextCount
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
class MainServiceImpl : MainService{

    override fun getTf(list: List<String>): HashMap<String, TextCount> {
        val map = HashMap<String, TextCount>()
        for(i in list.indices){
            val st = StringTokenizer(list[i])
            while(st.hasMoreTokens()){
                val now = st.nextToken()
                map.putIfAbsent(now, TextCount())
                map[now]!!.count = map[now]!!.count + 1
                map[now]!!.set.add(i)
            }
        }
        return map
    }
}
