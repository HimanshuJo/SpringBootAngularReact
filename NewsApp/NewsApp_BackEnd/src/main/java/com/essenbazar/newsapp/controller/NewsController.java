package com.essenbazar.newsapp.controller;

import com.essenbazar.newsapp.service.RSSFeedService;
import com.essenbazar.newsapp.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class NewsController {

	@Autowired
	private RSSFeedService rssFeedService;

	@GetMapping(value = "/news")
	public List<News> getAllNews(){
		List<News>allNews=new ArrayList<>();
		allNews.addAll(rssFeedService.getNewsFromRss("https://www.kn-online.de/arc/outboundfeeds/rss/"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://rp-online.de/feed.rss"));
		allNews.addAll(rssFeedService.getNewsFromRss("http://newsfeed.zeit.de/index"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://www.muensterschezeitung.de/rss/feed/mz_lokales"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://www.spiegel.de/index.rss"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://www.handelsblatt.com/contentexport/feed/top-themen"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://news.google.com/rss?hl=de&gl=DE&ceid=DE:de"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://www.rki.de/cln_049/nn_205908/SiteGlobals/Functions/RSSFeed/RSSGenerator.xml"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://blog.urbansportsclub.com/en/feed/"));
		allNews.addAll(rssFeedService.getNewsFromRss("https://fitnessgoesoffice.com/feed/"));
		Collections.shuffle(allNews);
		return allNews;
	}
}
