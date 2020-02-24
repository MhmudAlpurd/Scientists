package ir.mpkmro.scientists;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import ir.mpkmro.scientists.Adapter.PersonAdapter;
import ir.mpkmro.scientists.DataBase.DataBase;
import ir.mpkmro.scientists.Model.Person;

public class SearchFragment extends Fragment {

    View view;
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    EditText editText;
    PersonAdapter adapter;
    List<Person> personList;

    public SearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        setupViews();
        setData();
        showBackground();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    showBackground();

                } else {
                    removeBackground();
                    filter(s.toString());
                }
            }
        });
        return view;
    }

    private void filter(String text) {
        List<Person> filterList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(person);
            }
        }
        adapter.filterList(filterList);
    }

    private void setData() {
        DataBase db = new DataBase(getActivity());
        personList = db.getAllPerson();
        adapter = new PersonAdapter(getActivity(), personList);
        recyclerView.setAdapter(adapter);
    }

    private void setupViews() {
        linearLayout = view.findViewById(R.id.search_bg);
        recyclerView = view.findViewById(R.id.recycler_id);
        editText = view.findViewById(R.id.search_ed_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public void showBackground() {
        recyclerView.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);

    }

    public void removeBackground() {
        recyclerView.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
