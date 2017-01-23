package br.com.hisao.hf.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.hisao.hf.R;
import br.com.hisao.hf.fragments.RecipeListFragment;
import br.com.hisao.hf.models.Recipe;

/**
 * Created by viniciushisao.
 */

public class RecipeAdapter extends BaseAdapter {


    private List<Recipe> recipeList;
    private Activity activity;
    private RecipeListFragment.OnFragmentInteractionListener listener;

    public RecipeAdapter(List<Recipe> recipeList, Activity activity, RecipeListFragment.OnFragmentInteractionListener listener) {
        this.activity = activity;
        this.listener = listener;
        this.recipeList = recipeList;

    }

    @Override
    public int getCount() {
        return this.recipeList.size();
    }

    @Override
    public Object getItem(int i) {
        return recipeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Recipe recipe = recipeList.get(i);

        if (view == null) {
            LayoutInflater inflater = (activity).getLayoutInflater();
            view = inflater.inflate(R.layout.receipt_adapter_item, viewGroup, false);
        }
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(recipe.getName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragmentInteractionReceiptListFragment(recipe);
            }
        });

        return view;
    }
}
