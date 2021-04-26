package com.l2jong.shorten.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortenResult {

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	@JsonProperty(value = "url_short")
	private String shortUrl;

	@JsonProperty(value = "url_long")
	private String longUrl;
}
