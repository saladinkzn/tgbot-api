package ru.shadam.tg.api

data class User(
        val id: Int,
        val first_name: String,
        val last_name: String?,
        val username: String?
)

data class Chat(
        val id: Int,
        val type: String,
        val title: String?,
        val username: String?,
        val first_name: String?,
        val last_name: String?
)



data class Update(
        val update_id: Int,
        val message: Message?,
        val inline_query: InlineQuery?,
        val chosen_inline_result: ChosenInlineResult?
)

