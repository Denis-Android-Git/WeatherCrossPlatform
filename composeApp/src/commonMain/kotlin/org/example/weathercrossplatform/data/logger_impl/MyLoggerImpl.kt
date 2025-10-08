package org.example.weathercrossplatform.data.logger_impl

import co.touchlab.kermit.Logger
import org.example.weathercrossplatform.domain.logger.MyLogger

object MyLoggerImpl : MyLogger {
    override fun debug(message: String) {
        Logger.d(message)
    }

    override fun error(message: String, throwable: Throwable?) {
        Logger.e(message, throwable)
    }

    override fun warning(message: String) {
        Logger.w(message)
    }

    override fun info(message: String) {
        Logger.i(message)
    }
}