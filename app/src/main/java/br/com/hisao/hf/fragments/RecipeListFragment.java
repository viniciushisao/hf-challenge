package br.com.hisao.hf.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.hisao.hf.LoginActivity;
import br.com.hisao.hf.R;
import br.com.hisao.hf.adapters.RecipeAdapter;
import br.com.hisao.hf.models.Recipe;
import br.com.hisao.hf.modelsweb.HelloFrashWebApi;
import br.com.hisao.hf.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipeListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public RecipeListFragment() {
        // Required empty public constructor
    }


    public static RecipeListFragment newInstance() {
        RecipeListFragment fragment = new RecipeListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadList(List<Recipe> recipeList){
        ListView lstNumbers =(ListView)getActivity().findViewById(R.id.list_receipts);
        lstNumbers.setAdapter(new RecipeAdapter(recipeList, getActivity(), mListener));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View returnView = inflater.inflate(R.layout.fragment_receipt_list, container, false);

        Call<List<Recipe>> listCall = HelloFrashWebApi.getHelloFreshApiInterface().getReceipes();
        listCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                loadList(response.body());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.d("MainActivity:onFailure:54 " + t.getMessage());
            }
        });

        TextView login = (TextView) returnView.findViewById(R.id.login_action);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return returnView;
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
        void onFragmentInteractionReceiptListFragment(Recipe recipe);
    }
}
