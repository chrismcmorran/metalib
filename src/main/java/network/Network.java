package network;

import java.io.IOException;
import java.net.URL;

public class Network {
    /**
     * Fetches the HTML of a given URL as a String. Returns an empty string on error.
     * @param URL The URL to connect to.
     * @return A String.
     */
    public String HTML(String URL) {
        try {
            return org.apache.commons.io.IOUtils.toString(new URL(URL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
