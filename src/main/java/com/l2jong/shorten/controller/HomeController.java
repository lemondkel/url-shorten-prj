package com.l2jong.shorten.controller;

import com.l2jong.shorten.service.ShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class HomeController {
	@Autowired
	private ShortenService shortenService;

	@RequestMapping("/{shorturl}")
	public ModelAndView home(@PathVariable("shorturl") String shorturl) throws IOException {
		String url = shortenService.getUrl(shorturl);
		return new ModelAndView("redirect:" + url);
	}

}
