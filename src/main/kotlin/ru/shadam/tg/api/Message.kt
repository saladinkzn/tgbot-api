package ru.shadam.tg.api

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * @author sala
 */
data class Message(
        val message_id: Int,
        val from: User?,
        val date: Int,
        val chat: Chat,
        val forward_from: User?,
        val forward_date: Int?,
        val reply_to_message: Message?,
        val text: String?,
        val audio: Audio?,
        val document: Document?,
        val photo: List<PhotoSize>?,
        val sticker: Sticker?,
        val video: Video?,
        val voice: Voice?,
        val caption: String?,
        val contact: Contact?,
        val location: Location?,
        val new_chat_participant: User?,
        val left_chat_participant: User?,
        val new_chat_title: String?,
        val new_chat_photo: List<PhotoSize>?,
        val delete_chat_photo: Boolean?,
        val group_chat_created: Boolean?,
        val supergroup_chat_created: Boolean?,
        val channel_chat_created: Boolean?,
        val migrate_to_chat_id: Int?,
        val migrate_from_chat_id: Int?,
        val entities: List<MessageEntity>?
) {
    val dateTime: LocalDateTime
        get() = LocalDateTime.ofEpochSecond(date.toLong(), 0, ZoneOffset.UTC)
}

data class PhotoSize(
        val file_id: String,
        val width: Int,
        val height: Int,
        val file_size: Int?
)

data class Audio(
        val file_id: String,
        val duration: Int,
        val performer: String?,
        val title: String?,
        val mime_type: String?,
        val file_size: Int?
)

data class Document(
        val file_id: String,
        val thumb: PhotoSize?,
        val file_name: String?,
        val mime_type: String?,
        val file_size: Int?
)

data class Sticker(
        val file_id: String,
        val width: Int,
        val height: Int,
        val thumb: PhotoSize?,
        val file_size: Int?
)

data class Video(
        val file_id: String,
        val width: Int,
        val height: Int,
        val duration: Int,
        val thumb: PhotoSize?,
        val mime_type: String?,
        val file_size: Int?
)

data class Voice(
        val file_id: String,
        val duration: Int,
        val mime_type: String?,
        val file_size: Int?
)

data class Contact(
        val phone_number: String,
        val first_name: String,
        val last_name: String?,
        val user_id: Int?
)

data class Location(
        val longitude: Float,
        val latitude: Float
)

data class UserProfilePhotos(
        val total_count: Int,
        val photos: List<List<PhotoSize>>
)

data class File(
        val file_id: String,
        val file_size: Int?,
        val file_path: String?
)

interface KeyboardReply

data class ReplyKeyboardMarkup (
        val keyboard: List<List<String>>,
        val resize_keyboard: Boolean? = false,
        val one_time_keyboard: Boolean? = false,
        val selective: Boolean? = false
) : KeyboardReply

data class ReplyKeyboardHide (
        val hide_keyboard: Boolean,
        val selective: Boolean?
) : KeyboardReply

data class ForceReply (
        val force_reply: Boolean,
        val selective: Boolean?
) : KeyboardReply

enum class ParseMode {
    Markdown, HTML
}

data class MessageEntity(
    val type: MessageEntityType,
    val offset: Int,
    val length: Int,
    val url: String?,
    val user: User?
) {
    fun getEntityText(text: String) = text.substring(offset, offset + length)
}

enum class MessageEntityType {
    @JsonProperty("mention")
    MENTION,
    @JsonProperty("hashtag")
    HASHTAG,
    @JsonProperty("bot_command")
    BOT_COMMAND,
    @JsonProperty("url")
    URL,
    @JsonProperty("email")
    EMAIL,
    @JsonProperty("bold")
    BOLD,
    @JsonProperty("italic")
    ITALIC,
    @JsonProperty("code")
    CODE,
    @JsonProperty("pre")
    PRE,
    @JsonProperty("text_link")
    TEXT_LINK,
    @JsonProperty("text_mention")
    TEXT_MENTION
}



