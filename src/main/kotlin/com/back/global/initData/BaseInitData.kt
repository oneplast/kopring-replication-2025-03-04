package com.back.global.initData

import com.back.domain.post.post.service.PostService
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Configuration
class BaseInitData (
    private val postService: PostService
) {
    @Autowired
    @Lazy
    private lateinit var self: BaseInitData

    @Bean
    fun baseInitDataApplicationRunner(): ApplicationRunner {
        return ApplicationRunner {
            self.work1()
            self.work2()
        }
    }

    @Transactional
    fun work1() {
        if (postService.count() > 0) return

        postService.write("title 1", "content 1")
        postService.write("title 2", "content 2")
    }

    @Transactional
    fun work2() {
        postService.findAll()
            .forEach { println(it.id) }
    }
}