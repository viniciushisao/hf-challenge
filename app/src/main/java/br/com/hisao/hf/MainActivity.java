package br.com.hisao.hf;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.hisao.hf.fragments.RecipeDetailFragment;
import br.com.hisao.hf.fragments.RecipeListFragment;
import br.com.hisao.hf.models.Recipe;
import br.com.hisao.hf.util.Log;

public class MainActivity extends AppCompatActivity implements RecipeListFragment.OnFragmentInteractionListener, RecipeDetailFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, RecipeListFragment.newInstance());
        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentInteractionReceiptListFragment(Recipe recipe) {
        Log.d("MainActivity:onFragmentInteractionReceiptListFragment:27 " + recipe.getCalories());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frg_recipt_list, RecipeDetailFragment.newInstance(recipe));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteractionRecipeDetailFragment() {
    }
}
