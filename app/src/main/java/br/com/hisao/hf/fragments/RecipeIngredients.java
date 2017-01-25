package br.com.hisao.hf.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.hisao.hf.R;


public class RecipeIngredients extends Fragment {

    private OnFragmentInteractionListener mListener;
    private static final String ARG_PARAM_INGREDIENTS = "arg_param_ingredients";
    private List<String> ingredients;

    public RecipeIngredients() {
        // Required empty public constructor
    }


    public static RecipeIngredients newInstance(List<String> ingredients) {
        RecipeIngredients fragment = new RecipeIngredients();
        Bundle args = new Bundle();

        ArrayList<String> param = new ArrayList<>();

        for (String value : ingredients){
            param.add(value);
        }

        args.putStringArrayList(ARG_PARAM_INGREDIENTS, param);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ingredients = getArguments().getStringArrayList(ARG_PARAM_INGREDIENTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_ingredients, container, false);
        TextView ingredientsList = (TextView) view.findViewById(R.id.ingredientslist);

        StringBuilder finalValue = new StringBuilder();

        for (String ingredient : ingredients){
            finalValue.append(ingredient);
            finalValue.append(System.getProperty ("line.separator"));
        }
        ingredientsList.setText(finalValue.toString());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteractionRecipeIngredients();
    }
}
