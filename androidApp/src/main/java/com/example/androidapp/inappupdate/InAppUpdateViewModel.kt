package com.example.androidapp.inappupdate

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InAppUpdateViewModel : ViewModel() {
    private val _progress = MutableStateFlow(0f)
    val progress = _progress.asStateFlow()

    private val isDownLoading = MutableStateFlow(false)
    val isDownloading = isDownLoading.asStateFlow()

    private val _isConfirmInstall = MutableStateFlow(false)
    val isConfirmInstall = _isConfirmInstall.asStateFlow()

    fun updateConfirmInstall(value: Boolean) {
        _isConfirmInstall.value = value
    }

    fun updateProgress(bytesDownloaded: Long, totalBytes: Long) {
        if (bytesDownloaded > 0) {
            isDownLoading.value = true
            _progress.value = bytesDownloaded.toFloat() / totalBytes.toFloat()
        }
    }

    fun updateIsDownloading(value: Boolean) {
        isDownLoading.value = value
    }
}