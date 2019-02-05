package data;

import com.google.gson.Gson;
import sun.net.ftp.FtpDirEntry;
import util.Tuple;

public class JSON<T> {
    private Gson mGSON;
    public JSON() {
        this.mGSON = new Gson();
    }


    public String ObjectToJSON(Object object) {
        return this.mGSON.toJson(object);
    }

    public Object JSONtoObject(String json, T fill) {
        return this.mGSON.fromJson(json, fill.getClass());
    }
}
