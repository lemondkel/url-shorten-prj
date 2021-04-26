package com.l2jong.shorten.service;

import com.l2jong.shorten.util.Base62;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

@Service
public class ShortenService {

	private static Map<Long, String> map;

	private long generatedId;

	ShortenService() {
		map = new HashMap<>();
		generatedId = 10000000;
	}

	public String shorten(String url) {
		if (map.containsValue(url)) {
			Set<Long> keySet = map.keySet();
			Iterator<Long> iterator = keySet.iterator();

			long next = -1;
			while (iterator.hasNext()) {
				next = iterator.next();
				String getUrl = map.get(next);

				if (url.equals(getUrl)) {
					break;
				}
			}
			return Base62.encodeBase10(next);
		} else {
			++generatedId;
			map.put(generatedId, url);
			return Base62.encodeBase10(generatedId);
		}
	}

	public String getUrl(String shortUrl) {
		Long id = Base62.decodeBase62(shortUrl);
		return map.get(id);
	}
}
