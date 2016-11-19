package ru.shadam.tg.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

/**
 * @author sala
 */
interface TelegramApi {
    // --- getUpdates
    @GET("getUpdates")
    fun getUpdates(
            @Query("offset") offset: Int? = null,
            @Query("limit") limit: Int? = null,
            @Query("timeout") timeout: Int? = null
    ) : Call<Response<List<Update>>>

    // --- sendMessage
    @POST("sendMessage")
    @FormUrlEncoded
    fun sendMessage(
            @Field("chat_id") chatId: Int,
            @Field("text") text: String,
            @Field("parse_mode") parseMode: ParseMode? = null,
            @Field("disable_web_page_preview") disableWebPagePreview: Boolean? = null,
            @Field("disable_notification") disableNotification: Boolean? = null,
            @Field("reply_to_message_id") replyToMessageId: Int? = null,
            @Field("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message?>>

    @POST("sendMessage")
    @FormUrlEncoded
    fun sendMessage(
            @Field("chat_id") chatId: String,
            @Field("text") text: String,
            @Field("parse_mode") parseMode: ParseMode? = null,
            @Field("disable_web_page_preview") disableWebPagePreview: Boolean? = null,
            @Field("disable_notification") disableNotification: Boolean? = null,
            @Field("reply_to_message_id") replyToMessageId: Int? = null,
            @Field("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message?>>

    // -- forwardMessage
    @GET("forwardMessage")
    fun forwardMessage(
            @Query("chat_id") chatId: Int,
            @Query("from_chat_id") fromChatId: Int,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("message_id") messageId:Int
    ) : Call<Response<Message?>>

    @GET("forwardMessage")
    fun forwardMessage(
            @Query("chat_id") chatId: String,
            @Query("from_chat_id") fromChatId: Int,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("message_id") messageId:Int
    ) : Call<Response<Message?>>

    @GET("forwardMessage")
    fun forwardMessage(
            @Query("chat_id") chatId: Int,
            @Query("from_chat_id") fromChatId: String,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("message_id") messageId:Int
    ) : Call<Response<Message?>>

    @GET("forwardMessage")
    fun forwardMessage(
            @Query("chat_id") chatId: String,
            @Query("from_chat_id") fromChatId: String,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("message_id") messageId:Int
    ) : Call<Response<Message?>>

    // -- sendPhoto

    @GET("sendPhoto")
    fun sendPhoto(
            @Query("chat_id") chatId: Int,
            @Query("photo") photo: String,
            @Query("caption") caption: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    @Multipart
    @POST("sendPhoto")
    fun sendPhoto(
            @Query("chat_id") chatId: Int,
            @Part photo: MultipartBody.Part,
            @Query("caption") caption: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    // -- sendAudio

    @Multipart
    @POST("sendAudio")
    fun sendAudio(
            @Query("chat_id") chatId: Int,
            @Part audio: MultipartBody.Part,
            @Query("caption") caption: String? = null,
            @Query("duration") duration: Int? = null,
            @Query("performer") performer: String? = null,
            @Query("title") title: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    // -- sendDocument

    @Multipart
    @POST("sendDocument")
    fun sendDocument(
            @Query("chat_id") chatId: Int,
            @Part document: MultipartBody.Part,
            @Query("caption") caption: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    // --- sendSticker

    @Multipart
    @POST("sendSticker")
    fun sendSticker(
            @Query("chat_id") chatId: Int,
            @Part sticker: MultipartBody.Part,
            @Query("caption") caption: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    // -- sendVideo

    @Multipart
    @POST("sendVideo")
    fun sendVideo(
            @Query("chat_id") chatId: Int,
            @Part video: MultipartBody.Part,
            @Query("duration") duration: Int? = null,
            @Query("width") width: Int? = null,
            @Query("height") height: Int? = null,
            @Query("caption") caption: String? = null,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    @POST("sendLocation")
    fun sendLocation(
            @Query("chat_id") chatId : Int,
            @Query("latitude") latitude: Float,
            @Query("longitude") longitude: Float,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>

    @POST("sendVenue")
    fun sendVenue(
            @Query("chat_id") chatId: Int,
            @Query("latitude") latitude: Float,
            @Query("longitude") longitude: Float,
            @Query("title") title: String,
            @Query("address") address: String,
            @Query("foursquare_id") foursquareId: String?,
            @Query("disable_notification") disableNotification: Boolean? = null,
            @Query("reply_to_message_id") replyToMessageId: Int? = null,
            @Query("reply_markup") replyMarkup: String? = null
    ) : Call<Response<Message>>


    @GET("getFile")
    fun getFile(
            @Query("file_id") fileId: String
    ) : Call<Response<File>>


}