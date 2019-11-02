package net.zsoo.telegram;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

import com.google.gson.Gson;

public class Telegram {
	private String token;
	private boolean polling;

	public Telegram(String token) {
		this.token = token;
	}

	public void startPoll(TelegramUpdateListener callback, Supplier<Long> nextOffset, int timeout) {
		polling = true;
		new Thread(() -> {
			while (polling) {
				HashMap opt = new HashMap<>();
				Long offset = nextOffset.get();
				if (offset != null) {
					opt.put("offset", offset);
				}
				opt.put("timeout", timeout);
				GetUpdatesResult command = command("/getUpdates", opt, GetUpdatesResult.class);
				Update[] result = command.getResult();

				Arrays.stream(result).forEach((obj) -> {
					callback.onUpdate(obj);
				});
			}
		}).start();
	}

	private <T> T command(String command, HashMap<String, String> param, Class<T> clazz) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(param);
			byte[] jsonBytes = json.getBytes("UTF-8");

			String url = "https://api.telegram.org/bot" + this.token + command;
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Content-Length", String.valueOf(jsonBytes.length));
			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			os.write(jsonBytes);
			os.flush();

			int code = conn.getResponseCode();
			if (code != 200) {
				return null;
			}

			InputStream is = conn.getInputStream();
			gson = new Gson();
			T obj = gson.fromJson(new InputStreamReader(is), clazz);
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private HashMap<?, ?> command(String command, HashMap<String, String> param) {
		return command(command, param, HashMap.class);
	}

	public void sendMessage(String chatId, String message) {
		HashMap<String, String> param = new HashMap<String, String>();
		if (message.length() >= 4096) {
			message = message.substring(0, 4092) + "...";
		}
		param.put("chat_id", chatId);
		param.put("text", message);
		command("/sendMessage", param);
	}
}
