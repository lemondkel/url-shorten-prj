package com.l2jong.shorten.service;

import com.l2jong.shorten.util.Base62;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortenService {

	private static Map<Long, String> map;

	private long generatedId;

	ShortenService() {
		map = new HashMap<>();
	}

	public String shorten(String url) {
		++generatedId;
		map.put(generatedId, url);
		return Base62.encodeBase10(generatedId);
	}

	public String getUrl(String shortUrl) {
		Long id = Base62.decodeBase62(shortUrl);
		return map.get(id);
	}
}
