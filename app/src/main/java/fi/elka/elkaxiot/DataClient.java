package fi.elka.elkaxiot;

import com.loopj.android.http.*;

import java.net.ProxySelector;

/**
 * Created by fadhlika on 30/10/2016.
 */

public class DataClient {


    private static final String BASE_URL = "https://www.elka.fi.itb.ac.id/iot2";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }


}
