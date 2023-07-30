package com.mobile.foodorderingproject.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.foodorderingproject.Adapter.CustomShoppingCartAdapter;
import com.mobile.foodorderingproject.Model.LuuHoaDon;
import com.mobile.foodorderingproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShoppingCartFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingCartFrag extends Fragment {
    ListView lvShopping;
    TextView tvTongMon, tvTongTien;
    Button btnAdd, btnDelete, btnConfirm;
    CustomShoppingCartAdapter adapter;
    ArrayList<LuuHoaDon> arrayListLuuHoaDon;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShoppingCartFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShoppingCartFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static ShoppingCartFrag newInstance(String param1, String param2) {
        ShoppingCartFrag fragment = new ShoppingCartFrag();
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
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        addControls(view);
        arrayListLuuHoaDon = initData();
        adapter = new CustomShoppingCartAdapter(requireActivity(),R.layout.item_shopping_cart_layout,arrayListLuuHoaDon);
        lvShopping.setAdapter(adapter);
        return view;
    }
    public void addControls(View view){
        btnAdd = (Button)view.findViewById(R.id.btnAdd);
        btnConfirm=(Button)view.findViewById(R.id.btnConfirm);
        btnDelete=(Button)view.findViewById(R.id.btnDelete);
        lvShopping=(ListView)view.findViewById(R.id.lvShopping);
        tvTongMon=(TextView)view.findViewById(R.id.tvTongMon);
        tvTongTien=(TextView) view.findViewById(R.id.tvTongTien);
    }
    public ArrayList<LuuHoaDon> initData(){
        ArrayList<LuuHoaDon> lsData = new ArrayList<>();
        LuuHoaDon lhd = new LuuHoaDon();
        lsData.add(lhd);
        return lsData;
    }
    public void addEvents(){

    }
}