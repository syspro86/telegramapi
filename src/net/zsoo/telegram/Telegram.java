package net.zsoo.telegram;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

import com.google.gson.Gson;

public class Telegram {
	private String token;

	public Telegram(String token) {
		this.token = token;
	}

	private HashMap<?, ?> command(String command, HashMap<String, String> param) {
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
			HashMap<?, ?> obj = gson.fromJson(new InputStreamReader(is), HashMap.class);
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
