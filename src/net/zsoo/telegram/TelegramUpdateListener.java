package net.zsoo.telegram;

import java.util.Map;

@FunctionalInterface
public interface TelegramUpdateListener {
	Map onUpdate(Update body);
}
