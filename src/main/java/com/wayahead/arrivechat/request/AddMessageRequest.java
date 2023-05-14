package com.wayahead.arrivechat.request;

import java.util.Optional;

public record AddMessageRequest (
        String sessionId,
        String msgBy,
        String text,
        String translatedText,
        String language,
        String time
) {}
