package com.back.domain.post.post.service

import com.back.domain.post.post.entity.Post
import com.back.domain.post.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun findAll() = postRepository.findAll()

    fun write(title: String, content: String): Post {
        val post = Post(
            title = title,
            content = content
        )
        return postRepository.save(post)
    }

    fun count() = postRepository.count()
}