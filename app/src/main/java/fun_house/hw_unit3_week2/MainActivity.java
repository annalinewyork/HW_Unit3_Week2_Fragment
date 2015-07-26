package fun_house.hw_unit3_week2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements LeftFragment.CardSelectInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isTablet() {
        View rightFragmentContainer = findViewById(R.id.right_fragment_container);
        return (rightFragmentContainer != null);
    }


    @Override
    public void cardSelected(int cardSequence) {

            if (isTablet()) {
                FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            //attach fragment for the card sequence
            switch (cardSequence) {
                case 0:
                    WeatherFragment weatherFragment = new WeatherFragment();
                    ft.replace(R.id.right_fragment_container, weatherFragment);
                    break;
                case 1:
                    MusicFragment musicFragment = new MusicFragment();
                    ft.replace(R.id.right_fragment_container, musicFragment);
                    break;

            }
            ft.commit();
        }
        else {
            Intent detailActivityIntent = new Intent(this, DetailActivity.class);
            detailActivityIntent.putExtra("fragment_sequence", cardSequence);
            startActivity(detailActivityIntent);

        }
    }
}
