package br.com.hisao.hf.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

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
        ImageView imageThumb = (ImageView) view.findViewById(R.id.thumb);
        TextView favorites = (TextView) view.findViewById(R.id.favorites);
        TextView rating = (TextView) view.findViewById(R.id.rating);

        //I am not sure what kind of image (size or format) I am supposed to get here.
        if (imageThumb != null)
            Picasso.with(activity).load(recipe.getThumb()).into(imageThumb);
        name.setText((recipe.getName() != null) ? recipe.getName() : "Not available");
        favorites.setText((recipe.getFavorites() != null) ? recipe.getFavorites().toString() : "Not available");
        rating.setText((recipe.getRating() != null) ? recipe.getRating().toString() : "Not available");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragmentInteractionReceiptListFragment(recipe);
            }
        });

        return view;
    }
}
