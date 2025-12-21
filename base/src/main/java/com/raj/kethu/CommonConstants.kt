package com.raj.kethu

import com.raj.kethu.base.R
import com.raj.kethu.models.SocialMediaData


/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
const val BUNDLE_DATA = "bundle_data"
fun getSocialMediaInfo() = listOf(
    SocialMediaData(R.drawable.fb, "https://www.facebook.com/"),
    SocialMediaData(R.drawable.insta, "https://www.instagram.com/"),
    SocialMediaData(R.drawable.x, "https://x.com/"),
    SocialMediaData(R.drawable.lin, "https://www.linkedin.com/")
)

const val ZERO = 0
const val DEFAULT_EMPTY_STRING = ""