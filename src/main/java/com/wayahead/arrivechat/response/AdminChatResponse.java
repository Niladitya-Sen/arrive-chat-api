package com.wayahead.arrivechat.response;

import com.wayahead.arrivechat.table.Messages;

import java.util.List;

public record AdminChatResponse (
        String sessionId,
        List<Messages> chats
) {}
