package fun_house.hw_unit3_week2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created on 7/25/15.
 */
public class LeftFragment extends Fragment {

    ListView listView;
    String[] cards = {"Weather Card", "Music Card", "Twitter Card", "ToDo Card"};
    CardSelectInterface parentCommunicator;

    public interface CardSelectInterface {
        public void cardSelected(int cardSequence);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CardSelectInterface) {
            parentCommunicator = (CardSelectInterface) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_left, container, false);

        listView = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cards);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listRowClickListener);
        return v;
    }


    public ListView.OnItemClickListener listRowClickListener = new ListView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            parentCommunicator.cardSelected(position);

        }
    };
}
