package com.bookstore.jpa.dtos;

import java.util.UUID;
import java.util.Set;

public record BookRecordDto(String title,
                            UUID publisherId,
                            Set<UUID> authorsId,
                            String reviewComment) {
    
}
