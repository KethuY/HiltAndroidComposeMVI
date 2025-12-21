package com.kethu.raj

import com.raj.kethu.BaseViewModel
import com.raj.kethu.datastore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Yerramma Kethu
 * @Date: 20/12/2025
 */
@HiltViewModel
class AuthViewModel @Inject constructor(val dateStoreRepository: DataStoreRepository) : BaseViewModel() {
}