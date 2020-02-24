package ir.mpkmro.scientists;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ir.mpkmro.scientists.Adapter.favAdapter;
import ir.mpkmro.scientists.DataBase.DataBase;
import ir.mpkmro.scientists.Model.Person;

public class ProfileFragment extends Fragment {

    public static final String LOGIN = "login";
    TextView name;
    View view;
    favAdapter adapter;
    RecyclerView recyclerView;
    LinearLayout linearLayout;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        setUpViews();
        return view;
    }

    private void setUpViews() {
        name = view.findViewById(R.id.name_id);
        recyclerView = view.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        linearLayout = view.findViewById(R.id.profile_bg_id);
        DataBase db = new DataBase(getActivity());
        List<Person> personList = db.getFavPerson();
        adapter = new favAdapter(getActivity(), personList);

        if (personList.isEmpty()) {
            showBackground();
        } else {
            removeBackground();
        }

        recyclerView.setAdapter(adapter);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
        name.setText(sharedPreferences.getString("NAME", null));


    }

    private void removeBackground() {
        recyclerView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);


    }

    private void showBackground() {
        recyclerView.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
