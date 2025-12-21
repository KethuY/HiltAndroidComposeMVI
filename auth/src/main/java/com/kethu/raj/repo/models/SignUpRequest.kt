package com.kethu.raj.repo.models

/**
 * @Author: Yerramma Kethu
 * @Date: 27/12/2025
 */
data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String,
    val phone: String
)