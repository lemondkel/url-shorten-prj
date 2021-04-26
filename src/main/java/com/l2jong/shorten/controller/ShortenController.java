package com.l2jong.shorten.controller;


import com.l2jong.shorten.model.ShortenResult;
import com.l2jong.shorten.service.ShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@EnableAutoConfiguration
public class ShortenController {

	public static final String SHORTEN_PREFIX = "localhost/";

	@Autowired
	private ShortenService shortenService;

	@RequestMapping(value = "/shorten", method = RequestMethod.GET)
	public @ResponseBody
	List<ShortenResult> shorten(@RequestParam("url") String url) {
		List<String> list = Arrays.asList(url.split(","));
		if (list.isEmpty()) {
			return new ArrayList<>();
		}
		List<ShortenResult> results = new ArrayList<>();
		for (String longUrl : list) {
			ShortenResult result = new ShortenResult();
			result.setLongUrl(longUrl);
			String shortUrl = SHORTEN_PREFIX.concat(shortenService.shorten(longUrl));
			result.setShortUrl(shortUrl);
			results.add(result);
		}
		return results;
	}
}
