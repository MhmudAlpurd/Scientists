package ir.mpkmro.scientists;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;

import ir.mpkmro.scientists.Adapter.HomeAdapter;

public class HomeFragment extends Fragment {

    View view;
    TabLayout tabLayout;
    RtlViewPager viewPager;
    HomeAdapter adapter;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        setupViews();
        return view;
    }

    private void setupViews() {
        viewPager = view.findViewById(R.id.viewPager_id);
        tabLayout = view.findViewById(R.id.tab_layout_id);
        adapter = new HomeAdapter(getChildFragmentManager());
        adapter.addFragment(new IranFragment(), "ایرانی");
        adapter.addFragment(new ForeignFragment(), "خارجی");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
