package scraping;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scraper {
    /**
     * Creates a JSoup Connection using the given URL.
     * @param url The URL of the page to connect to.
     * @return A Connection instance.
     */
    public Connection Connect(String url) {
        return Jsoup.connect(url);
    }

    /**
     * Parses an HTML String into a Document.
     * @param html The HTML String.
     * @return A Document.
     */
    public Document Parse(String html) {
        return Jsoup.parse(html);
    }
}
