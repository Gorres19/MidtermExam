package sidespell.tech.midtermexam;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import sidespell.tech.midtermexam.utils.HttpUtils;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new AlbumSearcher().execute("");
    }

    public class AlbumSearcher extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return HttpUtils.getResponse("http://ws.audioscrobbler.com/2.0/?method=album.search&api_key="+BuildConfig.MIDTERM_EXAM_API_KEY+"&album="+params[0]+"&format=json", "POST");
        }

        @Override
        protected void onPostExecute(String result) {
            Log.v(LOG_TAG, result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
