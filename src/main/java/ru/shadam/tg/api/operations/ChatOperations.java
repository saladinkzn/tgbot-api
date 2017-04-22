package ru.shadam.tg.api.operations;

import ru.shadam.tg.enitity.Chat;
import ru.shadam.tg.enitity.ChatMember;

import java.util.List;

/**
 * @author sala
 */
public interface ChatOperations {
    Boolean kickChatMember(long chatId, Integer userId);

    Boolean kickChatMember(String chatId, Integer userId);

    Boolean leaveChat(long chatId);

    Boolean leaveChat(String chatId);

    Boolean unbanChatMember(long chatId);

    Boolean unbanChatMember(String chatId);

    Chat getChat(long chatId);

    Chat getChat(String chatId);

    List<ChatMember> getChatAdministrators(long chatId);

    List<ChatMember> getChatAdministrators(String chatId);

    int getChatMembersCount(long chatId);

    int getChatMembersCount(String chatId);

    ChatMember getChatMember(long chatId, int userId);

    ChatMember getChatMember(String chatId, int userId);
}
