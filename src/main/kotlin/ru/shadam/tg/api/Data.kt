package ru.shadam.tg.api

/**
 * @author sala
 */
data class Response<T> (val ok: Boolean, val result: T?, val description: String?, val error_code: Int?)
