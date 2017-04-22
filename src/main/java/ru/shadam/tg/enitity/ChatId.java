package ru.shadam.tg.enitity;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author sala
 */
public abstract class ChatId<T> {
    @JsonValue
    public abstract T getId();

    public static ChatId longId(long id) {
        return new LongId(id);
    }

    public static ChatId stringId(String id) {
        return new StringId(id);
    }

    private static class LongId extends ChatId<Long> {
        private final long id;

        public LongId(long id) {
            this.id = id;
        }

        @Override
        public Long getId() {
            return id;
        }
    }

    private static class StringId extends ChatId<String> {
        private final String id;

        public StringId(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }
    }


}
