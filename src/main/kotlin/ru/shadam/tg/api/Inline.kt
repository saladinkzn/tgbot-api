package ru.shadam.tg.api

/**
 * @author sala
 */
data class InlineQuery (
        val id: String,
        val from: User,
        val query: String,
        val offset: String
)

data class ChosenInlineResult (
        val result_id: String,
        val from: User,
        val query: String
)