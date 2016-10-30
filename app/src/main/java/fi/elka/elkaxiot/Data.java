package fi.elka.elkaxiot;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by fadhlika on 10/29/2016.
 */

public class Data {
    public double unit;
    public String title;

    public Data(String title_, double unit_){
        this.unit = unit_;
        this.title = title_;
    }
}
