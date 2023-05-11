package com.wayahead.arrivechat;

import java.util.Optional;

public record AddMessageRequest (
        String sessionId,
        String msgBy,
        String text,
        String language,
        String time
) {}
