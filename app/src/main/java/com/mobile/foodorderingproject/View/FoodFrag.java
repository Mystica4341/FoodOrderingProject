package com.mobile.foodorderingproject.View;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Adapter.CustomFoodAdapter;
import com.mobile.foodorderingproject.Adapter.CustomShoppingCartAdapter;
import com.mobile.foodorderingproject.Controller.FoodHandler;
import com.mobile.foodorderingproject.Model.Food;
import com.mobile.foodorderingproject.Model.LuuHoaDon;
import com.mobile.foodorderingproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFrag extends Fragment {
    ImageButton btnImgPlus, btnImgMinus;
    TextView tvNums, tvPrice, tvName;
    SQLiteDatabase db;
    GridView gridFood;
    CustomFoodAdapter adapter;
    ArrayList<Food> lsFood=new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFrag newInstance(String param1, String param2) {
        FoodFrag fragment = new FoodFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);

// Inflate the layout for this fragment
        addControls(view);
        load();
        addEvents();
        return view;

    }

    public void addControls(View view){
        gridFood = (GridView) view.findViewById(R.id.gridFood);
        btnImgPlus=(ImageButton) view.findViewById(R.id.btnImgPlus);
        btnImgMinus=(ImageButton) view.findViewById(R.id.btnImgMinus);
        tvNums=(TextView) view.findViewById(R.id.tvNums);
        tvName=(TextView)view.findViewById(R.id.tvName);
        tvPrice=(TextView) view.findViewById(R.id.tvPrice);
    }
    public void load(){
        lsFood = FoodHandler.loadData();
        adapter = new CustomFoodAdapter(requireActivity(), lsFood);
        gridFood.setAdapter(adapter);
    }

    private void addEvents(){
        gridFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i = 0;
                if (view.getId() == R.id.btnImgPlus) {
                    i += 1;
                    tvNums.setText(String.valueOf(i));
                } else if (view.getId() == R.id.btnImgMinus){
                    if (i < 0) {
                        tvNums.setText(0);
                    } else {
                        i -= 1;
                        tvNums.setText(String.valueOf(i));
                    }
                }
            }
        });
    }
}
