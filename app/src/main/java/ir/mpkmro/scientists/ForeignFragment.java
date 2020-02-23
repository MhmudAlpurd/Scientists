package ir.mpkmro.scientists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mpkmro.scientists.Adapter.PersonAdapter;
import ir.mpkmro.scientists.DataBase.DataBase;
import ir.mpkmro.scientists.Model.Person;

public class ForeignFragment extends Fragment {


    View view;
    RecyclerView recyclerView;
    PersonAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_home,container, false);
        setupViews();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupViews() {
        recyclerView = view.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DataBase db = new DataBase(getActivity());
        List<Person> personList = db.getAllPerson();
        adapter = new PersonAdapter(getActivity(),personList);
        recyclerView.setAdapter(adapter);
    }
}
